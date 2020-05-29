package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.operand.register;

import java.util.*;

public abstract class pass {
    protected IRroot Irroot;
    protected boolean changed;
    //def-use chain information
    protected Map<register, IRinst> def;
    protected Map<register, Set<IRinst>> use;
    //natural loop information
    protected Set<basicblock> loopHeaders;
    protected Map<basicblock, Set<basicblock>> loopBackers;
    protected Map<basicblock, Set<basicblock>> belongingLoopHeaders;
    protected Map<basicblock, Set<basicblock>> loopGroups;
    protected Map<basicblock, Set<basicblock>> loopExits;
    //instruction collection
    private LinkedList<IRinst> allStatements;

    pass(IRroot Irroot) {
        this.Irroot = Irroot;
    }

    abstract boolean run();

    void calcDefUseChain(function function) {
        def = new HashMap<>();
        use = new HashMap<>();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                register defregister = IRinst.getDefReg();
                if (defregister != null) {
                    def.put(defregister, IRinst);
                    use.computeIfAbsent(defregister, k -> new HashSet<>());
                }
                for (register useregister : IRinst.getUseregs()) {
                    use.computeIfAbsent(useregister, k -> new HashSet<>());
                    use.get(useregister).add(IRinst);
                }
            }
        });
    }

    LinkedList<IRinst> getAllStatements(function function) {
        allStatements = new LinkedList<>();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                allStatements.add(IRinst);
        });
        return allStatements;
    }

    //Dominator Tree Construction
    //This pass is a simple dominator construction algorithm for finding forward dominators.
    //LLVM Pass
    private void computeDominateTreeAllSuccessors(basicblock basicblock) {
        basicblock.DTAllSuccessors = new HashSet<>();
        basicblock.DTAllSuccessors.add(basicblock);
        basicblock.DTSuccessors.forEach(this::computeDominateTreeAllSuccessors);
        basicblock.DTSuccessors.forEach(successor -> basicblock.DTAllSuccessors.addAll(successor.DTAllSuccessors));
    }

    void computeDominateTree(function function) {
        List<basicblock> RPO = function.getReversePostOrderDFSBBList();
        List<basicblock> basicblockList = RPO.subList(1, RPO.size());
        basicblockList.forEach(basicblock -> basicblock.IDOM = null);
        function.getExitBB().IDOM = function.getEntryBB();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (basicblock basicblock : basicblockList) {
                basicblock newIDOM = null;
                for (basicblock predecessor : basicblock.getPredecessors()) {
                    if (predecessor.IDOM != null) newIDOM = predecessor;
                }
                for (basicblock predecessor : basicblock.getPredecessors()) {
                    if (predecessor != newIDOM && predecessor.IDOM != null)
                        newIDOM = intersect(predecessor, newIDOM);
                }
                if (basicblock.IDOM != newIDOM) {
                    basicblock.IDOM = newIDOM;
                    changed = true;
                }
            }
        }
        RPO.forEach(basicblock -> basicblock.DTSuccessors = new HashSet<>());
        basicblockList.forEach(basicblock -> basicblock.IDOM.DTSuccessors.add(basicblock));
        computeDominateTreeAllSuccessors(function.getEntryBB());
    }


    private basicblock intersect(basicblock basicblock1, basicblock basicblock2) {
        basicblock finger1 = basicblock1;
        basicblock finger2 = basicblock2;
        while (finger1 != finger2) {
            while (finger1.postOrderNumber < finger2.postOrderNumber) finger1 = finger1.IDOM;
            while (finger2.postOrderNumber < finger1.postOrderNumber) finger2 = finger2.IDOM;
        }
        return finger1;
    }

    //Dominance Frontier Construction
    //This pass is a simple dominator construction algorithm for finding forward dominator frontiers.
    //LLVM Pass
    void computeDominanceFrontier(function function) {
        List<basicblock> basicblockList = function.getReversePostOrderDFSBBList();
        basicblockList.forEach(basicblock -> basicblock.DF = new HashSet<>());
        for (basicblock basicblock : basicblockList) {
            if (basicblock.getPredecessors().size() >= 2) {
                for (basicblock predecessor : basicblock.getPredecessors()) {
                    basicblock runner = predecessor;
                    while (runner != basicblock.IDOM) {
                        runner.DF.add(basicblock);
                        runner = runner.IDOM;
                    }
                }
            }
        }
    }

    //Post-Dominator Tree Construction
    //This pass is a simple post-dominator construction algorithm for finding post-dominators.
    //LLVM Pass
    void computePostDominateTree(function function) {
        function.calcReverseCFGPostOrderNumber();
        List<basicblock> basicblockList = new LinkedList<>(function.getReversePostOrderDFSBBList());
        Collections.reverse(basicblockList);
        basicblockList.remove(function.getExitBB());
        function.getExitBB().postIDOM = function.getExitBB();
        boolean changed = true;
        while (changed) {
            changed = false;
            for (basicblock basicblock : basicblockList) {
                basicblock newPostIDOM = null;
                for (basicblock successor : basicblock.getSuccessors()) {
                    if (successor.postIDOM != null) newPostIDOM = successor;
                }
                for (basicblock successor : basicblock.getSuccessors()) {
                    if (successor != newPostIDOM && successor.postIDOM != null)
                        newPostIDOM = intersectPost(successor, newPostIDOM);
                }
                if (basicblock.postIDOM != newPostIDOM) {
                    basicblock.postIDOM = newPostIDOM;
                    changed = true;
                }
            }
        }
        function.getReversePostOrderDFSBBList().forEach(basicblock -> basicblock.RDFSuccessors = new HashSet<>());
        basicblockList.forEach(basicblock -> basicblock.postIDOM.RDFSuccessors.add(basicblock));
    }


    private basicblock intersectPost(basicblock basicblock1, basicblock basicblock2) {
        basicblock finger1 = basicblock1;
        basicblock finger2 = basicblock2;
        while (finger1 != finger2) {
            while (finger1.reversePostOrderNumber < finger2.reversePostOrderNumber) finger1 = finger1.postIDOM;
            while (finger2.reversePostOrderNumber < finger1.reversePostOrderNumber) finger2 = finger2.postIDOM;
        }
        return finger1;
    }

    //Post-Dominance Frontier Construction
    //This pass is a simple post-dominator construction algorithm for finding post-dominator frontiers.
    //LLVM Pass
    void computeReverseDominantFrontier(function function) {
        List<basicblock> basicblockList = function.getReversePostOrderDFSBBList();
        basicblockList.forEach(basicblock -> basicblock.RDF = new HashSet<>());
        for (basicblock basicblock : basicblockList) {
            if (basicblock.getSuccessors().size() >= 2) {
                for (basicblock successor : basicblock.getSuccessors()) {
                    basicblock runner = successor;
                    while (runner != basicblock.postIDOM) {
                        runner.RDF.add(basicblock);
                        runner = runner.postIDOM;
                    }
                }
            }
        }
    }

    //Natural Loop Information
    //This analysis is used to identify natural loops and determine the loop depth of various nodes of the CFG.
    //Note that the loops identified may actually be several natural loops that share the same header node not just a single natural loop.
    //LLVM Pass
    void calcLoopInformation(function function) {
        computeDominateTree(function);
        //mark loop headers and record loop backers
        loopHeaders = new HashSet<>();
        loopBackers = new HashMap<>();
        belongingLoopHeaders = new HashMap<>();
        loopGroups = new HashMap<>();
        loopExits = new HashMap<>();
        for (basicblock basicblock : function.getReversePostOrderDFSBBList()) {
            for (basicblock successor : basicblock.getSuccessors()) {
                if (successor.DTAllSuccessors.contains(basicblock)) {
                    loopHeaders.add(successor);
                    loopBackers.computeIfAbsent(successor, k -> new HashSet<>());
                    loopBackers.get(successor).add(basicblock);
                }
            }
        }
        //compute loop groups
        Stack<basicblock> workList = new Stack<>();
        for (basicblock loopHeader : loopHeaders) {
            workList.clear();
            loopGroups.put(loopHeader, new HashSet<>());
            loopGroups.get(loopHeader).add(loopHeader);
            for (basicblock backer : loopBackers.get(loopHeader)) {
                workList.add(backer);
                loopGroups.get(loopHeader).add(backer);
                for (; !workList.isEmpty(); ) {
                    basicblock nowBlock = workList.pop();
                    for (basicblock predecessor : nowBlock.getPredecessors())
                        if (!loopGroups.get(loopHeader).contains(predecessor)) {
                            loopGroups.get(loopHeader).add(predecessor);
                            workList.add(predecessor);
                            belongingLoopHeaders.computeIfAbsent(predecessor, k -> new HashSet<>());
                            belongingLoopHeaders.get(predecessor).add(loopHeader);
                        }
                }
            }
        }
        //compute loop exits
        for (basicblock loopHeader : loopHeaders) {
            loopExits.put(loopHeader, new HashSet<>());
            for (basicblock loopMember : loopGroups.get(loopHeader))
                for (basicblock successor : loopMember.getSuccessors())
                    if (!loopGroups.get(loopHeader).contains(successor)) {
                        loopExits.get(loopHeader).add(loopMember);
                    }
        }
    }






}

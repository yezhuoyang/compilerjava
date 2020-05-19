package compilerjava.codegen;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.IRprinter;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.instruction.load;
import compilerjava.IR.instruction.move;
import compilerjava.IR.instruction.store;
import compilerjava.IR.operand.*;
import compilerjava.config;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import static compilerjava.IR.operand.realregister.*;

//Graph Coloring
//Build -> Simplify -> Coalesce -> Freeze -> Spill -> Select
public class regAllocator {
    private IRroot _IRroot;
    private IRprinter _IRprinter;
    private PrintStream debug_out;
    private boolean DEBUG = true;

    private int iteration;
    private int K = 29;
    private Set<realregister> colors = new HashSet<>();

    private Set<virtualregister> precolored = new HashSet<>();
    private Set<virtualregister> initial = new HashSet<>();
    private Set<virtualregister> simplifyWorklist = new HashSet<>();
    private Set<virtualregister> freezeWorklist = new HashSet<>();
    private Set<virtualregister> spillWorklist = new HashSet<>();
    private Set<virtualregister> spilledNodes = new HashSet<>();
    private Set<virtualregister> coalescedNodes = new HashSet<>();
    private Set<virtualregister> coloredNodes = new HashSet<>();
    private Stack<virtualregister> selectStack = new Stack<>();
    private Set<virtualregister> selectStackNodes = new HashSet<>();

    private Set<move> coalescedmoves = new HashSet<>();
    private Set<move> constrainedmoves = new HashSet<>();
    private Set<move> frozenmoves = new HashSet<>();
    private Set<move> worklistmoves = new HashSet<>();
    private Set<move> activemoves = new HashSet<>();

    private Set<Edge> adjSet = new HashSet<>();

    public regAllocator(IRroot _IRroot){
        this._IRroot = _IRroot;
        precolored.addAll(allVRegisters);
        colors.addAll(allRegisters);
        colors.remove(sp);
        colors.remove(gp);
        colors.remove(tp);
        colors.remove(zero);
        try {
            debug_out = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/ir_debug.ll");
            _IRprinter = new IRprinter(debug_out, false, false);
            if (DEBUG) _IRprinter.visit(_IRroot);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void dumpmove(move move) {
        debug_out.print(_IRprinter.getName((storage) move.getDst()));
        debug_out.print(" = move ");
        debug_out.println(_IRprinter.getName((storage) move.getSrc()));
    }

    private void dumpNode(virtualregister virtualregister) {
        debug_out.print(_IRprinter.getName(virtualregister) + "(" + virtualregister.spillPriority + ") ");
    }

    private void dumpDebugInfo(function function) {
        if (DEBUG) {
            debug_out.println("========" + function.getName() + " Graph Info ========");
            initial.forEach(u -> {
                debug_out.println(_IRprinter.getName(u) + ":");
                debug_out.print("AdjList : ");
                u.adjList.forEach(v -> debug_out.print(" " + _IRprinter.getName(v)));
                debug_out.println();
                debug_out.print("degree : " + u.degree);
                debug_out.println();
                debug_out.print("Alias :" + _IRprinter.getName(u.alias));
                debug_out.println();
                debug_out.print("Color : " + (u.color == null ? "null" : _IRprinter.getName(u.color)));
                debug_out.println();
                debug_out.print("Priority : " + u.spillPriority);
                debug_out.println();
                debug_out.println("------");
            });
            debug_out.println("========" + function.getName() + " move List Info ========");
            debug_out.println("coalesced moves:");
            coalescedmoves.forEach(this::dumpmove);
            debug_out.println("------");
            debug_out.println("constrained moves:");
            constrainedmoves.forEach(this::dumpmove);
            debug_out.println("------");
            debug_out.println("fronzen moves:");
            frozenmoves.forEach(this::dumpmove);
            debug_out.println("------");
            debug_out.println("workList moves:");
            worklistmoves.forEach(this::dumpmove);
            debug_out.println("------");
            debug_out.println("active moves:");
            activemoves.forEach(this::dumpmove);
            debug_out.println("========" + function.getName() + " Node List Info ========");
            debug_out.println("simplify Nodes(low degree non move related):");
            simplifyWorklist.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("freeze Nodes(low degree move related):");
            freezeWorklist.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("spill Nodes(high degree):");
            spillWorklist.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("spilled Nodes:");
            spilledNodes.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("coalesced Nodes:");
            coalescedNodes.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("colored Nodes:");
            coloredNodes.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println("selected Stack:");
            selectStackNodes.forEach(this::dumpNode);
            debug_out.println("\n------");
            debug_out.println();
        }
    }

    public void run() {
        _IRroot.getFunctionMap().values().forEach(this::allocate);
        cleanmove();
    }

    private void cleanmove() {
        _IRroot.getFunctionMap().values().forEach(function -> function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                if (IRinst instanceof move && ((move) IRinst).getSrc() instanceof register && ((move) IRinst).getDst() instanceof register) {
                    realregister color1 = null, color2 = null;
                    if (((move) IRinst).getSrc() instanceof virtualregister)
                        color1 = ((virtualregister) ((move) IRinst).getSrc()).color;
                    else if (((move) IRinst).getSrc() instanceof realregister)
                        color1 = (realregister) ((move) IRinst).getSrc();
                    if (((move) IRinst).getDst() instanceof virtualregister)
                        color2 = ((virtualregister) ((move) IRinst).getDst()).color;
                    else if (((move) IRinst).getDst() instanceof realregister)
                        color2 = (realregister) ((move) IRinst).getDst();
                    assert color1 != null;
                    assert color2 != null;
                    if (color1 == color2)
                        IRinst.deleteSelf();
                }
        }));
    }

    private void init() {
        initial.clear();
        simplifyWorklist.clear();
        freezeWorklist.clear();
        spillWorklist.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selectStack.clear();
        selectStackNodes.clear();

        coalescedmoves.clear();
        constrainedmoves.clear();
        frozenmoves.clear();
        worklistmoves.clear();
        activemoves.clear();

        adjSet.clear();
    }

    private void allocate(function function){
        boolean finish;
        iteration = 0;
        do {
            if (DEBUG)
                debug_out.println("=====================" + function.getName() + " Iteration " + iteration + "=====================");
            init();
            livenessAnalysis(function);
            build(function);
            makeWorklist();
            if (DEBUG) {
                dumpDebugInfo(function);
                _IRprinter.visit(_IRroot);
            }
            do {
                if (!simplifyWorklist.isEmpty()) {
                    if (DEBUG) debug_out.println("===================== Simplify =====================");
                    simplify();
                } else if (!worklistmoves.isEmpty()) {
                    if (DEBUG) debug_out.println("===================== Coalesce =====================");
                    coalesce();
                } else if (!freezeWorklist.isEmpty()) {
                    if (DEBUG) debug_out.println("===================== Freeze =====================");
                    freeze();
                } else if (!spillWorklist.isEmpty()) {
                    if (DEBUG) debug_out.println("===================== SelectSpill =====================");
                    selectSpill();
                }
                if (DEBUG) dumpDebugInfo(function);
            } while (!(simplifyWorklist.isEmpty() && worklistmoves.isEmpty() && freezeWorklist.isEmpty() && spillWorklist.isEmpty()));
            assignColors();
            if (DEBUG) {
                debug_out.println("===================== after ASSIGN =====================");
                dumpDebugInfo(function);
            }
            if (!spilledNodes.isEmpty()) {
                finish = false;
                rewriteProgram(function);
                if (DEBUG) {
                    debug_out.println("===================== IR after Rewrite =====================");
                    _IRprinter.visit(_IRroot);
                }
            } else finish = true;
            iteration++;
        } while (!finish);
    }

    private void livenessAnalysis(function function) {
        //initialize def & use
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            basicblock.getDef().clear();
            basicblock.getUse().clear();
            basicblock.getLiveIn().clear();
            basicblock.getLiveOut().clear();
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                IRinst.calcUseAndDef();
                IRinst.getUse().forEach(virtualregister -> {
                    if (!basicblock.getDef().contains(virtualregister))
                        basicblock.getUse().add(virtualregister);
                });
                IRinst.getDef().forEach(virtualregister -> basicblock.getDef().add(virtualregister));
                initial.addAll(IRinst.getDef());
                initial.addAll(IRinst.getUse());
            }
        });
        initial.removeAll(precolored);
        initial.remove(vsp);
        initial.remove(vs0);
        //solve
        boolean changed = true;
        for(; changed;){
            changed = false;
            for (basicblock basicblock : function.getPostOrderDFSBBList()) {
                Set<virtualregister> newOut = new HashSet<>();
                Set<virtualregister> newIn = new HashSet<>(basicblock.getUse());
                Set<virtualregister> tmp = new HashSet<>(basicblock.getLiveOut());
                tmp.removeAll(basicblock.getDef());
                newIn.addAll(tmp);
                basicblock.getSuccessors().forEach(successor -> newOut.addAll(successor.getLiveIn()));
                if (!basicblock.getLiveIn().equals(newIn) || !basicblock.getLiveOut().equals(newOut)) {
                    changed = true;
                    basicblock.setLiveIn(newIn);
                    basicblock.setLiveOut(newOut);
                }
            }
        }
    }

    private void build(function function) {
        initial.forEach(virtualregister -> {
            virtualregister.clearAllocInfo();
            virtualregister.degree = 0;
            virtualregister.color = null;
        });
        precolored.forEach(virtualregister -> {
            virtualregister.clearAllocInfo();
            virtualregister.degree = Integer.MAX_VALUE;
        });
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            Set<virtualregister> live = new HashSet<>(basicblock.getLiveOut());
            /*if (basicblock == function.getExitBlock()) {
                live.addAll(calleeSaveVRegisters);
                live.remove(vrbp);
                live.remove(vrsp);
            }*/
            for (IRinst IRinst = basicblock.tail; IRinst != null; IRinst = IRinst.getprevInstruction()) {
                if (IRinst instanceof move && ((move) IRinst).getDst() instanceof virtualregister && !(((move) IRinst).getSrc() instanceof realregister)) {
                    //Dead move Elimination
                    if (((move) IRinst).getDst() == ((move) IRinst).getSrc()) {
                        IRinst.deleteSelf();
                        continue;
                    }
                    Set<virtualregister> tmp = new HashSet<>(live);
                    tmp.retainAll(IRinst.getDef());
                    if (tmp.isEmpty()) {
                        IRinst.deleteSelf();
                        continue;
                    }
                }
                if (IRinst instanceof move
                        && ((move) IRinst).getDst() instanceof virtualregister && ((move) IRinst).getSrc() instanceof virtualregister
                        && !(((move) IRinst).getDst() instanceof globalvar) && !(((move) IRinst).getSrc() instanceof globalvar)) {
                    live.removeAll(IRinst.getUse());
                    for (virtualregister def : IRinst.getDef())
                        def.moveList.add((move) IRinst);
                    for (virtualregister use : IRinst.getUse())
                        use.moveList.add((move) IRinst);
                    worklistmoves.add((move) IRinst);
                }
                live.addAll(IRinst.getDef());
                live.add(vzero);
                for (virtualregister def : IRinst.getDef())
                    for (virtualregister liveVR : live)
                        addEdge(def, liveVR);
                live.removeAll(IRinst.getDef());
                live.addAll(IRinst.getUse());
            }
        });
    }

    private void makeWorklist() {
        for (virtualregister n : initial) {
            if (n.degree >= K) spillWorklist.add(n);
            else if (moveRelated(n)) freezeWorklist.add(n);
            else simplifyWorklist.add(n);
        }
    }

    private Set<virtualregister> adjacent(virtualregister n){
        Set<virtualregister> res = new HashSet<>(n.adjList);
        res.removeAll(selectStackNodes);
        res.removeAll(coalescedNodes);
        return res;
    }

    private Set<move> nodemoves(virtualregister n) {
        Set<move> res = new HashSet<>(n.moveList);
        Set<move> tmp = new HashSet<>(activemoves);
        tmp.addAll(worklistmoves);
        res.retainAll(tmp);
        return res;
    }

    private boolean moveRelated(virtualregister n) {
        return !nodemoves(n).isEmpty();
    }

    private void simplify() {
        virtualregister n = simplifyWorklist.iterator().next();
        simplifyWorklist.remove(n);
        selectStack.push(n);
        selectStackNodes.add(n);
        for (virtualregister m : adjacent(n))
            decrementDegree(m);
    }

    private void decrementDegree(virtualregister m){
        int d = m.degree;
        m.degree = d - 1;
        if (d == K) {
            Set<virtualregister> tmp = new HashSet<>(adjacent(m));
            tmp.add(m);
            enablemoves(tmp);
            spillWorklist.remove(m);
            if (moveRelated(m)) freezeWorklist.add(m);
            else simplifyWorklist.add(m);
        }
    }

    private void enablemoves(Set<virtualregister> nodes) {
        for (virtualregister n : nodes)
            for (move m : nodemoves(n))
                if (activemoves.contains(m)) {
                    activemoves.remove(m);
                    worklistmoves.add(m);
                }
    }

    private void addWorklist(virtualregister u) {
        if (!precolored.contains(u) && !moveRelated(u) && u.degree < K) {
            freezeWorklist.remove(u);
            simplifyWorklist.add(u);
        }
    }

    private boolean ok(virtualregister t, virtualregister r) {
        return t.degree < K || precolored.contains(t) || adjSet.contains(new Edge(t, r));
    }

    private boolean conservative(Set<virtualregister> nodes) {
        int k = 0;
        for (virtualregister n : nodes)
            if (n.degree >= K) {
                k++;
            }
        return k < K;
    }

    private void coalesce(){
        move m = worklistmoves.iterator().next();
        virtualregister x = getAlias((virtualregister) m.getDst());
        virtualregister y = getAlias((virtualregister) m.getSrc());
        virtualregister u, v;
        if (precolored.contains(y)) {
            u = y;
            v = x;
        } else {
            u = x;
            v = y;
        }
        worklistmoves.remove(m);
        if (u == v) {
            coalescedmoves.add(m);
            addWorklist(u);
        } else if (precolored.contains(v) || adjSet.contains(new Edge(u, v))) {
            constrainedmoves.add(m);
            addWorklist(u);
            addWorklist(v);
        } else {
            boolean cond1 = precolored.contains(u);
            for (virtualregister t : adjacent(v)) cond1 &= ok(t, u);
            boolean cond2 = !precolored.contains(u);
            Set<virtualregister> tmp = adjacent(u);
            tmp.addAll(adjacent(v));
            cond2 &= conservative(tmp);
            if (cond1 || cond2) {
                coalescedmoves.add(m);
                combine(u, v);
                addWorklist(u);
            } else activemoves.add(m);
        }
    }

    private void combine(virtualregister u, virtualregister v) {
        if (freezeWorklist.contains(v)) freezeWorklist.remove(v);
        else spillWorklist.remove(v);
        coalescedNodes.add(v);
        v.alias = u;
        u.moveList.addAll(v.moveList);
        Set<virtualregister> tmp = new HashSet<>();
        tmp.add(v);
        enablemoves(tmp);
        for (virtualregister t : adjacent(v)) {
            addEdge(t, u);
            decrementDegree(t);
        }
        if (u.degree >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    private virtualregister getAlias(virtualregister n) {
        if (coalescedNodes.contains(n)) return n.alias = getAlias(n.alias);
        else return n;
    }

    private void freeze() {
        virtualregister u = freezeWorklist.iterator().next();
        freezeWorklist.remove(u);
        simplifyWorklist.add(u);
        freezemoves(u);
    }

    private void freezemoves(virtualregister u) {
        for (move m : nodemoves(u)) {
            virtualregister x = getAlias((virtualregister) m.getDst());
            virtualregister y = getAlias((virtualregister) m.getSrc());
            virtualregister v = y == getAlias(u) ? x : y;
            activemoves.remove(m);
            frozenmoves.add(m);
            if (freezeWorklist.contains(v) && nodemoves(v).isEmpty()) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    private void selectSpill() {
        Iterator<virtualregister> iterator = spillWorklist.iterator();
        //Heuristic
        virtualregister m = iterator.next();
        for (; m.addForSpill && iterator.hasNext(); m = iterator.next()) ;
        iterator = spillWorklist.iterator();
        for (virtualregister now; iterator.hasNext(); ) {
            now = iterator.next();
            if (!now.addForSpill && now.spillPriority < m.spillPriority)
                m = now;
        }
        spillWorklist.remove(m);
        simplifyWorklist.add(m);
        freezemoves(m);
    }

    private void assignColors(){
        while (!selectStack.isEmpty()) {
            virtualregister n = selectStack.pop();
            selectStackNodes.remove(n);
            Set<realregister> okColors = new HashSet<>(colors);
            for (virtualregister w : n.adjList)
                if (coloredNodes.contains(getAlias(w)) || precolored.contains(getAlias(w))) {
                    okColors.remove(getAlias(w).color);
                }
            if (okColors.isEmpty()) {
                spilledNodes.add(n);
            } else {
                coloredNodes.add(n);
                //select callee saved first
                realregister color1 = okColors.iterator().next(), color2 = null;
                okColors.retainAll(calleeSaveRegisters);
                if (!okColors.isEmpty()) color2 = okColors.iterator().next();
                n.color = color2 != null ? color2 : color1;
            }
        }
        for (virtualregister n : coalescedNodes)
            n.color = getAlias(n).color;
    }

    private void rewriteProgram(function function) {
        for (virtualregister virtualregister : spilledNodes)
            virtualregister.spillAddr = new stackdata(sp, null, new immediate(-(++function.temporaryCnt) * config.intsize));
        for (virtualregister virtualregister : coalescedNodes)
            getAlias(virtualregister);
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                for (virtualregister use : IRinst.getUse())
                    if (use.spillAddr != null) {
                        if (IRinst.getDef().contains(use)) {
                            I64Value tmp = new I64Value("spill_tmp");
                            tmp.addForSpill = true;
                            IRinst.prependInstruction(new load(basicblock, use.spillAddr, tmp));
                            IRinst.postpendInstruction(new store(basicblock, tmp, use.spillAddr));
                            IRinst.replaceUse(use, tmp);
                            IRinst.replaceDef(use, tmp);
                        } else {
                            //TODO : peephole optimization for move, Binary(add, sub, mul, and, or, xor)
                            if (IRinst instanceof move && ((move) IRinst).getSrc() == use && ((virtualregister) ((move) IRinst).getDst()).spillAddr == null)
                                IRinst.replaceInstruction(new load(basicblock, use.spillAddr, ((move) IRinst).getDst()));
                            else {
                                I64Value tmp = new I64Value("spill_tmp");
                                tmp.addForSpill = true;
                                IRinst.prependInstruction(new load(basicblock, use.spillAddr, tmp));
                                IRinst.replaceUse(use,tmp);
                            }
                        }
                    }
                for (virtualregister def : IRinst.getDef()) {
                    if (def.spillAddr != null) {
                        if (!IRinst.getUse().contains(def)) {
                            if (IRinst instanceof move && ((move) IRinst).getSrc() instanceof virtualregister && ((virtualregister) ((move) IRinst).getSrc()).spillAddr == null)
                                IRinst.replaceInstruction(new store(basicblock, ((move) IRinst).getSrc(), def.spillAddr));
                            else {
                                I64Value tmp = new I64Value("spill_tmp");
                                tmp.addForSpill = true;
                                IRinst.postpendInstruction(new store(basicblock, tmp, def.spillAddr));
                                IRinst.replaceDef(def, tmp);
                            }
                        }
                    }
                }
                IRinst.calcUseAndDef();
            }
        });
    }

    private void addEdge(virtualregister u, virtualregister v) {
        if (u != v && !adjSet.contains(new Edge(u, v))) {
            adjSet.add(new Edge(u, v));
            adjSet.add(new Edge(v, u));
            if (!precolored.contains(u)) {
                u.adjList.add(v);
                u.degree++;
            }
            if (!precolored.contains(v)) {
                v.adjList.add(u);
                v.degree++;
            }
        }
    }

    private class Edge {
        virtualregister u;
        virtualregister v;

        Edge(virtualregister u, virtualregister v) {
            this.u = u;
            this.v = v;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof Edge)
                return u == ((Edge) object).u && v == ((Edge) object).v;
            else
                return false;
        }

        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }
    }




}

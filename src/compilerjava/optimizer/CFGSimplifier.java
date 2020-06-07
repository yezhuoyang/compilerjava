package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.branch;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.instruction.jump;
import compilerjava.IR.instruction.phi;
import compilerjava.IR.operand.immediate;

import java.util.LinkedList;
import java.util.List;



public class CFGSimplifier extends pass {
    public CFGSimplifier(IRroot irRoot) {
        super(irRoot);
    }

    @Override
    public boolean run() {
        changed = false;
        Irroot.getFunctionMap().forEach((name, function) -> {
            convertClearbranch(function);
            removeUnreachableBB(function);
        });
        return changed;
    }

    boolean runMore() {
        changed = false;
        Irroot.getFunctionMap().forEach((name, function) -> {
            convertClearbranch(function);
            eliminateSinglebranchBB(function);
            removeUnreachableBB(function);
            mergeBB(function);
        });
        return changed;
    }

    private void convertClearbranch(function function) {
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            if (basicblock.tail instanceof branch) {
                branch branch = (branch) basicblock.tail;
                if (branch.getThenBB() == branch.getElseBB()) {
                    changed = true;
                    branch.replaceInstruction(new jump(basicblock, branch.getThenBB()));
                } else if (branch.getCond() instanceof immediate) {
                    changed = true;
                    int cond = ((immediate) branch.getCond()).getImmediate();
                    basicblock target = cond == 1 ? branch.getThenBB() : branch.getElseBB();
                    basicblock cut = cond == 1 ? branch.getElseBB() : branch.getThenBB();
                    branch.replaceInstruction(new jump(basicblock, target));
                    for (IRinst IRinst = cut.head; IRinst instanceof phi; IRinst = IRinst.getNextInstruction())
                        ((phi) IRinst).removePath(basicblock);
                    basicblock.getSuccessors().remove(cut);
                    cut.getPredecessors().remove(basicblock);
                }
            }
        });
        function.recalcReversePostOrderDFSBBList();
    }

    private void removeUnreachableBB(function function) {
        //RPO remove orphan
        List<basicblock> removeList = new LinkedList<>();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> basicblock.getPredecessors().forEach(predecessor -> {
            if (!function.reachable(predecessor)) {
                changed = true;
                removeList.add(predecessor);
            }
        }));
        removeList.forEach(basicblock::deleteSelf);
        function.recalcReversePostOrderDFSBBList();
    }

    private void mergeBB(function function) {
        //PO merge BB
        for (int i = function.getReversePostOrderDFSBBList().size() - 1; i >= 0; i--) {
            basicblock basicblock = function.getReversePostOrderDFSBBList().get(i);
            if (basicblock.getSuccessors().size() == 1) {
                basicblock successor = basicblock.getSuccessors().iterator().next();
                if (successor != function.getEntryBB() && successor.getPredecessors().size() == 1 && successor != basicblock) {
                    changed = true;
                    successor.mergeBB(basicblock);
                    if (successor == function.getExitBB())
                        function.setExitBB(basicblock);
                }
            }
        }
        function.recalcReversePostOrderDFSBBList();
    }

    private void eliminateSinglebranchBB(function function) {
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            if (basicblock != function.getEntryBB()) {
                if(basicblock.head == basicblock.tail && basicblock.head instanceof jump) {
                    changed = true;
                    basicblock targetBB = ((jump) basicblock.head).getDestBB();
                    targetBB.getPredecessors().remove(basicblock);
                    for (basicblock predecessor : basicblock.getPredecessors()) {
                        predecessor.getSuccessors().remove(basicblock);
                        predecessor.getSuccessors().add(targetBB);
                        targetBB.getPredecessors().add(predecessor);
                        if (predecessor.tail instanceof jump) {
                            ((jump) predecessor.tail).setDestBB(targetBB);
                        } else if (predecessor.tail instanceof branch) {
                            ((branch) predecessor.tail).replaceTarget(basicblock, targetBB);
                        }
                    }
                }
            }
        });
        function.recalcReversePostOrderDFSBBList();
    }
}

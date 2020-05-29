package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.*;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.HashSet;
import java.util.Set;



class DeadCodeEliminator extends pass {
    private Set<IRinst> markSet = new HashSet<>();

    DeadCodeEliminator(IRroot irRoot) {
        super(irRoot);
    }

    @Override
    boolean run() {
        changed = false;
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            computePostDominateTree(function);
            computeReverseDominantFrontier(function);
            aggressiveDeadCodeElimination(function);
        });
        return changed;
    }

    private void aggressiveDeadCodeElimination(function function) {
        mark(function);
        sweep(function);
    }

    private boolean isCritical(IRinst IRinst) {
        return !(IRinst instanceof binary || IRinst instanceof cmp || IRinst instanceof unary
                || IRinst instanceof branch || IRinst instanceof move || IRinst instanceof phi || IRinst instanceof jump);
    }

    private void mark(function function) {
        Set<IRinst> workList = new HashSet<>();
        markSet.clear();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                if (isCritical(IRinst)) {
                    markSet.add(IRinst);
                    workList.add(IRinst);
                }
            }
        });
        while (!workList.isEmpty()) {
            IRinst inst = workList.iterator().next();
            workList.remove(inst);
            if (inst == null) {
                System.err.println("ha?");
            }
            for (register use : inst.getUseregs()) {
                IRinst defOfUse = def.get(use);
                if (defOfUse != null)
                    if (!markSet.contains(defOfUse)) {
                        markSet.add(defOfUse);
                        workList.add(defOfUse);
                    }
            }
            for (basicblock b : inst.getCurrentBB().RDF) {
                IRinst j = b.tail;
                if (!markSet.contains(j)) {
                    markSet.add(j);
                    workList.add(j);
                }
            }
        }
    }

    private void sweep(function function) {
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                if (!markSet.contains(IRinst)) {
                    if (IRinst instanceof branch) {
                        changed = true;
                        IRinst.getCurrentBB().removeInst();
                        IRinst.getCurrentBB().finish(new jump(basicblock, basicblock.postIDOM));
                    } else if (!(IRinst instanceof jump)) {
                        changed = true;
                        IRinst.deleteSelf();
                    }
                }
            }
        });
    }
}

package compilerjava.optimizer;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.operand.virtualregister;

public class spillcalculator extends pass {

    public spillcalculator(IRroot irroot) {
        super(irroot);
    }

    @Override
    public boolean run() {
        Irroot.getFunctionMap().values().forEach(_function -> {
            computePostDominateTree(_function);
            computeReverseDominantFrontier(_function);
            computeDominateTree(_function);
            computeDominanceFrontier(_function);
        });
        Irroot.getFunctionMap().values().forEach(_function -> {
            calcLoopInformation(_function);
            markSpillPriority(_function);
        });
        return false;
    }

    private void markSpillPriority(function _function){
        _function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
            int loopLevel = belongingLoopHeaders.get(basicBlock) == null ? 0 : belongingLoopHeaders.get(basicBlock).size();
            int loopContribution = (int) Math.pow(10, loopLevel);
            for (IRinst irInstruction = basicBlock.head; irInstruction != null; irInstruction = irInstruction.getNextInstruction()) {
                irInstruction.calcUseAndDef();
                for (virtualregister def : irInstruction.getDef())
                    def.spillPriority += loopContribution;
                for (virtualregister use : irInstruction.getUse())
                    use.spillPriority += loopContribution;
            }
        });
    }

}

package compilerjava.optimizer;


import compilerjava.IR.IRroot;
import compilerjava.IR.function;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.instruction.binary;
import compilerjava.IR.instruction.load;
import compilerjava.IR.instruction.store;
import compilerjava.IR.operand.dynamicdata;
import compilerjava.IR.operand.immediate;
import compilerjava.IR.operand.virtualregister;
import compilerjava.config;

public class deadloadElim extends pass{

    deadloadElim(IRroot IRroot) {
        super(IRroot);
    }


    @Override
    boolean run() {
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            eliminateLoad(function);
        });
        return false;
    }

    private void eliminateLoad(function function){
        function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
            for (IRinst IRinst = basicBlock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                if (IRinst instanceof load){
                    if(use.get(((load)IRinst).getDst()).size()==0){
                        IRinst.deleteSelf();
                        calcDefUseChain(function);
                    }
                }
        });
    }

}

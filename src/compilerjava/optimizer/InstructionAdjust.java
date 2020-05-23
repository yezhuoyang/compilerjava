package compilerjava.optimizer;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;




public class InstructionAdjust extends pass{



    public InstructionAdjust(IRroot irroot){
        super(irroot);
    }


    @Override
    public boolean run() {
        Irroot.getFunctionMap().values().forEach(this::adjustImmpos);
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            mergeCmpwithBranch(function);
        });
        return true;
    }




    private void  adjustImmpos(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()) {
                if (irinst instanceof cmp) {
                    if (((cmp) irinst).getSrc1() instanceof immediate) {
                        irinst.replaceInstruction(((cmp) irinst).inverseInst());
                    }
                }
            }
        });
    }



    private void mergeCmpwithBranch(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
             if(BB.tail instanceof branch){
                if(((branch)BB.tail).getCond() instanceof virtualregister){
                    virtualregister cond=(virtualregister) ((branch) BB.tail).getCond();
                    if(def.get(cond) instanceof cmp && use.get(cond).size()==1){
                        cmp defOfCond=(cmp) def.get(cond);
                        defOfCond.deleteSelf();
                        defOfCond.setDefReg(null);
                        ((branch)BB.tail).setCond(null);
                        ((branch)BB.tail).defOfCond=defOfCond;
                    }else{
                        cmp newCmp=new cmp(BB,cmp.Op.EQ,cond,new immediate(1,config.boolsize),null);
                        ((branch)BB.tail).setCond(null);
                        ((branch)BB.tail).defOfCond=newCmp;
                    }
                }
             }
        });
    }






}

package compilerjava.optimizer;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;

import java.util.concurrent.atomic.AtomicInteger;


public class InstructionAdjust extends pass{


    public InstructionAdjust(IRroot irroot){
        super(irroot);
    }


    @Override
    public boolean run() {
        Irroot.getFunctionMap().values().forEach(this::adjustcall);
        Irroot.getFunctionMap().values().forEach(this::adjustImm);
        Irroot.getFunctionMap().values().forEach(this::adjustStore);
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            mergeCmpwithBranch(function);
        });
        return true;
    }




    // Adjust the position of immediate of binary function.
    // If both parts of the instruction are immediate, replace it with move instruction.
    public void adjustImm(function func) {
        func.getReversePostOrderDFSBBList().forEach(BB->{
            int srccondition= 1;
            int imm1=0;
            int imm2=0;
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
                if (irinst instanceof binary) {
                    if(((binary) irinst).getSrc1() instanceof register &&((binary) irinst).getSrc2() instanceof register)continue;
                    if(((binary) irinst).getSrc1() instanceof immediate){
                         if(((binary) irinst).getSrc2() instanceof immediate){
                                imm1=((immediate) ((binary) irinst).getSrc1()).getImmediate();
                                imm2=((immediate) ((binary) irinst).getSrc2()).getImmediate();
                                srccondition=0; // Case when both src1 and src2 are immediate
                         }
                         else{
                                srccondition=1;//Case when only src1 is an immediate
                         }
                    }else {
                                srccondition=2; //Case when only src2 is an immediate
                    }
                    switch (((binary) irinst).getOp()){
                        case ADD:
                             if(srccondition==2)continue;
                             else if(srccondition==1)irinst.replaceInstruction(new binary(BB,binary.Op.ADD,((binary) irinst).getSrc2(),((binary) irinst).getSrc1(),((binary) irinst).getDst()));
                             else{
                                 irinst.replaceInstruction(new move(BB,new immediate(imm1+imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                             }
                             break;
                        case BITL:
                            if(srccondition==2)continue;
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.BITL,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1<<imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                            }
                            break;
                        case BITR:
                            if(srccondition==2)continue;
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.BITR,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1>>imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                            }
                            break;
                        case BITAND:
                            if(srccondition==2)continue;
                            else if(srccondition==1)irinst.replaceInstruction(new binary(BB,binary.Op.BITAND,((binary) irinst).getSrc2(),((binary) irinst).getSrc1(),((binary) irinst).getDst()));
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1&imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                            }
                            break;
                        case BITOR:
                            if(srccondition==2)continue;
                            else if(srccondition==1)irinst.replaceInstruction(new binary(BB,binary.Op.BITOR,((binary) irinst).getSrc2(),((binary) irinst).getSrc1(),((binary) irinst).getDst()));
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1|imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                            }
                            break;
                        case XOR:
                            if(srccondition==2)continue;
                            else if(srccondition==1)irinst.replaceInstruction(new binary(BB,binary.Op.XOR,((binary) irinst).getSrc2(),((binary) irinst).getSrc1(),((binary) irinst).getDst()));
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate((imm1==1)||(imm2==1)?1:0,config.boolsize),((binary) irinst).getDst()));
                            }
                            break;
                        case SUB:
                            if(srccondition==2){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2())  ,tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.SUB,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1())  ,tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.SUB,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1-imm2,config.intsize),((binary) irinst).getDst()));
                            }
                            break;
                        case MUL:
                            if(srccondition==2){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2())  ,tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.MUL,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.MUL,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1*imm2,config.intsize),((binary) irinst).getDst()));
                            }
                            break;
                        case DIV:
                            if(srccondition==2){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.DIV,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.DIV,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1/imm2,config.intsize),((binary) irinst).getDst()));
                            }
                            break;
                        case MOD:
                            if(srccondition==2){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2())  ,tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.MOD,((binary) irinst).getSrc1(),tempop,((binary) irinst).getDst()));
                            }
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.MOD,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1%imm2,config.intsize),((binary) irinst).getDst()));
                            }
                            break;
                    }
                }
            }
        });
    }






    private void  adjustcall(function func){
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



    // The srouce of store must be a register
    private void  adjustStore(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()) {
                if (irinst instanceof store) {
                    if (((store) irinst).getSrc() instanceof immediate) {
                        virtualregister newSrc=new I64Value(((store) irinst).getSrc().getSize());
                        irinst.prependInstruction(new move(BB,((store) irinst).getSrc(),newSrc));
                        irinst.replaceInstruction(new store(((store) irinst).getSrc().getSize(),BB,newSrc,((store) irinst).getDst()));
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

                        // To endure that the second operand is a register.
                        defOfCond.setDefReg(null);
                        if(defOfCond.getSrc2() instanceof immediate){
                            operand newop=new I64Value(config.intsize);
                            BB.tail.prependInstruction(new move(BB,defOfCond.getSrc2(),newop));
                            defOfCond=new cmp(BB,defOfCond.getOp(),defOfCond.getSrc1(),newop,defOfCond.getDst());
                        }

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

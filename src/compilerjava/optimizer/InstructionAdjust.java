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
        Irroot.getFunctionMap().values().forEach(this::adjustcmp);
        Irroot.getFunctionMap().values().forEach(this::adjustImm);
        Irroot.getFunctionMap().values().forEach(this::adjustStore);
        Irroot.getFunctionMap().values().forEach(this::adjustNeg);
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            mergeCmpwithBranch(function);
        });
        Irroot.getFunctionMap().values().forEach(this::inversecmp);
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
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.BITL,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
                            }
                            else{
                                irinst.replaceInstruction(new move(BB,new immediate(imm1<<imm2,((binary) irinst).getSrc1().getSize()),((binary) irinst).getDst()));
                            }
                            break;
                        case BITR:
                            if(srccondition==2)continue;
                            else if(srccondition==1){
                                virtualregister tempop=new I64Value(config.intsize);
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc1()),tempop) );
                                irinst.replaceInstruction(new binary(BB,binary.Op.BITR,tempop,((binary) irinst).getSrc2(),((binary) irinst).getDst()));
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
                                irinst.prependInstruction(new move(BB,(immediate)(((binary) irinst).getSrc2()),tempop) );
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

    // Make sure that only LT,
    private void  adjustcmp(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
                if (irinst instanceof cmp) {
                    if (((cmp) irinst).getSrc1() instanceof immediate) {
                       if(!(((cmp) irinst).getSrc2() instanceof immediate))
                         irinst.replaceInstruction(((cmp) irinst).inverseInst());
                       //Trivial expression
                       else{
                           switch (((cmp)irinst).getOp()){
                               case  LT:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()< ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                               case  GT:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()> ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                               case  LEQ:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()<= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                               case  EQ:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()== ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                               case  GEQ:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()>= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                               case  NEQ:
                                   irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()!= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                   break;
                           }
                       }
                    }
                }
            }
        });
    }


    private void  inversecmp(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
                if (irinst instanceof cmp) {
                    if (!(((cmp) irinst).getSrc1() instanceof immediate)&&   (((cmp) irinst).getSrc2() instanceof immediate)){
                        switch (((cmp)irinst).getOp()){
                            case  LT:
                            case  LEQ:
                            case  EQ:
                            case  NEQ:
                                break;
                            default:{
                                    virtualregister loadop=new I64Value(config.intsize);
                                    irinst.prependInstruction(new move(BB,((cmp) irinst).getSrc2(),loadop));
                                    irinst.replaceInstruction(new cmp(BB,((cmp) irinst).getOp(),((cmp) irinst).getSrc1(),loadop,((cmp) irinst).getDst()));
                            }
                        }
                    }
                    else if (((cmp) irinst).getSrc1() instanceof immediate) {
                        if(!(((cmp) irinst).getSrc2() instanceof immediate)){
                            switch (((cmp)irinst).getOp()){
                                case  GT:
                                case  GEQ:
                                      break;
                                default:{
                                    virtualregister loadop=new I64Value(config.intsize);
                                    irinst.prependInstruction(new move(BB,((cmp) irinst).getSrc1(),loadop));
                                    irinst.replaceInstruction(new cmp(BB,((cmp) irinst).getOp(),loadop,((cmp) irinst).getSrc2(),((cmp) irinst).getDst()));
                                }
                            }
                        }
                            //Trivial expression
                        else{
                            switch (((cmp)irinst).getOp()){
                                case  LT:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()< ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                                case  GT:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()> ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                                case  LEQ:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()<= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                                case  EQ:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()== ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                                case  GEQ:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()>= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                                case  NEQ:
                                    irinst.replaceInstruction(new move(BB,new immediate(config.boolsize,((immediate)((cmp)irinst).getSrc1()).getImmediate()!= ((immediate)((cmp)irinst).getSrc2()).getImmediate()?1:0),((cmp) irinst).getDst()));
                                    break;
                            }
                        }
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
                    else if(((store) irinst).getSrc() instanceof globalvar){
                        virtualregister newSrc=new I64Value(((store) irinst).getSrc().getSize());
                        irinst.prependInstruction(new load(((store) irinst).getSrc().getSize(),BB,((store) irinst).getSrc(),newSrc));
                        irinst.replaceInstruction(new store(((store) irinst).getSrc().getSize(),BB,newSrc,((store) irinst).getDst()));
                    }
                }
            }
        });
    }




    // The srouce of a unary operand must be a register
    private void  adjustNeg(function func){
        func.getReversePostOrderDFSBBList().forEach(BB->{
            for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()) {
                if (irinst instanceof unary){
                      if(((unary)irinst).getSrc() instanceof immediate){
                          switch (((unary)irinst).getOp()){
                              case NEG:
                                  irinst.replaceInstruction(new move(BB,new immediate(-((immediate)((unary)irinst).getSrc()).getImmediate(),config.intsize),((unary)irinst).getDst()));
                                  break;
                              case BITNOT:
                                  irinst.replaceInstruction(new move(BB,new immediate(~((immediate)((unary)irinst).getSrc()).getImmediate(),config.intsize),((unary)irinst).getDst()));
                                  break;
                          }
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
                        // To ensure that the second operand is a register.
                        defOfCond.setDefReg(null);
                        if(defOfCond.getSrc2() instanceof immediate){
                            operand newop=new I64Value(config.intsize);
                            BB.tail.prependInstruction(new move(BB,defOfCond.getSrc2(),newop));
                            defOfCond=new cmp(BB,defOfCond.getOp(),defOfCond.getSrc1(),newop,defOfCond.getDst());
                        }
                        ((branch)BB.tail).setCond(null);
                        ((branch)BB.tail).defOfCond=defOfCond;
                    }else{
                        operand opforcompare=new I64Value(config.boolsize);
                        IRinst newload=new move(BB,new immediate(1,config.boolsize),opforcompare);
                        cmp newCmp=new cmp(BB,cmp.Op.EQ,cond,opforcompare,null);
                        ((branch)BB.tail).setCond(null);
                        ((branch)BB.tail).defOfCond=newCmp;
                        ((branch)BB.tail).prependInstruction(newload);
                    }
                }
             }
        });
    }


    private void mergeAddrCalcWithloadAndstore(function function) {
        function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
            for (IRinst IRinst = basicBlock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                if (IRinst instanceof load) {
                    if (((load) IRinst).getSrc() instanceof virtualregister) {
                        virtualregister addr = (virtualregister) ((load) IRinst).getSrc();
                        if (use.get(addr).size() == 1) {
                            IRinst defOfAddr_tmp = def.get(addr);
                            if(defOfAddr_tmp instanceof move && ((move)defOfAddr_tmp).getSrc() instanceof immediate){
                                defOfAddr_tmp.deleteSelf();
                                for (register useregister : defOfAddr_tmp.getUseregs()) {
                                    use.get(useregister).remove(defOfAddr_tmp);
                                    use.get(useregister).add(IRinst);
                                }
                            }
                            IRinst.replaceUseReg(((load) IRinst).getSrc(), new dynamicdata(((register) ((load) IRinst).getSrc()),new immediate(((immediate)((move)defOfAddr_tmp).getSrc()).getImmediate(),config.intsize),((load) IRinst).getSize()));
                        }
                        else{
                            IRinst.replaceUseReg(((load) IRinst).getSrc(), new dynamicdata(((register) ((load) IRinst).getSrc()),  new immediate(0,config.intsize),((load) IRinst).getSize()));
                        }
                    }
                } else if (IRinst instanceof store){
                    if (((store) IRinst).getDst() instanceof virtualregister) {
                        virtualregister addr = (virtualregister) ((store) IRinst).getDst();
                        if (use.get(addr).size() == 1) {
                            IRinst defOfAddr_tmp = def.get(addr);
                            if (defOfAddr_tmp instanceof move && ((move) defOfAddr_tmp).getSrc() instanceof immediate) {
                                defOfAddr_tmp.deleteSelf();
                                for (register useregister : defOfAddr_tmp.getUseregs()) {
                                    use.get(useregister).remove(defOfAddr_tmp);
                                    use.get(useregister).add(IRinst);
                                }
                            }
                            IRinst.replaceUseReg(((store) IRinst).getDst(), new dynamicdata(((register) ((store) IRinst).getDst()), new immediate(((immediate) ((move) defOfAddr_tmp).getDst()).getImmediate(), config.intsize), ((store) IRinst).getSize()));
                        } else {
                            IRinst.replaceUseReg(((store) IRinst).getDst(), new dynamicdata(((register) ((store) IRinst).getDst()), new immediate(0, config.intsize), ((store) IRinst).getSize()));
                        }
                    }
                }
        });
    }


}

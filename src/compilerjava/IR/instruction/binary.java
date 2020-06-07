package compilerjava.IR.instruction;


import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.*;

import java.util.Map;

public class binary extends IRinst {
    private Op op;
    private operand src1,src2,dst;

    public operand previousResult=null;

    public binary(basicblock currentBB,Op op,operand src1,operand src2, operand dst){
        super(currentBB);
        this.op=op;
        this.src1=src1;
        this.src2=src2;
        this.dst=dst;
        updateUseRegs();
    }

    public Op getOp() {
        return op;
    }

    public operand getSrc1() {
        return src1;
    }

    public void setSrc1(operand src1) {
        this.src1 = src1;
    }

    public operand getSrc2() {
        return src2;
    }

    public void setSrc2(operand src2) {
        this.src2 = src2;
    }

    public operand getDst() {
        return dst;
    }

    public void setDst(operand dst) {
        this.dst = dst;
    }


    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs() {
        useregs.clear();
        if(src1 instanceof register) useregs.add((register)src1);
        if(src2 instanceof register) useregs.add((register)src2);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(src1 instanceof register) src1=renameMap.get(src1);
        if(src2 instanceof register) src2=renameMap.get(src2);
        updateUseRegs();
    }


    @Override
    public void setDefReg(register newReg){
        dst=newReg;
    }

    @Override
    public register getDefReg() {
        return (register) dst;
    }

    @Override
    public void renameDefRegForSSA() {
        if(!(dst instanceof globalvar)){
            dst=((virtualregister)dst).getSSARenameReg(((virtualregister)dst).getNewId());
        }
    }

    @Override
    public void renameUseRegForSSA() {
        if(src1 instanceof virtualregister && !(src1 instanceof globalvar))
            src1=((virtualregister)src1).getSSARenameReg(((virtualregister)src1).info.stack.peek());
        if(src2 instanceof virtualregister && !(src2 instanceof globalvar))
            src2=((virtualregister)src2).getSSARenameReg(((virtualregister)src2).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(src1==oldop)src1=newop;
        if(src2==oldop)src2=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(src1 instanceof virtualregister && !(src1 instanceof globalvar))use.add((virtualregister)src1);
        if(src2 instanceof virtualregister && !(src2 instanceof globalvar))use.add((virtualregister)src2);
        if(dst instanceof virtualregister  && !(dst instanceof globalvar)) def.add((virtualregister)dst);
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
        if(src1==oldVR) src1=newVR;
        if(src2==oldVR) src2=newVR;
    }


    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(dst==oldVR) dst=newVR;
    }


    public boolean isCommutative(){
        return op==Op.ADD || op==Op.MUL || op==Op.BITAND || op==Op.BITOR || op==Op.XOR;
    }

    public enum Op{
        ADD,SUB,MUL,DIV,MOD,BITL,BITR,BITAND,BITOR,XOR
    }


    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return new binary(fakeBBMap.getOrDefault(currentBB, currentBB), op, fakeRegMap.getOrDefault(src1, src1), fakeRegMap.getOrDefault(src2, src2), fakeRegMap.getOrDefault(dst, dst));
    }


}

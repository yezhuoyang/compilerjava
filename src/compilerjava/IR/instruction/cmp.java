package compilerjava.IR.instruction;

import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;

public class cmp extends IRinst{
    private Op op;
    private operand src1;
    private operand src2;
    private operand dst;

    public operand previousResult=null;

    public cmp(basicblock currentBB,Op op,operand src1,operand src2,operand dst){
        super(currentBB);
        this.op=op;
        this.src1=src1;
        this.src2=src2;
        this.dst=dst;
        updateUseRegs();
    }

    public Op getOp(){
        return op;
    }

    public operand getSrc1(){
        return src1;
    }

    public operand getSrc2(){
        return src2;
    }

    public operand getDst(){
        return dst;
    }


    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
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
    public void renameDefRegForSSA(){
        if(dst instanceof virtualregister && !(dst instanceof globalvar))
            dst=((virtualregister)dst).getSSARenameReg(((virtualregister)dst).getNewId());
    }

    @Override
    public void renameUseRegForSSA(){
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
        if(src1 instanceof virtualregister && !(src1 instanceof globalvar)) use.add((virtualregister)src1);
        if(src2 instanceof virtualregister && !(src2 instanceof globalvar)) use.add((virtualregister)src2);
        if(dst instanceof virtualregister && !(dst instanceof globalvar)) def.add((virtualregister)dst);
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
        if(src1==oldVR)src1=newVR;
        if(src2==oldVR)src2=newVR;
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(dst==oldVR)dst=newVR;
    }

    public boolean isCommutative(){
        return op==Op.NEQ || op==Op.EQ;
    }


    public cmp inverseInst(){
        cmp.Op newOp=null;
        switch(this.op){
            case LT:
                newOp=Op.GT;
                break;
            case LEQ:
                newOp=Op.GEQ;
                break;
            case EQ:
                newOp=Op.EQ;
                break;
            case GT:
                newOp=Op.LT;
                break;
            case GEQ:
                newOp=Op.LEQ;
                break;
            case NEQ:
                newOp=Op.NEQ;
                break;
        }
        return new cmp(currentBB,newOp,src2,src1,dst);
    }


    public enum Op{
        LT,LEQ,EQ,GEQ,GT,NEQ
    }


    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return new cmp(fakeBBMap.getOrDefault(currentBB, currentBB), op, fakeRegMap.getOrDefault(src1, src1),
                fakeRegMap.getOrDefault(src2, src2), fakeRegMap.getOrDefault(dst, dst));
    }


}

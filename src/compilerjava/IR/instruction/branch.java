package compilerjava.IR.instruction;


import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;


public class branch extends IRinst {
    private operand cond;
    private basicblock thenBB;
    private basicblock elseBB;

    public cmp defOfCond=null;

    public branch(basicblock currentBB,operand cond,basicblock thenBB,basicblock elseBB){
        super(currentBB);
        this.cond=cond;
        this.thenBB=thenBB;
        this.elseBB=elseBB;
        updateUseRegs();
    }

    public basicblock getThenBB() {
        return thenBB;
    }

    public basicblock getElseBB() {
        return elseBB;
    }

    public void replaceTarget(basicblock oldBB,basicblock newBB){
        if(thenBB==oldBB)thenBB=newBB;
        else elseBB=newBB;
    }

    public operand getCond() {
        return cond;
    }

    public void setCond(operand cond) {
        this.cond = cond;
        updateUseRegs();
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
        useregs.clear();
        if(cond instanceof register) useregs.add((register)cond);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(cond instanceof register) cond=renameMap.get(cond);
    }


    @Override
    public void setDefReg(register newReg) {
    }

    @Override
    public register getDefReg() {
        return null;
    }

    @Override
    public void renameDefRegForSSA(){
    }

    @Override
    public void renameUseRegForSSA() {
        if(cond instanceof virtualregister && !(cond instanceof globalvar))
            cond=((virtualregister)cond).getSSARenameReg(((virtualregister)cond).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(cond==oldop) cond=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(defOfCond!=null){
           defOfCond.calcUseAndDef();
           use.addAll(defOfCond.use);
        }else{
            if(cond instanceof virtualregister && !(cond instanceof globalvar))use.add((virtualregister)cond);
        }
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){
        if(defOfCond!=null) defOfCond.replaceUse(oldVR,newVR);
        else{
            if(cond==oldVR) cond=newVR;
        }
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
    }


    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return new branch(fakeBBMap.getOrDefault(currentBB, currentBB), fakeRegMap.getOrDefault(cond, cond), fakeBBMap.getOrDefault(thenBB, thenBB), fakeBBMap.getOrDefault(elseBB, elseBB));
    }



}

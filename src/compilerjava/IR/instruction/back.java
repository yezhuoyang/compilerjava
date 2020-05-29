package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;

public class back extends IRinst{
    private operand returnValue;

    public back(basicblock currentBB,operand returnValue){
        super(currentBB);
        this.returnValue=returnValue;
        updateUseRegs();
    }

    public void setReturnValue(operand returnvalue){
        this.returnValue=returnvalue;
        updateUseRegs();
    }

    public operand getReturnValue(){
        return returnValue;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
        useregs.clear();
        if(returnValue instanceof register) useregs.add((register) returnValue);
    }

    @Override
    public register getDefReg() {
        return null;
    }

    @Override
    public void setDefReg(register newReg){
    }

    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(returnValue instanceof register) returnValue=renameMap.get(returnValue);
        updateUseRegs();
    }

    @Override
    public void renameDefRegForSSA(){
    }

    @Override
    public void renameUseRegForSSA(){
        if(returnValue instanceof virtualregister && !(returnValue instanceof globalvar))
            returnValue=((virtualregister)returnValue).getSSARenameReg(((virtualregister)returnValue).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(returnValue==oldop) returnValue=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(returnValue instanceof virtualregister && !(returnValue instanceof globalvar))
            use.add((virtualregister)returnValue);
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){
        if(returnValue==oldVR) returnValue=newVR;
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){

    }

    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return new back(fakeBBMap.getOrDefault(currentBB, currentBB), fakeRegMap.getOrDefault(returnValue, returnValue));
    }


}

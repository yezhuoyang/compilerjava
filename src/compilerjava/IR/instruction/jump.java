package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;



public class jump extends IRinst {
    private  basicblock destBB;

    public jump(basicblock currentBB,basicblock destBB){
        super(currentBB);
        this.destBB=destBB;
        updateUseRegs();
    }

    public basicblock getDestBB(){
        return destBB;
    }

    public void setDestBB(basicblock destBB) {
        this.destBB = destBB;
    }

    @Override
    public IRinst getFakeInst(Map<basicblock,basicblock> fakeBBMap,Map<operand,operand> fakeRegMap){
        return new jump(fakeBBMap.getOrDefault(currentBB,currentBB),fakeBBMap.getOrDefault(destBB,destBB));
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
        useregs.clear();
    }

    @Override
    public void setUseregs(Map<register,register> renameMap){

    }

    @Override
    public register getDefReg(){
        return null;
    }


    @Override
    public void setDefReg(register newreg){

    }

    @Override
    public void renameDefRegForSSA(){

    }

    @Override
    public void renameUseRegForSSA(){

    }

    @Override
    public void replaceUseReg(operand oldoperand,operand newoperand){

    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){

    }


    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){

    }







}

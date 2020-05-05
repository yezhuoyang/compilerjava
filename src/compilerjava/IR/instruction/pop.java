package compilerjava.IR.instruction;

import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;

public class pop extends IRinst{

    private operand dst;

    public pop(basicblock currentBB,operand dst){
        super(currentBB);
        this.dst=dst;
        updateUseRegs();
    }

    public operand getDst() {
        return dst;
    }

    @Override
    public IRinst getFakeInst(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap) {
        return null;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs() {
        useregs.clear();
        if(dst instanceof register) useregs.add((register)dst);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
    }


    @Override
    public void setDefReg(register newReg) {
    }

    @Override
    public register getDefReg() {
        return null;
    }

    @Override
    public void renameDefRegForSSA() {
    }

    @Override
    public void renameUseRegForSSA() {
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(dst==oldop) dst=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
    }
}

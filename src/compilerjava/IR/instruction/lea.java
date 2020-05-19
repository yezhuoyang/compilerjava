package compilerjava.IR.instruction;


import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.*;

import java.util.Map;

public class lea extends IRinst{
    private memory src;
    private operand dst;

    public lea(basicblock currentBB,memory src,operand dst){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        updateUseRegs();
    }


    public operand getDst() {
        return dst;
    }

    public memory getSrc() {
        return src;
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
    public void updateUseRegs(){
        useregs.clear();
        useregs.addAll(src.Useregs());
    }

    @Override
    public void setUseregs(Map<register,register> renameMap){
    }


    @Override
    public void setDefReg(register newReg) {
        dst=newReg;
    }

    @Override
    public register getDefReg(){
        return (register) dst;
    }

    @Override
    public void renameDefRegForSSA() {
    }

    @Override
    public void renameUseRegForSSA() {
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        src.replaceOperand(oldop,newop);
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        use.addAll(src.Useregs());
        if(dst instanceof virtualregister && !(dst instanceof globalvar))def.add((virtualregister)dst);
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
        src.replaceOperand(oldVR,newVR);
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(dst==oldVR)dst=newVR;
    }





}

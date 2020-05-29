package compilerjava.IR.instruction;


import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.Map;

public class move extends IRinst {
    private operand src;
    private operand dst;

    public move(basicblock currentBB,operand src,operand dst){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        updateUseRegs();
    }

    public operand getSrc(){
        return src;
    }

    public operand getDst() {
        return dst;
    }


    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs() {
        useregs.clear();
        if(src instanceof register) useregs.add((register) src);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(src instanceof register)src=renameMap.get(src);
        updateUseRegs();
    }


    @Override
    public void setDefReg(register newReg) {
        dst=newReg;
    }

    @Override
    public register getDefReg() {
        return (register) dst;
    }


    @Override
    public void renameDefRegForSSA() {
        if(dst instanceof virtualregister && !(dst instanceof globalvar))
            dst=((virtualregister) dst).getSSARenameReg(((virtualregister)dst).getNewId());
    }

    @Override
    public void renameUseRegForSSA() {
        if(src instanceof virtualregister && !(src instanceof globalvar))
            src=((virtualregister)src).getSSARenameReg(((virtualregister)src).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(src==oldop)src=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        assert  src instanceof virtualregister;
        assert  dst instanceof virtualregister;
        if(src instanceof virtualregister&& !(src instanceof  globalvar))use.add((virtualregister)src);
        if(dst instanceof virtualregister&&! (dst instanceof  globalvar))def.add((virtualregister)dst);
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
        if(src==oldVR) src=newVR;
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(dst==oldVR)dst=newVR;
    }



    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return new move(fakeBBMap.getOrDefault(currentBB, currentBB), fakeRegMap.getOrDefault(src, src), fakeRegMap.getOrDefault(dst, dst));
    }



}

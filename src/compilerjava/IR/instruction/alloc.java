package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.lang.annotation.Inherited;
import java.util.Map;

import static compilerjava.IR.operand.realregister.*;

public class alloc extends IRinst{
    private operand size;
    private operand pointer;

    public alloc(basicblock currentBB,operand size,operand pointer){
        super(currentBB);
        this.size=size;
        this.pointer=pointer;
        updateUseRegs();
    }

    public operand getSize(){
        return size;
    }

    public operand getPointer(){
        return pointer;
    }

    public void setSize(operand size) {
        this.size = size;
        updateUseRegs();
    }

    public void setPointer(operand pointer) {
        this.pointer = pointer;
    }

    @Override
    public IRinst getFakeInst(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap) {
        return new alloc(fakeBBMap.getOrDefault(currentBB,currentBB),fakeRegMap.getOrDefault(size,size),fakeRegMap.getOrDefault(pointer,pointer));
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs() {
        useregs.clear();
        if(size instanceof register) useregs.add((register) size);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(size instanceof register)size=renameMap.get(size);
        updateUseRegs();
    }


    @Override
    public void setDefReg(register newReg) {
        pointer=newReg;
    }

    @Override
    public register getDefReg() {
        return null;
    }

    @Override
    public void renameDefRegForSSA() {
        if(pointer instanceof virtualregister && !(pointer instanceof globalvar))
            pointer=((virtualregister)pointer).getSSARenameReg(((virtualregister)pointer).getNewId());
    }

    @Override
    public void renameUseRegForSSA() {
        if(size instanceof virtualregister && !(size instanceof globalvar))
            size=((virtualregister)size).getSSARenameReg(((virtualregister)size).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(size==oldop) size=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(size instanceof virtualregister && !(size instanceof globalvar)) use.add((virtualregister)size);
        if(pointer instanceof virtualregister && !(pointer instanceof globalvar))
            def.add((virtualregister)pointer);
        def.addAll(calleeSaveVRegisters);
        def.remove(vrsp);
        def.remove(vrbp);
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){
        if(size==oldVR)size=newVR;
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(pointer==oldVR)pointer=newVR;
    }

}

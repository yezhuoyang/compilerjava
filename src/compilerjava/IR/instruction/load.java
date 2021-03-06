package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.*;

import java.util.Map;

public class load extends IRinst {

    private operand src;
    private operand dst;
    private boolean isInsertedForGlobalVar;
    private boolean loadtoPointer=false;
    private int size;


    public boolean isLoadtoPointer() {
        return loadtoPointer;
    }

    public void setLoadtoPointer(boolean loadtoPointer) {
        this.loadtoPointer = loadtoPointer;
    }

    public void setInsertedForGlobalVar(boolean insertedForGlobalVar) {
        isInsertedForGlobalVar = insertedForGlobalVar;
    }

    public load(int S, basicblock currentBB, operand src, operand dst){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        this.isInsertedForGlobalVar=false;
        this.size=S;
        if(dst instanceof pointer){
            loadtoPointer=true;
        }
        updateUseRegs();
    }

    public int getSize() {
        return size;
    }

    public load(int S, basicblock currentBB, operand src, operand dst, boolean isInsertedForGlobalVar){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        this.isInsertedForGlobalVar=isInsertedForGlobalVar;
        if(dst instanceof pointer){
            loadtoPointer=true;
        }
        this.size=S;
        updateUseRegs();
    }

    public operand getSrc() {
        return src;
    }

    public operand getDst() {
        return dst;
    }

    public boolean isInsertedForGlobalVar() {
        return isInsertedForGlobalVar;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
        useregs.clear();
        if(src instanceof register)useregs.add((register)src);
        else if(src instanceof memory)useregs.addAll(((memory)src).Useregs());
    }

    @Override
    public register getDefReg(){
        return (register) dst;
    }

    @Override
    public void setDefReg(register newreg){
        dst=newreg;
    }

    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(src instanceof register) src=renameMap.get(src);
        updateUseRegs();
    }

    @Override
    public void renameDefRegForSSA(){
        if(dst instanceof virtualregister&& !(dst instanceof globalvar))
                dst=((virtualregister)dst).getSSARenameReg(((virtualregister)dst).getNewId());
    }

    @Override
    public void renameUseRegForSSA(){
        if(src instanceof virtualregister && !(src instanceof globalvar))
            src=((virtualregister)src).getSSARenameReg(((virtualregister)src).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldoperand,operand newoperand){
        if(src instanceof register){
            if(src==oldoperand) src=newoperand;
        }else if(src instanceof memory) ((memory) src).replaceOperand(oldoperand,newoperand);
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(src instanceof virtualregister && !(src instanceof globalvar))use.add((virtualregister)src);
        else if(src instanceof memory) use.addAll(((memory)src).Useregs());
        if(dst instanceof virtualregister && !(dst instanceof globalvar))def.add((virtualregister)dst);
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){
        if(src instanceof virtualregister){
            if(src==oldVR)src=newVR;
        }else if(src instanceof memory) ((memory)src).replaceOperand(oldVR,newVR);
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
        if(dst instanceof virtualregister){
           if(dst==oldVR) dst=newVR;
        }
    }

    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap) {
        load result = new load(size, fakeBBMap.getOrDefault(currentBB, currentBB), fakeRegMap.getOrDefault(src, src), fakeRegMap.getOrDefault(dst, dst));
        if(isInsertedForGlobalVar){
            result.setInsertedForGlobalVar(true);
        }
        if(isLoadtoPointer()){
            result.setLoadtoPointer(true);
        }
        return result;
    }

}

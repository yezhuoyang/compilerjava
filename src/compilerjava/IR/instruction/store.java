package compilerjava.IR.instruction;


import compilerjava.IR.IRvisitor;
import compilerjava.IR.basicblock;
import compilerjava.IR.operand.*;

import java.util.Map;

public class store extends IRinst{
    private operand src;
    private operand dst;
    private global64Value storeforglobal;
    private boolean isInsertedForglobalvar;
    private int size;

    public store(int S,basicblock currentBB,operand src,operand dst){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        this.isInsertedForglobalvar=false;
        this.size=S;
        updateUseRegs();
    }

    public global64Value getStoreforglobal() {
        return storeforglobal;
    }

    public store(int S, basicblock currentBB, operand src, operand dst, boolean isInsertedForglobalvar, global64Value storeforglobal){
        super(currentBB);
        this.src=src;
        this.dst=dst;
        this.isInsertedForglobalvar=isInsertedForglobalvar;
        this.storeforglobal=storeforglobal;
        this.size=S;
        updateUseRegs();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public operand getSrc(){
        return src;
    }

    public operand getDst(){
        return dst;
    }

    public boolean isInsertedForglobalvar(){
        return isInsertedForglobalvar;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs() {
        useregs.clear();
        if(src instanceof register) useregs.add((register)src);
        if(dst instanceof register) useregs.add((register)dst);
        else if(dst instanceof memory) useregs.addAll(((memory)dst).Useregs());
    }

    @Override
    public void setUseregs(Map<register,register> renameMap){
        if(src instanceof register) src=renameMap.get(src);
        if(dst instanceof register) dst=renameMap.get(dst);
        updateUseRegs();
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
    public void renameUseRegForSSA(){
        if(src instanceof virtualregister && !(src instanceof  globalvar))
            src=((virtualregister)src).getSSARenameReg(((virtualregister)src).info.stack.peek());
        if(dst instanceof virtualregister && !(dst instanceof globalvar))
            dst=((virtualregister)dst).getSSARenameReg(((virtualregister)dst).info.stack.peek());
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        if(src==oldop) src=newop;
        if(dst instanceof register){
            if(dst==oldop)dst=newop;
        }else if(dst instanceof memory) ((memory)dst).replaceOperand(oldop,newop);
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        if(src instanceof virtualregister && !(src instanceof globalvar))use.add((virtualregister)src);
        if(dst instanceof virtualregister && !(dst instanceof globalvar))use.add((virtualregister)dst);
        else if(dst instanceof memory) use.addAll(((memory)dst).Useregs());
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR){
        if(src instanceof virtualregister){
            if(src==oldVR){
                src=newVR;
            }
        }
        if(dst instanceof virtualregister){
            if(dst==oldVR){
                dst=newVR;
            }
        }else if(dst instanceof memory){
            ((memory)dst).replaceOperand(oldVR,newVR);
        }
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
    }


    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        if(isInsertedForglobalvar){
            return new store(size,fakeBBMap.getOrDefault(currentBB,currentBB),fakeRegMap.getOrDefault(src,src),fakeRegMap.getOrDefault(dst,dst),true,storeforglobal);
        }
        else
            return new store(size,fakeBBMap.getOrDefault(currentBB,currentBB),fakeRegMap.getOrDefault(src,src),fakeRegMap.getOrDefault(dst,dst));
    }




}

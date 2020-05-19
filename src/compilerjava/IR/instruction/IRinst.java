package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;

import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;



import java.util.*;


public abstract class IRinst {
    protected basicblock currentBB;
    protected List<register> useregs=new ArrayList<>();
    private compilerjava.IR.instruction.IRinst prevInstruction;
    private compilerjava.IR.instruction.IRinst nextInstruction;

    public IRinst(basicblock currentBB){
            this.currentBB=currentBB;
    }

    public basicblock getCurrentBB() {
        return currentBB;
    }

    public void setCurrentBB(basicblock currentBB) {
        this.currentBB = currentBB;
    }


    public boolean hasprevInstruction(){
        return prevInstruction!=null;
    }

    public IRinst getprevInstruction(){
        return prevInstruction;
    }

    public void setprevInstruction(compilerjava.IR.instruction.IRinst prevInstruction) {
        this.prevInstruction = prevInstruction;
    }

    public boolean hasNextInstruction(){
        return prevInstruction!=null;
    }

    public IRinst getNextInstruction(){
        return nextInstruction;
    }

    public void setNextInstruction(compilerjava.IR.instruction.IRinst nextInstruction){
        this.nextInstruction=nextInstruction;
    }

    public void replaceInstruction(compilerjava.IR.instruction.IRinst newInstruction){
        if(hasprevInstruction()){
            getprevInstruction().setNextInstruction(newInstruction);
            newInstruction.setprevInstruction(getprevInstruction());
        }else currentBB.head=newInstruction;
        if(hasNextInstruction()){
            getNextInstruction().setprevInstruction(newInstruction);
            newInstruction.setNextInstruction(getNextInstruction());
        }else currentBB.tail=newInstruction;
    }

    public void prependInstruction(IRinst newinstruct){
         if(prevInstruction!=null) prevInstruction.setNextInstruction(newinstruct);
         else currentBB.head=newinstruct;
         newinstruct.setprevInstruction(prevInstruction);
         newinstruct.setNextInstruction(this);
         setprevInstruction(newinstruct);
    }

    public void postpendInstruction(IRinst newinst){
         if(nextInstruction!=null) nextInstruction.setprevInstruction(newinst);
         else currentBB.tail=newinst;
         newinst.setprevInstruction(this);
         newinst.setNextInstruction(nextInstruction);
         setNextInstruction(newinst);
    }

    public void deleteSelf(){
        if(this==currentBB.head) currentBB.head=this.getNextInstruction();
        if(this==currentBB.tail) currentBB.tail=this.getprevInstruction();
        if(hasprevInstruction())getprevInstruction().setNextInstruction(this.nextInstruction);
        if(hasNextInstruction())getNextInstruction().setprevInstruction(this.prevInstruction);
    }

    public abstract void accept(IRvisitor iRvisitor);

    public abstract void updateUseRegs();


    public abstract register getDefReg();

    public abstract void setDefReg(register newReg);

    public List<register> getUseregs(){
        updateUseRegs();
        return useregs;
    }

    public abstract void setUseregs(Map<register,register> renameMap);

    public abstract IRinst getFakeInst(Map<basicblock,basicblock> fakeBBMap,Map<operand,operand> fakeRegMap);

    protected Set<virtualregister> use=new HashSet<>();
    protected Set<virtualregister> def=new HashSet<>();
    protected Set<virtualregister> liveIn=new HashSet<>();
    protected Set<virtualregister> liveOut=new HashSet<>();


    public abstract void renameDefRegForSSA();

    public abstract void renameUseRegForSSA();


    public abstract void replaceUseReg(operand oldoperand,operand newoperand);

    public abstract void calcUseAndDef();


    public abstract void replaceUse(virtualregister oldVR,virtualregister newVR);


    public abstract void replaceDef(virtualregister oldVR,virtualregister newVR);

    public Set<virtualregister> getUse(){
        return use;
    }

    public Set<virtualregister> getDef(){
        return def;
    }

    public void setLiveIn(Set<virtualregister> liveIn) {
        this.liveIn = liveIn;
    }

    public Set<virtualregister> getLiveOut() {
        return liveOut;
    }

    public Set<virtualregister> getLiveIn() {
        return liveIn;
    }
}

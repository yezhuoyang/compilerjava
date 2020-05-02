package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;

import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;





import java.util.*;


public class IRinst {
    protected basicblock currentBB;
    protected List<register> useregisters=new ArrayList<>();
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

    public compilerjava.IR.instruction.IRinst getprevInstruction(){
        return prevInstruction;
    }

    public void setprevInstruction(compilerjava.IR.instruction.IRinst prevInstruction) {
        this.prevInstruction = prevInstruction;
    }

    public boolean hasNextInstruction(){
        return prevInstruction!=null;
    }

    public compilerjava.IR.instruction.IRinst getNextInstruction(){
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


    }

    public void addInstruction(){

    }

    public void removeInstruction(){

    }








}

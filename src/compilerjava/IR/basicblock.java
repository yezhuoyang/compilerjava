package compilerjava.IR;

import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.virtualregister;

import java.util.HashSet;
import java.util.Set;
import java.io.*;


public class basicblock {
    public IRinst head;
    public IRinst tail;

    public basicblock IDOM;
    public int postOrderNumber;
    public int reversePostOrderNumber;
    public Set<basicblock> DF;
    public Set<basicblock> DTSuccessors;
    public Set<basicblock> DTAllSuccessors;

    public basicblock postIDOM;
    public Set<basicblock> RDF;
    public Set<basicblock> RDFSuccessors;


    private function currentfunction;
    private String name;
    private Set<basicblock>  predecessors=new HashSet<>();
    private Set<basicblock>  successors=new HashSet<>();
    private boolean finished;


    public basicblock(function currentfunction,String name){
        this.currentfunction=currentfunction;
        this.name=name;
    }

    public String getName(){
        return currentfunction.getName()+"_"+name;
    }

    public function getCurrentfunction(){
        return currentfunction;
    }

    public Set<basicblock> getPredecessors(){
        return predecessors;
    }

    public Set<basicblock> getSuccessors(){
        return successors;
    }

    public boolean isFinished() {
        return finished;
    }

    private void addSuccessor(basicblock BB){
        successors.add(BB);
    }

    private void addPredessor(basicblock BB){
        predecessors.add(BB);
    }

    private void removeSuccessor(basicblock BB){
        if(BB==null) return;
        successors.remove(BB);
    }

    private void removePredecessor(basicblock BB){
        if(BB==null) return;
        predecessors.remove(BB);
    }

    public void replacePredecessor(basicblock oldBB,basicblock newBB){
        predecessors.remove(oldBB);
        predecessors.add(newBB);
        newBB.successors.add(this);
    }

    public void addInst(IRinst irinst){
        if(tail==null){
            head=tail=irinst;
        }
        else{
            tail.setNextInstruction(irinst);
            irinst.setprevInstruction(tail);
            tail=irinst;
        }
    }

    public void addFirst(IRinst irinst){
        if(tail==null){
            head=tail=irinst;
        }
        else{
            irinst.setNextInstruction(irinst);
            head.setprevInstruction(irinst);
            head=irinst;
        }
    }

    public void removeInst(){
        finished=false;
        if(tail==null){
            throw new RuntimeException("empty BB");
        }else{
            if(tail instanceof branch){
                removeSuccessor(((branch)tail).getThenBB());
                removeSuccessor(((branch) tail).getElseBB());
            }else if(tail instanceof jump){
                removeSuccessor(((jump) tail).getDestBB());
            }else if(tail instanceof back){
                currentfunction.getReturnInstList().remove(tail);
            }
            tail=tail.getprevInstruction();
            if(tail!=null) tail.setNextInstruction(null);
            else head=tail=null;
        }
    }

    private void addBB(basicblock BB){
        if(BB==null) return;
        this.addSuccessor(BB);
        BB.addPredessor(this);
    }

    public void finish(IRinst irinst){
        addInst(irinst);
        if(irinst instanceof branch){
            addBB(((branch) irinst).getThenBB());
            addBB(((branch) irinst).getElseBB());
        }else if(irinst instanceof jump){
            addBB(((jump) irinst).getDestBB());
        }else if(irinst instanceof back){
            currentfunction.addReturnList((back)irinst);
        }
        finished=true;
    }

    public void deleteSelf(){
        getSuccessors().forEach(successor->{
              for(IRinst irinst=successor.head;;irinst=irinst.getNextInstruction()){
                  if(irinst instanceof phi) ((phi)irinst).removePath(this);
                  else break;
                  if(!irinst.hasNextInstruction())break;
              }
        });
        getSuccessors().forEach(successor->successor.removePredecessor(this));
        getPredecessors().forEach(predecessor->predecessor.removeSuccessor(this));
    }


    public void mergeBB(basicblock newBB){
        getSuccessors().forEach(successor->{
            for(IRinst irinst=successor.head;;irinst=irinst.getNextInstruction()){
                if(irinst instanceof phi) ((phi) irinst).replacePath(this,newBB);
                else break;
                if(!irinst.hasNextInstruction()) break;
            }
        });
        getSuccessors().forEach(successor->successor.replacePredecessor(this,newBB));
        newBB.removeInst();
        newBB.addInst(this.head);
        newBB.tail=this.tail;
        newBB.finished=true;
        for(IRinst irinst=this.head;;irinst=irinst.getNextInstruction()){
            irinst.setCurrentBB(newBB);
            if(!irinst.hasNextInstruction()) break;
        }
    }

    private Set<virtualregister> use=new HashSet<>();
    private Set<virtualregister> def=new HashSet<>();
    private Set<virtualregister> liveIn=new HashSet<>();
    private Set<virtualregister> liveOut=new HashSet<>();

    public Set<virtualregister> getUse(){
        return use;
    }

    public Set<virtualregister> getDef() {
        return def;
    }

    public Set<virtualregister> getLiveIn() {
        return liveIn;
    }

    public void setLiveIn(Set<virtualregister> liveIn) {
        this.liveIn = liveIn;
    }

    public Set<virtualregister> getLiveOut() {
        return liveOut;
    }

    public void setLiveOut(Set<virtualregister> liveOut) {
        this.liveOut = liveOut;
    }



}

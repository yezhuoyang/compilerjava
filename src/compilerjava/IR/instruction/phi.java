package compilerjava.IR.instruction;

import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.LinkedHashMap;
import java.util.Map;


public class phi extends IRinst{
    private operand dst;
    private Map<basicblock,operand> paths=new LinkedHashMap<>();

    public phi(basicblock currentBB,operand dst){
        super(currentBB);
        this.dst=dst;
    }

    public operand getDst() {
        return dst;
    }

    public void setDst(operand dst) {
        this.dst = dst;
    }

    public Map<basicblock, operand> getPaths() {
        return paths;
    }

    public void removePath(basicblock BB){
        paths.remove(BB);
        if(paths.size()==1) {
            IRinst newinst=new move(currentBB,paths.values().iterator().next(),dst);
            replaceInstruction(newinst);
            if(this==currentBB.head)currentBB.head=newinst;
            if(this==currentBB.tail)currentBB.tail=newinst;
        }
    }

    public void replacePath(basicblock oldBB,basicblock newBB){
        operand op=paths.get(oldBB);
        paths.remove(oldBB);
        paths.put(newBB,op);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }


    @Override
    public void updateUseRegs() {
        useregs.clear();
        for(Map.Entry<basicblock,operand>entry:paths.entrySet() ){
            operand op=entry.getValue();
            if(op instanceof register) useregs.add((register)op);
        }
    }

    @Override
    public register getDefReg() {
        return (register)dst;
    }


    @Override
    public void setDefReg(register newReg) {

    }

    @Override
    public void setUseregs(Map<register, register> renameMap) {

    }

    @Override
    public void renameDefRegForSSA() {

    }

    @Override
    public void renameUseRegForSSA() {

    }

    @Override
    public void replaceUseReg(operand oldoperand, operand newoperand) {
        for(Map.Entry<basicblock,operand>entry:paths.entrySet()){
            basicblock BB=entry.getKey();
            operand op=entry.getValue();
            if(op==oldoperand) paths.put(BB,newoperand);
        }
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef() {
        use.clear();
        use.clear();
    }

    @Override
    public void replaceUse(virtualregister oldVR, virtualregister newVR) {

    }


    @Override
    public void replaceDef(virtualregister oldVR, virtualregister newVR) {

    }

    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        return null;
    }


}

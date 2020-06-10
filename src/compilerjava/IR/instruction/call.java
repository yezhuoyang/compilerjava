package compilerjava.IR.instruction;


import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.virtualregister;

import java.util.LinkedList;
import java.util.Map;

import static compilerjava.IR.operand.realregister.*;


public class call extends IRinst {
    private LinkedList<operand> parameterList=new LinkedList<>();
    private function callee;
    private operand objectPointer;
    private operand result;

    public call(basicblock currentBB,function callee,operand result){
        super(currentBB);
        this.callee=callee;
        this.result=result;
        updateUseRegs();
    }

    public void addParameter(operand op){
        parameterList.add(op);
        updateUseRegs();
    }

    public LinkedList<operand> getParameterList() {
        return parameterList;
    }

    public operand getObjectPointer() {
        return objectPointer;
    }

    public void setObjectPointer(operand objectPointer) {
        this.objectPointer = objectPointer;
        updateUseRegs();
    }

    public function getCallee() {
        return callee;
    }

    public operand getResult() {
        return result;
    }

    public void setResult(operand result) {
        this.result = result;
        updateUseRegs();
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    @Override
    public void updateUseRegs(){
        useregs.clear();
        parameterList.forEach(parameter->{
            if(parameter instanceof register)useregs.add((register)parameter);
        });
        if(objectPointer instanceof register)useregs.add((register)objectPointer);
    }


    @Override
    public void setUseregs(Map<register,register> renameMap){
        for(int i=0;i<parameterList.size();i++){
            operand parameter=parameterList.get(i);
            if(parameter instanceof register) parameterList.set(i,renameMap.get(parameter));
        }
        if(objectPointer instanceof register)objectPointer=renameMap.get(objectPointer);
        updateUseRegs();
    }


    @Override
    public void setDefReg(register newReg) {
        if(result!=null) result=newReg;
    }

    @Override
    public register getDefReg() {
        if(result!=null)return (register)result;
        else return null;
    }

    @Override
    public void renameDefRegForSSA(){
        if(result!=null&&result instanceof virtualregister&&!(result instanceof globalvar))
            result=((virtualregister)result).getSSARenameReg(((virtualregister)result).getNewId());
    }

    @Override
    public void renameUseRegForSSA(){
        for(int i=0;i<parameterList.size();i++){
            operand parameter=parameterList.get(i);
            if(parameter instanceof virtualregister&& !(parameter instanceof globalvar))
                parameterList.set(i,((virtualregister)parameter).getSSARenameReg(((virtualregister)parameter).info.stack.peek()));
        }
        if(objectPointer instanceof virtualregister && !(objectPointer instanceof globalvar)){
            objectPointer=((virtualregister)objectPointer).getSSARenameReg(((virtualregister)objectPointer).info.stack.peek());
        }
        updateUseRegs();
    }

    @Override
    public void replaceUseReg(operand oldop,operand newop){
        for(int i=0;i<parameterList.size();i++){
            operand parameter=parameterList.get(i);
            if(parameter==oldop) parameterList.set(i,newop);
        }
        if(objectPointer==oldop)objectPointer=newop;
        updateUseRegs();
    }

    @Override
    public void calcUseAndDef(){
        use.clear();
        def.clear();
        parameterList.forEach(parameter->{
            if(parameter instanceof virtualregister && !(parameter instanceof globalvar))
                use.add((virtualregister)parameter);
        });
        if(objectPointer instanceof virtualregister && !(objectPointer instanceof globalvar))
            use.add((virtualregister)objectPointer);
        if(result instanceof virtualregister&& !(result instanceof globalvar))
                def.add((virtualregister)result);
        def.addAll(callerSaveVRegisters);
        def.remove(vsp);
    }

    @Override
    public void replaceUse(virtualregister oldVR,virtualregister newVR){
        for(int i=0;i<parameterList.size();i++){
            operand parameter=parameterList.get(i);
            if(parameter==oldVR) parameterList.set(i,newVR);
        }
        if(objectPointer==oldVR) objectPointer=newVR;
    }

    @Override
    public void replaceDef(virtualregister oldVR,virtualregister newVR){
    }


    @Override
    public IRinst getFakeInstruction(Map<basicblock, basicblock> fakeBBMap, Map<operand, operand> fakeRegMap){
        call newCall = new call(fakeBBMap.getOrDefault(currentBB, currentBB), callee, fakeRegMap.getOrDefault(result, result));
        parameterList.forEach(operand -> newCall.addParameter(fakeRegMap.getOrDefault(operand, operand)));
        newCall.setObjectPointer(fakeRegMap.getOrDefault(objectPointer, objectPointer));
        return newCall;
    }





}

package compilerjava.IR;


import compilerjava.IR.instruction.call;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.instruction.back;
import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.register;
import compilerjava.IR.operand.stackdata;
import compilerjava.IR.operand.virtualregister;
import compilerjava.config;

import java.util.*;


public class function {
    public Set<function> calleeset=new HashSet<>();
    public Set<function> recursivecalleeset=new HashSet<>();
    public functioninfo funcinfo;
    public LinkedList<call> callerInstList=new LinkedList<>();
    public int argumentLimit;
    private HashMap<register,stackdata>  saveArgumentMap;
    public int temporaryCnt=0;
    public int stackframsize=0;

    public int stackSize;


    private basicblock entryBB=new basicblock(this,"entry");
    private basicblock exitBB=new basicblock(this,"exit");
    private List<back> returnInstList=new ArrayList<>();
    private register referenceForClassMethod=null;
    private List<register> parameterList=new ArrayList<>();
    private List<register> allParameterList=new ArrayList<>();
    private List<basicblock> postOrderDFSBBList=null;
    private List<basicblock> reversePostOrderDFSBBList=null;
    private List<basicblock> reverseCFGPostOrderDFSBBList=null;
    private Set<basicblock> visit=null;
    private Set<virtualregister> globals=new HashSet<>();
    private String name;

    public String builtinFunctionName;

    public function(String name){
        this.name=name;
        this.funcinfo=new functioninfo();
        this.stackSize=0;
    }

    public void saveArgument(int i,stackdata stac){
        saveArgumentMap.put(parameterList.get(i),stac);
    }

    public stackdata stackForArgument(int i){
        stackdata stac=saveArgumentMap.get(parameterList.get(i));
        if(stac==null)assert false;
        return stac;
    }


    public function(String name,String builtinname){
        this.name=name;
        this.builtinFunctionName=builtinname;
        this.funcinfo=new functioninfo();
        this.stackSize=0;
    }

    public int getStackSize(){
        return stackSize*4+(16-stackSize*4%16);
    }

    public void calcStackFrame(){
        stackframsize=(Math.max(argumentLimit-8,0)+temporaryCnt)* config.registersize;
    }

    public int getStackframsize() {
        return stackframsize;
    }

    public String getName() {
        return name;
    }

    public void addReturnList(back iRinst){
        returnInstList.add(iRinst);
    }

    public void addParameterList(register reg){
        parameterList.add(reg);
    }

    public void addglobals(virtualregister vreg){
        globals.add(vreg);
    }

    public void setParameterList(List<register> parameterList){
        this.parameterList=parameterList;
    }

    public basicblock getEntryBB() {
        return entryBB;
    }

    public void setEntryBB(basicblock entryBB) {
        this.entryBB = entryBB;
    }

    public basicblock getExitBB() {
        return exitBB;
    }

    public void setExitBB(basicblock exitBB) {
        this.exitBB = exitBB;
    }

    public Set<virtualregister> getGlobals() {
        return globals;
    }

    public register getReferenceForClassMethod() {
        return referenceForClassMethod;
    }

    public void setReferenceForClassMethod(register referenceForClassMethod) {
        this.referenceForClassMethod = referenceForClassMethod;
    }

    public List<back> getReturnInstList() {
        return returnInstList;
    }

    public List<register> getParameterList(){
        return parameterList;
    }

    public List<register> getAllParameterList(){
        allParameterList.clear();
        if(referenceForClassMethod!=null)allParameterList.add(referenceForClassMethod);
        allParameterList.addAll(parameterList);
        return allParameterList;
    }

    public List<basicblock> getReversePostOrderDFSBBList(){
        if(reversePostOrderDFSBBList==null)calcReversePostOrderDFSBBList();
        return reversePostOrderDFSBBList;
    }

    public void recalcReversePostOrderDFSBBList(){
        calcReversePostOrderDFSBBList();
    }

    public void calcReversePostOrderDFSBBList(){
        reversePostOrderDFSBBList=new ArrayList<>();
        visit=new HashSet<>();
        postOrderDFS(entryBB);
        for(int i=0;i<reversePostOrderDFSBBList.size();i++){
            reversePostOrderDFSBBList.get(i).postOrderNumber=i;
        }
        Collections.reverse(reversePostOrderDFSBBList);
    }

    public List<basicblock> getPostOrderDFSBBList(){
       if(postOrderDFSBBList==null){
           postOrderDFSBBList=new ArrayList<>();
           postOrderDFSBBList.addAll(reversePostOrderDFSBBList);
           Collections.reverse(postOrderDFSBBList);
       }
       return postOrderDFSBBList;
    }

    private void postOrderDFS(basicblock nowBB){
        visit.add(nowBB);
        nowBB.getSuccessors().forEach(x->{
            if(!visit.contains(x)) postOrderDFS(x);
        });
        reversePostOrderDFSBBList.add(nowBB);
    }

    public void calcReverseCFGPostOrderNumber(){


    }

    private void reverseCFGPostOrderDFS(basicblock nowBB){
        visit.add(nowBB);
        nowBB.getPredecessors().forEach(x->{
            if(!visit.contains(x)) reverseCFGPostOrderDFS(x);
        });
        reverseCFGPostOrderDFSBBList.add(nowBB);
    }

    public boolean reachable(basicblock BB){
        return visit.contains(BB);
    }

    public void updateCalleeSet(){
        calleeset.clear();
        getReversePostOrderDFSBBList().forEach(BB -> {
           for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction())
               if(irinst instanceof call) calleeset.add(((call)irinst).getCallee());
        });
    }


    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    public static class functioninfo{
        public Set<globalvar> defglobalvar=new HashSet<>();
        public Set<globalvar> recursiveUseglobalvar=new HashSet<>();
        public Set<globalvar> recursiveDefglobalvar=new HashSet<>();
        public Map<globalvar,virtualregister> globaltemporal=new HashMap<>();
    }

}

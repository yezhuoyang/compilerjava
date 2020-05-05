package compilerjava.Env;


import compilerjava.AST.funcdeclNode;
import compilerjava.IR.function;
import compilerjava.util.position;

import compilerjava.util.semanticError;

import java.util.LinkedHashMap;
import java.util.Map;

public class funcsymbol extends symbol implements field{
    private field outerfield;
    private function func;
    private Map<String,varsymbol> arguments=new LinkedHashMap<>();

    public boolean hasSideEffect=false;

    private boolean isMemberFunc=false;

    public funcsymbol(String name,type tp,funcdeclNode node,field outerfield){
        super(name,tp,node);
        this.outerfield=outerfield;
    }

    public funcsymbol(String name,type tp, funcdeclNode node,field outerfield, boolean hasSideEffect){
        super(name,tp,node);
        this.outerfield=outerfield;
        this.hasSideEffect=hasSideEffect;
    }


    public Map<String, varsymbol> getArguments() {
        return arguments;
    }

    @Override
    public String getfieldName(){
        return super.getWord();
    }

    @Override
    public field getOuterfield(){
        return outerfield;
    }


    @Override
    public void defvar(varsymbol symbol){
        if(arguments.containsKey(symbol.getWord()))
            throw new semanticError(" Duplicate name variables ",symbol.getDefNode().getpos());
        else arguments.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }

    @Override
    public void deffunc(funcsymbol symbol){
    }

    @Override
    public void defclass(classsymbol symbol){

    }

    @Override
    public symbol resolvesymbol(String ID,position pos){
        symbol sym=arguments.get(ID);
        if(sym!=null)return sym;
        else return outerfield.resolvesymbol(ID,pos);
    }

    @Override
    public boolean isFuncsymbol(){
        return true;
    }


    public boolean isMemberFunc(){
        return isMemberFunc;
    }

    public void setMemberFunc() {
        isMemberFunc=true;
    }

    public function getFunc() {
        return func;
    }


    public void setFunc(function func) {
        this.func = func;
    }
}
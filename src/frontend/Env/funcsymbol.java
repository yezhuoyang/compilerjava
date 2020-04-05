package compilerjava.Env;


import compilerjava.AST.funcdeclNode;

import compilerjava.util.position;

import compilerjava.util.semanticError;

import java.util.LinkedHashMap;
import java.util.Map;

public class funcsymbol extends symbol implements field{
    private field outerfield;
    private Map<String,Varsymbol> arguments=new LinkedHashMap<>();

    public funcsymbol(String name,type tp,funcdeclNode node,field outerfield){
        super(name,tp,node);
        this.outerfield=outerfield;
    }

    public Map<String, Varsymbol> getArguments() {
        return arguments;
    }

    @Override
    public String getfieldName(){
        return super.getfieldName();
    }

    @Override
    public field getOuterfield(){
        return outerfield;
    }

    @Override
    public void defvar(varsymbol symbol){
        if(arguments.containsKey(symbol.getword()))
            throw new semanticError("Duplicate name variables",symbol.getDefNode().getpos());
        else arguments.put(symbol.getword(),symbol)
        symbol.setfield(this);
    }

    @Override
    void deffunc(funceymbol symbol){

    }

    @Override
    void defclass(classsymbol symbol){

    }

    @Override
    symbol resolvesymbol(String ID,position pos){
        symbol sym=arguments.get(ID);
        if(sym!=null)return sym;
        else return outerfield.resolvesymbol(ID,pos);
    }

    @Override
    public boolean isFuncsymbol(){
        return true;
    }

}
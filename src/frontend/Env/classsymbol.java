package compilerjava.Env;


import compilerjava.AST.classdeclNode;
import compilerjava.config;
import compilerjava.util.position;
import compilerjava.util.semanticError;

import java.util.LinkedHashMap;
import java.util.Map;



public class classsymbol extends symbol implements field, type{
    private field outerfield;
    private funcsymbol constructor;
    private Map<String,varsymbol> varsymbolMap=new LinkedHashMap<>();
    private Map<String,funcsymbol> funcsymbolMap=new LinkedHashMap<>();

    public classsymbol(String name,classsdeclNode classnode,field outerfield){
        super(name,null,classnode);
        this.outerfield=outerfield;
        constructor=null;
    }

    @Override
    public String getfieldName(){
        return super.getSymbolName();
    }

    @Override
    public String getTypeName(){
        return super.getSymbolName();
    }

    @Override
    public getOuterfield(){
        return outerfield;
    }

    public funcsymbol getConstructor(){
        return constructor;
    }

    public void setConstructor(funcsymbol constructor){
        this.constructor=constructor;
    }

    @Override
    public void defvar(varsymbol symbol){
        if(varsymbolMap.containsKey(symbol.getSymbolName())||funcsymbolMap.containsKey(symbol.getSymbolName()))
            throw new semanticError("Duplicate ID",symbol.getDefNode().getpos());
        varsymbolMap.put(symbol.getSymbolName(),symbol);
        symbol.setfield(this);
    }

    @Override
    public void deffunc(funcsymbol symbol){
        if(varsymbolMap.containsKey(symbol.getSymbolName())||funcsymbolMap.containsKey(symbol.getSymbolName()))
            throw new semanticError("Duplicate ID",symbol.getDefNode().getpos());
        symbol.setMemberfunction();
        symbol.setfield(this);
        funcsymbolMap.put(symbol.getSymbolName(),symbol);
    }

    @Override
    public void defclass(classsymbol symbol){

    }

    @Override
    public Symbol resolvesymbol(){

    }




}
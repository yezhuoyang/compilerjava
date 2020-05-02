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

    private int size;

    public classsymbol(String name,classdeclNode classnode,field outerfield){
        super(name,null,classnode);
        this.outerfield=outerfield;
        constructor=null;
    }

    @Override
    public String getfieldName(){
        return super.getWord();
    }

    @Override
    public String getTypeName(){
        return super.getWord();
    }

    @Override
    public field getOuterfield(){
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
        if(varsymbolMap.containsKey(symbol.getWord())||funcsymbolMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID",symbol.getDefNode().getpos());
        varsymbolMap.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }

    @Override
    public void deffunc(funcsymbol symbol){
        if(varsymbolMap.containsKey(symbol.getWord())||funcsymbolMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID",symbol.getDefNode().getpos());
        symbol.setMemberFunc();
        symbol.setfield(this);
        funcsymbolMap.put(symbol.getWord(),symbol);
    }

    @Override
    public void defclass(classsymbol symbol){

    }



    @Override
    public symbol resolvesymbol(String ID,position pos){
        symbol varsymbol=varsymbolMap.get(ID);
        symbol funcsymbol=funcsymbolMap.get(ID);
        if(varsymbol!=null)return varsymbol;
        if(funcsymbol!=null)return funcsymbol;
        return outerfield.resolvesymbol(ID,pos);
    }


    public symbol resolvemember(String ID,position pos){
        symbol varsymbol=varsymbolMap.get(ID);
        symbol funcsymbol=funcsymbolMap.get(ID);
        if(varsymbol!=null)return varsymbol;
        if(funcsymbol!=null)return funcsymbol;
        throw new semanticError(ID+" is not a member of "+ getWord(),pos);
    }

    @Override
    public void compatible(type tp,position pos){
        if(getTypeName().equals("string")){
            if(tp.getTypeName().equals("string")){

            }else throw new semanticError("Type string is not compatible with type "+ getTypeName(),pos);
        }else{
            if(tp.getTypeName().equals("null")||tp.getTypeName().equals(getTypeName())){

            }else
                throw new semanticError("Type "+getTypeName()+" is not compatible with type "+ getTypeName(),pos);
        }
    }

    @Override
    public boolean isClasssymbol(){
        return true;
    }



    @Override
    public boolean isBaseType(){
        return false;
    }


    @Override
    public boolean isClassType(){
        return true;
    }


    @Override
    public boolean isArrayType(){
        return false;
    }

    @Override
    public boolean isNullType(){
        return false;
    }

    @Override
    public boolean isPointerType(){
        return true;
    }

    @Override
    public int getTypeSize(){
        return config.pointersize();
    }


    public int getObjectSize(){
        return size;
    }

}
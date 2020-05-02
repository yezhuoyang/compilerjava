package compilerjava.Env;

import compilerjava.util.semanticError;

import java.util.LinkedHashMap;
import java.util.Map;


public abstract class basefield implements field{
    Map<String,symbol> symbolMap=new LinkedHashMap<>();
    private String name;
    private field outerfield;

    public basefield(String name,field outerfield){
        this.name=name;
        this.outerfield=outerfield;
    }

    @Override
    public String getfieldName(){
        return name;
    }

    @Override
    public field getOuterfield(){
        return outerfield;
    }

    @Override
    public void defvar(varsymbol symbol){
        if(symbolMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID: ",symbol.getDefNode().getpos());
        symbolMap.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }

    @Override
    public void deffunc(funcsymbol symbol){
        if(symbolMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID: ",symbol.getDefNode().getpos());
        symbolMap.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }




}
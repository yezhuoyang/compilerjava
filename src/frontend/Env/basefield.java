package compilerjava.Env;

import compilerjava.util.semanticError;

import java.util.LinkedHashMap;
import java.util.Map;


public abstract class basefield implements field{
    Map<String,symbol> symbolMap=new LinkedHashMap<>();
    private String name;
    private field outerfield;

    basefield(String name,field outerfield){
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
    public void definevar(varsymbol symbol){
        if(symbolMap.containsKey(symbol.getSymbolName()))
            throw new semanticError("Duplicate ID: ",symbol.getDefNode().getpos());
        symbolMap.put(symbol.getSymbolName(),symbol);
        symbol.setfield(this);
    }







}
package compilerjava.Env;

import compilerjava.AST.*;
import compilerjava.util.position;
import compilerjava.util.semanticError;


import java.util.LinkedHashMap;
import java.util.Map;


public class globalfield extends basefield{

    private Map<String,type> typeMap=new LinkedHashMap<>();
    private basesymbol  intsymbol;
    private basesymbol  boolsymbol;
    private basesymbol  voidsymbol;
    private funcsymbol  arrayfunctionsymbol;
    private classsymbol string;


    public globalfield(String name){
        super(name,null);
    }

    @Override
    public void defclass(classsymbol symbol){
        if(typeMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID: ",symbol.getDefNode().getpos());
        if(symbolMap.containsKey(symbol.getWord()))
            throw new semanticError("Duplicate ID: ",symbol.getDefNode().getpos());
        symbolMap.put(symbol.getWord(),symbol);
        typeMap.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }

    public void defbasetype(basesymbol symbol){
        typeMap.put(symbol.getWord(),symbol);
        symbol.setfield(this);
    }

    @Override
    public symbol resolvesymbol(String ID,position pos){
        symbol sym=symbolMap.get(ID);
        if(ID==null) throw new semanticError("Unknown ID",pos);
        return sym;
    }


    public type resolvetype(typeNode node){
        type tp=typeMap.get(node.gettypeID());
        if(tp==null) throw new semanticError("Unknown type ",node.getpos());
        return tp;
    }

    public symbol resolveMain(){
        if(!symbolMap.containsKey("main"))throw new semanticError("No main function!",new position(0,0));
        return symbolMap.get("main");
    }

    public void setBoolsymbol(basesymbol boolsymbol) {
        this.boolsymbol = boolsymbol;
    }

    public basesymbol getBoolsymbol() {
        return boolsymbol;
    }


    public void setIntsymbol(basesymbol intsymbol) {
        this.intsymbol = intsymbol;
    }

    public basesymbol getIntsymbol(){
        return intsymbol;
    }

    public void setVoidsymbol(basesymbol voidsymbol) {
        this.voidsymbol = voidsymbol;
    }

    public basesymbol getVoidsymbol() {
        return voidsymbol;
    }

    public classsymbol getString() {
        return string;
    }

    public void setString(classsymbol string) {
        this.string = string;
    }

    public funcsymbol getArrayfunctionsymbol() {
        return arrayfunctionsymbol;
    }

    public void setArrayfunctionsymbol(funcsymbol arrayfunctionsymbol) {
        this.arrayfunctionsymbol = arrayfunctionsymbol;
    }
}
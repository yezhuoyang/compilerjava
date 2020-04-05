package compilerjava.Env;

import compilerjava.AST.Node;
import compilerjava.util.position;
import compilerjava.util.semanticError;


import java.util.LinkedHashMap;
import java.util.Map;


public class globalfield extends basefield{

    private Map<String,type> typeMap=new LinkedHashMap;
    private basesymbol  Intsymbol;
    private basesymbol  boolsymbol;
    private basesymbol  voidsymbol;
    private funcsymbol  arrayfunctionsymbol;
    private classsymbol classsym;


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
        if(!symbolMap.containsKey("main"))throw semanticError("No main function!",new position(0,0));
        return symbolMap.get("main");
    }

    public void setBoolsymbol(basesymbol boolsymbol) {
        this.boolsymbol = boolsymbol;
    }

    public basesymbol getBoolsymbol() {
        return boolsymbol;
    }


    public void setIntsymbol(basesymbol intsymbol) {
        Intsymbol = intsymbol;
    }

    public void getIntsymbol(){
        return Intsymbol;
    }

    public void setVoidsymbol(basesymbol voidsymbol) {
        this.voidsymbol = voidsymbol;
    }

    public basesymbol getVoidsymbol() {
        return voidsymbol;
    }

    public classsymbol getClasssym() {
        return classsym;
    }

    public void setClasssym(classsymbol classsym) {
        this.classsym = classsym;
    }

    public funcsymbol getArrayfunctionsymbol() {
        return arrayfunctionsymbol;
    }

    public void setArrayfunctionsymbol(funcsymbol arrayfunctionsymbol) {
        this.arrayfunctionsymbol = arrayfunctionsymbol;
    }
}
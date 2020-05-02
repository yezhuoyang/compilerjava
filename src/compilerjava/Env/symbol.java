package compilerjava.Env;

import compilerjava.AST.Node;


public class symbol{

    private String word;
    private type _type;
    private field _field;
    private Node defNode;

    public symbol(String name,type _type,Node defNode){
        this.word=name;
        this._type=_type;
        this.defNode=defNode;
    }

    public String getWord(){
        return word;
    }

    public Node getDefNode() {
        return defNode;
    }

    public type gettype() {
        return _type;
    }

    public field getfield() {
        return _field;
    }


    public void setfield(field _field){
            this._field=_field;
    }

    public boolean isVarsymbol(){
        return false;
    }

    public boolean isClasssymbol(){
        return false;
    }

    public boolean isFuncsymbol(){
        return false;
    }



}
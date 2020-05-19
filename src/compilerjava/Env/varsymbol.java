package compilerjava.Env;
import compilerjava.AST.vardeclNode;
import compilerjava.IR.operand.storage;



public class varsymbol extends symbol{

    private storage varstorage;
    private int offset;

    public varsymbol(String name,type tp,vardeclNode node){
            super(name,tp,node);
    }

    @Override
    public boolean isVarsymbol(){
        return true;
    }


    public storage getVarstorage(){
        return varstorage;
    }

    public void setVarstorage(storage varstorage) {
        this.varstorage = varstorage;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
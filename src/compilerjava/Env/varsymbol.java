package compilerjava.Env;
import compilerjava.AST.vardeclNode;




public class varsymbol extends symbol{


    public varsymbol(String name,type tp,vardeclNode node){
            super(name,tp,node);
    }

    @Override
    public boolean isVarsymbol(){
        return true;
    }




}
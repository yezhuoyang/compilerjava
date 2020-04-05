package compilerjava.Env;


import compilerjava.config;
import compilerjava.util.position;
import compiler.util.semanticError;

public class basesymbol extends symbol implements type{

    public basesymbol(String name){
        super(name,null,null);
    }

    @Override
    public String getTypeName(){
        return super.getWord();
    }

    @Override
    public void compatible(type tp,position pos){
        if(!tp.getTypeName().equals("void")){
            if(getTypeName().equals(tp.getTypeName())){

            }else throw new semanticError("Type "+getTypeName()+" not compatible with"+tp.getTypeName(),pos);
        }else throw new semanticError("void on the right side!",pos);
    }

    @Override
    boolean isbaseType(){
        return true
    }

    @Override
    boolean isClassType(){
        return false;
    }

    @Override
    boolean isArrayType(){
        return false;
    }

    @Override
    boolean isNullType(){
        return false;
    }

    @Override
    boolean isPointerType(){
        return false;
    }

    @Override
    boolean int getTypeSize(){
        return config.basetypesize();
    }


}
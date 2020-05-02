package compilerjava.Env;


import compilerjava.config;
import compilerjava.util.position;
import compilerjava.util.semanticError;

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
    public boolean isBaseType(){
        return true;
    }

    @Override
    public boolean isClassType(){
        return false;
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
        return false;
    }

    @Override
    public int getTypeSize(){
        return config.basetypesize();
    }


}
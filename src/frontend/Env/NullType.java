package compilerjava.Env;

import compilerjava.Env.position;
import compilerjava.Env.semanticError;


public class Nulltype implements type{

    @Override
    public String getTypeName(){
        return "null";
    }

    @Override
    public void compatible(type tp,position pos){
        throw new semanticError("Null expression is not assignable",pos);
    }

    @Override
    public boolean isBaseType(){
        return false;
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
        return true;
    }

    @Override
    public boolean isPointerType(){
        return true;
    }

    @Override
    public int getTypeSize(){
        return 0;
    }

}

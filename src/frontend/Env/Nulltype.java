package compilerjava.Env;

import compilerjava.util.position;
import compilerjava.util.semanticError;


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

    @Override
    public String toString(){
        return "null";
    }

}

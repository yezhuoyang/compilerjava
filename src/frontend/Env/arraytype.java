package compilerjava.Env;



import compilerjava.util.position;
import compilerjava.util.semanticError;

import compilerjava.config;


public class arraytype implements type{
    private type basetype;
    private int dims;

    public arraytype(type basetype,int dims){
        this.basetype=basetype;
        this.dims=dims;
    }

    public type getBasetype(){
        return basetype;
    }

    public void setBasetype(type basetype){
        this.basetype=basetype;
    }

    public int getDims(){
        return dims;
    }

    public void setDims(int dims){
        this.dims=dims;
    }

    @Override
    public String getTypeName(){
        return basetype.getTypeName()+" array";
    }

    public String getBaseTypeName(){
        return basetype.getTypeName();
    }


    @Override
    public void compatible(type tp,position pos){
        if(tp.getTypeName().equals("null")){}
        else if(tp instanceof arraytype){
            basetype.compatible(((arraytype) tp).getBasetype(),pos);
            if(dims==((arraytype)tp).getDims()){

            }
            else{
                throw new semanticError("Dimension mismatch",pos);
            }
        }else{
                throw new semanticError("Type "+getTypeName()+" is not compatible with type "+tp.getTypeName(),pos);
        }
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
        return true;
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
        return config.pointersize();
    }


    @Override
    public String toString(){
        return getTypeName();
    }


}
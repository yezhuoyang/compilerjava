package compilerjava.Env;
import compilerjava.util.position;






public class localfield extends basefield{
    public localfield(String name,field outerfield){
        super(name,outerfield);
    }

    @Override
    public void defclass(classsymbol sym){}

    @Override
    public symbol resolvesymbol(String ID,position pos){
        symbol sym=symbolMap.get(ID);
        if(sym!=null)return sym;
        else return getOuterfield().resolvesymbol(ID,pos);
    }



}
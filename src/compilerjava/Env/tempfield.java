package compilerjava.Env;
import compilerjava.util.position;






public class tempfield extends basefield{
    public tempfield(String name,field outerfield){
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
package compilerjava.IR.operand;
import compilerjava.config;

import java.util.ArrayList;
import java.util.List;



public abstract class memory extends storage{
    private register base=null;
    private immediate offset=new immediate(0,config.pointersize());
    private List<virtualregister> useregs=new ArrayList<>();

    public memory(virtualregister base,int Size){
        super(base.getName(),Size);
        this.base=base;
    }

    public memory(register base,immediate offset,int Size){
        super(Size);
        this.base=base;
        this.offset=offset;
    }

    public register getBase(){
        return base;
    }

    public void setBase(register base) {
        this.base = base;
    }

    public void setbase(virtualregister base){
        this.base=base;
    }

    public immediate getOffset(){
        return offset;
    }

    public void setOffset(immediate offset){
        this.offset=offset;
    }

    public List<virtualregister> Useregs(){
        useregs.clear();
        if(base!=null && !(base instanceof  globalvar)) useregs.add((virtualregister)base);
        return useregs;
    }

    public void replaceOperand(operand oldoperand,operand newoperand){
        if(base==oldoperand) base=(virtualregister)newoperand;
    }
}

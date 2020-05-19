package compilerjava.IR.operand;


import java.util.ArrayList;
import java.util.List;



public abstract class memory extends storage{
    private register base=null;
    private register index=null;
    private immediate offset=new immediate(0);
    private List<virtualregister> useregs=new ArrayList<>();

    public memory(virtualregister base){
        super(base.getName());
        this.base=base;
    }

    public memory(register base,register index,immediate offset){
        this.base=base;
        this.index=index;
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

    public register getIndex(){
        return index;
    }

    public void setIndex(register index){
        this.index=index;
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
        if(index !=null && !(index instanceof globalvar)) useregs.add((virtualregister) index);
        return useregs;
    }

    public void replaceOperand(operand oldoperand,operand newoperand){
        if(base==oldoperand) base=(virtualregister)newoperand;
        if(index==oldoperand) index=(virtualregister)newoperand;
    }
}

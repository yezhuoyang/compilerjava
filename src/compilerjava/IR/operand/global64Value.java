package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;


public class global64Value extends value implements globalvar{
    private boolean isString=false;


    public global64Value(String name,int Size){
        super(name,Size);
    }


    public global64Value(String name,boolean isString,int Size){
        super(name,Size);
        this.isString=isString;
    }

    public boolean isString(){
        return isString;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }
}

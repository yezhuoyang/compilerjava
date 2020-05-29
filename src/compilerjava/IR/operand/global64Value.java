package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;


public class global64Value extends value implements globalvar{
    private boolean isString=false;
    private staticstring referencedstring;

    public global64Value(String name,int Size){
        super(name,Size);
    }


    public global64Value(String name,boolean isString,int Size){
        super(name,Size);
        this.isString=isString;
    }

    public void setReferencedstring(staticstring referencedstring) {
        this.referencedstring = referencedstring;
    }

    public staticstring getReferencedstring() {
        return referencedstring;
    }

    public boolean isString(){
        return isString;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }
}

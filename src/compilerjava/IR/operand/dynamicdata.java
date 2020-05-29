package compilerjava.IR.operand;


import compilerjava.IR.IRvisitor;

public class dynamicdata extends memory{

    public dynamicdata(register base,immediate offset,int Size){
        super(base,offset,Size);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

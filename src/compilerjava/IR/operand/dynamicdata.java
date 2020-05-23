package compilerjava.IR.operand;


import compilerjava.IR.IRvisitor;

public class dynamicdata extends memory{

    public dynamicdata(register base,register index,immediate offset,int Size){
        super(base,index,offset,Size);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

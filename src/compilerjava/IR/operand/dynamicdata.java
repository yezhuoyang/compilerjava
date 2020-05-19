package compilerjava.IR.operand;


import compilerjava.IR.IRvisitor;

public class dynamicdata extends memory{

    public dynamicdata(register base,register index,immediate offset){
        super(base,index,offset);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

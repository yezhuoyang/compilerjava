package compilerjava.IR.operand;


import compilerjava.IR.IRvisitor;

public class dynamicdata extends memory{

    public dynamicdata(register base,register index,immediate scale,immediate offset){
        super(base,index,scale,offset);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

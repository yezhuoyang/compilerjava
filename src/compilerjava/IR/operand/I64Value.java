package compilerjava.IR.operand;
import compilerjava.IR.IRvisitor;



public class I64Value extends value{

    public I64Value() {
    }

    public I64Value(String name){
        super(name);
    }

    public I64Value(String name,realregister color){
        super(name);
        this.color=color;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }


}

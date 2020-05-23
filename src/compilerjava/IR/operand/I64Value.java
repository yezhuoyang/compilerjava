package compilerjava.IR.operand;
import compilerjava.IR.IRvisitor;



public class I64Value extends value{

    public I64Value(int Size){
        super(Size);
    }

    public I64Value(String name,int Size){
        super(name,Size);
    }

    public I64Value(String name,realregister color,int Size){
        super(name,Size);
        this.color=color;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }


}

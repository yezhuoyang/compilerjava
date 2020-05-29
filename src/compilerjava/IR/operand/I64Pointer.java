package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;

public class I64Pointer extends pointer{

    public I64Pointer(int S){
        super(S);
    }

    public I64Pointer(String name,int S){
        super(name,S);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }


}

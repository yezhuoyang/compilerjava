package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;

public class I64Pointer extends pointer{

    public I64Pointer(){

    }

    public I64Pointer(String name){
        super(name);
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }


}

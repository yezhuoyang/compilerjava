package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;



public class immediate extends operand{

    private int immediate;

    public immediate(int immediate,int Size){
        super(Size);
        this.immediate=immediate;
    }

    public int getImmediate(){
        return immediate;
    }

    @Override
    public void accept(IRvisitor irvisitor) {
        irvisitor.visit(this);
    }


}

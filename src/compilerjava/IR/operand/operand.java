package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;


public abstract class operand {
    String name;
    int Size;

    public operand(int Size){
        this.Size=Size;
    }

    public operand(String name,int Size){
        this.Size=Size;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return Size;
    }

    public abstract void accept(IRvisitor irvisitor);

}

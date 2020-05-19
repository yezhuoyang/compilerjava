package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;


public abstract class operand {
    String name;


    public operand(){
    }

    public operand(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }


    public abstract void accept(IRvisitor irvisitor);

}

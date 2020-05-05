package compilerjava.IR.operand;


import compilerjava.IR.IRvisitor;


public class staticstring extends staticdata{
    private String val;

    public staticstring(virtualregister pointer,String val){
        super(pointer);
        this.val=val;
    }

    public String getVal(){
        return val;
    }

    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

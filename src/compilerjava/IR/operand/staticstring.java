package compilerjava.IR.operand;

import compilerjava.config;
import compilerjava.IR.IRvisitor;


public class staticstring extends staticdata{
    private String val;

    public staticstring(virtualregister pointer,String val){
        super(pointer,config.charsize);
        this.val=val;
    }

    public String getVal(){
        return val;
    }

    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

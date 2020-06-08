package compilerjava.IR.operand;

import compilerjava.config;
import compilerjava.IR.IRvisitor;


public class staticstring extends staticdata{
    private String val;

    public staticstring(virtualregister pointer,String val){
        super(pointer,config.charsize);
        this.val=val;
    }

    public String getString(){
        String tmp=val.replace("\0", "");
        return tmp;
    }


    public String getVal(){
        String tmp=val.replace("\\", "\\\\");
        tmp=tmp.replace("\n","\\n");
        tmp=tmp.replace("\0", "");
        tmp=tmp.replace("\t","\\t");
        tmp=tmp.replace("\"", "\\\"");
        return "\""+tmp+"\"";
    }

    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

}

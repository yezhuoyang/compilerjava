package compilerjava.IR.operand;


public class stackdata extends dynamicdata{
    public stackdata(register base,register index,immediate scale,immediate offset){
        super(base,index,scale,offset);
    }
}

package compilerjava.IR.operand;


public class stackdata extends dynamicdata{

    
    public stackdata(register base,register index,immediate offset){
        super(base,index,offset);
    }

}

package compilerjava.IR.operand;

import compilerjava.IR.function;
import static compilerjava.IR.operand.realregister.*;
import compilerjava.config;


public class stackdata extends dynamicdata{


    private function func;
    private int index;
    boolean fromCallee=false;

    public stackdata(register base,immediate offset,int Size){
        super(base,offset,Size);
    }


    public stackdata(function func,int index){
        super(vsp,new immediate(index*4,config.pointersize()),4);
        this.func=func;
        this.index=index;
        this.fromCallee=true;
    }


    public stackdata(function func){
        super(vsp,new immediate(func.stackSize*4,config.pointersize()),4);
        this.func=func;
        this.index=func.stackSize;
        func.stackSize++;
    }

    public String toString(){
        if(fromCallee){
            return (4*index+func.getStackSize())+"(sp)";
        }
        return 4*index+"(sp)";
    }


}

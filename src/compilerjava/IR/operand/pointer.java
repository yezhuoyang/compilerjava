package compilerjava.IR.operand;
import compilerjava.config;


public abstract class pointer extends virtualregister{


    public pointer(){
        super(config.pointersize());
    }

    public pointer(String name){
        super(name,config.pointersize());
    }


}

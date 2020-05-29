package compilerjava.IR.operand;
import compilerjava.config;


public abstract class pointer extends virtualregister{

    int objsize;
    public pointer(int S){
        super(config.pointersize());
        this.objsize=S;
    }

    public pointer(String name,int S){
        super(name,config.pointersize());
        this.objsize=S;
    }

    public int getObjsize() {
        return objsize;
    }

    public void setObjsize(int objsize) {
        this.objsize = objsize;
    }
}

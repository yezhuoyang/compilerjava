package compilerjava.IR.operand;


public abstract class value extends virtualregister{


    public value(int Size){
        super(Size);
    }

    public value(String name,int Size){
        super(name,Size);
    }

}

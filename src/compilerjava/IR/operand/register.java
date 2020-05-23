package compilerjava.IR.operand;





public abstract class register extends storage{

    public register(int Size){
        super(Size);
    }

    public register(String name,int Size){
        super(name,Size);
    }

}

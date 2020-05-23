package compilerjava.IR.operand;





public abstract class storage extends operand{

    public storage(int Size){
        super(Size);
    }

    public storage(String name,int Size){
        super(name,Size);
    }

}

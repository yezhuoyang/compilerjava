package compilerjava.util;


public class semanticError extends RuntimeException{
    private position pos;

    public semanticError(){
        pos=null;
    }

    public semanticError(String msg,position pos){
        super(msg);
        this.pos=pos;
    }

    @Override
    public String getMessage(){
        return "[Semantic Error]: "+super.getMessage()+" @ "+pos.toString();
    }


}
package compiler.util;


public class semanticError extends RuntimeException{
    private position pos;

    public semanticError(){
        pos=null;
    }

    public semanticError(String msg,position pos){
        super(msg);
        this.position=pos;
    }

    @Override
    public String getMessage(){
        return "[Semantic Error]: "+super.getMessage()+" @ "+position.toString();
    }


}
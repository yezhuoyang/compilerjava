package compilerjava.util;


public class syntaxError extends RuntimeException{
    private position pos;

    public syntaxError(){
        pos=null;
    }

    public syntaxError(String msg,position pos){
        super(msg);
        this.pos=pos;
    }

    @Override
    public String getMessage(){
        return "[Syntax Error]: "+super.getMessage()+" @ "+pos.toString();
    }


}
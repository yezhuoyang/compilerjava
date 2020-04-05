package compiler.util;


public class syntaxError extends RuntimeException{
    private position pos;

    public syntaxError(){
        pos=null;
    }

    public syntaxError(String msg,position pos){
        super(msg);
        this.position=pos;
    }

    @Override
    public String getMessage(){
        return "[Syntax Error]: "+super.getMessage()+" @ "+position.toString();
    }


}
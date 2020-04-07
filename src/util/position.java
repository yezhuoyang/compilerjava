package compilerjava.util;
import org.antlr.v4.runtime.Token;

public class position{
    private int row,col;

    public position(int r,int c){
        this.row=r;
        this.col=c;
    }
    public int getrow(){
        return row;
    }
    public int getcol(){
        return col;
    }

    public position(Token tok){
        this.row=tok.getLine();
        this.col=tok.getCharPositionInLine();
    }

    public String toString(){
        return "line:"+row+" col: "+col+"\n";
    }

}
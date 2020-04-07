package compilerjava.AST;
import compilerjava.util.position;



public abstract class constexprNode extends exprNode{
    public constexprNode(position pos){
        super(pos);
    }
}
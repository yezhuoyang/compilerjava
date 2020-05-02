package compilerjava.AST;
import compilerjava.util.position;


public class nullliteralNode extends constexprNode{
    public nullliteralNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
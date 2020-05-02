package compilerjava.AST;
import compilerjava.util.position;



public class inttpNode extends basetpNode{
    public inttpNode(position pos){
        super("int",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
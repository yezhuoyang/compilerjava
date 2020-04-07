package compilerjava.AST;
import compilerjava.util.position;



public class inttypeNode extends basetypeNode{
    public inttypeNode(position pos){
        super("int",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
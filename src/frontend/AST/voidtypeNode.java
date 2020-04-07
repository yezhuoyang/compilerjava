package compilerjava.AST;
import compilerjava.util.position;


public class voidtypeNode extends basetypeNode{

    public voidtypeNode(position pos){
        super("void",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
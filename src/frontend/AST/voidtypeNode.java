package compilerjava.AST;
import compilerjava.position;


public class voidtypeNode extends basetypeNode{

    public voidtypeNode(position pos){
        super("void",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
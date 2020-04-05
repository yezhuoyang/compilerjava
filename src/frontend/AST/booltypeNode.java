package compilerjava.AST;



import compilerjava.util.position;


public class booltypeNode extends basetypeNode{

    public booltypeNode(position pos){
        super("bool",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
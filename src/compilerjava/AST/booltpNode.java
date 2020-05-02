package compilerjava.AST;



import compilerjava.util.position;


public class booltpNode extends basetpNode{

    public booltpNode(position pos){
        super("bool",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
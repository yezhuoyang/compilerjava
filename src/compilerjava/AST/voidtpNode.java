package compilerjava.AST;
import compilerjava.util.position;


public class voidtpNode extends basetpNode{

    public voidtpNode(position pos){
        super("void",pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
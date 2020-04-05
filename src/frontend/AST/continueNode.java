package compilerjava.AST;
import compilerjava.position;



public class continueNode extends stmtNode {


    public continueNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }

}
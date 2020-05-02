package compilerjava.AST;
import compilerjava.util.position;



public class continueNode extends stmtNode {

    private Loop currentLoop;

    public continueNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTvisitor visitor) {
        visitor.visit(this);
    }



    public Loop getCurrentLoop() {
        return currentLoop;
    }

    public void setCurrentLoop(Loop currentLoop) {
        this.currentLoop = currentLoop;
    }




}
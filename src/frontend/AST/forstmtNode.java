package compilerjava.AST;
import compilerjava.position;


public class forstmtNode extends stmtNode{
    private exprNode init;
    private exprNode cond;
    private exprNode step;
    private stmtNode stmt;

    public forstmtNode(exprNode init,exprNode cond,exprNode step,stmtNode stmt,position pos){
        super(pos);
        this.init=init;
        this.cond=cond;
        this.step=step;
        this.stmt=stmt;
    }

    public exprNode getCond() {
        return cond;
    }

    public exprNode getInit() {
        return init;
    }

    public exprNode getStep() {
        return step;
    }

    public stmtNode getStmt() {
        return stmt;
    }

    @Override
    public void accept(ASTvisitor visitor){
            visitor.visit(this);
    }




}
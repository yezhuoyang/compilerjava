package compilerjava.AST;
import compilerjava.util.position;
import compilerjava.IR.basicblock;



public class whilestmtNode extends stmtNode implements Loop{
    private exprNode expr;
    private stmtNode stmt;
    private position pos;

    private basicblock stepBB;
    private basicblock mergeBB;

    public whilestmtNode(exprNode expr,stmtNode stmt,position pos){
        super(pos);
        this.expr=expr;
        this.stmt=stmt;
    }

    public exprNode getExpr(){
        return expr;
    }

    public stmtNode getStmt() {
        return stmt;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

    @Override
    public basicblock getStepBB() {
        return stepBB;
    }

    public void setStepBB(basicblock stepBB) {
        this.stepBB = stepBB;
    }

    @Override
    public basicblock getMergeBB() {
        return mergeBB;
    }

    public void setMergeBB(basicblock mergeBB) {
        this.mergeBB = mergeBB;
    }
}
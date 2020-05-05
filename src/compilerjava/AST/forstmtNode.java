package compilerjava.AST;
import compilerjava.util.position;

import compilerjava.IR.basicblock;
import compilerjava.util.position;


public class forstmtNode extends stmtNode implements Loop{
    private exprNode init;
    private exprNode cond;
    private exprNode step;
    private stmtNode stmt;

    private basicblock stepBB;
    private basicblock mergeBB;


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
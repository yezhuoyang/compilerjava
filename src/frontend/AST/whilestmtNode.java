package compilerjava.AST;
import compilerjava.util.position;


public class whilestmtNode extends stmtNode implements Loop{
    private exprNode expr;
    private stmtNode stmt;
    private position pos;


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

}
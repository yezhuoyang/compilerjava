package compilerjava.AST;

import compilerjava.util.position;


public class IfstmtNode extends  stmtNode{
    private exprNode expr;
    private stmtNode thenstmt;
    private stmtNode elsestmt;

    public IfstmtNode(exprNode expr,stmtNode thenstmt,stmtNode elsestmt,position pos){
        super(pos);
        this.expr=expr;
        this.thenstmt=thenstmt;
        this.elsestmt=elsestmt;
    }

    public exprNode getExpr() {
        return expr;
    }


    public stmtNode getThenstmt() {
        return thenstmt;
    }

    public stmtNode getElsestmt() {
        return elsestmt;
    }


    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
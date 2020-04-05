package compilerjava.AST;

import compilerjava.util.position;



public class unaryexprNode extends exprNode{
    private Op op;
    private exprNode expr;

    public enum Op{
        PRE_ADD,PRE_SUB,SUF_ADD,SUF_SUB,POS,NEG,NOTL,NOT
    }

    public unaryexprNode(exprNode expr,Op op,position pos){
        super(pos);
        this.expr=expr;
        this.op=op;
    }

    public exprNode getExpr() {
        return expr;
    }

    public void setOp(Op op) {
        this.op = op;
    }

    public Op getOp() {
        return op;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
package compilerjava.AST;
import compilerjava.position;



public class exprstmtNode extends stmtNode{
        private exprNode expr;

        public exprstmtNode(exprNode node,position pos){
            super(pos);
            this.expr=node;
        }


    public exprNode getExpr() {
        return expr;
    }

    @Override
    public void accept(ASTvisitor visitor){
            visitor.visit(this);
    }

}
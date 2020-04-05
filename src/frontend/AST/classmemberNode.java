package compilerjava.AST;

import compilerjava.Env.symbol;
import compilerjava.util.position;

public class classmemberNode extends exprNode{
    private exprNode expr;
    private String ID;
    private symbol sym;

    public classmemberNode(exprNode expr,String ID,position pos){
        super(pos);
        this.expr=expr;
        this.ID=ID;
    }

    public exprNode getExpr() {
        return expr;
    }

    public String getID() {
        return ID;
    }

    public symbol getSym() {
        return sym;
    }

    public void setSymbol(symbol sym) {
        this.sym = sym;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
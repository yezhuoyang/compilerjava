package compilerjava.AST;
import compilerjava.util.position;
import compilerjava.Env.funcsymbol;


public class returnNode extends stmtNode{
    private exprNode expr;
    private funcsymbol _funcsymbol;

    public returnNode(exprNode expr,position pos){
        super(pos);
        this.expr=expr;
    }

    public exprNode getExpr() {
        return expr;
    }

    public funcsymbol getfuncsymbol() {
        return _funcsymbol;
    }

    public void setfuncsymbol(funcsymbol _funcsymbol) {
        this._funcsymbol = _funcsymbol;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
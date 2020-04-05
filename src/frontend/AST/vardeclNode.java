package compilerjava.AST;


import compilerjava.position;
import compilerjava.Env.type;
import compilerjava.Env.varsymbol;



public class vardeclNode extends declNode{
    private typeNode _typeNode;
    private type typeAfterresolve;
    private exprNode expr;
    private String ID;
    private position pos;

    private varsymbol _varsymbol;
    private boolean isGlobalVarible=false;
    private boolean isParameterVariable=false;

    public vardeclNode(typeNode tyNode,exprNode expr,String ID,position pos){
        super(pos);
        this._typeNode=tyNode;
        this.expr=expr;
        this.ID=ID;
    }

    public exprNode getExpr() {
        return expr;
    }

    public void setExpr(exprNode expr) {
        this.expr = expr;
    }

    public String getID() {
        return ID;
    }

    public boolean isParameterVariable() {
        return isParameterVariable;
    }

    public void setParameterVariable() {
        isParameterVariable =true;
    }

    public void setGlobalVarible() {
        isGlobalVarible = true;
    }

    public boolean isGlobalVarible() {
        return isGlobalVarible;
    }

    public void setTypeAfterresolve(type typeAfterresolve) {
        this.typeAfterresolve = typeAfterresolve;
    }

    public type getTypeAfterresolve() {
        return typeAfterresolve;
    }

    public void settypeNode(typeNode _typeNode) {
        this._typeNode = _typeNode;
    }

    public typeNode gettypeNode() {
        return _typeNode;
    }


    public varsymbol getvarsymbol() {
        return _varsymbol;
    }


    public void setvarsymbol(varsymbol _varsymbol) {
        this._varsymbol = _varsymbol;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
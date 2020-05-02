package compilerjava.AST;


import compilerjava.util.position;
import compilerjava.Env.type;
import compilerjava.Env.varsymbol;


import java.util.*;

public class vardeclNode extends declNode{
    private tpNode _tpNode;
    private type typeAfterresolve;
    private exprNode expr;
    private String ID;
    private position pos;

    private varsymbol _varsymbol;
    private boolean isGlobalVarible=false;
    private boolean isParameterVariable=false;

    public vardeclNode(tpNode tyNode,exprNode expr,String ID,position pos){
        super(pos);
        this._tpNode=tyNode;
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

    public void settpNode(tpNode _tpNode) {
        this._tpNode = _tpNode;
    }

    public tpNode gettpNode() {
        return _tpNode;
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
package compilerjava.AST;

import compilerjava.Env.symbol;
import compilerjava.util.position;



public class IDexprNode extends exprNode{
    private String ID;
    private symbol _symbol;

    public IDexprNode(String ID,position pos){
        super(pos);
        this.ID=ID;
    }

    public String getID(){
        return ID;
    }

    public symbol getsymbol(){
        return _symbol;
    }

    public void setsymbol(symbol sym){
        this._symbol=sym;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
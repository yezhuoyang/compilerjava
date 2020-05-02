package compilerjava.AST;
import compilerjava.util.position;
import compilerjava.Env.field;



public class thisexprNode extends exprNode{
    private field _field;

    public thisexprNode(position pos){
        super(pos);
    }

    public field getfield() {
        return _field;
    }

    public void setfield(field _field) {
        this._field = _field;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
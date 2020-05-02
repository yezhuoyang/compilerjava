package compilerjava.AST;
import compilerjava.util.position;


public class intliteralNode extends constexprNode{
    private int val;

    public intliteralNode(int val,position pos){
        super(pos);
        this.val=val;
    }

    public int getVal() {
        return val;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
package compilerjava.AST;
import compilerjava.position;


public class intliteralNode extends constexprNode{
    private int val;

    public intliteralNode(int val,position pos){
        super(position);
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
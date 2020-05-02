package compilerjava.AST;

import compilerjava.util.position;



public class boolliteralNode extends constexprNode{
    private boolean val;
    public boolliteralNode(boolean val,position pos){
        super(pos);
        this.val=val;
    }
    public boolean getVal() {
        return val;
    }
    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
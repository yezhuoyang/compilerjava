package compilerjava.AST;
import compilerjava.util.position;


public class stringliteralNode extends constexprNode{

    private String val;

    public stringliteralNode(String val,position pos){
        super(pos);
        this.val=val;
    }

    public String getVal(){
        return val;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }



}
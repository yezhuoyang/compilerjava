package compilerjava.AST;
import compilerjava.position;


public class stringliteralNode extends constexprNode{

    private String val;

    public StringliteralNode(String val,position pos){
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
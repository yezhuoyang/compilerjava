package compilerjava.AST;
import compilerjava.util.position;



public class classtypeNode extends typeNode{
    private String ID;

    public classtypeNode(String ID,position pos){
        super(ID,pos);
        this.ID=ID;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
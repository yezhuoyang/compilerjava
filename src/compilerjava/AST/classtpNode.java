package compilerjava.AST;
import compilerjava.util.position;



public class classtpNode extends tpNode{
    private String ID;

    public classtpNode(String ID,position pos){
        super(ID,pos);
        this.ID=ID;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
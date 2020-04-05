package compilerjava.AST;


import compilerjava.util.position;

public class breakNode extends stmtNode{

    public breakNode(position pos){
        super(pos);
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
package compilerjava.AST;


import compilerjava.util.position;


public class vardeclstmtNode extends stmtNode{
    private vardecllistNode vardeclList;

    public vardeclstmtNode(vardecllistNode vardeclList,position pos){
        super(pos);
        this.vardeclList=vardeclList;
    }

    public vardecllistNode getVardeclList() {
        return vardeclList;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
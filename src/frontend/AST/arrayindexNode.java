package compilerjava.AST;

import compiler.util.position;


public class arrayindexNode extends exprNode{
    private exprNode array;
    private exprNode index;

    public arrayindexNode(exprNode array,exprNode index,position pos){
        super(pos);
        this.array=array;
        this.index=index;
    }

    public exprNode getArray() {
        return array;
    }

    public exprNode getIndex() {
        return index;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
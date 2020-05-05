package compilerjava.AST;


import compilerjava.util.position;


public class binaryexprNode extends exprNode{
    private Optype op;
    private exprNode lhs,rhs;


    public binaryexprNode(exprNode lhs,exprNode rhs,Optype op,position pos){
            super(pos);
            this.lhs=lhs;
            this.rhs=rhs;
            this.op=op;
    }

    public exprNode getrhs(){
        return rhs;
    }

    public exprNode getlhs(){
        return lhs;
    }

    public Optype getOp(){
        return op;
    }

    public void setOp(Optype op) {
        this.op = op;
    }

    public enum Optype{
        MUL,DIV,MOD,ADD,SUB,BITL,BITR,LT,GT,LEQ,GEQ,EQ,NEQ,AND,XOR,OR,BITAND,BITOR,ASSIGN
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }

}
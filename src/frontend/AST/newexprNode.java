package compilerjava.AST;


import compilerjava.Env.type;
import compilerjava.util.position;

import java.util.ArrayList;
import java.util.List;

public class newexprNode extends exprNode{
    private typeNode baseType;
    private type baseTypeAfterResolve;
    private int numDims;
    private List<exprNode> exprNodeList=new Array<newexprNode>();


    public newexprNode(typeNode baseType,int numDims,List<exprNode> exprNodeList,position pos){
        super(pos);
        this.baseType=baseType;
        this.numDims=numDims;
        this.exprNodeList=exprNodeList;
    }

    public typeNode getBaseType(){
        return baseType
    }

    public int getNumDims(){
        return numDims;
    }

    public List<exprNode> getExprNodeList() {
        return exprNodeList;
    }

    public type getBaseTypeAfterResolve() {
        return baseTypeAfterResolve;
    }

    public void setBaseTypeAfterResolve(type baseTypeAfterResolve) {
        this.baseTypeAfterResolve = baseTypeAfterResolve;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }
}
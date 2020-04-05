package compilerjava.AST;
import compilerjava.position;
import java.util.List;


public class funccallexprNode extends exprNode{
    private exprNode function;
    private List<exprNode> parameterList;

    public funccallexprNode(exprNode function,List<exprNode> params,position pos){
            super(pos);
            this.function=function;
            this.parameterList=params;
    }

    public exprNode getFunction() {
        return function;
    }

    public List<exprNode> getParameterList() {
        return parameterList;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
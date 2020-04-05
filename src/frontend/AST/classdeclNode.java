package compilerjava.AST;
import compilerjava.util.position;

import java.util.List;


public class classdeclNode extends declNode{

    private String ID;
    private List<funcdeclNode> funcdeclNodeList;
    private List<vardeclNode>  vardeclNodeList;
    private classsymbol classname;


    @Override
    public void accept(ASTvisitor visitor){
        visitor.visitor(this);
    }

    public String getID(){
        return ID;
    }

    public List<funcdeclNode> getFuncdeclNodeList() {
        return funcdeclNodeList;
    }

    public List<vardeclNode> getVardeclNodeList() {
        return vardeclNodeList;
    }

    public classsymbol getClassSymbol() {
        return classname;
    }

    public void setClassSymbol(classsymbol classname) {
        this.classname = classname;
    }
}
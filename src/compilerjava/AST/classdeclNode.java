package compilerjava.AST;
import compilerjava.util.position;
import compilerjava.Env.*;
import java.util.List;


public class classdeclNode extends declNode{

    private String ID;
    private List<funcdeclNode> funcdeclNodeList;
    private List<vardeclNode>  vardeclNodeList;
    private classsymbol classname;


    public classdeclNode(String ID,List<funcdeclNode> funcdeclList,List<vardeclNode>
                         vardeclList,position pos){
        super(pos);
        this.ID=ID;
        this.funcdeclNodeList=funcdeclList;
        this.vardeclNodeList=vardeclList;
    }


    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
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
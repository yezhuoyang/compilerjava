package compilerjava.AST;
import compilerjava.util.position;
import compilerjava.Env.funcsymbol;

import java.util.List;



public class funcdeclNode extends declNode{
    private typeNode tpnode;
    private String ID;
    private List<vardeclNode> parameterList;
    private blockstmtNode block;
    private funcsymbol _funcsymbol;

    public funcdeclNode(typeNode tp,String ID,List<vardeclNode> parameterList,blockstmtNode block,position pos){
        super(pos);
        this.tpnode=tp;
        this.ID=ID;
        this.parameterList=parameterList;
        this.block=block;
        this.parameterList.forEach(vardeclNode::setParameterVariable);
    }

    public String getID(){
        return ID;
    }

    public typeNode gettypeNode(){
        return tpnode;
    }

    public List<vardeclNode> getParameterList() {
        return parameterList;
    }

    public blockstmtNode getBlock() {
        return block;
    }

    public funcsymbol getfuncsymbol() {
        return _funcsymbol;
    }

    public void setfuncsymbol(funcsymbol _funcsymbol) {
        this._funcsymbol = _funcsymbol;
    }


    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }




}
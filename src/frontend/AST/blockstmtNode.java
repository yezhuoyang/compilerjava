package compilerjava.AST;


import compilerjava.util.position;

import java.util.ArrayList;

import java.util.List;



public class blockstmtNode extends stmtNode{
    private List<stmtNode> stmtList=new ArrayList<>();
    private position pos;

    public blockstmtNode(stmtNode sNode,position pos){
            super(pos);
            if(stmtNode !=null)
                stmtList.add(sNode);
    }

    public blockstmtNode(List<stmtNode> stmtList,position pos){
            this.stmtList=stmtList;
            this.pos=pos;
    }

    public List<stmtNode> getStmtList(){
        return stmtList;
    }

    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }


}
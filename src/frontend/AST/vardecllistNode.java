package compilerjava.AST;
import compilerjava.position;

import java.util.ArrayList;
import java.util.List;



public class vardecllistNode extends declNode{
    private List<vardecllistNode> decls;

    public vardecllistNode(position pos){
        super(pos);
        this.decls=new ArrayListM<>();
    }

    public vardecllistNode(List<vardecllistNode> decls,position pos){
        super(pos);
        this.decls=decls;
    }

    public List<vardecllistNode> getDecls() {
        return decls;
    }

    public void setType(typeNode tpnode){
        for(vardeclNode decl:decls)
            decl.settypeNode(tpnode);
    }

    public void addVar(vardeclNode _vardeclNode){
        decls.add(_vardeclNode);
    }

    @Override
    public void accept(ASTvisitor visitor){

    }



}
package compilerjava.AST;
import compilerjava.util.position;


public abstract class Node{
    private position pos;

    public Node(position pos){
        this.pos=pos;
    }

    public position getpos(){
        return pos;
    }

    abstract public void accept(ASTvisitor visitor);

}
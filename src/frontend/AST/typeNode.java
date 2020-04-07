package compilerjava.AST;
import compilerjava.util.position;



public abstract class typeNode extends Node{
    private String typeID;

    public typeNode(String typeID,position pos){
        super(pos);
        this.typeID=typeID;
    }

    public String gettypeID(){
        return typeID;
    }


}
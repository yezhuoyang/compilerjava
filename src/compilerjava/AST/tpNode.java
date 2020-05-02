package compilerjava.AST;
import compilerjava.util.position;



public abstract class tpNode extends Node{
    private String typeID;

    public tpNode(String typeID,position pos){
        super(pos);
        this.typeID=typeID;
    }

    public String gettypeID(){
        return typeID;
    }


}
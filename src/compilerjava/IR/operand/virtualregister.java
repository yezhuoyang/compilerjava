package compilerjava.IR.operand;


import compilerjava.IR.basicblock;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.instruction.move;
import compilerjava.config;

import java.util.*;


public abstract class virtualregister extends register{
    public registerInfo info;
    public Map<Integer,virtualregister> aliases=null;
    private virtualregister origin=null;
    private int SSAID=-1;

    public realregister color=null;
    public stackdata spillAddr=null;
    public Set<virtualregister> adjList=new HashSet<>();
    public int degree;
    public Set<move> moveList=new HashSet<>();
    public virtualregister alias;
    public boolean addForSpill=false;
    public int spillPriority=0;

    public virtualregister(int Size){
        super(Size);
    }

    public virtualregister(String name,int Size){
        super(name,Size);
    }

    public virtualregister(int SSAID,virtualregister origin,int Size){
        super(origin.name,Size);
        this.origin=origin;
        this.SSAID=SSAID;
    }

    public int getSSAID() {
        return SSAID;
    }

    public virtualregister getOrigin() {
        return origin==null? this:origin;
    }

    public virtualregister getSSARenameReg(int id){
        if(aliases==null) aliases=new HashMap<>();
        virtualregister alias=aliases.get(id);
        if(alias==null){
            alias=new virtualregister(id,this,this.Size){
                @Override
                public void accept(IRvisitor irvisitor){
                       irvisitor.visit(this);
                }
            };
            aliases.put(id,alias);
        }
        return alias;
    }



    public int getNewId(){
        int newID=info.counter++;
        info.stack.push(newID);
        return newID;
    }

    public void clearAllocInfo(){
        spillAddr=null;
        adjList.clear();
        moveList.clear();
        alias=null;
    }


    public static class registerInfo{
        public Set<basicblock> defBB=new HashSet<>();
        public Stack<Integer> stack=new Stack<>();
        public int counter=0;
    }

}

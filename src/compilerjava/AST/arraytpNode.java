package compilerjava.AST;
import compilerjava.util.position;




public class arraytpNode extends tpNode{
    private tpNode baseType;
    private int dims;


    public arraytpNode(tpNode tpnode,position pos){
          super(tpnode.gettypeID(),pos);
          if(tpnode instanceof arraytpNode){
              baseType=((arraytpNode)tpnode).baseType;
              dims=((arraytpNode)tpnode).dims+1;
          }
          else {
              baseType = tpnode;
              dims = 1;
          }
    }

    public int getDims(){
        return dims;
    }


    @Override
    public void accept(ASTvisitor visitor){
        visitor.visit(this);
    }






}
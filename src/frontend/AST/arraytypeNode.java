package compilerjava.AST;
import compilerjava.util.position;




public class arraytypeNode extends typeNode{
    private typeNode baseType;
    private int dims;

    public arraytypeNode(typeNode tpnode,position pos){
          super(tpnode.gettypeID(),pos);
          if(tpnode instanceof arraytypeNode){
              baseType=((arraytypeNode)tpnode).baseType;
              dims=((arraytypeNode)tpnode).dims+1;
          }
          else {
              baseType = tpnode
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
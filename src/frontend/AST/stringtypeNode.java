package compilerjava.AST;
import compilerjava.util.position;


public class stringtypeNode extends basetypeNode{
        public stringtypeNode(position pos){
            super("string",pos);
        }

        @Override
        public void accept(ASTvisitor visitor){
            visitor.visit(this);
        }

}
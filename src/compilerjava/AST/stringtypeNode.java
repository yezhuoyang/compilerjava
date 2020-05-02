package compilerjava.AST;
import compilerjava.util.position;


public class stringtpNode extends basetpNode{
        public stringtpNode(position pos){
            super("string",pos);
        }

        @Override
        public void accept(ASTvisitor visitor){
            visitor.visit(this);
        }

}
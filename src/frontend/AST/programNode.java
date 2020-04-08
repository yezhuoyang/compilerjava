package compilerjava.AST;
import java.util.List;
import compilerjava.util.position;





public class programNode extends Node{
        private List<declNode> declNodeList;
        public boolean hasClassDeclNode=false;



        public programNode(List<declNode> declNodeList,position pos,boolean hasClassDeclNode){
            super(pos);
            this.declNodeList=declNodeList;
            this.hasClassDeclNode=hasClassDeclNode;
        }

        public List<declNode> getDeclNodeList(){
            return this.declNodeList;
        }

        @Override
        public void accept(ASTvisitor visitor){
            visitor.visit(this);
        }


}
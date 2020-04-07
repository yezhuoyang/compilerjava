package compilerjava.AST;
import compilerjava.Parser.MXBaseVisitor;
import compilerjava.Parser.MXParser;
import compilerjava.util.position;
import compilerjava.util.syntaxError;
import org.antlr.v4.runtime.ParserRuleContext;
import java.util.ArrayList;
import java.util.List;


public class ASTcreator extends MXBaseVisitor<Node>{

	@Override
	public Node visitProgram(MXParser.ProgramContext ctx) {
	    boolean hasclassdeclNode=false;
	    List<declNode> decls=new ArrayList<>();
	    if(ctx.programParts()!=null){
	        for(ParserRuleContext programParts:ctx.programParts()){
	            Node decl=visit(programParts);
	            if(decl instanceof vardecllistNode) decls.addAll(((vardecllistNode)decl).getDecls());
                else decls.add((declNode)decl);
                if(decl instanceof classdeclNode)hasclassdeclNode=true;
	        }
	    }
        return new programNode(decls,new position(ctx.getStart()),hasclassdeclNode);
	}



	@Override
	public Node visitProgramParts(MXParser.ProgramPartsContext ctx) {
	        if(ctx.functionDecl()!=null)return visit(ctx.functionDecl());
	        if(ctx.variableDecl()!=null)return visit(ctx.variableDecl());
	        if(ctx.classDecl()!=null)return visit(ctx.classDecl());
	        return null;
	}


	@Override
	public Node visitFunctionDecl(MXParser.FunctionDeclContext ctx) {
	        typeNode tpnode=ctx.typeForfunc()==null? null:(typeNode) visit(ctx.typeForfunc());
            String ID=ctx.ID().getText();
            List<vardeclNode> parameterList=new ArrayList<>();
            if(ctx.params()!=null){
                Node decl=visit(ctx.params());
                parameterList.addAll( ((vardecllistNode)decl).getDecls());
            }
            blockstmtNode block=(blockstmtNode) visit(ctx.block());
            return new funcdeclNode(tpnode,ID,parameterList,block,new position(ctx.getStart()));
	}


	@Override
	public Node visitClassDecl(MXParser.ClassDeclContext ctx) {
	       String ID=ctx.ID().getText();
	       List<funcdeclNode> funcdeclList=new ArrayList<>();
	       List<vardeclNode> vardeclList=new ArrayList<>();
	       for(ParserRuleContext decl:ctx.functionDecl())
	            funcdeclList.add((funcdeclNode) visit(decl));
           for(ParserRuleContext decl:ctx.variableDecl())
                vardeclList.addAll(((vardecllistNode)visit(decl)).getDecls());
           return new classdeclNode(ID,funcdeclList,vardeclList,new position(ctx.getStart()));
	}


	@Override
	 public Node visitVariableDecl(MXParser.VariableDeclContext ctx) {
          typeNode tpnode=(typeNode) visit(ctx.type());
          vardecllistNode vardeclList=(vardecllistNode) visit(ctx.variableList());
          vardeclList.setType(tpnode);
          return vardeclList;
	 }


	@Override
	public Node visitVariableList(MXParser.VariableListContext ctx) {
	    vardecllistNode vardeclList=new vardecllistNode(new position(ctx.getStart()));
        for(ParserRuleContext singleVariableDecl:ctx.singleVariableDecl())
            vardeclList.addVar((vardeclNode) visit(singleVariableDecl));
        return vardeclList;
	}


	@Override
	public Node visitSingleVariableDecl(MXParser.SingleVariableDeclContext ctx) {
	    String ID=ctx.ID().getText();
        exprNode expr=ctx.expr()==null? null:(exprNode)visit(ctx.expr());
        return new vardeclNode(null,expr,ID,new position(ctx.getStart()));
	}


	@Override
	public Node visitParams(MXParser.ParamsContext ctx) {
        vardecllistNode parameterdeclListNode=new vardecllistNode(new position(ctx.getStart()));
        for(ParserRuleContext  paramdecl:ctx.paramDecl())
                parameterdeclListNode.addVar((vardeclNode)visit(paramdecl));
        return parameterdeclListNode;
	}


	@Override
	public Node visitParamDecl(MXParser.ParamDeclContext ctx) {
        typeNode tpnode=(typeNode) visit(ctx.type());
        String ID=ctx.ID().getText();
        return new vardeclNode(tpnode,null,ID,new position(ctx.getStart()));
	}



	@Override
	public Node visitArrayType(MXParser.ArrayTypeContext ctx) {
         return  new arraytypeNode((typeNode)visit(ctx.type()),new position(ctx.getStart()));
	}



	@Override
	public Node visitNarrayType(MXParser.NarrayTypeContext ctx) {
         return visit(ctx.nonArraytype());
	}



	@Override
	public Node visitTypeForfunc(MXParser.TypeForfuncContext ctx) {
        if(ctx.type()!=null)return visit(ctx.type());
        return new voidtypeNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitNarrayTypeInt(MXParser.NarrayTypeIntContext ctx) {
        return  new inttypeNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitNarrayTypeBool(MXParser.NarrayTypeBoolContext ctx) {
        return new booltypeNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitNarrayTypeString(MXParser.NarrayTypeStringContext ctx) {
        return new stringtypeNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitNarrayID(MXParser.NarrayIDContext ctx) {
        return new classtypeNode(ctx.ID().getText(),new position(ctx.getStart()));
	}


	@Override
	public Node visitBlockstmt(MXParser.BlockstmtContext ctx) {
        return visit(ctx.block());
	}


	@Override
	public Node visitVardeclstmt(MXParser.VardeclstmtContext ctx) {
	        return new vardeclstmtNode((vardecllistNode) visit(ctx.variableDecl()),new position(ctx.getStart()) );
	}


	@Override
	public Node visitExprstmt(MXParser.ExprstmtContext ctx) {
	        return new exprstmtNode((exprNode) visit(ctx.expr()),new position(ctx.getStart()));
	}


	@Override
	public Node visitConditionstmt(MXParser.ConditionstmtContext ctx) {
	       return  visit(ctx.conditionStatement());
	 }


	@Override
	public Node visitLoopstmt(MXParser.LoopstmtContext ctx) {
	        return visit(ctx.loopStatement());
	}


	@Override
	public Node visitJumpstmt(MXParser.JumpstmtContext ctx) {
	        return visit(ctx.jumpStatement());
	}



	@Override
	public Node visitBlankstmt(MXParser.BlankstmtContext ctx) {
	        return null;
	}


	@Override
	public Node visitBlock(MXParser.BlockContext ctx) {
	       List<stmtNode> stmtList=new ArrayList<>();
	       for(ParserRuleContext stmt:ctx.stmt()){
	            stmtNode stnode=(stmtNode) visit(stmt);
	            if(stnode!=null)stmtList.add((stmtNode)visit(stmt));
	       }
           return new blockstmtNode(stmtList,new position(ctx.getStart()));
	}


	@Override
	public Node visitConditionStatement(MXParser.ConditionStatementContext ctx) {
	        stmtNode thenStmt=(stmtNode) visit(ctx.thenStmt);
	        stmtNode elseStmt=ctx.elseStmt==null?null:(stmtNode) visit(ctx.elseStmt);
            if(!((thenStmt) instanceof blockstmtNode))
                    thenStmt=new blockstmtNode(thenStmt,new position(ctx.getStart()));
            if(elseStmt!=null&&!(elseStmt instanceof blockstmtNode))
                    elseStmt=new blockstmtNode(elseStmt,new position(ctx.getStart()));
            return new IfstmtNode((exprNode)visit(ctx.expr()),thenStmt,elseStmt,new position(ctx.getStart()));
	}


	@Override
	public Node visitWhilestmt(MXParser.WhilestmtContext ctx) {
	        stmtNode stnode=(stmtNode) visit(ctx.stmt());
	        if(!(stnode instanceof blockstmtNode))
	            stnode=new blockstmtNode(stnode,new position(ctx.getStart()));
	        return new whilestmtNode((exprNode)visit(ctx.expr()),stnode,new position(ctx.getStart()));
	}


	@Override
	public Node visitForstmt(MXParser.ForstmtContext ctx) {
	       	stmtNode stnode=(stmtNode) visit(ctx.stmt());
            if(!(stnode instanceof blockstmtNode))
                stnode=new blockstmtNode(stnode,new position(ctx.getStart()));
	        return new forstmtNode(
	            ctx.init==null?null:(exprNode) visit(ctx.init),
	            ctx.cond==null?null:(exprNode) visit(ctx.cond),
	            ctx.step==null?null:(exprNode) visit(ctx.step),
	            stnode,
	            new position(ctx.getStart())
	        );
	}


	@Override
	public Node visitReturnstmt(MXParser.ReturnstmtContext ctx) {
            return new returnNode(ctx.expr()==null?null:(exprNode) visit(ctx.expr()),
            new position(ctx.getStart()));
    }



	@Override
	public Node visitBreakstmt(MXParser.BreakstmtContext ctx) {
	        return new breakNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitContinuestmt(MXParser.ContinuestmtContext ctx) {
	       return new continueNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitUnaryexpr(MXParser.UnaryexprContext ctx) {
	       unaryexprNode.Op op;
	       switch(ctx.op.getText()){
	        case "++":
	               op=unaryexprNode.Op.PRE_ADD;
	               break;
	        case "--":
	               op=unaryexprNode.Op.PRE_SUB;
	                break;
	        case "+":
	        	    op=unaryexprNode.Op.POS;
	                break;
	        case "-":
	       	        op=unaryexprNode.Op.NEG;
	                break;
	        case "!":
	        	    op=unaryexprNode.Op.NOTL;
	                break;
	        case "~":
	        	    op=unaryexprNode.Op.NOT;
	                break;
	        default:
	                op=null;
	       }
	    return new unaryexprNode((exprNode)visit(ctx.expr()),op,new position(ctx.getStart()));
	}


	@Override
	public Node visitIdentifier(MXParser.IdentifierContext ctx) {
	        return new IDexprNode(ctx.ID().getText(),new position(ctx.getStart()));
	}


	@Override
	public Node visitThisexpr(MXParser.ThisexprContext ctx) {
	        return new thisexprNode(new position(ctx.getStart()));
	}


	@Override
	public Node visitSubscript(MXParser.SubscriptContext ctx) {
	        return new arrayindexNode((exprNode)visit(ctx.array),(exprNode)visit(ctx.index),new position(ctx.getStart()));
	}


	@Override
	public Node visitMemberaccess(MXParser.MemberaccessContext ctx) {
	        return new classmemberNode((exprNode)visit(ctx.expr()),ctx.ID().getText(),new position(ctx.getStart()));
	}


	@Override
	public Node visitNewexpr(MXParser.NewexprContext ctx) {
	        return visit(ctx.creator());
	}


	@Override
	public Node visitFunctioncall(MXParser.FunctioncallContext ctx) {
	        List<exprNode> parameterList=new ArrayList<>();
	        if(ctx.params()!=null){
	            for(ParserRuleContext parameter:ctx.params().paramDecl())
	                parameterList.add((exprNode) visit(parameter));
	        }
            return new funccallexprNode((exprNode)visit(ctx.expr()),parameterList,new position(ctx.getStart()));
	}


	@Override
	public Node visitBinaryexpr(MXParser.BinaryexprContext ctx) {
	        binaryexprNode.Optype op;
	        switch(ctx.op.getText()){
	           case "*":
	            op=binaryexprNode.Optype.MUL;
	            break;
	           case "/":
	            op=binaryexprNode.Optype.DIV;
	            break;
	           case "%":
		        op=binaryexprNode.Optype.MOD;
	            break;
	           case "+":
	           	op=binaryexprNode.Optype.ADD;
	            break;
	           case "-":
	           	op=binaryexprNode.Optype.SUB;
	            break;
	           case "<<":
	           op=binaryexprNode.Optype.BITL;
	           break;
	           case ">>":
	            op=binaryexprNode.Optype.BITR;
	            break;
	           case "<":
	            op=binaryexprNode.Optype.LT;
	            break;
	           case ">":
	            op=binaryexprNode.Optype.GT;
	            break;
	           case "<=":
	     	    op=binaryexprNode.Optype.LEQ;
	            break;
	           case ">=":
	     	    op=binaryexprNode.Optype.GEQ;
	            break;
	           case "==":
	     	    op=binaryexprNode.Optype.EQ;
	            break;
	           case "!=":
	     	    op=binaryexprNode.Optype.NEQ;
	            break;
	 	       case "&":
	     	    op=binaryexprNode.Optype.BITAND;
     	        break;
     	       case "^":
	     	    op=binaryexprNode.Optype.XOR;
     	        break;
     	       case "|":
	     	    op=binaryexprNode.Optype.BITOR;
     	        break;
     	       case "&&":
     	  	    op=binaryexprNode.Optype.AND;
     	        break;
      	       case "||":
  	     	    op=binaryexprNode.Optype.OR;
      	        break;
      	       case "=":
  	     	    op=binaryexprNode.Optype.ASSIGN;
      	        break;
     	       default:
     	        	 op=null;
	        }
	        return new binaryexprNode((exprNode) visit(ctx.src1),
	           (exprNode) visit(ctx.src2),
	           op,
	           new position(ctx.getStart()));
	}


	@Override
	public Node visitConstantexpr(MXParser.ConstantexprContext ctx) {
	       return visit(ctx.constant());
	}


	@Override
	public Node visitSubexpr(MXParser.SubexprContext ctx) {
	        return visit(ctx.expr());
	}


	@Override
	public Node visitPostcalcdecl(MXParser.PostcalcdeclContext ctx) {
	        return new unaryexprNode((exprNode) visit(ctx.expr()),
	         (ctx.op.getText().equals("++"))? unaryexprNode.Op.SUF_ADD:unaryexprNode.Op.SUF_SUB,
	         new position(ctx.getStart()));
	}


	@Override
	public Node visitErrorCreator(MXParser.ErrorCreatorContext ctx) {
	        throw new syntaxError("Invalid new expression",new position(ctx.getStart()));
	}


	@Override
	public Node visitArrayCreator(MXParser.ArrayCreatorContext ctx) {
	       List<exprNode> exprNodeList=new ArrayList<>();
	       for(ParserRuleContext expr:ctx.expr())
	                exprNodeList.add((exprNode) visit(expr)  );
	       return new newexprNode( (typeNode)visit(ctx.nonArraytype()),
	           (ctx.getChildCount()-ctx.expr().size()-1)/2,
	           exprNodeList,
	           new position(ctx.getStart())
	           );
	}


	@Override
	public Node visitClassCreator(MXParser.ClassCreatorContext ctx) {
	       return new  newexprNode((typeNode) visit(ctx.nonArraytype()),
	           0,
	           new ArrayList<>(),
	           new position(ctx.getStart()));
	}


	@Override
	public Node visitNarrayCreator(MXParser.NarrayCreatorContext ctx) {
           return new  newexprNode((typeNode) visit(ctx.nonArraytype()),
               0,
               new ArrayList<>(),
               new position(ctx.getStart()));
	}


	@Override
	public Node visitIntegerLiteral(MXParser.IntegerLiteralContext ctx) {
	        return new intliteralNode(Integer.valueOf(ctx.INTCONSTANT().getText()),new position(ctx.getStart()));
	}


	@Override
	public Node visitStringLiteral(MXParser.StringLiteralContext ctx) {
	        return new stringliteralNode(ctx.STRINGCONSTANT().getText(),new position(ctx.getStart()));
	}


	@Override
	public Node visitBoolLiteral(MXParser.BoolLiteralContext ctx) {
	       return new boolliteralNode(Boolean.valueOf(ctx.BOOLCONSTANT().getText()),new position(ctx.getStart()));
	}


	@Override
	public Node visitNullLiteral(MXParser.NullLiteralContext ctx) {
	        return new nullliteralNode(new position(ctx.getStart()));
	}



}
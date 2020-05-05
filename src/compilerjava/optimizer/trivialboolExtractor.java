package compilerjava.optimizer;

import compilerjava.AST.*;


import java.util.HashMap;
import java.util.Map;


public class trivialboolExtractor implements ASTvisitor{
    public static Map<Node,Boolean> trivialNodeMap=new HashMap<>();
    private boolean collectMode;

    public trivialboolExtractor(){
    }

    @Override
    public void visit(programNode node){
        collectMode=true;
        node.getDeclNodeList().forEach(x->x.accept(this));
        collectMode=false;
        node.getDeclNodeList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(vardeclNode node){
        if(collectMode){
            if(node.getExpr()!=null) node.getExpr().accept(this);
        }else{
            if(node.getExpr()!=null && trivialNodeMap.get(node.getExpr()))node.getExpr().accept(this);
        }
    }

    @Override
    public void visit(funcdeclNode node){
        visit(node.getBlock());
    }

    @Override
    public void visit(classdeclNode node){
        node.getFuncdeclNodeList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(arraytpNode node){

    }

    @Override
    public void visit(classtpNode node){

    }

    @Override
    public void visit(booltpNode node){

    }

    @Override
    public void visit(inttpNode node){

    }

    @Override
    public void visit(voidtpNode node){

    }

    @Override
    public void visit(stringtpNode node){

    }

    @Override
    public void visit(blockstmtNode node){
        node.getStmtList().forEach(x->x.accept(this));
    }


    @Override
    public void visit(vardeclstmtNode node){
        node.getVardeclList().getDecls().forEach(x->x.accept(this));
    }

    @Override
    public void visit(exprstmtNode node){
        node.getExpr().accept(this);
    }

    @Override
    public void visit(IfstmtNode node){
        node.getThenstmt().accept(this);
        if(node.getElsestmt()!=null)node.getElsestmt().accept(this);
    }

    @Override
    public void visit(whilestmtNode node){
         if(node.getStmt()!=null) node.getStmt().accept(this);
    }

    @Override
    public void visit(forstmtNode node){
        if(node.getInit()!=null)node.getInit().accept(this);
        if(node.getStep()!=null)node.getStep().accept(this);
        if(node.getStmt()!=null)node.getStmt().accept(this);
    }

    @Override
    public void visit(returnNode node){
        if(collectMode){
            if(node.getExpr()!=null)node.getExpr().accept(this);
        }else{
            if(node.getExpr()!=null&&trivialNodeMap.get(node.getExpr())){
                node.getExpr().accept(this);
            }
        }
    }

    @Override
    public void visit(breakNode node){
    }

    @Override
    public void visit(continueNode node){
    }

    @Override
    public void visit(arrayindexNode node){
        trivialNodeMap.put(node,false);
    }



    @Override
    public void visit(binaryexprNode node){
        switch (node.getOp()){
            case LT:
            case LEQ:
            case EQ:
            case GT:
            case GEQ:
            case NEQ:{
                if(collectMode){
                    node.getlhs().accept(this);
                    node.getrhs().accept(this);
                    trivialNodeMap.put(node,trivialNodeMap.get(node.getlhs())&trivialNodeMap.get(node.getrhs()));
                }
                break;
            }
            case OR:{
                if(collectMode){
                    node.getlhs().accept(this);
                    node.getrhs().accept(this);
                    trivialNodeMap.put(node,trivialNodeMap.get(node.getlhs())&trivialNodeMap.get(node.getrhs()));
                }else{
                    node.setOp(binaryexprNode.Optype.OR);
                    node.getlhs().accept(this);
                    node.getrhs().accept(this);
                }
                break;
            }
            case AND:{
                 if(collectMode){
                     node.getlhs().accept(this);
                     node.getrhs().accept(this);
                     trivialNodeMap.put(node,trivialNodeMap.get(node.getlhs())&trivialNodeMap.get(node.getrhs()));
                 }else{
                     node.setOp(binaryexprNode.Optype.AND);
                     node.getlhs().accept(this);
                     node.getrhs().accept(this);
                 }
                 break;
            }
            case ASSIGN:{
                 if(collectMode){
                     node.getrhs().accept(this);
                     trivialNodeMap.put(node,false);
                 }else{
                     if(trivialNodeMap.get(node.getrhs())) node.getrhs().accept(this);
                 }
                 break;
            }
            default:{
                trivialNodeMap.put(node,false);
            }
        }
    }

    @Override
    public void visit(classmemberNode node){
        trivialNodeMap.put(node,false);
    }

    @Override
    public void visit(funccallexprNode node){
        trivialNodeMap.put(node,false);
    }

    @Override
    public void visit(IDexprNode node){
        trivialNodeMap.put(node,true);
    }

    @Override
    public void visit(newexprNode node){
        trivialNodeMap.put(node,false);
    }

    @Override
    public void visit(thisexprNode node){
        trivialNodeMap.put(node,false);
    }

    @Override
    public void visit(unaryexprNode node){
        if(node.getOp()==unaryexprNode.Op.NOT){
            if(collectMode){
                node.getExpr().accept(this);
                trivialNodeMap.put(node,trivialNodeMap.get(node.getExpr()));
            }else{
                node.setOp(unaryexprNode.Op.NOT);
                node.getExpr().accept(this);
            }
        }else{
            trivialNodeMap.put(node,false);
        }
    }

    @Override
    public void visit(intliteralNode node){
        trivialNodeMap.put(node,true);
    }

    @Override
    public void visit(boolliteralNode node){
        trivialNodeMap.put(node,true);
    }

    @Override
    public void visit(nullliteralNode node){
        trivialNodeMap.put(node,true);
    }

    @Override
    public void visit(stringliteralNode node){
        trivialNodeMap.put(node,true);
    }


}

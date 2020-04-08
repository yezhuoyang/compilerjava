package compilerjava.semantic;



import compilerjava.AST.*;
import compilerjava.util.*;
import compilerjava.Env.*;


import java.util.Stack;



public class symbolcollector implements ASTvisitor{
    private globalfield _globalfield;
    private field currentfield;
    private classsymbol currentclasssymbol;
    private funcsymbol currentfuncsymbol;
    private Stack<Loop> stackOfLoops=new Stack<>();

    public symbolcollector(globalfield _globalfield){
        this._globalfield=_globalfield;
        currentfield=_globalfield;
    }

    public static type Node2Type(typeNode tpnode,globalfield _globalfield){
        type tp=_globalfield.resolvetype(tpnode);
        if(tpnode instanceof arraytypeNode)
            return new arraytype(tp,((arraytypeNode)tpnode).getDims());
        else return tp;
    }


    @Override
    public void visit(programNode node){
        currentfield=_globalfield;
        currentclasssymbol=null;
        currentfuncsymbol=null;
        node.getDeclNodeList().forEach(x->{
            x.accept(this);
            currentfield = _globalfield;
            currentclasssymbol=null;
            currentfuncsymbol=null;
        });
    }

    @Override
    public void visit(vardeclNode node){
        if(node.getExpr()!=null)node.getExpr().accept(this);
        type _type=Node2Type(node.gettypeNode(),_globalfield);
        node.setTypeAfterresolve(_type);
        varsymbol _varsymbol=new varsymbol(node.getID(),_type,node);
        node.setvarsymbol(_varsymbol);

        currentfield.defvar(_varsymbol);


        if(currentfield==_globalfield)node.setGlobalVarible();
    }


    @Override
    public void visit(funcdeclNode node){
        funcsymbol _funcsymbol=(funcsymbol) currentfield.resolvesymbol(node.getID(),node.getpos());
        currentfield=_funcsymbol;
        currentfuncsymbol=_funcsymbol;
        visit(node.getBlock());
    }

    @Override
    public void visit(classdeclNode node){
        classsymbol _classsymbol=node.getClassSymbol();
        currentfield=_classsymbol;
        currentclasssymbol=_classsymbol;
        node.getFuncdeclNodeList().forEach(x->{
            x.accept(this);
            currentfield=_classsymbol;
        });
    }

    @Override
    public void visit(arraytypeNode node){
    }

    @Override
    public void visit(classtypeNode node){
    }

    @Override
    public void visit(booltypeNode node){
    }

    @Override
    public void visit(inttypeNode node){
    }


    @Override
    public void visit(voidtypeNode node){
    }


    @Override
    public void visit(stringtypeNode node){
    }

    @Override
    public void visit(blockstmtNode node){
        localfield _localfield=new localfield("block local field",currentfield);
        currentfield=_localfield;
        node.getStmtList().forEach(x->{
            x.accept(this);
            currentfield=_localfield;
        });
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
        node.getExpr().accept(this);
        node.getThenstmt().accept(this);
        if(node.getElsestmt()!=null)node.getElsestmt().accept(this);
    }

    @Override
    public void visit(whilestmtNode node){
        stackOfLoops.push(node);
        node.getExpr().accept(this);
        if (node.getStmt()!=null) {
            node.getStmt().accept(this);
        }
        stackOfLoops.pop();
    }




    @Override
    public void visit(forstmtNode node){
        stackOfLoops.push(node);
        if(node.getInit()!=null)node.getInit().accept(this);
        if(node.getCond()!=null)node.getCond().accept(this);
        if(node.getStep()!=null)node.getStep().accept(this);
        if(node.getStmt()!=null){
            node.getStmt().accept(this);
        }
        stackOfLoops.pop();
    }

    @Override
    public void visit(returnNode node){
        if(node.getExpr()!=null)node.getExpr().accept(this);
        if(currentfuncsymbol==null)
            throw new semanticError("Return should be in a function",node.getpos());
        node.setfuncsymbol(currentfuncsymbol);
    }

    @Override
    public void visit(breakNode node){
        if(stackOfLoops.empty())
            throw new semanticError("Break should be in a loop",node.getpos());
        node.setCurrentLoop(stackOfLoops.peek());
    }

    @Override
    public void visit(continueNode node){
        if(stackOfLoops.empty())
            throw new semanticError("Continue should be in a loop",node.getpos());
        node.setCurrentLoop(stackOfLoops.peek());
    }

    @Override
    public void visit(arrayindexNode node){
        node.getArray().accept(this);
        node.getIndex().accept(this);
    }

    @Override
    public void visit(binaryexprNode node){
        node.getlhs().accept(this);
        node.getrhs().accept(this);
    }

    @Override
    public void visit(classmemberNode node){
        node.getExpr().accept(this);
    }

    @Override
    public void visit(funccallexprNode node){
        node.getFunction().accept(this);
        node.getParameterList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(IDexprNode node){
        symbol _symbol=currentfield.resolvesymbol(node.getID(),node.getpos());
        node.setsymbol(_symbol);
    }

    @Override
    public void visit(newexprNode node){
        type tp=Node2Type(node.getBaseType(),_globalfield);
        node.setBaseTypeAfterResolve(tp);
        node.getExprNodeList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(thisexprNode node){
        if(currentclasssymbol==null)throw new semanticError("No corresponding class for this",node.getpos());
        node.setfield(currentclasssymbol);
    }

    @Override
    public void visit(unaryexprNode node){
        node.getExpr().accept(this);
    }

    @Override
    public void visit(intliteralNode node){

    }

    @Override
    public void visit(boolliteralNode node){

    }

    @Override
    public void visit(nullliteralNode node){

    }

    @Override
    public void visit(stringliteralNode node){

    }


}

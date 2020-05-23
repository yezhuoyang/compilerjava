package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;
import java.util.*;


public class classdeclcollector implements ASTvisitor{
    private globalfield _globalfield;

    public classdeclcollector(globalfield _globalfield){
            this._globalfield=_globalfield;
    }

    @Override
    public void visit(programNode node){
        node.getDeclNodeList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(vardeclNode node){
    }

    @Override
    public void visit(funcdeclNode node){
    }

    @Override
    public void visit(classdeclNode node){
        classsymbol _classsymbol=new classsymbol(node.getID(),node,_globalfield);
        _globalfield.defclass(_classsymbol);
        node.setClassSymbol(_classsymbol);
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
    }

    @Override
    public void visit(vardeclstmtNode node){
    }

    @Override
    public void visit(exprstmtNode node){
    }

    @Override
    public void visit(IfstmtNode node){
    }


    @Override
    public void visit(whilestmtNode node){
    }

    @Override
    public void visit(forstmtNode node){
    }

    @Override
    public void visit(returnNode node){
    }


    @Override
    public void visit(breakNode node){
    }


    @Override
    public void visit(continueNode node){
    }


    @Override
    public void visit(arrayindexNode node){
    }

    @Override
    public void visit(binaryexprNode node){
    }


    @Override
    public void visit(classmemberNode node){
    }


    @Override
    public void visit(funccallexprNode node){
    }


    @Override
    public void visit(IDexprNode node){

    }


    @Override
    public void visit(newexprNode node){

    }


    @Override
    public void visit(thisexprNode node){}


    @Override
    public void visit(unaryexprNode node){}


    @Override
    public void visit(intliteralNode node){}


    @Override
    public void visit(boolliteralNode node){}


    @Override
    public void visit(nullliteralNode node){}


    @Override
    public void visit(stringliteralNode node){}

}
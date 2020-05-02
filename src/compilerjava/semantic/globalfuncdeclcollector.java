package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.util.*;


public class globalfuncdeclcollector implements ASTvisitor{
    private globalfield _globalfield;

    public static type Node2Type(tpNode tpnode,globalfield _globalfield){
        type tp=_globalfield.resolvetype(tpnode);
        if(tpnode instanceof arraytpNode)
            return new arraytype(tp,((arraytpNode)tpnode).getDims());
        else return tp;
    }

    public globalfuncdeclcollector(globalfield _globalfield){
        this._globalfield=_globalfield;
    }


    private void MainfunctionChecker(symbol main){
        if(main.gettype() instanceof  basesymbol){
            if(!main.gettype().getTypeName().equals("int"))
                throw new semanticError("Return type of main ought to be int",new position(0,0));
            if(!(((funcdeclNode)main.getDefNode()).getParameterList().isEmpty()))
                throw new semanticError("Parameter list of main ought to be empty ",new position(0,0));
        }else throw new semanticError("Return type of main ought to be int",new position(0,0));
    }

    @Override
    public void visit(programNode node){
        node.getDeclNodeList().forEach(x->x.accept(this));
        MainfunctionChecker(_globalfield.resolveMain());
    }

    @Override
    public void visit(vardeclNode node){
    }

    @Override
    public void visit(funcdeclNode node){
        if(node.gettpNode()==null)
            throw new semanticError("Global function should have return type",node.getpos());
        type returnType=Node2Type(node.gettpNode(),_globalfield);
        funcsymbol _funcsymbol=new funcsymbol(node.getID(),returnType,node,_globalfield);
        node.setfuncsymbol(_funcsymbol);
        for(vardeclNode _vardeclNode:node.getParameterList()){
            type parameterType=Node2Type(_vardeclNode.gettpNode(),_globalfield);
            varsymbol _varsymbol=new varsymbol(_vardeclNode.getID(),parameterType,_vardeclNode);
            _vardeclNode.setvarsymbol(_varsymbol);
            _funcsymbol.defvar(_varsymbol);
        }
        _globalfield.deffunc(_funcsymbol);
    }


    @Override
    public void visit(classdeclNode node){
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
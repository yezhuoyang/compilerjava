package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.util.semanticError;
import compilerjava.util.position;


public class globalfuncdeclcollector implements ASTvisitor{
    private globalfield _globalfield;

    public static type Node2Type(typeNode tpnode,globalfield _globalfield){
        type tp=_globalfield.resolveyType(tpnode);
        if(tpnode instanceof arraytypeNode)
            return new arraytype(tp,((arraytypeNode)tpnode).getDims());
        else return tp;
    }

    public globalfuncdeclcollectorr(globalfield _globalfield){
        this.globalfield=_globalfield;
    }


    private void MainfunctionChecker(symbol main){
        if(main.gettype() instanceof  basesymbol){
            if(!main.gettype().getWord().equals("int"))
                throw new semanticError("Return type of main ought to be int",new position(0,0));
            if(!(((funcdeclNode)main.getdef()).getParameterList().isEmpty()))
                throw new semanticError("Parameter list of main ought to be empty ",new position(0,0));
        }else throw new semanticError("Return type of main ought to be int",new position(0,0));
    }

    @Override
    public void visit(ProgramNode node){
        node.getDeclNodeList().forEach(x->x.accept(this));
        MainfunctionChecker(_globalfield.resolveMain());
    }

    @Override
    public void visit(VariabledeclNode node){
    }

    @Override
    public void visit(funcdeclNode node){
        if(node.gettype()==null)
            throw new semanticError("Global function should have return type",node.getpos());
        type returnType=Node2Type(node.gettype(),_globalfield);
        funcsymbol _funcsymbol=new funcsymbol(node.getID(),returnType,node,_globalfield);
        node.setFunctionSymbol(_funcsymbol);
        for(vardeclNode vardecclNode:node.getParameterList()){
            type parameterType=Node2Type(vardecclNode.gettype(),_globalfield);
            varsymbol _varsymbol=new varsymbol(vardeclNode.getID(),parameterType,vardecclNode);
            vardecclNode.setvarsymbol(_varsymbol);
            _funcsymbol.defvar(_varsymbol);
        }
        _globalfield.deffunc(_funcsymbol);
    }



    @Override
    public void visit(classdeclNode node){
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
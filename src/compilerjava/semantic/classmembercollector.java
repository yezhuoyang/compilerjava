package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.util.*;



public class classmembercollector implements ASTvisitor{
    private globalfield _globalfield;
    private field  currentfield;

    public static type Node2Type(tpNode tpnode,globalfield _globalfield){
        type tp=_globalfield.resolvetype(tpnode);
        if(tpnode instanceof arraytpNode)
            return new arraytype(tp,((arraytpNode)tpnode).getDims());
        else return tp;
    }


    public classmembercollector(globalfield _globalfield){
        this._globalfield=_globalfield;
    }

    @Override
    public void visit(programNode node){
        node.getDeclNodeList().forEach(x->{
            if(x instanceof classdeclNode)x.accept(this);
        });
    }

    @Override
    public void visit(vardeclNode node){
        type tp=Node2Type(node.gettpNode(),_globalfield);
        varsymbol _varsymbol=new varsymbol(node.getID(),tp,node);
        node.setvarsymbol(_varsymbol);
        currentfield.defvar(_varsymbol);
    }

    @Override
    public void visit(funcdeclNode node){
        type returntype=node.gettpNode()==null
                ? (classsymbol) currentfield:
                Node2Type(node.gettpNode(),_globalfield);
        funcsymbol _funcsymbol=new funcsymbol(node.getID(),returntype,node,currentfield);
        node.setfuncsymbol(_funcsymbol);
        currentfield.deffunc(_funcsymbol);
        if(currentfield instanceof classsymbol){
            if(node.getID().equals(((classsymbol)currentfield).getTypeName())){
                if(node.gettpNode()==null){
                    if(((classsymbol)currentfield).getConstructor()!=null)
                        throw new semanticError("Duplicated constructors",node.getpos());
                    ((classsymbol) currentfield).setConstructor(_funcsymbol);
                }else throw new semanticError("Wrong type for constructor",node.getpos());
            }else if(node.gettpNode()==null) throw new semanticError("Return type missing",node.getpos());
        }
        currentfield=_funcsymbol;
        node.getParameterList().forEach(x->x.accept(this));
    }

    @Override
    public void visit(classdeclNode node){
        classsymbol _classsymbol=node.getClassSymbol();
        currentfield=_classsymbol;
        node.getVardeclNodeList().forEach(x->x.accept(this));
        node.getFuncdeclNodeList().forEach(x->{
            x.accept(this);
            currentfield=_classsymbol;
        });
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
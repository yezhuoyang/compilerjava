package compilerjava.semantic;


import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.util.*;

import java.util.Iterator;
import java.util.Map;

public class semanticchecker implements ASTvisitor{
    private globalfield  _globalfield;
    private classsymbol  stringsymbol;
    private basesymbol  intsymbol,boolsymbol,voidsymbol;

    public semanticchecker(globalfield gf){
        this._globalfield=gf;
        this.intsymbol=gf.getIntsymbol();
        this.boolsymbol=gf.getBoolsymbol();
        this.stringsymbol=gf.getString();
        this.voidsymbol=gf.getVoidsymbol();
    }

    @Override
    public void visit(programNode node){
        node.getDeclNodeList().forEach(x->x.accept(this));
    }


    @Override
    public void visit(vardeclNode node){
        if(node.getExpr()!=null){
            node.getExpr().accept(this);
            node.getTypeAfterresolve().compatible(node.getExpr().gettype(),node.getpos());
        }else{
            type tp=node.getTypeAfterresolve();
            if(tp.isBaseType()){
                if(tp.getTypeName().equals("int")) {
                    node.setExpr(new intliteralNode(0, null));
                }
                else{
                    node.setExpr(new boolliteralNode(false,null));
                }
                node.getExpr().accept(this);
            }
            else if(tp.isArrayType()||tp.isClassType()||tp.isNullType()){
                if(!tp.getTypeName().equals("string")){
                    node.setExpr(new nullliteralNode(null));
                }
                else{
                    node.setExpr(new stringliteralNode("newstr",null));
                }
                node.getExpr().accept(this);
            }
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
        node.getVardeclList().getDecls().forEach(x->{
                    x.accept(this);
                    if(x.getExpr()!=null)
                        x.getTypeAfterresolve().compatible(x.getExpr().gettype(),node.getpos());
                        });
    }


    @Override
    public void visit(exprstmtNode node){
        node.getExpr().accept(this);
    }


    @Override
    public void visit(IfstmtNode node){
        node.getExpr().accept(this);
        if(!node.getExpr().isBoolean())
            throw new semanticError("Condition statement of If must be bool",node.getpos());
        node.getThenstmt().accept(this);
        if(node.getElsestmt()!=null) node.getElsestmt().accept(this);
    }


    @Override
    public void visit(whilestmtNode node){
        node.getExpr().accept(this);
        if(!node.getExpr().isBoolean())
            throw new semanticError("Condition statement of while must be bool",node.getpos());
        if(node.getStmt()!=null) node.getStmt().accept(this);
    }


    @Override
    public void visit(forstmtNode node){
        if(node.getInit()!=null)node.getInit().accept(this);
        if(node.getCond()!=null){
            node.getCond().accept(this);
            if(!node.getCond().isBoolean())
                throw new semanticError("Condition statement of for must be bool",node.getpos());
        }
        if(node.getStep()!=null) node.getStep().accept(this);
        if(node.getStmt()!=null) node.getStmt().accept(this);
    }


    @Override
    public void visit(returnNode node){
        type returntype=node.getfuncsymbol().gettype();
        if(node.getExpr()!=null){
            if(((funcdeclNode)node.getfuncsymbol().getDefNode()).gettpNode()==null)
                throw new semanticError("Constructor shouldn't have return statement!",node.getpos());
            node.getExpr().accept(this);
            returntype.compatible(node.getExpr().gettype(),node.getpos());
        }
        else{
            if(!(returntype.getTypeName().equals("void")||((funcdeclNode)node.getfuncsymbol().getDefNode()).gettpNode()==null ))
                throw new semanticError("Return without expression!",node.getpos());
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
        exprNode array=node.getArray();
        exprNode index=node.getIndex();
        array.accept(this);
        index.accept(this);
        if(array.gettype().isArrayType()){
            if(index.isInteger()){
                    node.setCat(exprNode.Category.LVALUE);
                    node.settype(((arraytype)array.gettype()).getDims()==1
                            ? ((arraytype)array.gettype()).getBasetype()
                            : new arraytype( ((arraytype)array.gettype()).getBasetype(),((arraytype)array.gettype()).getDims()-1));
                }else throw new semanticError("Subscript ought to be int ",node.getpos());
        }else throw new semanticError("Array expression ought to be array type",node.getpos());
    }


    @Override
    public void visit(binaryexprNode node){
        exprNode lhs=node.getlhs();
        exprNode rhs=node.getrhs();
        lhs.accept(this);
        rhs.accept(this);
        switch (node.getOp()){
            case MUL:
            case DIV:
            case MOD:
            case SUB:
            case BITL:
            case BITR:
            case BITAND:
            case XOR:
            case BITOR:{
                if(lhs.isInteger()&&rhs.isInteger()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(intsymbol);
                }else throw new semanticError("Operands ought to be integers",node.getpos());
                break;
            }
            case ADD:{
                if(lhs.isString()&&rhs.isString()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(stringsymbol);
                } else if(lhs.isInteger()&&rhs.isInteger()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(intsymbol);
                }else throw new semanticError("Operands ought to be both integers or strings",node.getpos());
                break;
            }
            case GT:
            case LEQ:
            case GEQ:
            case LT:{
                if(lhs.isString()&&rhs.isString()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(boolsymbol);
                }
                else if(lhs.isInteger()&&rhs.isInteger()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(boolsymbol);
                }else throw new semanticError("Operands ought to be both integers or strings",node.getpos());
                break;
            }
            case NEQ:
            case EQ:{
                if((lhs.isString()&&rhs.isString())
                    || (lhs.isInteger()&&rhs.isInteger())
                    || (lhs.isBoolean()&&rhs.isBoolean())
                    || (lhs.isNullable()&&rhs.isNull())
                    || (lhs.isNull()&&rhs.isNullable())){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(boolsymbol);
                } else
                    throw new semanticError("Operands ought to be both integers or strings",node.getpos());
                break;
            }
            case AND:
            case OR:{
                if(lhs.isBoolean()&&rhs.isBoolean()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(boolsymbol);
                }else throw new semanticError("Operands ought to be both booleans",node.getpos());

                break;
            }
            case ASSIGN:{
                if(lhs.isAssignable()&&rhs.isValue()){
                    lhs.gettype().compatible(rhs.gettype(),node.getpos());
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(voidsymbol);
                }
                else throw new semanticError("Expression ought to be lvalue",node.getpos());
            }
        }
    }

    @Override
    public void visit(classmemberNode node) {
        node.getExpr().accept(this);
        if (node.getExpr().isAccessable()){
            classsymbol classSymbol=(classsymbol) node.getExpr().gettype();
            symbol membersymbol=classSymbol.resolvemember(node.getID(),node.getpos());
            node.setSym(membersymbol);
            if (membersymbol.isVarsymbol()){
                node.setCat(exprNode.Category.LVALUE);
                node.settype(membersymbol.gettype());
            } else if (membersymbol.isFuncsymbol()) {
                node.setCat(exprNode.Category.FUNCTION);
                node.settype(membersymbol.gettype());
                node.setfuncsymbol((funcsymbol) membersymbol);
            }
        } else if (node.getExpr().gettype().isArrayType()){
            if(node.getID().equals("size")){
                node.setCat(exprNode.Category.FUNCTION);
                node.settype(intsymbol);
                node.setfuncsymbol(_globalfield.getArrayfunctionsymbol());
            }else throw new semanticError("Type array builtin function call error",node.getpos());
        }else throw new semanticError("Member Access error, expression not a class type variable",node.getpos());
    }


    @Override
    public void visit(funccallexprNode node){
        exprNode function=node.getFunction();
        function.accept(this);
        node.getParameterList().forEach(x->x.accept(this));
        if(function.isCallable()){
            if(node.getParameterList().size()==function.getfuncsymbol().getArguments().size()){
                funcsymbol _funcsymbol=function.getfuncsymbol();
                Iterator<exprNode> iterator=node.getParameterList().iterator();
                for(Map.Entry<String,varsymbol> entry:_funcsymbol.getArguments().entrySet()){
                    String ID=entry.getKey();
                    varsymbol variablesymbol=entry.getValue();
                    exprNode exprnode=iterator.next();
                    if(!exprnode.isValue())
                        throw new semanticError("Function call expression error, parameter not a valid value",node.getpos());
                    variablesymbol.gettype().compatible(exprnode.gettype(),node.getpos());
                }
                node.setCat(exprNode.Category.RVALUE);
                node.settype(function.getfuncsymbol().gettype());
            }else
                throw new semanticError("Function call expression error, parameter list length not match",node.getpos());
        }else throw new semanticError("Function call expression error, expression not a function",node.getpos());
    }


    @Override
    public void visit(IDexprNode node){
        symbol _symbol=node.getsymbol();
        if(_symbol.isVarsymbol()){
            node.setCat(exprNode.Category.LVALUE);
            node.settype(_symbol.gettype());
        }else if(_symbol.isClasssymbol()){
            node.setCat(exprNode.Category.LVALUE);
            node.settype((classsymbol) _symbol);
        }else if(_symbol.isFuncsymbol()){
            node.setCat(exprNode.Category.FUNCTION);
            node.settype(_symbol.gettype());
            node.setfuncsymbol((funcsymbol)_symbol);
        }
    }

    @Override
    public void visit(newexprNode node){
        node.getExprNodeList().forEach(x->{
            x.accept(this);
            if(!(x.isInteger()))throw new semanticError("Array subscript ought to be integers",node.getpos());
        });
        type tp=node.getBaseTypeAfterResolve();
        if(node.getNumDims()==0){
            if(tp.isClassType()){
                if(tp.getTypeName().equals("string")){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(tp);
                } else {
                    if (((classsymbol) tp).getConstructor() == null) {
                        node.setCat(exprNode.Category.RVALUE);
                        node.settype(tp);
                    } else {
                        node.setCat(exprNode.Category.RVALUE);
                        node.settype(tp);
                        node.setfuncsymbol(((classsymbol) tp).getConstructor());
                    }
                }
                }else{
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(tp);
                }
              }else{
                node.setCat(exprNode.Category.RVALUE);
                node.settype(new arraytype(tp,node.getNumDims()));
              }
        }


    @Override
    public void visit(thisexprNode node){
        node.setCat(exprNode.Category.RVALUE);
        node.settype((classsymbol)node.getfield());
    }


    @Override
    public void visit(unaryexprNode node){
        node.getExpr().accept(this);
        switch (node.getOp()){
            case PRE_ADD:
            case PRE_SUB:{
                    if(node.getExpr().isIntvar()){
                        node.setCat(exprNode.Category.LVALUE);
                        node.settype(intsymbol);
                    }else throw new semanticError("Non-int variable ",node.getpos());
                    break;
            }
            case SUF_ADD:
            case SUF_SUB:{
                if(node.getExpr().isIntvar()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(intsymbol);
                }else throw new semanticError("Non-int variable",node.getpos());
                break;
            }
            case POS:
            case NEG:
            case BITNOT:{
                if(node.getExpr().isInteger()){
                    node.setCat(exprNode.Category.RVALUE);
                    node.settype(intsymbol);
                }else throw new semanticError("Non_int expression",node.getpos());
                break;
            }
            case NOT:{
                 if(node.getExpr().isBoolean()){
                     node.setCat(exprNode.Category.RVALUE);
                     node.settype(boolsymbol);
                 }else throw new semanticError("Non_bool expression",node.getpos());
                 break;
            }
            default:
                break;
        }
    }

    @Override
    public void visit(intliteralNode node){
        node.setCat(exprNode.Category.RVALUE);
        node.settype(intsymbol);
    }


    @Override
    public void visit(boolliteralNode node){
        node.setCat(exprNode.Category.RVALUE);
        node.settype(boolsymbol);
    }


    @Override
    public void visit(nullliteralNode node){
        node.setCat(exprNode.Category.RVALUE);
        node.settype(new Nulltype());
    }


    @Override
    public void visit(stringliteralNode node){
        node.setCat(exprNode.Category.RVALUE);
        node.settype(stringsymbol);
    }




}
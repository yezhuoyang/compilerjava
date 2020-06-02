package compilerjava.IR;

import  compilerjava.AST.*;
import  compilerjava.Env.*;
import  compilerjava.optimizer.trivialboolExtractor;
import  compilerjava.IR.basicblock;
import  compilerjava.config;
import  compilerjava.IR.function;
import  compilerjava.IR.IRroot;
import  compilerjava.IR.instruction.*;
import  compilerjava.IR.operand.*;
import org.apache.commons.text.StringEscapeUtils;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class IRcreator implements ASTvisitor {
    private globalfield     _globalfield;
    private basicblock      currentBB;
    private classsymbol     currentclasssymbol;
    private function        currentfunction;
    private IRroot irRoot=new IRroot();

    public IRcreator(globalfield _globalfield){
        this._globalfield=_globalfield;
    }

    public IRroot getIrRoot(){
        return irRoot;
    }

    @Override
    public void visit(programNode node){
        builtinFunctionSymbolInitialization();
        node.getDeclNodeList().forEach(x->{
            if(x instanceof funcdeclNode){
                funcsymbol  _funcsymbol=((funcdeclNode)x).getfuncsymbol();
                _funcsymbol.setFunc(new function(_funcsymbol.getWord()));
            }else if(x instanceof classdeclNode){
                ((classdeclNode)x).getFuncdeclNodeList().forEach(y->{
                    funcsymbol _functionsymbol=y.getfuncsymbol();
                    _functionsymbol.setFunc(new function(((classdeclNode)x).getClassSymbol().getWord()+"_"+_functionsymbol.getWord()));
                });
            }
        });
        node.getDeclNodeList().forEach(x->x.accept(this));
        irRoot.getFunctionMap().values().forEach(function::updateCalleeSet);
        irRoot.calcRecursiveCalleeSet();
    }



    public static type Node2Type(tpNode tpnode,globalfield _globalfield){
        type tp=_globalfield.resolvetype(tpnode);
        if(tpnode instanceof arraytpNode)
            return new arraytype(tp,((arraytpNode)tpnode).getDims());
        else return tp;
    }

    @Override
    public void visit(vardeclNode node){
        varsymbol _varsymbol=node.getvarsymbol();
        if(node.isGlobalVarible()){

            virtualregister _globalvar=new global64Value(node.getID(),Node2Type(node.gettpNode(),_globalfield).getTypeSize());
            irRoot.addglobalvar((globalvar)_globalvar);
            _varsymbol.setVarstorage(_globalvar);


        }else{
            virtualregister _vregister = new I64Value(node.getID(),Node2Type(node.gettpNode(),_globalfield).getTypeSize());
            if(currentfunction!=null&&node.isParameterVariable())
                currentfunction.addParameterList(_vregister);
            _varsymbol.setVarstorage(_vregister);
            if(node.getExpr()!=null)
                assign(_vregister,node.getExpr());
        }
    }


    @Override
    public void visit(funcdeclNode node){
        funcsymbol _funcsymbol=node.getfuncsymbol();
        currentfunction=_funcsymbol.getFunc();
        if(_funcsymbol.isMemberFunc()) currentfunction.setReferenceForClassMethod(new I64Value("this",config.pointersize()));
        irRoot.addfunction(currentfunction);
        currentBB=currentfunction.getEntryBB();
        node.getParameterList().forEach(x->x.accept(this));
        node.getBlock().accept(this);
        if(!currentBB.isFinished()){
            if(_funcsymbol.gettype().getTypeName().equals("void"))currentBB.finish(new back(currentBB,null));
            else currentBB.finish(new back(currentBB,new immediate(0,config.intsize)));
        }
        if(currentfunction.getReturnInstList().size()>1){
            basicblock exitBB=currentfunction.getExitBB();
            operand returnop=_funcsymbol.gettype().getTypeName().equals("void")? null: new I64Value(_funcsymbol.gettype().getTypeSize());
            List<back> returnList=new ArrayList<>(currentfunction.getReturnInstList());
            returnList.forEach(ret->{
                ret.getCurrentBB().removeInst();
                if(ret.getReturnValue()!=null)
                    ret.getCurrentBB().addInst(new move(ret.getCurrentBB(),ret.getReturnValue(),returnop));
                ret.getCurrentBB().finish(new jump(ret.getCurrentBB(),exitBB));
            });
            exitBB.finish(new back(exitBB,returnop));
        }else currentfunction.setExitBB(currentfunction.getReturnInstList().get(0).getCurrentBB());
        currentfunction=null;
    }

    @Override
    public void visit(classdeclNode node){
        currentclasssymbol=node.getClassSymbol();
        node.getFuncdeclNodeList().forEach(x->x.accept(this));
        currentclasssymbol=null;
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
        for(stmtNode _stmtNode:node.getStmtList()){
            _stmtNode.accept(this);
            if(currentBB.isFinished())
                break;
        }
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
        basicblock thenBB=new basicblock(currentfunction,"if_then");
        basicblock elseBB=node.getElsestmt()==null?null:new basicblock(currentfunction,"if_else");
        basicblock mergeBB=new basicblock(currentfunction,"if_merge");

        node.getExpr().setThenBB(thenBB);
        node.getExpr().setElseBB(node.getElsestmt()==null?mergeBB:elseBB);
        node.getExpr().accept(this);

        currentBB=thenBB;
        node.getThenstmt().accept(this);
        if(!currentBB.isFinished()) currentBB.finish(new jump(currentBB,mergeBB));

        if(node.getElsestmt()!=null){
           currentBB=elseBB;
           node.getElsestmt().accept(this);
           if(!currentBB.isFinished())currentBB.finish(new jump(currentBB,mergeBB));
        }

        currentBB=mergeBB;
    }

    @Override
    public void visit(whilestmtNode node){
        basicblock condBB=new basicblock(currentfunction,"while_cond");
        basicblock bodyBB=new basicblock(currentfunction,"while_body");
        basicblock mergeBB=new basicblock(currentfunction,"while_merge");
        node.setStepBB(condBB);
        node.setMergeBB(mergeBB);

        currentBB.finish(new jump(currentBB,condBB));
        currentBB=condBB;
        node.getExpr().setThenBB(bodyBB);
        node.getExpr().setElseBB(mergeBB);
        node.getExpr().accept(this);

        currentBB=bodyBB;
        node.getStmt().accept(this);
        if(!currentBB.isFinished()) currentBB.finish(new jump(currentBB,condBB));

        currentBB=mergeBB;
    }

    @Override
    public void visit(forstmtNode node){
        basicblock bodyBB = new basicblock(currentfunction, "for_body");
        basicblock condBB = node.getCond() == null ? bodyBB : new basicblock(currentfunction, "for_cond");
        basicblock stepBB = node.getStep() == null ? condBB : new basicblock(currentfunction, "for_step");
        basicblock mergeBB = new basicblock(currentfunction, "for_merge");

        node.setStepBB(stepBB);
        node.setMergeBB(mergeBB);
        //generate init
        if (node.getInit() != null) node.getInit().accept(this);
        currentBB.finish(new jump(currentBB, condBB));
        //generate cond
        if (node.getCond() != null) {
            currentBB = condBB;
            node.getCond().setThenBB(bodyBB);
            node.getCond().setElseBB(mergeBB);
            node.getCond().accept(this);
        }
        //generate body
        currentBB = bodyBB;
        node.getStmt().accept(this);
        if (!currentBB.isFinished()) currentBB.finish(new jump(currentBB, stepBB));
        //generate step
        if (node.getStep() != null) {
            currentBB = stepBB;
            node.getStep().accept(this);
            if (!currentBB.isFinished()) currentBB.finish(new jump(currentBB, condBB));
        }
        currentBB = mergeBB;
    }


    @Override
    public void visit(returnNode node){
        if(node.getExpr()==null){
            currentBB.finish(new back(currentBB,null));
        }else{

            operand retValue=new I64Value(node.getExpr().getSize());
            assign(retValue,node.getExpr());
            currentBB.finish(new back(currentBB,retValue));
        }
    }

    @Override
    public void visit(breakNode node){
        currentBB.finish(new jump(currentBB,node.getCurrentLoop().getMergeBB()));
    }

    @Override
    public void visit(continueNode node){
        currentBB.finish(new jump(currentBB,node.getCurrentLoop().getStepBB()));
    }

    @Override
    public void visit(arrayindexNode node){
        arraytype _arraytype=(arraytype) node.getArray().gettype();
        node.getArray().accept(this);
        node.getIndex().accept(this);
        operand baseAddress=getOperandForValueUse(currentBB,node.getArray().getResultop());
        operand indexValue=getOperandForValueUse(currentBB,node.getIndex().getResultop());


        int Size=_arraytype.getDims()>1?config.pointersize():_arraytype.getBasetype().getTypeSize();
        node.setResultop(new I64Pointer(Size));

        I64Value offset=new I64Value(config.pointersize());
        I64Value offset_2=new I64Value(config.pointersize());

        currentBB.addInst(new binary(currentBB,binary.Op.MUL,indexValue,new immediate(Size,config.pointersize()),offset));

        currentBB.addInst(new binary(currentBB,binary.Op.ADD,offset,new immediate(config.registersize,config.pointersize()),offset_2));

        currentBB.addInst(new binary(currentBB,binary.Op.ADD,baseAddress,offset_2,node.getResultop()));

        if(node.getThenBB()!=null){
            I64Value tmp=new I64Value(config.boolsize);
            currentBB.finish(new load(config.boolsize,currentBB,node.getResultop(),tmp));
            currentBB.finish(new branch(currentBB,tmp,node.getThenBB(),node.getElseBB()));
        }
    }


    @Override
    public void visit(binaryexprNode node){
        exprNode lhs=node.getlhs();
        exprNode rhs=node.getrhs();
        int Size=rhs.getSize();
        binary.Op op_binary=binary.Op.MUL;
        cmp.Op op_cmp=cmp.Op.LT;
        function callfunction=irRoot.builtinStringAdd;
        switch (node.getOp()){
            case MUL:
                op_binary=binary.Op.MUL;
                break;
            case DIV:
                op_binary=binary.Op.DIV;
                break;
            case MOD:
                op_binary=binary.Op.MOD;
                break;
            case SUB:
                op_binary=binary.Op.SUB;
                break;
            case BITL:
                op_binary=binary.Op.BITL;
                break;
            case BITR:
                op_binary=binary.Op.BITR;
                break;
            case BITAND:
                op_binary=binary.Op.BITAND;
                break;
            case XOR:
                op_binary=binary.Op.XOR;
                break;
            case BITOR:
                op_binary=binary.Op.BITOR;
                break;
            case ADD:
                op_binary=binary.Op.ADD;
                break;
            case GT:
                op_cmp=cmp.Op.GT;
                callfunction=irRoot.builtinStringGT;
                break;
            case LEQ:
                op_cmp=cmp.Op.LEQ;
                callfunction=irRoot.builtinStringLEQ;
                break;
            case GEQ:
                op_cmp=cmp.Op.GEQ;
                callfunction=irRoot.builtinStringGEQ;
                break;
            case LT:
                op_cmp=cmp.Op.LT;
                callfunction=irRoot.builtinStringLT;
                break;
            case NEQ:
                op_cmp=cmp.Op.NEQ;
                callfunction=irRoot.builtinStringNEQ;
                break;
            case EQ:
                op_cmp=cmp.Op.EQ;
                callfunction=irRoot.builtinStringEQ;
                break;
            case AND:
            case ASSIGN:
            case OR:
                break;
        }
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
                lhs.accept(this);
                rhs.accept(this);
                operand lhsValue=getOperandForValueUse(currentBB,lhs.getResultop());
                operand rhsValue=getOperandForValueUse(currentBB,rhs.getResultop());
                node.setResultop(new I64Value(config.intsize));
                currentBB.addInst(new binary(currentBB,op_binary,lhsValue,rhsValue,node.getResultop()));
                break;
            }
            case ADD:{
                lhs.accept(this);
                rhs.accept(this);
                operand lhsValue=getOperandForValueUse(currentBB,lhs.getResultop());
                operand rhsValue=getOperandForValueUse(currentBB,rhs.getResultop());
                if(lhs.isString()){
                    node.setResultop(new I64Value(config.pointersize()));
                    call _call=new call(currentBB,irRoot.builtinStringAdd,node.getResultop());
                    _call.addParameter(lhsValue);
                    _call.addParameter(rhsValue);
                    currentBB.addInst(_call);
                }else{
                    node.setResultop(new I64Value(config.intsize));
                    currentBB.addInst(new binary(currentBB,op_binary,lhsValue,rhsValue,node.getResultop()));
                }
                break;
            }
            case GT:
            case LEQ:
            case GEQ:
            case LT:{
                lhs.accept(this);
                rhs.accept(this);
                operand lhsValue=getOperandForValueUse(currentBB,lhs.getResultop());
                operand rhsValue=getOperandForValueUse(currentBB,rhs.getResultop());
                node.setResultop(new I64Value(config.boolsize));
                if(lhs.isString()){
                    call _call=new call(currentBB,callfunction,node.getResultop());
                    _call.addParameter(lhsValue);
                    _call.addParameter(rhsValue);
                    currentBB.addInst(_call);
                }else{
                    currentBB.addInst(new cmp(currentBB,op_cmp,lhsValue,rhsValue,node.getResultop()));
                }
                if(node.getThenBB()!=null)
                    currentBB.finish(new branch(currentBB,node.getResultop(),node.getThenBB(),node.getElseBB()));
                break;
            }
            case NEQ:
            case EQ:{
                lhs.accept(this);
                rhs.accept(this);
                operand lhsValue=getOperandForValueUse(currentBB,lhs.getResultop());
                operand rhsValue=getOperandForValueUse(currentBB,rhs.getResultop());
                node.setResultop(new I64Value(config.boolsize));
                if(lhs.isString()){
                    call _call=new call(currentBB,callfunction,node.getResultop());
                    _call.addParameter(lhsValue);
                    _call.addParameter(rhsValue);
                    currentBB.addInst(_call);
                }else if(lhs.isNullable()){
                    currentBB.addInst(new cmp(currentBB,op_cmp,lhsValue,rhsValue,node.getResultop()));
                }else{
                    currentBB.addInst(new cmp(currentBB,op_cmp,lhsValue,rhsValue,node.getResultop()));
                }
                if(node.getThenBB()!=null)
                    currentBB.finish(new branch(currentBB,node.getResultop(),node.getThenBB(),node.getElseBB()));
                    break;
            }
            case AND:{
                if(node.getThenBB()!=null){
                     lhs.setThenBB(new basicblock(currentfunction,"lhs_then"));
                     lhs.setElseBB(node.getElseBB());
                     lhs.accept(this);
                     currentBB=lhs.getThenBB();
                     rhs.setThenBB(node.getThenBB());
                     rhs.setElseBB(node.getElseBB());
                     rhs.accept(this);
                }else{
                   node.setResultop(new I64Value(config.boolsize));
                   assign(node.getResultop(),node);
                }
                break;
            }
            case OR:{
                if(node.getThenBB()!=null){
                    //short-circuit evaluation
                    lhs.setThenBB(node.getThenBB());
                    lhs.setElseBB(new basicblock(currentfunction,"lhs_else"));
                    lhs.accept(this);
                    currentBB=lhs.getElseBB();
                    rhs.setThenBB(node.getThenBB());
                    rhs.setElseBB(node.getElseBB());
                    rhs.accept(this);
                    break;
                }else{
                    node.setResultop(new I64Value(config.boolsize));
                    assign(node.getResultop(),node);
                }
            }
            case ASSIGN:{
                lhs.accept(this);
                assign(lhs.getResultop(),rhs);
                break;
            }
        }
    }


    @Override
    public void visit(classmemberNode node){
        node.getExpr().accept(this);
        operand base=getOperandForValueUse(currentBB,node.getExpr().getResultop());

        if(node.getExpr().isAccessable()){
            //class
            symbol membersymbol=node.getSym();
            if(membersymbol instanceof varsymbol){
                //class variable
                I64Pointer memberPointer=new I64Pointer(membersymbol.gettype().getTypeSize());
                //Offset and set result
                currentBB.addInst(new binary(currentBB,binary.Op.ADD,base,new immediate(((varsymbol)membersymbol).getOffset(),config.intsize),memberPointer));
                node.setResultop(memberPointer);


                //Short-circuit evaluation
                if(node.getThenBB()!=null){
                    I64Value tmp=new I64Value(config.boolsize);
                    currentBB.addInst(new load(memberPointer.getObjsize(),currentBB,memberPointer,tmp));
                    currentBB.finish(new branch(currentBB,tmp,node.getThenBB(),node.getElseBB()));
                }
            } else {
                // class function
                node.setResultop(base);
            }
        }else{
                // Array.size()
                node.setResultop(base);
        }
    }

    @Override
    public void visit(funccallexprNode node){
        if(isArraySizeCall(node)) return;
        node.getFunction().accept(this);
        funcsymbol _funcsymbol=node.getFunction().getfuncsymbol();
        if(node.gettype().getTypeName().equals("void"))node.setResultop(null);
        else node.setResultop(new I64Value(node.gettype().getTypeSize()));
        call _call=new call(currentBB,_funcsymbol.getFunc(),node.getResultop());
        _funcsymbol.getFunc().callerInstList.add(_call);
        node.getParameterList().forEach(x->{
            x.accept(this);
            _call.addParameter(getOperandForValueUse(currentBB,x.getResultop()));
        });
        //The object pointer will also be used as return value.
        if(_funcsymbol.isMemberFunc()){
            _call.setObjectPointer(node.getFunction().getResultop());
        }
        currentBB.addInst(_call);
        //Short-circuit evaluation
        if(node.getThenBB()!=null){
            operand result=getOperandForValueUse(currentBB,node.getResultop());
            currentBB.finish(new branch(currentBB,result,node.getThenBB(),node.getElseBB()));
        }
    }


    @Override
    public void visit(IDexprNode node) {
        symbol _symbol = node.getsymbol();
        if (_symbol.getfield() == currentclasssymbol){
            if (_symbol instanceof varsymbol) {
                I64Pointer memberPointer = new I64Pointer(_symbol.gettype().getTypeSize());
                currentBB.addInst(new binary(currentBB, binary.Op.ADD, currentfunction.getReferenceForClassMethod(), new immediate(((varsymbol) _symbol).getOffset(),config.intsize), memberPointer));
                node.setResultop(memberPointer);
                if (node.getThenBB() != null) {
                    I64Value tmp = new I64Value(config.boolsize);
                    currentBB.addInst(new load(memberPointer.getObjsize(),currentBB,memberPointer,tmp));
                    currentBB.finish(new branch(currentBB, tmp, node.getThenBB(), node.getElseBB()));
                }
            } else {
                // ID is a function symbol
                node.setResultop(currentfunction.getReferenceForClassMethod());
            }
        } else {
            if(_symbol instanceof varsymbol){
                    node.setResultop(((varsymbol)_symbol).getVarstorage());
                    if(node.getThenBB()!=null){
                        currentBB.finish(new branch(currentBB,((varsymbol)_symbol).getVarstorage(),node.getThenBB(),node.getElseBB()));
                    }
            }
        }
    }

    @Override
    public void visit(newexprNode node){
        type tp=node.getBaseTypeAfterResolve();
        node.setResultop(new I64Value(config.pointersize()));
        if(node.getNumDims()==0){
            currentBB.addInst(new alloc(currentBB,new immediate(((classsymbol)tp).getObjectSize(),config.pointersize()),node.getResultop()));
            classsymbol _classsymbol=(classsymbol) tp;
            if(_classsymbol.getConstructor()!=null){
                call _call=new call(currentBB,_classsymbol.getConstructor().getFunc(),null);
                _classsymbol.getConstructor().getFunc().callerInstList.add(_call);
                _call.setObjectPointer(node.getResultop());
                currentBB.addInst(_call);
            }
        }else{
            arrayAlloc(node,node.getResultop(),0);
        }
    }

    @Override
    public void visit(thisexprNode node){
        node.setResultop(currentfunction.getReferenceForClassMethod());
    }

    @Override
    public void visit(unaryexprNode node){
        exprNode exprNode = node.getExpr();
        int Size=exprNode.getSize();
        unary.Op op = unary.Op.NOT;
        switch (node.getOp()) {
            case PRE_ADD:
            case SUF_ADD:
                op = unary.Op.SUF_ADD;
                break;
            case PRE_SUB:
            case SUF_SUB:
                op = unary.Op.SUF_SUB;
                break;
            case POS:
                op = unary.Op.POS;
                break;
            case NEG:
                op = unary.Op.NEG;
                break;
            case BITNOT:
                op = unary.Op.BITNOT;
                break;
            default:
                break;
        }
        switch (node.getOp()) {
            case PRE_ADD:
            case PRE_SUB: {
                exprNode.accept(this);
                operand _operand = exprNode.getResultop();
                operand _value = getOperandForValueUse(currentBB, _operand);
                if (_operand instanceof pointer) {
                    I64Value tmp = new I64Value(config.intsize);
                    currentBB.addInst(new binary(currentBB, node.getOp() == unaryexprNode.Op.PRE_ADD ? binary.Op.ADD : binary.Op.SUB, _value, new immediate(1,config.intsize), tmp));
                    currentBB.addInst(new store(config.intsize,currentBB, tmp, _operand));
                    node.setResultop(_operand);
                } else if (_operand instanceof value) {
                    currentBB.addInst(new binary(currentBB, node.getOp() == unaryexprNode.Op.PRE_ADD ? binary.Op.ADD : binary.Op.SUB, _value, new immediate(1,config.intsize), _value));
                    node.setResultop(_operand);
                }
                break;
            }
            case SUF_ADD:
            case SUF_SUB: {
                exprNode.accept(this);
                operand _operand = exprNode.getResultop();
                operand _value = getOperandForValueUse(currentBB, _operand);
                if (_operand instanceof pointer) {
                    I64Value tmp = new I64Value(config.intsize);
                    currentBB.addInst(new binary(currentBB, node.getOp() == unaryexprNode.Op.SUF_ADD ? binary.Op.ADD : binary.Op.SUB, _value, new immediate(1,config.intsize), tmp));
                    currentBB.addInst(new store(config.intsize,currentBB, tmp, _operand));
                    node.setResultop(_value);
                } else if (_operand instanceof value) {
                    I64Value tmp = new I64Value(config.intsize);
                    currentBB.addInst(new move(currentBB, _value, tmp));
                    currentBB.addInst(new binary(currentBB, node.getOp() == unaryexprNode.Op.SUF_ADD ? binary.Op.ADD : binary.Op.SUB, _value, new immediate(1,config.intsize), _value));
                    node.setResultop(tmp);
                }
                break;
            }
            case POS: {
                exprNode.accept(this);
                operand value = getOperandForValueUse(currentBB, exprNode.getResultop());
                node.setResultop(value);
                break;
            }
            case NEG:
            case BITNOT: {
                exprNode.accept(this);
                operand value = getOperandForValueUse(currentBB, exprNode.getResultop());
                node.setResultop(new I64Value(config.intsize));
                currentBB.addInst(new unary(currentBB,op, value, node.getResultop()));
                break;
            }
            case NOT: {
                if (node.getThenBB() != null) {
                    //short-circuit evaluation
                    exprNode.setThenBB(node.getElseBB());
                    exprNode.setElseBB(node.getThenBB());
                    exprNode.accept(this);
                    break;
                } else {
                    node.setResultop(new I64Value(config.boolsize));
                    assign(node.getResultop(), node);
                }
            }
            default:
                break;
        }
    }

    @Override
    public void visit(intliteralNode node){
        node.setResultop(new immediate(node.getVal(),config.intsize));
    }

    @Override
    public void visit(boolliteralNode node){
        node.setResultop(new immediate(node.getVal() ? 1:0,config.boolsize));
        if(node.getThenBB()!=null){
            if(node.getVal())currentBB.finish(new jump(currentBB,node.getThenBB()));
            else currentBB.finish(new jump(currentBB,node.getElseBB()));
        }
    }


    @Override
    public void visit(nullliteralNode node){
        node.setResultop(new immediate(0,config.pointersize()));
    }


    private String processConstStr(String str){
        str=str.replace("\\n","\n");
        str=str.replace("\\t", "\t");
        str=str.replace("\\\"","\"");
        str=str.replace("\\\\","\\");
        str+="\0";
        return str;
    }

    @Override
    public void visit(stringliteralNode node){
        String str=processConstStr(node.getVal().substring(1,node.getVal().length()-1));
        staticstring _staticstring=new staticstring(new global64Value("_str_const",true,config.pointersize()),str);
        node.setResultop(_staticstring.getBase());
        ((global64Value)_staticstring.getBase()).setReferencedstring(_staticstring);
        irRoot.addstaticstring(_staticstring);
    }

    private void assign(operand lhs,exprNode rhsexpr){
        int Size=rhsexpr.getSize();
        //System.out.println(lhs.getName()+" "+rhsexpr.gettype().getTypeName());
        //&&!trivialboolExtractor.trivialNodeMap.get(rhsexpr)
        if(rhsexpr.isBoolean()&&trivialboolExtractor.trivialNodeMap.containsKey(rhsexpr)&&!trivialboolExtractor.trivialNodeMap.get(rhsexpr)){
            basicblock thenBB=new basicblock(currentfunction,"thenBB");
            basicblock elseBB=new basicblock(currentfunction,"elseBB");
            basicblock mergeBB=new basicblock(currentfunction,"mergeBB");
            rhsexpr.setThenBB(thenBB);
            rhsexpr.setElseBB(elseBB);
            if(rhsexpr.getResultop()==null)rhsexpr.accept(this);
            if(lhs instanceof pointer){
                thenBB.addInst(new store(((pointer)lhs).getObjsize(),thenBB,new immediate(1,((pointer)lhs).getObjsize()),lhs));
                elseBB.addInst(new store(((pointer)lhs).getObjsize(),elseBB,new immediate(0,((pointer)lhs).getObjsize()),lhs));
            }else{
                thenBB.addInst(new move(thenBB,new immediate(1,config.boolsize),lhs));
                elseBB.addInst(new move(elseBB,new immediate(0,config.boolsize),lhs));
            }
            thenBB.finish(new jump(thenBB,mergeBB));
            elseBB.finish(new jump(elseBB,mergeBB));
            currentBB=mergeBB;
        }else{
            if(rhsexpr.getResultop()==null)rhsexpr.accept(this);
            if(rhsexpr.getResultop() instanceof pointer){
                I64Value tmp_value=new I64Value(rhsexpr.getSize());
                currentBB.addInst(new load(((pointer)(rhsexpr.getResultop())).getObjsize(),currentBB,rhsexpr.getResultop(),tmp_value));
                if(lhs instanceof pointer)currentBB.addInst(new store(((pointer)(rhsexpr.getResultop())).getObjsize(),currentBB,tmp_value,lhs));
                else currentBB.addInst(new move(currentBB,tmp_value,lhs));
            }else{
                if(lhs instanceof pointer) currentBB.addInst(new store(((pointer)lhs).getObjsize(),currentBB,rhsexpr.getResultop(),lhs));
                else {
                    //System.out.println(lhs.getName()+" "+rhsexpr.getfuncsymbol().getWord());
                    currentBB.addInst(new move(currentBB,rhsexpr.getResultop(),lhs));
                }
            }
        }
    }


    private void arrayAlloc(newexprNode node,operand result,int depth){
        if(depth==node.getExprNodeList().size())return;
        exprNode indexExprNode=node.getExprNodeList().get(depth);
        indexExprNode.accept(this);
        operand indexValue=getOperandForValueUse(currentBB,indexExprNode.getResultop());
        I64Value allocateSize=new I64Value(config.intsize);
        if(depth==node.getExprNodeList().size()-1){
            //Final dimension
            currentBB.addInst(new binary(currentBB,binary.Op.MUL,indexValue,new immediate(depth==node.getNumDims()-1? node.getBaseTypeAfterResolve().getTypeSize():config.pointersize(),config.intsize),allocateSize));
            currentBB.addInst(new binary(currentBB,binary.Op.ADD,allocateSize,new immediate(config.registersize,config.intsize),allocateSize));
            if(result instanceof pointer){
                I64Value tmp=new I64Value(config.pointersize());
                currentBB.addInst(new alloc(currentBB,allocateSize,tmp));
                currentBB.addInst(new store(config.pointersize(),currentBB,indexValue,tmp));
                currentBB.addInst(new store(config.pointersize(),currentBB,tmp,result));
            }else{
                currentBB.addInst(new alloc(currentBB,allocateSize,result));
                currentBB.addInst(new store(config.pointersize(),currentBB,indexValue,result));
            }
        }else {
            currentBB.addInst(new binary(currentBB,binary.Op.MUL,indexValue,new immediate(config.pointersize(),config.intsize),allocateSize));
            currentBB.addInst(new binary(currentBB,binary.Op.ADD,allocateSize,new immediate(config.registersize,config.intsize),allocateSize));
            I64Value tmp=new I64Value(config.pointersize());
            if(result instanceof pointer){
                currentBB.addInst(new alloc(currentBB,allocateSize,tmp));
                currentBB.addInst(new store(config.pointersize(),currentBB,indexValue,tmp));
                currentBB.addInst(new store(config.pointersize(),currentBB,tmp,result));
            }else {
                currentBB.addInst(new alloc(currentBB,allocateSize,result));
                currentBB.addInst(new store(config.pointersize(),currentBB,indexValue,result));
            }
            basicblock bodyBB=new basicblock(currentfunction,"for_body");
            basicblock condBB=new basicblock(currentfunction,"for_cond");
            basicblock stepBB=new basicblock(currentfunction,"for_step");
            basicblock mergBB=new basicblock(currentfunction,"for_merge");

            I64Pointer nowPointer=new I64Pointer(config.pointersize());
            I64Pointer endPointer=new I64Pointer(config.pointersize());
            I64Pointer tempPointer=new I64Pointer(config.pointersize());
            //generate init
            if(result instanceof pointer){
                currentBB.addInst(new binary(currentBB,binary.Op.ADD,tmp,new immediate(config.registersize,config.intsize),nowPointer));
                currentBB.addInst(new binary(currentBB,binary.Op.ADD,tmp,allocateSize,endPointer));
            }else{
                currentBB.addInst(new binary(currentBB,binary.Op.ADD,result,new immediate(config.registersize,config.intsize),nowPointer));
                currentBB.addInst(new binary(currentBB,binary.Op.ADD,result,allocateSize,endPointer));
            }
            currentBB.finish(new jump(currentBB,condBB));
            //generate cond
            currentBB=condBB;
            I64Value _cmp=new I64Value(config.boolsize);
            condBB.addInst(new cmp(currentBB,cmp.Op.LT,nowPointer,endPointer,_cmp));
            condBB.finish(new branch(currentBB,_cmp,bodyBB,mergBB));

            //generate body
            currentBB=bodyBB;
            arrayAlloc(node,nowPointer,depth+1);
            currentBB.finish(new jump(currentBB,stepBB));

            //generate step
            currentBB=stepBB;
            currentBB.addInst(new binary(currentBB,binary.Op.ADD,nowPointer,new immediate(config.pointersize(),config.intsize),tempPointer));
            currentBB.addInst(new move(currentBB,tempPointer,nowPointer));
            currentBB.finish(new jump(currentBB,condBB));
            currentBB=mergBB;
        }
    }


    private operand getOperandForValueUse(basicblock currentBB,operand oprand){
         if(oprand instanceof pointer){
             I64Value val=new I64Value(((pointer)oprand).getObjsize());
             currentBB.addInst(new load(((pointer)oprand).getObjsize(),currentBB,oprand,val));
             return val;
         }else return oprand;
    }


    private void builtinFunctionSymbolInitialization(){
        ((funcsymbol)_globalfield.getString().resolvesymbol("length",null)).setFunc(irRoot.builtinStringLength);
        ((funcsymbol)_globalfield.getString().resolvesymbol("substring",null)).setFunc(irRoot.builtinSubstring);
        ((funcsymbol)_globalfield.getString().resolvesymbol("parseInt",null)).setFunc(irRoot.builtinParseInt);
        ((funcsymbol)_globalfield.getString().resolvesymbol("ord",null)).setFunc(irRoot.builtinOrd);

        ((funcsymbol)_globalfield.resolvesymbol("print",null)).setFunc(irRoot.builtinPrint);
        ((funcsymbol)_globalfield.resolvesymbol("printInt",null)).setFunc(irRoot.builtinPrintInt);

        ((funcsymbol)_globalfield.resolvesymbol("printlnInt",null)).setFunc(irRoot.builtinPrintlnInt);
        ((funcsymbol)_globalfield.resolvesymbol("println",null)).setFunc(irRoot.builtinPrintln);
        ((funcsymbol)_globalfield.resolvesymbol("getString",null)).setFunc(irRoot.builtinGetString);
        ((funcsymbol)_globalfield.resolvesymbol("getInt",null)).setFunc(irRoot.builtinGetInt);
        ((funcsymbol)_globalfield.resolvesymbol("toString",null)).setFunc(irRoot.builtinToString);
    }


    private boolean isArraySizeCall(funccallexprNode node){
        funcsymbol _funcsymbol=node.getFunction().getfuncsymbol();
        String functionName=_funcsymbol.getWord();
        if(_funcsymbol.isMemberFunc() && functionName.equals("array.size")){
            node.getFunction().accept(this);
            operand objpointer=node.getFunction().getResultop();
            node.setResultop(new I64Value(config.intsize));
            currentBB.addInst(new load(config.intsize,currentBB,objpointer,node.getResultop()));
            return true;
        }else return false;
    }



}

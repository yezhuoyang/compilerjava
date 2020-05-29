package compilerjava.optimizer;

import compilerjava.AST.*;
import compilerjava.Env.*;

import java.util.*;


public class elimsideeffect implements ASTvisitor {
    private globalfield _globalfield;
    private funcsymbol currentfuncsymbol;
    private Map<funcsymbol, Set<funcsymbol>> calleeMap = new HashMap<>();
    private Stack<Boolean> isAssign = new Stack<>();
    private boolean DEBUG = false;

    public elimsideeffect(globalfield _globalfield) {
        this._globalfield = _globalfield;
    }

    @Override
    public void visit(programNode node) {
        node.getDeclNodeList().forEach(declNode -> {
            if (declNode instanceof funcdeclNode) {
                currentfuncsymbol = ((funcdeclNode) declNode).getfuncsymbol();
                calleeMap.put(currentfuncsymbol, new HashSet<>());
                for (vardeclNode vardeclNode : ((funcdeclNode) declNode).getParameterList()) {
                    varsymbol varsymbol = vardeclNode.getvarsymbol();
                    if (!(varsymbol.gettype() instanceof basesymbol)
                            || (varsymbol.gettype() instanceof classsymbol && varsymbol.gettype() != _globalfield.getString())) {
                        currentfuncsymbol.hasSideEffect = true;
                        break;
                    }
                }
                isAssign.push(false);
                if (!currentfuncsymbol.hasSideEffect) declNode.accept(this);
                isAssign.pop();
            }
        });

        boolean changed = true;
        for (; changed; ) {
            changed = false;
            for (Map.Entry<funcsymbol, Set<funcsymbol>> entry : calleeMap.entrySet()) {
                funcsymbol caller = entry.getKey();
                Set<funcsymbol> callees = entry.getValue();
                boolean newValue = caller.hasSideEffect;
                for (funcsymbol callee : callees) newValue |= callee.hasSideEffect;
                if (caller.hasSideEffect != newValue) {
                    changed = true;
                    caller.hasSideEffect = newValue;
                }
            }
        }
        if (DEBUG) {
            node.getDeclNodeList().forEach(declNode -> {
                if (declNode instanceof funcdeclNode) {
                    System.err.println(((funcdeclNode) declNode).getID() + " " + ((funcdeclNode) declNode).getfuncsymbol().hasSideEffect);
                }
            });
        }
    }

    @Override
    public void visit(vardeclNode node) {
        if (node.getExpr() != null) {
            isAssign.push(false);
            node.getExpr().accept(this);
            isAssign.pop();
        }
    }

    @Override
    public void visit(funcdeclNode node) {
        node.getBlock().accept(this);
    }

    @Override
    public void visit(classdeclNode node) {
        //need doing nothing
    }

    @Override
    public void visit(arraytpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(classtpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(booltpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(inttpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(voidtpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(stringtpNode node) {
        //need doing nothing
    }

    @Override
    public void visit(blockstmtNode node) {
        node.getStmtList().forEach(stmtNode -> stmtNode.accept(this));
    }

    @Override
    public void visit(vardeclstmtNode node) {
        node.getVardeclList().getDecls().forEach(vardeclNode -> vardeclNode.accept(this));
    }

    @Override
    public void visit(exprstmtNode node) {
        isAssign.push(false);
        node.getExpr().accept(this);
        isAssign.pop();
    }

    @Override
    public void visit(IfstmtNode node) {
        isAssign.push(false);
        node.getExpr().accept(this);
        isAssign.pop();
        node.getThenstmt().accept(this);
        if (node.getElsestmt() != null) node.getElsestmt().accept(this);
    }

    @Override
    public void visit(whilestmtNode node) {
        isAssign.push(false);
        node.getExpr().accept(this);
        isAssign.pop();
        node.getStmt().accept(this);
    }

    @Override
    public void visit(forstmtNode node) {
        isAssign.push(false);
        if (node.getInit() != null) node.getInit().accept(this);
        isAssign.pop();
        isAssign.push(false);
        if (node.getCond() != null) node.getCond().accept(this);
        isAssign.pop();
        isAssign.push(false);
        if (node.getStep() != null) node.getStep().accept(this);
        isAssign.pop();
        node.getStmt().accept(this);
    }

    @Override
    public void visit(returnNode node) {
        if (node.getExpr() != null) {
            isAssign.push(false);
            node.getExpr().accept(this);
            isAssign.pop();
        }
    }

    @Override
    public void visit(breakNode node) {
        //need doing nothing
    }

    @Override
    public void visit(continueNode node) {
        //need doing nothing
    }

    @Override
    public void visit(arrayindexNode node) {
        node.getArray().accept(this);
        isAssign.push(false);
        node.getIndex().accept(this);
        isAssign.pop();
    }

    @Override
    public void visit(binaryexprNode node) {
        if (node.getOp() == binaryexprNode.Optype.ASSIGN) {
            isAssign.push(true);
            node.getlhs().accept(this);
            isAssign.pop();
            isAssign.push(false);
            node.getrhs().accept(this);
            isAssign.pop();
        } else {
            isAssign.push(false);
            node.getlhs().accept(this);
            isAssign.pop();
            isAssign.push(false);
            node.getrhs().accept(this);
            isAssign.pop();
        }
    }

    @Override
    public void visit(classmemberNode node) {
        node.getExpr().accept(this);
        if (node.getExpr().isAccessable()) {
            if (!(node.getSym() instanceof varsymbol)
                    || (node.getSym() instanceof varsymbol && !(node.getSym().gettype() instanceof basesymbol)))
                currentfuncsymbol.hasSideEffect = true;
        }
    }

    @Override
    public void visit(funccallexprNode node) {
        funcsymbol callee = node.getFunction().getfuncsymbol();
        if (callee.isMemberFunc() && !(currentfuncsymbol.getOuterfield() == _globalfield.getString()))
            currentfuncsymbol.hasSideEffect = true;
        calleeMap.get(currentfuncsymbol).add(callee);
    }

    @Override
    public void visit(IDexprNode node) {
        if (isAssign.peek()) {
            if (node.getsymbol() instanceof varsymbol) {
                if (node.getsymbol().getfield() == _globalfield) {
                    currentfuncsymbol.hasSideEffect = true;
                }
            }
        }
    }

    @Override
    public void visit(newexprNode node) {
        isAssign.push(false);
        node.getExprNodeList().forEach(exprNode -> exprNode.accept(this));
        isAssign.pop();
    }

    @Override
    public void visit(thisexprNode node) {
        assert false;
    }

    @Override
    public void visit(unaryexprNode node) {
        isAssign.push(true);
        node.getExpr().accept(this);
        isAssign.pop();
    }

    @Override
    public void visit(intliteralNode node) {

    }

    @Override
    public void visit(boolliteralNode node) {

    }

    @Override
    public void visit(nullliteralNode node) {

    }

    @Override
    public void visit(stringliteralNode node) {

    }
}

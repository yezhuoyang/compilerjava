package compilerjava.optimizer;

import compilerjava.AST.*;
import compilerjava.Env.funcsymbol;
import compilerjava.Env.globalfield;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class printSplitter implements ASTvisitor {
    private globalfield globalfield;
    private funcsymbol printlnfuncsymbol;
    private funcsymbol printfuncsymbol;
    private List<exprNode> nodeList = new LinkedList<>();
    private blockstmtNode fatherNode;
    private exprstmtNode thisNode;
    private boolean collect = false;

    public printSplitter(globalfield globalfield) {
        this.globalfield = globalfield;
        this.printlnfuncsymbol = (funcsymbol) globalfield.resolvesymbol("println", null);
        this.printfuncsymbol = (funcsymbol) globalfield.resolvesymbol("print", null);
    }

    @Override
    public void visit(programNode node) {
        node.getDeclNodeList().forEach(x -> x.accept(this));
    }

    @Override
    public void visit(vardeclNode node) {

    }

    @Override
    public void visit(funcdeclNode node) {
        node.getBlock().accept(this);
    }

    @Override
    public void visit(classdeclNode node) {
        node.getFuncdeclNodeList().forEach(x -> x.accept(this));
    }

    @Override
    public void visit(arraytpNode node) {
    }

    @Override
    public void visit(classtpNode node) {
    }

    @Override
    public void visit(booltpNode node) {
    }

    @Override
    public void visit(inttpNode node) {
    }

    @Override
    public void visit(voidtpNode node) {
    }

    @Override
    public void visit(stringtpNode node) {
    }

    @Override
    public void visit(blockstmtNode node) {
        List<stmtNode> stmtNodeList = new ArrayList<>(node.getStmtList());
        stmtNodeList.forEach(x -> {
            fatherNode = node;
            x.accept(this);
        });
    }

    @Override
    public void visit(vardeclstmtNode node) {
    }

    @Override
    public void visit(exprstmtNode node) {
        thisNode = node;
        node.getExpr().accept(this);
    }

    @Override
    public void visit(IfstmtNode node) {
        node.getThenstmt().accept(this);
        if (node.getElsestmt() != null) node.getElsestmt().accept(this);
    }

    @Override
    public void visit(whilestmtNode node) {
        if (node.getStmt() != null) node.getStmt().accept(this);
    }

    @Override
    public void visit(forstmtNode node) {
        if (node.getStmt() != null) node.getStmt().accept(this);
    }

    @Override
    public void visit(returnNode node) {

    }

    @Override
    public void visit(breakNode node) {
    }

    @Override
    public void visit(continueNode node) {

    }

    @Override
    public void visit(arrayindexNode node) {
        if (collect) {
            nodeList.add(node);
        }
    }

    @Override
    public void visit(binaryexprNode node) {
        if (collect) {
            node.getlhs().accept(this);
            node.getrhs().accept(this);
        }
    }

    @Override
    public void visit(classmemberNode node) {
        if (collect) {
            nodeList.add(node);
        }
    }

    @Override
    public void visit(funccallexprNode node) {
        funcsymbol funcsymbol = node.getFunction().getfuncsymbol();
        if (funcsymbol == printfuncsymbol || funcsymbol == printlnfuncsymbol) {
            IDexprNode printFunction = new IDexprNode("print", null);
            printFunction.setCat(exprNode.Category.FUNCTION);
            printFunction.settype(printfuncsymbol.gettype());
            printFunction.setsymbol(printfuncsymbol);
            printFunction.setfuncsymbol(printfuncsymbol);
            IDexprNode printlnFunction = new IDexprNode("println", null);
            printlnFunction.setCat(exprNode.Category.FUNCTION);
            printlnFunction.settype(printlnfuncsymbol.gettype());
            printlnFunction.setsymbol(printlnfuncsymbol);
            printlnFunction.setfuncsymbol(printlnfuncsymbol);

            nodeList.clear();
            collect = true;
            node.getParameterList().forEach(x -> x.accept(this));
            collect = false;

            if (nodeList.size() > 1) {
                List<stmtNode> printList = new LinkedList<>();
                for (int i = 0; i < nodeList.size(); i++) {
                    List<exprNode> parameterList = new ArrayList<>();
                    parameterList.add(nodeList.get(i));
                    funccallexprNode funcCallNode = new funccallexprNode(funcsymbol == printlnfuncsymbol && i + 1 == nodeList.size() ? printlnFunction : printFunction,
                            parameterList, null);
                    funcCallNode.setCat(exprNode.Category.RVALUE);
                    funcCallNode.settype(funcsymbol.gettype());
                    printList.add(new exprstmtNode(funcCallNode, null));
                }
                blockstmtNode blockstmtNode = new blockstmtNode(printList, null);
                int pos = fatherNode.getStmtList().indexOf(thisNode);
                fatherNode.getStmtList().remove(pos);
                fatherNode.getStmtList().add(pos, blockstmtNode);
            }
        } else {
            if (collect) {
                nodeList.add(node);
            }
        }
    }

    @Override
    public void visit(IDexprNode node) {
        if (collect) {
            nodeList.add(node);
        }
    }

    @Override
    public void visit(newexprNode node) {
    }

    @Override
    public void visit(thisexprNode node) {
    }

    @Override
    public void visit(unaryexprNode node) {
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
        if (collect) {
            nodeList.add(node);
        }
    }
}

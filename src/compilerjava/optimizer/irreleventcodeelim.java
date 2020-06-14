package compilerjava.optimizer;

import compilerjava.AST.*;
import compilerjava.Env.*;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;

public class irreleventcodeelim implements ASTvisitor {
    private globalfield _globalfield;
    private Map<Node, Set<varsymbol>> defs = new HashMap<>();
    private Map<Node, Set<varsymbol>> uses = new HashMap<>();
    private Set<varsymbol> outputRelevantSymbols = new HashSet<>();
    private Stack<Boolean> isAssign = new Stack<>();

    private boolean DEBUG = true;
    private boolean collectMode;
    private boolean solveMode;
    private boolean cleanMode;
    private boolean debugMode;
    private PrintStream debug_out = new PrintStream("ast_debug.txt");
    private String indent = "";

    private varsymbol callNotifier = new varsymbol("callNotifier", null, null);
    private varsymbol globalVariableNotifier = new varsymbol("gvNotifier", null, null);
    private varsymbol controlTransferNotifier = new varsymbol("ctNotifier", null, null);

    public irreleventcodeelim(globalfield _globalfield) throws FileNotFoundException {
        this._globalfield = _globalfield;
    }

    private void addIndent() {
        indent += "\t\t\t";
    }

    private void decIndent() {
        indent = indent.substring(0, indent.length() - 3);
    }

    private void debug(String msg) {
        debug_out.print(msg);
    }

    private void debugln(String msg) {
        debug_out.println(indent + msg);
    }

    private void showDef(Node node) {
        debug(indent + "defs : ");
        defs.get(node).forEach(varsymbol -> debug(varsymbol.getWord() + " "));
        debugln("");
    }

    private void showUse(Node node) {
        debug(indent + "uses : ");
        uses.get(node).forEach(varsymbol -> debug(varsymbol.getWord() + " "));
        debugln("");
    }

    @Override
    public void visit(programNode node) {
        if (node.hasClassDeclNode) return;
        outputRelevantSymbols.add(callNotifier);
        outputRelevantSymbols.add(globalVariableNotifier);
        outputRelevantSymbols.add(controlTransferNotifier);

        collectMode = true;
        node.getDeclNodeList().forEach(x -> {
            if (x instanceof funcdeclNode) x.accept(this);
        });
        collectMode = false;
        solveMode = true;
        int size;
        do {
            size = outputRelevantSymbols.size();
            node.getDeclNodeList().forEach(x -> {
                if (x instanceof funcdeclNode) x.accept(this);
            });
        } while (size != outputRelevantSymbols.size());
        if (DEBUG) {
            debugln("Output Relevant Symbols");
            outputRelevantSymbols.forEach(varsymbol -> debug(varsymbol.getWord() + " "));
            debugln("\n");

            debugln("Before elimination");
            debugMode = true;
            solveMode=false;
            node.getDeclNodeList().forEach(x -> {
                if (x instanceof funcdeclNode) x.accept(this);
            });
            solveMode=true;
            debugMode = false;

        }
        solveMode = false;
        cleanMode = true;
        node.getDeclNodeList().forEach(x -> {
            if (x instanceof funcdeclNode) x.accept(this);
        });
        cleanMode = false;
        if (DEBUG) {

            debugln("After elimination");
            debugMode = true;
            node.getDeclNodeList().forEach(x -> {
                if (x instanceof funcdeclNode) x.accept(this);
            });
            debugMode = false;
        }
    }

    @Override
    public void visit(vardeclNode node) {
        if (collectMode) {
            init(node);
            if (node.getExpr() != null) {
                isAssign.push(false);
                node.getExpr().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getExpr());
            }
            defs.get(node).add(node.getvarsymbol());
        } else if (solveMode) {
            propagate(node, node.getExpr());
            if (node.getExpr() != null) node.getExpr().accept(this);
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("vardeclNode");
            showDef(node);
            showUse(node);
            addIndent();
            debugln("var_name : " + node.getID());
            if (node.getExpr() != null) node.getExpr().accept(this);
            decIndent();
        }
    }


    @Override
    public void visit(funcdeclNode node) {
        if (collectMode) {
            isAssign.push(false);
            node.getParameterList().forEach(x -> {
                if (x.gettpNode() instanceof arraytpNode)
                   outputRelevantSymbols.add(x.getvarsymbol());
            });
            node.getBlock().accept(this);
            isAssign.pop();
        } else if (solveMode){
            node.getBlock().accept(this);
        } else if (cleanMode){
            instructionElimination(node.getBlock().getStmtList());
        } else if (debugMode) {
            debugln("funcdeclNode : " + node.getID());
            addIndent();
            node.getBlock().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(classdeclNode node) {
        assert false;
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
        if (collectMode) {
            init(node);
            node.getStmtList().forEach(x -> {
                x.accept(this);
                updateDefAndUse(node, x);
            });
        } else if (solveMode) {
            node.getStmtList().forEach(x -> {
                x.accept(this);
            });
        } else if (cleanMode) {
            instructionElimination(node.getStmtList());
        } else if (debugMode) {
            debugln("blockstmtNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getStmtList().forEach(x -> x.accept(this));
            decIndent();
        }
    }

    @Override
    public void visit(vardeclstmtNode node){
        if (collectMode) {
            init(node);
            node.getVardeclList().getDecls().forEach(x -> {
                x.accept(this);
                updateDefAndUse(node, x);
            });
        } else if (solveMode) {
            node.getVardeclList().getDecls().forEach(x -> {
                x.accept(this);
            });
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("vardeclstmtNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getVardeclList().getDecls().forEach(x -> x.accept(this));
            decIndent();
        }
    }

    @Override
    public void visit(exprstmtNode node) {
        if (collectMode) {
            init(node);
            node.getExpr().accept(this);
            updateDefAndUse(node, node.getExpr());
        } else if (solveMode) {
            propagate(node, node.getExpr());
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("exprstmtNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExpr().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(IfstmtNode node) {
        if (collectMode) {
            init(node);
            isAssign.push(false);
            node.getExpr().accept(this);
            isAssign.pop();
            updateDefAndUse(node, node.getExpr());
            node.getThenstmt().accept(this);
            updateDefAndUse(node, node.getThenstmt());
            if (node.getElsestmt() != null) {
                node.getElsestmt().accept(this);
                updateDefAndUse(node, node.getElsestmt());
            }
        } else if (solveMode) {
            propagate(node, node.getExpr());
            node.getExpr().accept(this);
            node.getThenstmt().accept(this);
            if (node.getElsestmt() != null) node.getElsestmt().accept(this);
        } else if (cleanMode) {
            node.getThenstmt().accept(this);
            if (node.getElsestmt() != null) node.getElsestmt().accept(this);
        } else if (debugMode) {
            debugln("IfstmtNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExpr().accept(this);
            node.getThenstmt().accept(this);
            if (node.getElsestmt() != null) node.getElsestmt().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(whilestmtNode node) {
        if (collectMode) {
            init(node);
            isAssign.push(false);
            node.getExpr().accept(this);
            isAssign.pop();
            updateDefAndUse(node, node.getExpr());
            node.getStmt().accept(this);
            updateDefAndUse(node, node.getStmt());
        } else if (solveMode) {
            propagate(node, node.getExpr());
            node.getExpr().accept(this);
            node.getStmt().accept(this);
        } else if (cleanMode) {
            node.getStmt().accept(this);
        } else if (debugMode) {
            debugln("whilestmtNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExpr().accept(this);
            node.getStmt().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(forstmtNode node) {
        if (collectMode) {
            init(node);
            if (node.getInit() != null) {
                isAssign.push(false);
                node.getInit().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getInit());
            }
            if (node.getCond() != null) {
                isAssign.push(false);
                node.getCond().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getCond());
            }
            if (node.getStep() != null) {
                isAssign.push(false);
                node.getStep().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getStep());
            }
            node.getStmt().accept(this);
            updateDefAndUse(node, node.getStmt());
        } else if (solveMode) {
            propagate(node, node.getInit(), node.getCond(), node.getStep());
            if (node.getInit() != null) node.getInit().accept(this);
            if (node.getCond() != null) node.getCond().accept(this);
            if (node.getStep() != null) node.getStep().accept(this);
            node.getStmt().accept(this);
        } else if (cleanMode) {
            node.getStmt().accept(this);
        } else if (debugMode) {
            debugln("forstmtNode");
            showDef(node);
            showUse(node);
            debugln("init");
            addIndent();
            if (node.getInit() != null) node.getInit().accept(this);
            decIndent();
            debugln("cond");
            addIndent();
            if (node.getCond() != null) node.getCond().accept(this);
            decIndent();
            debugln("step");
            addIndent();
            if (node.getStep() != null) node.getStep().accept(this);
            decIndent();
            node.getStmt().accept(this);
        }
    }

    @Override
    public void visit(returnNode node) {
        if (collectMode) {
            init(node);
            if (node.getExpr() != null) {
                isAssign.push(false);
                node.getExpr().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getExpr());
                outputRelevantSymbols.addAll(uses.get(node.getExpr()));
            }
            defs.get(node).add(globalVariableNotifier);
        } else if (solveMode) {
            if (node.getExpr() != null) node.getExpr().accept(this);
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("returnNode");
            showDef(node);
            showUse(node);
            addIndent();
            if (node.getExpr() != null) node.getExpr().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(breakNode node) {
        if (collectMode) {
            init(node);
            defs.get(node).add(controlTransferNotifier);
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("breakNode");
            showDef(node);
            showUse(node);
        }
    }

    @Override
    public void visit(continueNode node) {
        if (collectMode) {
            init(node);
            defs.get(node).add(controlTransferNotifier);
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("continueNode");
            showDef(node);
            showUse(node);
        }
    }

    @Override
    public void visit(arrayindexNode node) {
        if (collectMode) {
            init(node);
            node.getArray().accept(this);
            updateDefAndUse(node, node.getArray());
            isAssign.push(false);
            node.getIndex().accept(this);
            isAssign.pop();
            updateDefAndUse(node, node.getIndex());
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("arrayindexNode");
            showDef(node);
            showUse(node);
            debugln("array");
            addIndent();
            node.getArray().accept(this);
            decIndent();
            debugln("index");
            addIndent();
            node.getIndex().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(binaryexprNode node) {
        if (collectMode) {
            init(node);
            if (node.getOp() == binaryexprNode.Optype.ASSIGN) {
                isAssign.push(true);
                node.getlhs().accept(this);
                isAssign.pop();
                updateDefAndUse(node, node.getlhs());
                node.getrhs().accept(this);
                updateDefAndUse(node, node.getrhs());
                if (defs.get(node.getrhs()) != null) {
                    uses.get(node).addAll(defs.get(node.getlhs()));
                }
                if (node.getrhs().gettype() instanceof arraytype) {
                    //Alias of array
                    defs.get(node).addAll(uses.get(node.getrhs()));
                }
            } else {
                node.getlhs().accept(this);
                updateDefAndUse(node, node.getlhs());
                node.getrhs().accept(this);
                updateDefAndUse(node, node.getrhs());
            }
        } else if (solveMode) {
            propagate(node, node.getlhs(), node.getrhs());
            node.getlhs().accept(this);
            node.getrhs().accept(this);
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("binaryexprNode");
            showDef(node);
            showUse(node);
            debugln("lhs");
            addIndent();
            node.getlhs().accept(this);
            decIndent();
            debugln("rhs");
            addIndent();
            node.getrhs().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(classmemberNode node) {
        if (collectMode) {
            init(node);
            node.getExpr().accept(this);
            updateDefAndUse(node, node.getExpr());
        } else if (solveMode) {
            node.getExpr().accept(this);
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("classmemberNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExpr().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(funccallexprNode node) {
        if (collectMode) {
            init(node);
            node.getFunction().accept(this);
            updateDefAndUse(node, node.getFunction());
            node.getParameterList().forEach(parameter -> {
                parameter.accept(this);
                updateDefAndUse(node, parameter);
            });
            if (node.getFunction().getfuncsymbol().hasSideEffect) {
                defs.get(node).add(callNotifier);
                outputRelevantSymbols.addAll(uses.get(node));
            }
        } else if (solveMode) {
            propagate(node, node.getParameterList());
            node.getParameterList().forEach(parameter -> parameter.accept(this));
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("funccallexprNode");
            showDef(node);
            showUse(node);
            debugln("parameters");
            addIndent();
            node.getParameterList().forEach(x -> x.accept(this));
            decIndent();
            debugln("function");
            addIndent();
            node.getFunction().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(IDexprNode node) {
        if (collectMode) {
            init(node);
            if (node.getsymbol() instanceof varsymbol) {
                if (node.getsymbol().getfield() == _globalfield) {
                    defs.get(node).add(globalVariableNotifier);
                } else if (isAssign.peek()) {
                    defs.get(node).add((varsymbol) node.getsymbol());
                } else {
                    uses.get(node).add((varsymbol) node.getsymbol());
                }
            }
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("IDExprNode");
            showDef(node);
            showUse(node);
            addIndent();
            debugln(node.getsymbol().getWord());
            decIndent();
        }
    }

    @Override
    public void visit(newexprNode node) {
        if (collectMode) {
            init(node);
            node.getExprNodeList().forEach(exprNode -> {
                exprNode.accept(this);
                updateDefAndUse(node, exprNode);
            });
        } else if (solveMode) {
            propagate(node, node.getExprNodeList());
            node.getExprNodeList().forEach(exprNode -> exprNode.accept(this));
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("newexprNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExprNodeList().forEach(x -> x.accept(this));
            decIndent();
        }
    }

    @Override
    public void visit(thisexprNode node) {
        if (collectMode) {
            init(node);
        } else if (solveMode) {

        } else if (cleanMode) {

        }
    }

    @Override
    public void visit(unaryexprNode node) {
        if (collectMode) {
            init(node);
            node.getExpr().accept(this);
            updateDefAndUse(node, node.getExpr());
            if (node.getOp() == unaryexprNode.Op.PRE_ADD || node.getOp() == unaryexprNode.Op.PRE_SUB
                    || node.getOp() == unaryexprNode.Op.SUF_ADD || node.getOp() == unaryexprNode.Op.SUF_SUB) {
                defs.get(node).addAll(uses.get(node.getExpr()));
            }
        } else if (solveMode) {
            propagate(node, node.getExpr());
            node.getExpr().accept(this);
        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("unaryexprNode");
            showDef(node);
            showUse(node);
            addIndent();
            node.getExpr().accept(this);
            decIndent();
        }
    }

    @Override
    public void visit(intliteralNode node) {
        if (collectMode) {
            init(node);
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("IntLiteral");
            addIndent();
            debugln(String.valueOf(node.getVal()));
            decIndent();
        }
    }

    @Override
    public void visit(boolliteralNode node) {
        if (collectMode) {
            init(node);
        } else if (solveMode) {

        } else if (cleanMode) {

        } else if (debugMode) {
            debugln("BoolLiteral");
            addIndent();
            debugln(String.valueOf(node.getVal()));
            decIndent();
        }
    }

    @Override
    public void visit(nullliteralNode node) {
        if (collectMode) {
            init(node);
        } else if (solveMode) {

        } else if (debugMode) {
            debugln("NullLiteral");
        }
    }

    @Override
    public void visit(stringliteralNode node) {
        if (collectMode) {
            init(node);
        } else if (solveMode) {

        } else if (debugMode) {
            debugln("StringLiteral");
            addIndent();
            debugln(node.getVal());
            decIndent();
        }
    }

    private void init(Node node) {
        defs.put(node, new HashSet<>());
        uses.put(node, new HashSet<>());
    }

    private void updateDefAndUse(Node parent, Node child) {
        defs.get(parent).addAll(defs.get(child));
        uses.get(parent).addAll(uses.get(child));
    }

    private boolean irrelevant(Node node) {
        Set<varsymbol> defined = new HashSet<>(defs.get(node));
        defined.retainAll(outputRelevantSymbols);
        return defined.isEmpty();
    }

    private void propagate(Node parent, Node... children) {
        propagate(parent, Arrays.asList(children));
    }

    private void propagate(Node parent, List<? extends Node> children) {
        if(!irrelevant(parent)){
            children.forEach(child -> {
                if (child != null)
                    outputRelevantSymbols.addAll(uses.get(child));
            });
        }
    }

    private void instructionElimination(List<stmtNode> stmtNodes) {
        Set<stmtNode> deadNode = new HashSet<>();
        stmtNodes.forEach(stmtNode -> {
            if (irrelevant(stmtNode)) deadNode.add(stmtNode);
            else stmtNode.accept(this);
        });
        stmtNodes.removeAll(deadNode);
    }
}

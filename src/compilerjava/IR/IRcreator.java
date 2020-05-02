package compilerjava.IR;
import  compilerjava.AST.*;
import  compilerjava.Env.*;



public class IRcreator implements ASTvisitor {
    private globalfield     _globalfield;
    private basicblock      currentBB;
    private classsymbol     currentclasssymbol;
    private function        currentfunction;
    private IRroot irRoot=new IRroot();

    @Override
    void visit(programNode node);

    @Override
    void visit(vardeclNode node);

    @Override
    void visit(funcdeclNode node);

    @Override
    void visit(classdeclNode node);

    @Override
    void visit(arraytpNode node);

    @Override
    void visit(classtpNode node);

    @Override
    void visit(booltpNode node);

    @Override
    void visit(inttpNode node);

    @Override
    void visit(voidtpNode node);

    @Override
    void visit(stringtpNode node);

    @Override
    void visit(blockstmtNode node);

    @Override
    void visit(vardeclstmtNode node);

    @Override
    void visit(exprstmtNode node);

    @Override
    void visit(IfstmtNode node);

    @Override
    void visit(whilestmtNode node);

    @Override
    void visit(forstmtNode node);

    @Override
    void visit(returnNode node);

    @Override
    void visit(breakNode node);

    @Override
    void visit(continueNode node);

    @Override
    void visit(arrayindexNode node);

    @Override
    void visit(binaryexprNode node);

    @Override
    void visit(classmemberNode node);

    @Override
    void visit(funccallexprNode node);

    @Override
    void visit(IDexprNode node);

    @Override
    void visit(newexprNode node);

    @Override
    void visit(thisexprNode node);

    @Override
    void visit(unaryexprNode node);

    @Override
    void visit(intliteralNode node);

    @Override
    void visit(boolliteralNode node);

    @Override
    void visit(nullliteralNode node);

    @Override
    void visit(stringliteralNode node);





}

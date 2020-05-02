package compilerjava.AST;



public interface ASTvisitor{

    void visit(programNode node);

    void visit(vardeclNode node);

    void visit(funcdeclNode node);

    void visit(classdeclNode node);

    void visit(arraytpNode node);

    void visit(classtpNode node);

    void visit(booltpNode node);

    void visit(inttpNode node);

    void visit(voidtpNode node);

    void visit(stringtpNode node);

    void visit(blockstmtNode node);

    void visit(vardeclstmtNode node);

    void visit(exprstmtNode node);

    void visit(IfstmtNode node);

    void visit(whilestmtNode node);

    void visit(forstmtNode node);

    void visit(returnNode node);

    void visit(breakNode node);

    void visit(continueNode node);

    void visit(arrayindexNode node);

    void visit(binaryexprNode node);

    void visit(classmemberNode node);

    void visit(funccallexprNode node);

    void visit(IDexprNode node);

    void visit(newexprNode node);

    void visit(thisexprNode node);

    void visit(unaryexprNode node);

    void visit(intliteralNode node);

    void visit(boolliteralNode node);

    void visit(nullliteralNode node);

    void visit(stringliteralNode node);



}








package compilerjava.AST



public interface ASTvisitor{

    void visit(ProgramNode node);

    void visit(VariabledeclNode node);

    void visit(funcdeclNode node);

    void visit(classdeclNode node);

    void visit(arraytypeNode node);

    void visit(classtypeNode node);

    void visit(booltypeNode node);

    void visit(inttypeNode node);

    void visit(voidtypeNode node);

    void visit(stringtypeNode node);

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








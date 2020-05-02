package compilerjava;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.Parser.*;
import compilerjava.semantic.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.InputStream;
import java.io.FileInputStream;



public class Main{



    private static programNode buildAST(InputStream in)throws Exception{
        MXLexer lexer = new MXLexer(CharStreams.fromStream(in));
        lexer.removeErrorListeners();
        lexer.addErrorListener( new MXErrorListener() );
        MXParser parser=new  MXParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new MXErrorListener());
        ParseTree tree=parser.program();
        ASTbuilder ASTbuilder=new ASTbuilder();
        return (programNode)ASTbuilder.visit(tree);
    }


    public static void main(String... args)throws Exception{
        InputStream in = new FileInputStream("test.txt");
        try{

            programNode ast=buildAST(in);
            globalfield _globalfield=(new builtinsymbolcollector(ast)).getglobalfield();

            new classdeclcollector(_globalfield).visit(ast);
            new globalfuncdeclcollector(_globalfield).visit(ast);
            new classmembercollector(_globalfield).visit(ast);
            new symbolcollector(_globalfield).visit(ast);
            new semanticchecker(_globalfield).visit(ast);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }



}
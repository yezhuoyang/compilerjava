package compilerjava;

import compilerjava.AST.programNode;


import compilerjava.Parser.MXErrorListener;
import compilerjava.Parser.MXLexer;
import compilerjava.Parser.MXParser;




import compilerjava.Env.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.InputStream;
import java.io.FileInputStream;



public class Main{


    private static programNode buildAST(InputStream in)throws Exception{
        MXParser parser=new  MXParser(new CommonTokenStream(new MXLexer(CharStreams.fromStream(in))));
        parser.removeErrorListeners();
        parser.addErrorListener(new MXErrorListener());
        parserTree tree=paresr.program();
        ASTcreator astcreator=new ASTcreator();
        return (programNode)astcreator.visit(tree);
    }


    public static void main(){
        InputStream in = new FileInputStream("test.txt");
        try{
            programNode ast=buildAST(in);

            globalfield _globalfield=(new builtinsymbolcollector(ast)).getglobalfield();
            new classdeclcollector(_globalfield).visit(ast);
            new globalfuncdeclcollector(_globalfield).visit(ast);
            new classmembercollector(_globalfield).visit(ast);
            new semanticchecker(_globalfield).visit(ast);

        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new RuntimeExcception();
        }
    }



}
package compilerjava;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.codegen.*;
import compilerjava.Parser.*;
import compilerjava.semantic.*;
import compilerjava.IR.*;
import compilerjava.IR.IRInterpreter.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


import compilerjava.optimizer.*;


import java.io.*;

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


    public enum stage{
        semantic,codegen,optim
    }
    static private stage process;

    public static void main(String[] args)throws Exception{


        if(args.length==0){
            process=stage.optim;
        }else{
            if((args[0]).equals("-s")){
                process=stage.semantic;
            }
            else if((args[0]).equals("-c")){
                process=stage.codegen;
            }
            else if((args[0]).equals("-o")){
                process=stage.optim;
            }
        }
        InputStream in = new FileInputStream("code.txt");
        //PrintStream out = new PrintStream("output.s");
        //PrintStream out = new PrintStream("test.s");
        PrintStream out = new PrintStream(System.out);
        try{
            programNode ast=buildAST(in);
            globalfield _globalfield=(new builtinsymbolcollector(ast)).getglobalfield();
            new classdeclcollector(_globalfield).visit(ast);
            new globalfuncdeclcollector(_globalfield).visit(ast);
            new classmembercollector(_globalfield).visit(ast);
            new symbolcollector(_globalfield).visit(ast);
            new semanticchecker(_globalfield).visit(ast);

            if(process==stage.codegen||process==stage.optim){
                new trivialboolExtractor().visit(ast);
                new elimsideeffect(_globalfield).visit(ast);
                new irreleventcodeelim(_globalfield).visit(ast);

                IRcreator ircreator=new IRcreator(_globalfield);
                ircreator.visit(ast);
                IRroot irroot=ircreator.getIrRoot();


                new inliner(irroot).run();
                new globalvarresolver(irroot).run();
                optimizer optim=new optimizer(irroot);


                //optim.DeadCodeElimination();


                //new IRprinter(out,false,false).printAllBlock(irroot);
                optim.CFGSimplification();
                optim.SSAConstruction();
                int round=0;
                for (boolean changed = true; changed; ) {
                    changed=optim.CommonSubexpressionElimination();
                    changed|=optim.runConstAndCopy();
                    changed|=optim.CFGSimplification();
                    changed|=optim.DeadCodeElimination();
                    changed|=optim.CFGSimplification();
                }
                optim.SSADestruction();
                optim.CFGSimplification(true);

/*
                PrintStream out2 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/iroutput.txt");
                IRprinter irprinter=new IRprinter(out2);
                irprinter.visit(irroot);
                DataInputStream code_in =new DataInputStream(new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/iroutput.txt"));
                DataInputStream data_in =new DataInputStream(new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/test.in"));
                PrintStream out3 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/irtest.out");
                IRinterpreter IRint=new IRinterpreter(code_in,false,data_in,out3);
                IRint.run();
*/

                callingConvention adjustToEmmit=new callingConvention(irroot);
                adjustToEmmit.run();
                optim.InstructionAdujust();

                new regAllocator(irroot).run();

                ASMgenerator codegen=new ASMgenerator(irroot,out);
                codegen.run();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }



}
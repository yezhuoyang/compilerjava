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

    public static void main(String... args)throws Exception{
        InputStream in = new FileInputStream("code.txt");
        PrintStream out = new PrintStream("output.s");
        //PrintStream out = new PrintStream("test.s");
        //PrintStream out = new PrintStream(System.out);
        try{
            programNode ast=buildAST(in);
            globalfield _globalfield=(new builtinsymbolcollector(ast)).getglobalfield();
            new classdeclcollector(_globalfield).visit(ast);
            new globalfuncdeclcollector(_globalfield).visit(ast);
            new classmembercollector(_globalfield).visit(ast);
            new symbolcollector(_globalfield).visit(ast);
            new semanticchecker(_globalfield).visit(ast);

            new trivialboolExtractor().visit(ast);
            new elimsideeffect(_globalfield).visit(ast);
            new irreleventcodeelim(_globalfield).visit(ast);

            IRcreator ircreator=new IRcreator(_globalfield);
            ircreator.visit(ast);
            IRroot irroot=ircreator.getIrRoot();

            new globalvarresolver(irroot).run();

            new inliner(irroot).run();
            new globalvarresolver(irroot).run();
            optimizer optim=new optimizer(irroot);
            //optim.DeadCodeElimination();


            optim.CFGSimplification();
            optim.SSAConstruction();
            int round=0;
            for (boolean changed = true; changed; ) {
                changed=optim.CommonSubexpressionElimination();
                changed|=optim.CFGSimplification();
                //changed|=optim.DeadCodeElimination();
                //changed|=optim.CFGSimplification();
            }
            optim.SSADestruction();
            optim.CFGSimplification(true);

/*
            PrintStream out2 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/iroutput.txt");

            IRprinter irprinter=new IRprinter(out2);
            irprinter.visit(irroot);

            DataInputStream code_in =new DataInputStream(new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/iroutput.txt"));

            DataInputStream data_in =new DataInputStream(new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/test.in"));

            PrintStream out3 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/test.out");

            IRinterpreter IRint=new IRinterpreter(code_in,false,data_in,out3);
            IRint.run();

 */
            optim.InstructionAdujust();
            //optim.SSADestruction();


            //optim.InstructionCombination();


            callingConvention adjustToEmmit=new callingConvention(irroot);
            adjustToEmmit.run();


            new regAllocator(irroot).run();



            ASMgenerator codegen=new ASMgenerator(irroot,out);
            codegen.run();

            /*
            IRroot irroot=ircreator.getIrRoot();
            new riscvconstraintResolver(irroot).run();
            new regAllocator(irroot).run();
            IRprinter irprinter=new IRprinter(out,true);
            irprinter.visit(irroot);
            PrintStream out2 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/outcode.txt");
            new riscvcodeEmitter(irroot,out2).run();
            */
            /*
            IRprinter irprinter=new IRprinter(out);
            irprinter.visit(irroot);
            InputStream in2 = new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/out.txt");
            PrintStream out2 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/out2.txt");
            DataInputStream data_in =new DataInputStream(new FileInputStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/data_input.txt"));
            IRinterpreter IRint=new IRinterpreter(in2,false,data_in,out2);
            IRint.run();
            optimizer optim=new optimizer(irroot);
            optim.DeadCodeElimination();
            optim.SpillPriorityCalculation();
            new regAllocator(irroot).run();
            */
            /*
            optimizer optim=new optimizer(irroot);
            optim.DeadCodeElimination();
            optim.SpillPriorityCalculation();
            new regAllocator(irroot).run();
            IRprinter irprinter=new IRprinter(out,true);
            irprinter.visit(irroot);
            */


            //PrintStream out2 = new PrintStream("/Users/yezhuoyang/Desktop/share/compilerjava/src/compilerjava/outcode.txt");
            //new X86CodeEmitter(irroot,out2).run();
        }catch (Exception e){
            e.printStackTrace();
            System.err.println(e.getMessage());
            throw new RuntimeException();
        }
    }



}
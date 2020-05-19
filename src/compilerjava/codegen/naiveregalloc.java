package compilerjava.codegen;


import compilerjava.IR.IRprinter;
import compilerjava.IR.IRroot;
import compilerjava.IR.function;
import compilerjava.IR.basicblock;
import compilerjava.IR.instruction.*;
import java.io.PrintStream;

public class naiveregalloc {
    private IRroot _IRroot;









    private void alloc(basicblock BB){
        for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){

        }
    }

























}



package compilerjava.optimizer;


import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.register;


import java.util.HashSet;
import java.util.Set;


public class DeadCodeEliminator extends pass{


    private Set<IRinst> markSet=new HashSet<>();


    DeadCodeEliminator(IRroot irroot){
        super(irroot);
    }

    @Override
    boolean run() {
        changed=false;
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
        });
        return changed;
    }



}

package compilerjava.codegen;



import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static compilerjava.IR.operand.realregister.*;


public class riscvconstraintResolver {
    private IRroot irroot;
    private LinkedList<register> parameterList=new LinkedList<>();
    private Map<virtualregister,virtualregister> calleeSaveVRTemporaryMap=new HashMap<>();

    public riscvconstraintResolver(IRroot irroot){
        this.irroot=irroot;
    }













}

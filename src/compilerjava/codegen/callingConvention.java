package compilerjava.codegen;



import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static compilerjava.IR.operand.realregister.*;



// Before send IR to emit ASMgenerator, serveral condition must be satisfied to simplyfy the process of codegen.
//1. Only src2 can be immediate (For binary, cmp)
//2. For IRinst cmp, only remain EQ, NEQ , LT


public class callingConvention {

    private IRroot irroot;
    private LinkedList<register> parameterList = new LinkedList<>();
    private Map<virtualregister, virtualregister> calleeSaveVRTemporaryMap = new HashMap<>();


    public callingConvention(IRroot irroot) {
        this.irroot = irroot;
    }

    public void run() {
        irroot.getFunctionMap().values().forEach(this::argumentPass);
        irroot.getFunctionMap().values().forEach(this::ModifyReturn);
        irroot.getFunctionMap().values().forEach(this::calleeSave);
    }


    private void argumentPass(function function) {
        //load function arguments
        parameterList.clear();

        parameterList.addAll(function.getParameterList());
        if (function.getReferenceForClassMethod() != null)
            parameterList.add(function.getReferenceForClassMethod());

        for (int i = 0; i < parameterList.size(); i++)
            if (i < 8)
                function.getEntryBB().head.prependInstruction(new move(function.getEntryBB(), argumentPassVRegisters.get(i), parameterList.get(i)));
            else {
                //TODO: Check callee convention
                function.getEntryBB().head.prependInstruction(new load(parameterList.get(i).getSize(), function.getEntryBB(), new stackdata(function, i - 8), parameterList.get(i)));
            }

        back returnInst = (back) function.getExitBB().tail;

        if (returnInst.getReturnValue() != null) {
            returnInst.prependInstruction(new move(function.getExitBB(), returnInst.getReturnValue(), va0));
            returnInst.setReturnValue(va0);
        }

        function.getReversePostOrderDFSBBList().forEach(BB -> {
            for (IRinst irinst = BB.head; irinst != null; irinst = irinst.getNextInstruction()) {
                if (irinst instanceof call) {

                    call inst = (call) irinst;

                    function.argumentLimit = Math.max(function.argumentLimit, inst.getObjectPointer() == null ? inst.getParameterList().size() : inst.getParameterList().size() + 1);
                    //pass arguments
                    int registerLimit = inst.getObjectPointer() == null ? 8 : 7;
                    int Size;
                    for (int i = 8; i < inst.getParameterList().size(); i++) {
                        Size = inst.getParameterList().get(i).getSize();
                        inst.prependInstruction(new store(Size, BB, inst.getParameterList().get(i), new stackdata(function)));
                    }

                    int cnt = 0;
                    for (int i = 0; i < Integer.min(8, ((call) irinst).getParameterList().size()); i++) {
                        operand op = ((call) irinst).getParameterList().get(i);
                        ((call) irinst).getParameterList().set(i, argumentPassVRegisters.get(cnt));
                        irinst.prependInstruction(new move(BB, op, argumentPassVRegisters.get(cnt++)));
                    }


                    while(inst.getParameterList().size()>8){
                        inst.getParameterList().removeLast();
                    }


                    if (((call) irinst).getObjectPointer() != null) {
                        operand op = ((call) irinst).getObjectPointer();
                        ((call) irinst).setObjectPointer(argumentPassVRegisters.get(cnt));
                        irinst.prependInstruction(new move(BB, op, argumentPassVRegisters.get(cnt++)));
                    }

                    if(inst.getResult()!=null){
                        irinst.postpendInstruction(new move(BB,va0,inst.getResult()));
                        ((call) irinst).setResult(va0);
                    }

                    irinst.updateUseRegs();
                } else if (irinst instanceof alloc) {
                    irinst.prependInstruction(new move(BB, ((alloc) irinst).getSize(), va0));
                    irinst.postpendInstruction(new move(BB,va0,((alloc) irinst).getPointer()));
                    ((alloc) irinst).setPointer(va0);
                    ((alloc) irinst).setSize(va0);
                }
            }
        });
    }



    private void calleeSave(function function) {
        for (virtualregister vreg : calleeSaveVRegisters) {
            if (vreg == vsp || vreg == vgp || vreg == vtp || vreg == vzero || vreg == vs0)
                continue;
            stackdata stackloc = new stackdata(function);
            function.getEntryBB().addFirst(new store(config.registersize, function.getEntryBB(), vreg, stackloc));
            function.getExitBB().tail.prependInstruction(new load(config.registersize, function.getExitBB(), stackloc, vreg));
        }
    }


    private void ModifyReturn(function function) {
        //modify return
        back returnInst = (back) function.getExitBB().tail;
        stackdata stackloc = new stackdata(function);
        function.getEntryBB().head.prependInstruction(new store(config.registersize, function.getExitBB(), vra, stackloc));
        returnInst.prependInstruction(new load(config.registersize, function.getExitBB(), stackloc, vra));
    }


}



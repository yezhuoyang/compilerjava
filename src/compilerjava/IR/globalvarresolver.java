package compilerjava.IR;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.*;
import java.io.*;

public class globalvarresolver{


    private IRroot irRoot;
    public globalvarresolver(IRroot irRoot) {
        this.irRoot = irRoot;
    }


    public void run(){
        Map<register, register> renameMap = new HashMap<>();
        irRoot.getFunctionMap().forEach((name, function) -> {
            function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
                for (IRinst IRinst = basicBlock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                    if ((IRinst instanceof load && ((load) IRinst).isInsertedForGlobalVar()) ||
                            (IRinst instanceof store && ((store) IRinst).isInsertedForglobalvar()))
                        continue;
                    List<register> useregisters = IRinst.getUseregs();
                    register defregister = IRinst.getDefReg();
                    if(!useregisters.isEmpty()){
                        renameMap.clear();
                        for (register useregister : useregisters)
                            if (useregister instanceof globalvar && !((global64Value) useregister).isString())
                                renameMap.put(useregister, getTemporal((globalvar) useregister, function.funcinfo.globaltemporal));
                            else
                                renameMap.put(useregister, useregister);
                            IRinst.setUseregs(renameMap);
                    }
                    if (defregister instanceof globalvar && !((global64Value) defregister).isString()){
                        IRinst.setDefReg(getTemporal((globalvar) defregister, function.funcinfo.globaltemporal));
                        function.funcinfo.defglobalvar.add((globalvar) defregister);
                    }
                }
            });
            function.funcinfo.globaltemporal.forEach(((globalvar, temporal) -> {
                function.getEntryBB().addFirst(new load(((global64Value)globalvar).getSize(),function.getEntryBB(), (global64Value) globalvar, temporal, true));
            }));
        });

        irRoot.getFunctionMap().forEach((name, function) -> {
            function.funcinfo.recursiveUseglobalvar.addAll(function.funcinfo.globaltemporal.keySet());
            function.funcinfo.recursiveDefglobalvar.addAll(function.funcinfo.defglobalvar);
            function.recursivecalleeset.forEach(callee -> {
                function.funcinfo.recursiveUseglobalvar.addAll(callee.funcinfo.globaltemporal.keySet());
                function.funcinfo.recursiveDefglobalvar.addAll(callee.funcinfo.defglobalvar);
            });
        });

        Set<globalvar> reloadSet = new HashSet<>();
        irRoot.getFunctionMap().forEach((name, function) -> {
            Set<globalvar> useglobalvar = function.funcinfo.globaltemporal.keySet();
            if (!useglobalvar.isEmpty()) {
                function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
                    for (IRinst IRinst = basicBlock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                        if (!(IRinst instanceof call)) continue;
                        function callee = ((call) IRinst).getCallee();
                        for(globalvar defglobalvar : function.funcinfo.defglobalvar){
                            if (callee.funcinfo.recursiveUseglobalvar.contains(defglobalvar)) {
                                pointer pointerForglobal=new I64Pointer(((global64Value)defglobalvar).getSize());
                                IRinst.prependInstruction(new load(((global64Value)defglobalvar).getSize(),basicBlock,(global64Value) defglobalvar,pointerForglobal,true));
                                IRinst.prependInstruction(new store(((global64Value) defglobalvar).getSize(), basicBlock, function.funcinfo.globaltemporal.get(defglobalvar),pointerForglobal, true,(global64Value) defglobalvar));
                            }
                        }
                        if (callee.funcinfo.recursiveDefglobalvar.isEmpty()) continue;
                        reloadSet.clear();
                        reloadSet.addAll(callee.funcinfo.recursiveDefglobalvar);
                        reloadSet.retainAll(useglobalvar);
                        for (globalvar globalvar : reloadSet)
                            IRinst.postpendInstruction(new load(((global64Value)globalvar).getSize(),basicBlock, (global64Value) globalvar, function.funcinfo.globaltemporal.get(globalvar), true));
                    }
                });
            }
        });


        irRoot.getFunctionMap().forEach((name, function) -> {
            if(function != irRoot.getFunctionMap().get("__init")) {
                back ret = function.getReturnInstList().get(0);
                // For the convention of Riscv, the pointer to the globalvariable must be read before store.
                for (globalvar globalvar:function.funcinfo.defglobalvar) {
                    pointer pointerForglobal=new I64Pointer(((global64Value)globalvar).getSize());
                    ret.prependInstruction(new load(((global64Value)globalvar).getSize(),ret.getCurrentBB(),(global64Value) globalvar,pointerForglobal,true));
                    ret.prependInstruction(new store(((global64Value)globalvar).getSize(),ret.getCurrentBB(), function.funcinfo.globaltemporal.get(globalvar),pointerForglobal, true,(global64Value) globalvar));
                }
            }
        });
    }




    private virtualregister getTemporal(globalvar useregister, Map<globalvar, virtualregister> globalTemporal) {
        virtualregister temporal = globalTemporal.get(useregister);
        if (temporal == null) {
            temporal = new I64Value(((global64Value) useregister).getName(),((global64Value)useregister).getSize());
            globalTemporal.put(useregister, temporal);
        }
        return temporal;
    }



}
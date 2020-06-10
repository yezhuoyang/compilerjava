package compilerjava.optimizer;


import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class inliner {
    private IRroot IRroot;
    private int inlinecalleeInstructionLimit =150;
    private int inlineMaxDepth = 5;

    private Map<function, Integer> functionInstructionCountMap = new HashMap<>();
    private Map<function, Integer> functioncalledCountMap = new HashMap<>();
    private Map<function, function> unlimitedfunctionWorks = new HashMap<>();
    private Map<function, Integer> functionFakerCountMap = new HashMap<>();
    private List<IRinst> tmpIRinstList = new ArrayList<>();

    private Map<basicblock, basicblock> basicblockFakerMap = new HashMap<>();
    private Map<operand, operand> registerFakerMap = new HashMap<>();

    public inliner(IRroot IRroot) {
        this.IRroot = IRroot;
    }

    public void run() {
        collectStatistics();
        nonRecursiveInline();
        recursiveInline();
    }

    private void collectStatistics() {
        IRroot.getFunctionMap().values().forEach(function -> functioncalledCountMap.put(function, 0));
        IRroot.getFunctionMap().values().forEach(function -> {
            int instructionCount = 0;
            for (basicblock basicblock : function.getReversePostOrderDFSBBList()) {
                for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                    instructionCount++;
                    if (IRinst instanceof call) {
                        function callee = ((call) IRinst).getCallee();
                        if (functioncalledCountMap.containsKey(callee))
                            functioncalledCountMap.put(callee, functioncalledCountMap.get((callee)) + 1);
                    }
                }
            }
            functionInstructionCountMap.put(function, instructionCount);
        });
    }

    private function functionFaker(function function) {
        int fakeCount = functionFakerCountMap.getOrDefault(function, 0);
        fakeCount = fakeCount + 1;
        functionFakerCountMap.put(function, fakeCount);
        function fakefunction = new function("fake_" + function.getName() + "_" + fakeCount);
        basicblockFakerMap.clear();
        registerFakerMap.clear();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> basicblockFakerMap.put(basicblock, new basicblock(fakefunction, basicblock.getName())));
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            basicblock fakeBB = basicblockFakerMap.get(basicblock);
            for(IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                if(IRinst == basicblock.tail)
                    fakeBB.finish(IRinst.getFakeInstruction(basicblockFakerMap, registerFakerMap));
                else
                    fakeBB.addInst(IRinst.getFakeInstruction(basicblockFakerMap, registerFakerMap));
        });
        fakefunction.setEntryBB(basicblockFakerMap.get(function.getEntryBB()));
        fakefunction.setExitBB(basicblockFakerMap.get(function.getExitBB()));
        fakefunction.setReferenceForClassMethod(function.getReferenceForClassMethod());
        fakefunction.setParameterList(function.getParameterList());
        return fakefunction;
    }

    private void traceON() {
        unlimitedfunctionWorks.clear();
        for (function function : IRroot.getFunctionMap().values()) {
            if (function.recursivecalleeset.contains(function)) {
                unlimitedfunctionWorks.put(function, functionFaker(function));
            }
        }
    }

    private boolean worthNonRecursiveInline(function callee) {
        if(functioncalledCountMap.get(callee) == null) return false;
        if(callee.recursivecalleeset.contains(callee)) return false;
        if(callee.getReferenceForClassMethod() != null) return false;
        return functionInstructionCountMap.get(callee) <= inlinecalleeInstructionLimit;
    }
    
    private boolean worthRecursiveInline(function callee) {
        if(functioncalledCountMap.get(callee) == null) return false;
        if(callee.getReferenceForClassMethod() != null) return false;
        return functionInstructionCountMap.get(callee) <= inlinecalleeInstructionLimit;
    }

    private void initregisterFakerMap() {
        registerFakerMap.clear();
        IRroot.getGlobalvarList().forEach(globalVariable -> registerFakerMap.put((global64Value) globalVariable, (global64Value) globalVariable));
        IRroot.getStaticStringList().forEach(staticString -> registerFakerMap.put(staticString.getBase(), staticString.getBase()));
    }

    private IRinst doInline(call callInst) {
        function caller = callInst.getCurrentBB().getCurrentfunction();
        function callee = unlimitedfunctionWorks.getOrDefault(callInst.getCallee(), callInst.getCallee());

        //split the block
        basicblock splitter = new basicblock(caller, "splitter");
        callInst.getCurrentBB().getSuccessors().forEach(successor -> successor.replacePredecessor(callInst.getCurrentBB(),splitter));

        tmpIRinstList.clear();
        for(IRinst IRinst = callInst.getCurrentBB().tail, nextInstruction; IRinst != callInst; IRinst = nextInstruction){
            nextInstruction = IRinst.getprevInstruction();
            callInst.getCurrentBB().removeInst();
            tmpIRinstList.add(IRinst);
        }

        for(int i = tmpIRinstList.size() - 1; i >= 0; i--){
            IRinst IRinst = tmpIRinstList.get(i);
            IRinst.setCurrentBB(splitter);
            if(IRinst instanceof back || IRinst instanceof jump || IRinst instanceof branch)
                splitter.finish(IRinst);
            else splitter.addInst(IRinst);
        }

        splitter.head.setprevInstruction(null);
        basicblockFakerMap.clear();
        initregisterFakerMap();
        basicblockFakerMap.put(callee.getEntryBB(), callInst.getCurrentBB());
        basicblockFakerMap.put(callee.getExitBB(), splitter);
        if(caller.getExitBB() == callInst.getCurrentBB())
            caller.setExitBB(splitter);
        for(int i = 0; i < callInst.getParameterList().size(); i++){
            register oldParameter = callee.getAllParameterList().get(i);
            virtualregister newParameter = new I64Value(callee.getAllParameterList().get(i).getSize());
            callInst.prependInstruction(new move(callInst.getCurrentBB(), callInst.getParameterList().get(i), newParameter));
            registerFakerMap.put(oldParameter, newParameter);
        }
        callInst.deleteSelf();
        for(basicblock realBB : callee.getReversePostOrderDFSBBList()){
            if (!basicblockFakerMap.containsKey(realBB))
                basicblockFakerMap.put(realBB, new basicblock(caller, "faker_" + realBB.getName()));
        }
        IRinst splitterHead = splitter.head;
        for(basicblock realBB : callee.getReversePostOrderDFSBBList()){
            basicblock fakeBB=basicblockFakerMap.get(realBB);
            for(IRinst IRinst = realBB.head; IRinst != null; IRinst = IRinst.getNextInstruction()){
                for(register register : IRinst.getUseregs())
                    if(!registerFakerMap.containsKey(register)){
                        registerFakerMap.put(register, new I64Value(register.getSize()));
                    }
                if (IRinst.getDefReg() != null) {
                    if (!registerFakerMap.containsKey(IRinst.getDefReg())) {
                        registerFakerMap.put(IRinst.getDefReg(), new I64Value(IRinst.getDefReg().getSize()));
                    }
                }
                if(fakeBB == splitter){
                    if(IRinst != realBB.tail) {
                        splitterHead.prependInstruction(IRinst.getFakeInstruction(basicblockFakerMap, registerFakerMap));
                    }
                } else {
                    if (IRinst == realBB.tail)
                        fakeBB.finish(IRinst.getFakeInstruction(basicblockFakerMap, registerFakerMap));
                    else fakeBB.addInst(IRinst.getFakeInstruction(basicblockFakerMap, registerFakerMap));
                }
            }
        }
        if (!callInst.getCurrentBB().isFinished())
            callInst.getCurrentBB().finish(new jump(callInst.getCurrentBB(), splitter));
        back returnInst = (back) callee.getExitBB().tail;
        if(returnInst.getReturnValue() != null)
            splitterHead.prependInstruction(new move(splitter, registerFakerMap.getOrDefault(returnInst.getReturnValue(), returnInst.getReturnValue()), callInst.getResult()));
        return splitter.head;
    }

    private void nonRecursiveInline() {
        for(boolean changed = true; changed;){
            changed = false;
            for(function function : IRroot.getFunctionMap().values()){
                for(basicblock basicblock : function.getReversePostOrderDFSBBList()){
                    for (IRinst IRinst = basicblock.head, nextInstruction; IRinst != null; IRinst = nextInstruction) {
                        nextInstruction = IRinst.getNextInstruction();
                        if(IRinst instanceof call && worthNonRecursiveInline(((call) IRinst).getCallee())) {
                            function callee = ((call) IRinst).getCallee();
                            changed = true;
                            nextInstruction = doInline((call) IRinst);
                            functionInstructionCountMap.put(function, functionInstructionCountMap.get(function) + functionInstructionCountMap.get(callee));
                            functioncalledCountMap.put(callee, functioncalledCountMap.get(callee) - 1);
                        }
                    }
                }
                function.recalcReversePostOrderDFSBBList();
            }
            for (Map.Entry<function, Integer> entry : functioncalledCountMap.entrySet()) {
                if(entry.getValue() == 0 && !entry.getKey().getName().equals("__init"))
                    IRroot.removefunction(entry.getKey());
            }
        }
        IRroot.getFunctionMap().values().forEach(function::updateCalleeSet);
        IRroot.calcRecursiveCalleeSet();
    }

    private void recursiveInline() {
        boolean changed = true;
        for(int i=0; i<inlineMaxDepth && changed; i++){
            changed = false;
            traceON();
            for(function function : IRroot.getFunctionMap().values()){
                for(basicblock basicblock : function.getReversePostOrderDFSBBList()) {
                    for(IRinst IRinst = basicblock.head, nextInstruction; IRinst != null; IRinst = nextInstruction) {
                        nextInstruction = IRinst.getNextInstruction();
                        if(IRinst instanceof call && worthRecursiveInline(((call) IRinst).getCallee())) {
                            function callee = ((call) IRinst).getCallee();
                            changed = true;
                            nextInstruction = doInline((call) IRinst);
                            functionInstructionCountMap.put(function, functionInstructionCountMap.get(function) + functionInstructionCountMap.get(callee));
                        }
                    }
                }
                function.recalcReversePostOrderDFSBBList();
            }
        }
        IRroot.getFunctionMap().values().forEach(function::updateCalleeSet);
        IRroot.calcRecursiveCalleeSet();
    }



}

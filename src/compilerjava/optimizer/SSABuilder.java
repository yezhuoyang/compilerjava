package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.*;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.*;

public class SSABuilder extends pass {
    Set<Integer> clearIndex = new HashSet<>();

    public SSABuilder(IRroot irRoot) {
        super(irRoot);
    }

    @Override
    public boolean run() {
        Irroot.getFunctionMap().forEach((name, function) -> {
            computeDominateTree(function);
            computeDominanceFrontier(function);
            findGlobalNames(function);
            insertphifunction(function);
            renameVariables(function);
        });
        return true;
    }

    private void findGlobalNames(function function) {
        List<basicblock> basicblockList = function.getReversePostOrderDFSBBList();
        Set<virtualregister> varKill = new HashSet<>();
        for (basicblock basicblock : basicblockList) {
            varKill.clear();
            for (IRinst IRinst = basicblock.head; ; IRinst = IRinst.getNextInstruction()){
                List<register> useregisters = IRinst.getUseregs();
                register defregister = IRinst.getDefReg();
                useregisters.forEach(useregister -> {
                    if (useregister instanceof virtualregister && !varKill.contains(useregister))
                        function.addglobals((virtualregister) useregister);
                    if (useregister instanceof virtualregister && ((virtualregister) useregister).info == null)
                        ((virtualregister) useregister).info = new virtualregister.registerInfo();
                });
                if (defregister instanceof virtualregister){
                    varKill.add((virtualregister) defregister);
                    if (((virtualregister) defregister).info == null)
                        ((virtualregister) defregister).info = new virtualregister.registerInfo();
                    ((virtualregister) defregister).info.defBB.add(basicblock);
                }
                if (!IRinst.hasNextInstruction()) break;
            }
        }
    }


    private void insertphifunction(function function) {
        Queue<basicblock> workList = new LinkedList<>();
        Set<basicblock> visited = new HashSet<>();
        function.getGlobals().forEach(x -> {
            workList.clear();
            visited.clear();
            workList.addAll(x.info.defBB);
            while(!workList.isEmpty()){
                basicblock b = workList.remove();
                b.DF.forEach(d -> {
                    if(!visited.contains(d)){
                        visited.add(d);
                        d.addFirst(new phi(d, x));
                        workList.add(d);
                    }
                });
            }
        });
    }

    private void rename(basicblock basicblock) {
        for(IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
            if (!(IRinst instanceof phi)) break;
            virtualregister dst = (virtualregister) ((phi) IRinst).getDst();
            ((phi) IRinst).setDst(dst.getSSARenameReg(dst.getNewId()));
        }
        for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
            if (!(IRinst instanceof phi)) {
                IRinst.renameUseRegForSSA();
                IRinst.renameDefRegForSSA();
            }
        for (basicblock successor : basicblock.getSuccessors()) {
            for (IRinst IRinst = successor.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                if (!(IRinst instanceof phi)) break;
                virtualregister origin = ((virtualregister) ((phi) IRinst).getDst()).getOrigin();
                virtualregister alias = origin.info.stack.empty() ? null : origin.getSSARenameReg(origin.info.stack.peek());
                ((phi) IRinst).getPaths().put(basicblock, alias);
            }
        }
        basicblock.DTSuccessors.forEach(this::rename);
        for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
            virtualregister dst = (virtualregister) IRinst.getDefReg();
            if (dst != null) {
                dst.getOrigin().info.stack.pop();
            }
        }
    }


    private void renameVariables(function function) {
        virtualregister _this = (virtualregister) function.getReferenceForClassMethod();
        boolean eliminateThis = false;
        if (_this != null) {
            if (_this.info == null) {
                //if _this is not used, eliminate its argument passing
                for (call call : function.callerInstList) call.setObjectPointer(null);
                function.setReferenceForClassMethod(null);
                eliminateThis = true;
            } else function.setReferenceForClassMethod(_this.getSSARenameReg(_this.getNewId()));
        }
        for (int i = 0; i < function.getParameterList().size(); i++) {
            virtualregister parameter = (virtualregister) function.getParameterList().get(i);
            if (parameter.info == null) {
                //if parameter is not used/def, eliminate its argument passing
                for (call call : function.callerInstList) call.getParameterList().set(i, null);
                function.getParameterList().set(i, null);
            } else function.getParameterList().set(i, parameter.getSSARenameReg(parameter.getNewId()));
        }
        function.getParameterList().removeAll(Collections.singleton(null));
        for (call call : function.callerInstList) call.getParameterList().removeAll(Collections.singleton(null));

        rename(function.getEntryBB());

        if (_this != null && !eliminateThis) _this.getOrigin().info.stack.pop();
        function.getParameterList().forEach(parameter -> ((virtualregister) parameter).getOrigin().info.stack.pop());
    }



}

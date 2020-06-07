package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.IR.IRroot;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class CommonSubexprElim extends pass {
    private Set<basicblock> visit = new HashSet<>();
    private HashMap<binarycmpHash, operand> binaryHashMap = new HashMap<>();

    public CommonSubexprElim(IRroot Irroot) {
        super(Irroot);
    }
    
    @Override
    boolean run() {
        changed = false;
        Irroot.getFunctionMap().values().forEach(function -> {
            visit.clear();
            function.getReversePostOrderDFSBBList().forEach(basicblock -> {
                if (!visit.contains(basicblock)) {
                    binaryHashMap.clear();
                    commonSubexpressionElimination(basicblock);
                }
            });
        });
        return changed;
    }

    private void commonSubexpressionElimination(basicblock basicblock) {
        visit.add(basicblock);
        for(IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
            if(IRinst instanceof binary){
                binarycmpHash binarycmpHash = new binarycmpHash((binary) IRinst);
                operand dst = binaryHashMap.get(binarycmpHash);
                if(dst != null){
                    changed = true;
                    ((binary) IRinst).previousResult = dst;
                    IRinst.replaceInstruction(new move(basicblock, dst, ((binary) IRinst).getDst()));
                }else{
                    ((binary) IRinst).previousResult = null;
                    binaryHashMap.put(binarycmpHash, ((binary) IRinst).getDst());
                    if (((binary) IRinst).isCommutative()) {
                        binarycmpHash binarycmpHashComm = new binarycmpHash((binary) IRinst);
                        binaryHashMap.put(binarycmpHashComm, ((binary) IRinst).getDst());
                    }
                }
            }else if(IRinst instanceof cmp){
                binarycmpHash binarycmpHash=new binarycmpHash((cmp) IRinst);
                operand dst = binaryHashMap.get(binarycmpHash);
                if (dst != null) {
                    changed = true;
                    ((cmp) IRinst).previousResult = dst;
                    IRinst.replaceInstruction(new move(basicblock, dst, ((cmp) IRinst).getDst()));
                } else {
                    ((cmp) IRinst).previousResult = null;
                    binaryHashMap.put(binarycmpHash, ((cmp) IRinst).getDst());
                    if (((cmp) IRinst).isCommutative()) {
                        binarycmpHash binarycmpHashComm = new binarycmpHash((cmp) IRinst);
                        binaryHashMap.put(binarycmpHashComm, ((cmp) IRinst).getDst());
                    }
                }
            }
        basicblock.getSuccessors().forEach(successor -> {
            if (successor.getPredecessors().size() == 1 && successor != basicblock)
                commonSubexpressionElimination(successor);
        });
        for (IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
            if (IRinst instanceof binary && ((binary) IRinst).previousResult == null) {
                binarycmpHash binarycmpHash = new binarycmpHash((binary) IRinst);
                binaryHashMap.remove(binarycmpHash);
                if (((binary) IRinst).isCommutative()) {
                    binarycmpHash binarycmpHashComm = new binarycmpHash((binary) IRinst);
                    binaryHashMap.remove(binarycmpHashComm);
                }
            } else if (IRinst instanceof cmp && ((cmp) IRinst).previousResult == null) {
                binarycmpHash binarycmpHash = new binarycmpHash((cmp) IRinst);
                binaryHashMap.remove(binarycmpHash);
                if (((cmp) IRinst).isCommutative()) {
                    binarycmpHash binarycmpHashComm = new binarycmpHash((cmp) IRinst);
                    binaryHashMap.remove(binarycmpHashComm);
                }
            }
    }

    static class binarycmpHash {
        String op, src1, src2;

        binarycmpHash(binary inst) {
            this.op = inst.getOp().toString();
            this.src1 = inst.getSrc1() instanceof immediate ? String.valueOf(((immediate) inst.getSrc1()).getImmediate()) : inst.getSrc1().toString();
            this.src2 = inst.getSrc2() instanceof immediate ? String.valueOf(((immediate) inst.getSrc2()).getImmediate()) : inst.getSrc2().toString();
        }

        binarycmpHash(cmp inst) {
            this.op = inst.getOp().toString();
            this.src1 = inst.getSrc1() instanceof immediate ? String.valueOf(((immediate) inst.getSrc1()).getImmediate()) : inst.getSrc1().toString();
            this.src2 = inst.getSrc2() instanceof immediate ? String.valueOf(((immediate) inst.getSrc2()).getImmediate()) : inst.getSrc2().toString();
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof binarycmpHash)
                return op.equals(((binarycmpHash) object).op) && src1.equals(((binarycmpHash) object).src1) && src2.equals(((binarycmpHash) object).src2);
            else
                return false;
        }

        @Override
        public int hashCode() {
            return op.hashCode() ^ src1.hashCode() ^ src2.hashCode();
        }
    }
}

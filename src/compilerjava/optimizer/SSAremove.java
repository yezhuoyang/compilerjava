package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.I64Value;
import compilerjava.IR.operand.immediate;
import compilerjava.IR.operand.operand;
import compilerjava.IR.operand.virtualregister;

import java.util.*;

public class SSAremove extends pass {
    private Map<basicblock, List<ParallelCopy>> parallelCopyInfo = new HashMap<>();

    public SSAremove(IRroot irRoot) {
        super(irRoot);
    }
    
    @Override
    public boolean run() {
        Irroot.getFunctionMap().values().forEach(function -> {
            removephifunction(function);
            function.recalcReversePostOrderDFSBBList();
            sequentializationParallelCopy(function);
        });
        return true;
    }

    private void removephifunction(function function) {
        function.getReversePostOrderDFSBBList().forEach(basicblock -> parallelCopyInfo.computeIfAbsent(basicblock, k -> new LinkedList<>()));
        Map<basicblock, List<ParallelCopy>> PCmap = new HashMap<>();
        List<basicblock> predecessors = new LinkedList<>();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            PCmap.clear();
            predecessors.clear();
            predecessors.addAll(basicblock.getPredecessors());
            predecessors.forEach(predecessor -> {
                if (predecessor.getSuccessors().size() > 1) {
                    basicblock pcBB = new basicblock(function, "parallel_copy");
                    pcBB.finish(new jump(pcBB, basicblock));
                    ((branch) predecessor.tail).replaceTarget(basicblock, pcBB);
                    predecessor.getSuccessors().remove(basicblock);
                    predecessor.getSuccessors().add(pcBB);
                    pcBB.getPredecessors().add(predecessor);
                    pcBB.getSuccessors().add(basicblock);
                    basicblock.getPredecessors().remove(predecessor);
                    basicblock.getPredecessors().add(pcBB);
                    parallelCopyInfo.computeIfAbsent(pcBB, k -> new LinkedList<>());
                    PCmap.put(predecessor, parallelCopyInfo.get(pcBB));
                } else
                    PCmap.put(predecessor, parallelCopyInfo.get(predecessor));
            });

            IRinst IRinst = basicblock.head;
            for (; IRinst instanceof phi; IRinst = IRinst.getNextInstruction()) {
                for (Map.Entry<basicblock, operand> entry : ((phi) IRinst).getPaths().entrySet()) {
                    basicblock comingbasicblock = entry.getKey();
                    operand comingRegister = entry.getValue();
                    //TODO
                    PCmap.get(comingbasicblock).add(new ParallelCopy((virtualregister) ((phi) IRinst).getDst(), comingRegister == null ? new immediate(0,4) : comingRegister));
                }
            }

            basicblock.head = IRinst;
            basicblock.head.setprevInstruction(null);
        });
    }
    
    private void sequentializationParallelCopy(function function) {
        Queue<virtualregister> ready = new LinkedList<>();
        Queue<virtualregister> to_do = new LinkedList<>();
        Map<virtualregister, virtualregister> pred = new HashMap<>();
        Map<virtualregister, virtualregister> loc = new HashMap<>();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            ready.clear();
            to_do.clear();
            pred.clear();
            loc.clear();
            //TODO
            virtualregister n = new I64Value(4);
            pred.put(n, null);
            parallelCopyInfo.get(basicblock).forEach(parallelCopy -> {
                if (parallelCopy.src instanceof virtualregister) {
                    loc.put(parallelCopy.dst, null);
                    pred.put((virtualregister) parallelCopy.src, null);
                }
            });
            parallelCopyInfo.get(basicblock).forEach(parallelCopy -> {
                if (parallelCopy.src instanceof virtualregister) {
                    virtualregister src = (virtualregister) parallelCopy.src;
                    loc.put(src, src);
                    pred.put(parallelCopy.dst, src);
                    to_do.add(parallelCopy.dst);
                }
            });
            parallelCopyInfo.get(basicblock).forEach(parallelCopy -> {
                if (parallelCopy.src instanceof virtualregister) {
                    if (loc.get(parallelCopy.dst) == null)
                        ready.add(parallelCopy.dst);
                }
            });
            while (!to_do.isEmpty()) {
                while (!ready.isEmpty()) {
                    virtualregister b = ready.poll();
                    virtualregister a = pred.get(b);
                    virtualregister c = loc.get(a);
                    basicblock.tail.prependInstruction(new move(basicblock, c, b));
                    loc.put(a, b);
                    if (a == c && pred.get(a) != null) ready.add(a);
                }
                virtualregister b = to_do.poll();
                if (b == loc.get(pred.get(b))) {
                    basicblock.tail.prependInstruction(new move(basicblock, b, n));
                    loc.put(b, n);
                    ready.add(b);
                }
            }
            parallelCopyInfo.get(basicblock).forEach(parallelCopy -> {
                if (parallelCopy.src instanceof immediate)
                    basicblock.tail.prependInstruction(new move(basicblock, parallelCopy.src, parallelCopy.dst));
            });
        });
    }

    static class ParallelCopy {
        virtualregister dst;
        operand src;

        ParallelCopy(virtualregister dst, operand src) {
            this.dst = dst;
            this.src = src;
        }
    }
}

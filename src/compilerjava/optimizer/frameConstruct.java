package compilerjava.optimizer;

import compilerjava.IR.basicblock;
import compilerjava.IR.*;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;

import java.util.HashSet;
import java.util.Set;

import static compilerjava.IR.operand.realregister.*;
import static compilerjava.IR.operand.realregister.vs0;


public class frameConstruct extends pass{

    private Set<realregister> MayMod=new HashSet<>();

    frameConstruct(IRroot irroot){
        super(irroot);
    }

    @Override
    boolean run(){
        changed = false;
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            calleeSave(function);
        });
        return changed;
    }


    private void calleeSave(function function){
        for(virtualregister vreg : calleeSaveVRegisters){
            if(vreg == vsp ||vreg == vzero)
                continue;
            calcMaymod(function);
            if(MayMod.contains(vreg.color)){
                stackdata stackloc = new stackdata(function);
                function.getEntryBB().addFirst(new store(config.registersize, function.getEntryBB(), vreg, stackloc));
                function.getExitBB().tail.prependInstruction(new load(config.registersize, function.getExitBB(), stackloc, vreg));
            }
        }
    }


    private void calcMaymod(function function){
        MayMod.clear();
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            for(IRinst IRinst = basicblock.head; IRinst != null; IRinst = IRinst.getNextInstruction()) {
                register defregister = IRinst.getDefReg();
                if(defregister != null) {
                    if(((virtualregister)defregister).color==null) assert false;
                    MayMod.add(((virtualregister)defregister).color);
                }
            }
        });
    }




}

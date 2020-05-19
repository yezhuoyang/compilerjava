package compilerjava.IR;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;

import java.util.*;


public class globalvarresolver{
    /*
    private IRroot irroot;


    public globalvarresolver(IRroot irroot){
        this.irroot=irroot;
    }


    public void run(){
        Map<register,register> renameMap=new HashMap<>();
        irroot.getFunctionMap().forEach((name,function)->{
            function.getReversePostOrderDFSBBList().forEach(BB-> {
                 for (IRinst irinst = BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
                     if((irinst instanceof load && ((load) irinst).isInsertedForGlobalVar())||
                             (irinst instanceof store && ((store) irinst).isInsertedForglobalvar()))
                         continue;
                     List<register> useRegisters=irinst.getUseregs();
                     register defreg=irinst.getDefReg();
                     if(!useRegisters.isEmpty()){
                         renameMap.clear();
                         for(register usereg:useRegisters)
                             if(usereg instanceof globalvar && !((global64Value)usereg).isString())
                                renameMap.put(usereg,getTemporal((globalvar)usereg,function.funcinfo.globaltemporal));
                             else
                                renameMap.put(usereg,usereg);
                             irinst.setUseregs(renameMap);
                     }
                     if(defreg instanceof globalvar && !((global64Value)defreg).isString()){
                            irinst.setDefReg(getTemporal((globalvar)defreg,function.funcinfo.globaltemporal));
                            function.funcinfo.defglobalvar.add((globalvar)defreg);
                     }
                 }
            });
            function.funcinfo.globaltemporal.forEach(((globalvar,temporal)->{
                function.getEntryBB().addFirst(new load(function.getEntryBB(),(global64Value)globalvar,temporal,true));
            }));







        });



    }

    private virtualregister getTemporal(){


    }












*/



}
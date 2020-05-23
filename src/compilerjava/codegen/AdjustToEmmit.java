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


public class AdjustToEmmit {

    private IRroot irroot;
    private LinkedList<register> parameterList=new LinkedList<>();
    private Map<virtualregister,virtualregister> calleeSaveVRTemporaryMap=new HashMap<>();


    public AdjustToEmmit(IRroot irroot){
        this.irroot=irroot;
    }

    public void run(){
            irroot.getFunctionMap().values().forEach(this::physicalRegisterConstraintResolve);
    }


    private void physicalRegisterConstraintResolve(function function) {
        //load function arguments
        parameterList.clear();
        if (function.getReferenceForClassMethod() != null)
            parameterList.add(function.getReferenceForClassMethod());
        parameterList.addAll(function.getParameterList());

        for (int i = 0; i < parameterList.size(); i++)
            if (i < 8)
                function.getEntryBB().head.prependInstruction(new move(function.getEntryBB(),argumentPassVRegisters.get(i), parameterList.get(i)));
            else {
                //TODO: Check callee convention
                function.getEntryBB().head.prependInstruction(new load(parameterList.get(i).getSize(),function.getEntryBB(),new stackdata(function,parameterList.size()-1-i), parameterList.get(i)));
            }

        //Save callee saved register to a local register
        for(virtualregister vreg:calleeSaveVRegisters){
            if(vreg==vsp||vreg==vgp||vreg==vtp||vreg==vzero||vreg==vs0)
                    continue;
            virtualregister newvreg=new I64Value("saved."+vreg.getName(),config.registersize);
            function.getEntryBB().head.prependInstruction(new move(function.getEntryBB(),vreg,newvreg));
            function.getExitBB().tail.prependInstruction(new move(function.getExitBB(),newvreg,vreg));
        }


        //modify return
        back returnInst = (back) function.getExitBB().tail;
        if (returnInst.getReturnValue() != null) {
            returnInst.prependInstruction(new move(function.getExitBB(), returnInst.getReturnValue(), va0));
            returnInst.setReturnValue(va0);
        }


        function.getReversePostOrderDFSBBList().forEach(BB->{
           for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
                if(irinst instanceof call){

                    call inst= (call) irinst;

                    function.argumentLimit=Math.max(function.argumentLimit,inst.getObjectPointer()==null?inst.getParameterList().size():inst.getParameterList().size()+1);

                    //pass arguments
                    int registerLimit=inst.getObjectPointer()==null?8:7;


                    int Size;
                    while(inst.getParameterList().size()>registerLimit){
                        Size=inst.getParameterList().getLast().getSize();
                        inst.prependInstruction(new store(Size,BB,inst.getParameterList().removeLast(),new stackdata(function)));
                    }


                    int cnt=0;
                    if(((call)irinst).getObjectPointer()!=null){
                        operand op=((call)irinst).getObjectPointer();
                        ((call)irinst).setObjectPointer(argumentPassVRegisters.get(cnt));
                        irinst.prependInstruction(new move(BB,op,argumentPassVRegisters.get(cnt++)));
                    }


                    for(int i=0;i<((call)irinst).getParameterList().size();i++){
                        operand op=((call)irinst).getParameterList().get(i);
                        ((call)irinst).getParameterList().set(i,argumentPassVRegisters.get(cnt));
                        irinst.prependInstruction(new move(BB,op,argumentPassVRegisters.get(cnt++)));
                    }

                    irinst.updateUseRegs();


                    if(((call)irinst).getResult()!=null){
                        irinst.postpendInstruction(new move(BB,va0,((call)irinst).getResult()));
                        ((call)irinst).setResult(va0);
                    }

                }else if(irinst instanceof alloc){

                    irinst.prependInstruction(new move(BB,((alloc)irinst).getSize(),va0));
                    irinst.postpendInstruction(new move(BB,va0,((alloc)irinst).getPointer()));

                }
           }
        });






        }



    }

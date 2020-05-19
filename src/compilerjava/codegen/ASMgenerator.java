package compilerjava.codegen;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;
import org.apache.commons.text.StringEscapeUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static compilerjava.IR.operand.realregister.*;



public class ASMgenerator implements IRvisitor{

    private IRroot irroot;
    private PrintStream out;
    private String indent="       ";
    private Map<storage, String> storageStringMap = new HashMap<>();
    private Map<basicblock, String> basicBlockStringMap = new HashMap<>();
    private Map<String, Integer> nameCountMap = new HashMap<>();

    private int currentpush;


    public ASMgenerator(IRroot irroot,PrintStream _out){
        this.irroot=irroot;
        this.out=_out;
    }


    private void printInst(String msg){
        out.println(indent+msg);
    }

    private void printLabel(String msg){
        out.println(msg);
    }

    @Override
    public void visit(IRroot irroot){
        for(globalvar _globalvar:  irroot.getGlobalvarList()){

        }
        for(Map.Entry<String,function> entry: irroot.getFunctionMap().entrySet()){
            entry.getValue().accept(this);
        }
    }



    private void stackframeinit(function func){
        basicblock entryBB=func.getEntryBB();
        basicblock exitBB=func.getExitBB();
        int stackframsize=(Math.max(func.argumentLimit-8,0)+func.temporaryCnt)* config.registersize;

        if(stackframsize!=0)
            entryBB.head.prependInstruction(new binary(entryBB,binary.Op.SUB,sp,new immediate(stackframsize),sp));

        entryBB.head.prependInstruction(new push(entryBB,s0));
        entryBB.head.prependInstruction(new push(entryBB,s1));
        entryBB.head.prependInstruction(new push(entryBB,s2));
        entryBB.head.prependInstruction(new push(entryBB,s3));
        entryBB.head.prependInstruction(new push(entryBB,s4));
        entryBB.head.prependInstruction(new push(entryBB,s5));
        entryBB.head.prependInstruction(new push(entryBB,s6));
        entryBB.head.prependInstruction(new push(entryBB,s7));
        entryBB.head.prependInstruction(new push(entryBB,s8));
        entryBB.head.prependInstruction(new push(entryBB,s9));
        entryBB.head.prependInstruction(new push(entryBB,s10));
        entryBB.head.prependInstruction(new push(entryBB,s11));

        if(stackframsize!=0)
            exitBB.tail.prependInstruction(new binary(entryBB,binary.Op.ADD,sp,new immediate(stackframsize),sp));

        entryBB.head.prependInstruction(new pop(entryBB,s0));
        entryBB.head.prependInstruction(new pop(entryBB,s1));
        entryBB.head.prependInstruction(new pop(entryBB,s2));
        entryBB.head.prependInstruction(new pop(entryBB,s3));
        entryBB.head.prependInstruction(new pop(entryBB,s4));
        entryBB.head.prependInstruction(new pop(entryBB,s5));
        entryBB.head.prependInstruction(new pop(entryBB,s6));
        entryBB.head.prependInstruction(new pop(entryBB,s7));
        entryBB.head.prependInstruction(new pop(entryBB,s8));
        entryBB.head.prependInstruction(new pop(entryBB,s9));
        entryBB.head.prependInstruction(new pop(entryBB,s10));
        entryBB.head.prependInstruction(new pop(entryBB,s11));
    }



    @Override
    public void visit(function func){
        currentpush=0;
        func.getReversePostOrderDFSBBList().forEach(this::visit);
    }


    @Override
    public void visit(staticstring sstring){
        printInst(".asciz\t"+sstring.getVal());
    }

    @Override
    public void visit(basicblock BB){
        printLabel(getLabel(BB)+":");
        for(IRinst inst=BB.head;inst!=null;inst=inst.getNextInstruction()){
            inst.accept(this);
        }
    }


    @Override
    public void visit(alloc inst){
        printInst("call malloc");
    }


    @Override
    public void visit(binary inst){
        String op=null;
        switch(inst.getOp()){
            case DIV:
                op="div";
            case MOD:
                op="mod";
            case MUL:
                op="mul";
                break;
            case BITR:
                op=(inst.getSrc2() instanceof immediate)? "srai":"sra";
                break;
            case BITL:
                op=(inst.getSrc2() instanceof immediate)? "srli":"srl";
                break;
            case SUB:
                 op="sub";
                 break;
            case ADD:
                op=(inst.getSrc2() instanceof immediate)? "addi":"add";
                break;
            case XOR:
                op="xor";
                op=(inst.getSrc2() instanceof immediate)? "xori":"xor";
                break;
            case BITAND:
                op=(inst.getSrc2() instanceof immediate)? "andi":"add";
                break;
            case BITOR:
                op=(inst.getSrc2() instanceof immediate)? "xori":"xor";
                break;
        }
        out.print(indent+op+" ");
        inst.getSrc1().accept(this);
        out.print(", ");
        inst.getSrc2().accept(this);
        out.println();
    }


    @Override
    public void visit(branch inst){
        String op=null, inverseOp=null;
        switch (inst.defOfCond.getOp()){
            case LT:
                  op="blt";
                  inverseOp="bge";
                  break;
            case LEQ:
                  op="ble";
                  inverseOp="bgt";
                  break;
            case EQ:
                  op="beq";
                  inverseOp="bne";
                  break;
            case GEQ:
                  op="bge";
                  inverseOp="blt";
                  break;
            case GT:
                  op="bgt";
                  inverseOp="ble";
                  break;
            case NEQ:
                op="bne";
                inverseOp="beq";
                break;
        }
        if(inst.getThenBB().postOrderNumber==inst.getCurrentBB().postOrderNumber-1){
            out.print(indent+inverseOp+" ");
            inst.defOfCond.getSrc1().accept(this);
            out.print(", ");
            inst.defOfCond.getSrc2().accept(this);
            out.print(",  "+getLabel(inst.getElseBB()));
        }else{
            out.print(indent+op);
            out.println(" "+getLabel(inst.getThenBB()));
        }
    }

    @Override
    public void visit(call inst){
        printInst("call"+inst.getCallee().getName());
    }


    @Override
    public void visit(cmp inst){
        out.print(indent+"cmp ");
        inst.getSrc1().accept(this);
        out.print(", ");
        inst.getSrc2().accept(this);
    }

    @Override
    public void visit(jump inst){
        printInst("j\t"+getLabel(inst.getDestBB()));
    }


    @Override
    public void visit(load inst){
        if(!(inst.getSrc() instanceof global64Value)){
            out.print("lw ");
            inst.getSrc().accept(this);
            out.print(",");
            inst.getDst().accept(this);
        }
        else{
            out.print("la ");
            inst.getDst().accept(this);
            out.print(","+((global64Value)inst.getDst()).getName());
        }
    }


    @Override
    public void visit(move inst){
        if(inst.getSrc() instanceof immediate){
            out.print("li\t");
        }
        else {
            out.print("mv\t");
        }
        inst.getDst().accept(this);
        out.print(",");
        inst.getSrc().accept(this);
    }


    @Override
    public void visit(back inst){
        printInst("ret");
    }



    @Override
    public void visit(store inst){
            out.print("sw ");
            inst.getSrc().accept(this);
            out.print(",");
            inst.getDst().accept(this);
    }


    @Override
    public void visit(unary inst){
    }


    @Override
    public void visit(phi inst){
    }

    @Override
    public void visit(lea inst){
    }


    @Override
    public void visit(push inst){



    }

    @Override
    public void visit(pop inst){



    }


    @Override
    public void visit(storage stor){
        if(stor instanceof register) out.print(getName(stor));
        else if(stor instanceof stackdata){

        }

    }


    public String getName(storage stor){


    }



    @Override
    public void visit(immediate imme){
        out.print(imme.getImmediate());
    }


    private String getLabel(basicblock BB){
        if(BB==null)return "";
        String name=basicBlockStringMap.get(BB);
        return name!=null? name:createLabel(BB,BB.getName());
    }


    private String createLabel(basicblock BB,String name){
        if(BB.getName().equals("__init_entry")){
            String newname="main";
            basicBlockStringMap.put(BB,newname);
            return newname;
        }
        int cnt=nameCountMap.getOrDefault(name,0)+1;
        nameCountMap.put(name,cnt);
        String newname=name+"_"+cnt;
        basicBlockStringMap.put(BB,newname);
        return newname;
    }







}

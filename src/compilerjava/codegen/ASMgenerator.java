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
    private function currentfunc;

    public ASMgenerator(IRroot irroot,PrintStream _out){
        this.irroot=irroot;
        this.out=_out;
    }

    public void run() throws IOException{
        irroot.getFunctionMap().values().forEach(this::stackframeinit);
        visit(irroot);
    }

    private void printGlobal(global64Value _globalvar){
        out.println(indent+".globl\t"+getName(_globalvar)+"\t\t\t\t\t\t#@"+getName(_globalvar));
        if(_globalvar.getSize()==4)
            out.println(indent+".p2align\t2");
        out.println(getName(_globalvar)+":");
        if(_globalvar.getSize()==1){
            out.println(indent+".byte\t0");
        }else if(_globalvar.getSize()==4){
            out.println(indent+".word\t0");
        }
    }

    private void printStaticstring(staticstring _staticstring){
        out.println(indent+".globl\t"+getName(_staticstring)+"\t\t\t\t\t\t#@"+getName(_staticstring));
        out.println(getName(_staticstring)+":");
        out.println(indent+".asciz\t"+_staticstring.getVal());
    }

    private void printInst(String msg){
        out.println(indent+msg);
    }

    private void printLabel(String msg){
        out.println(msg);
    }

    @Override
    public void visit(IRroot irroot){
        out.println(indent+".text\n");

        //ReverseCFGPostOrderNumber is used in codegen.
        for(Map.Entry<String,function> entry: irroot.getFunctionMap().entrySet()){
            currentfunc=entry.getValue();
            entry.getValue().calcReverseCFGPostOrderNumber();
        }

        for(Map.Entry<String,function> entry: irroot.getFunctionMap().entrySet()){
            currentfunc=entry.getValue();
            entry.getValue().accept(this);
        }
        out.println(indent+".section\t.sdata,\"aw\",@progbits");
        for(globalvar _globalvar:  irroot.getGlobalvarList()){
            printGlobal((global64Value)_globalvar);
        }
        for(staticstring _staticstring:  irroot.getStaticStringList()){
            printStaticstring(_staticstring);
        }
    }


    private void stackframeinit(function func){
        basicblock entryBB=func.getEntryBB();
        basicblock exitBB=func.getExitBB();
        int stackframsize=func.getStackSize();
        if(stackframsize!=0)
            entryBB.head.prependInstruction(new binary(entryBB,binary.Op.ADD,vsp,new immediate(-stackframsize,config.intsize),vsp));

        if(stackframsize!=0)
            exitBB.tail.prependInstruction(new binary(exitBB,binary.Op.ADD,vsp,new immediate(stackframsize,config.intsize),vsp));
    }


    @Override
    public void visit(function func){
        currentpush=0;
        out.println(indent+".globl\t"+getLabel(func.getEntryBB())+"\t\t\t\t\t # -- Begin function "+getLabel(func.getEntryBB()));
        out.println(indent+".p2align\t2");
        out.println(indent+".type\t"+getLabel(func.getEntryBB())+",@function");
        func.getReversePostOrderDFSBBList().forEach(this::visit);
        out.println("\t\t\t\t\t\t # -- End function");
    }


    @Override
    public void visit(staticstring sstring){
        out.println(".global\t"+getName(sstring)+"\t\t\t\t\t#@"+getName(sstring));
        out.println(getName(sstring)+":");
        out.println(".asciz\t"+sstring.getVal());
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
        printInst("call"+'\t'+"malloc");
    }


    @Override
    public void visit(binary inst){
        String op=null;
        switch(inst.getOp()){
            case DIV:
                op="div";break;
            case MOD:
                op="rem";break;
            case MUL:
                op="mul";
                break;
            case BITR:
                op=(inst.getSrc2() instanceof immediate)? "srai":"sra";
                break;
            case BITL:
                op=(inst.getSrc2() instanceof immediate)? "slli":"sll";
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
        out.print(indent+op+'\t');
        inst.getDst().accept(this);
        out.print(", ");
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
            out.print(indent+inverseOp+"\t");
            inst.defOfCond.getSrc1().accept(this);
            out.print(", ");
            inst.defOfCond.getSrc2().accept(this);
            out.println(",  "+getLabel(inst.getElseBB()));
        }else{
            out.print(indent+op+"\t");
            inst.defOfCond.getSrc1().accept(this);
            out.print(", ");
            inst.defOfCond.getSrc2().accept(this);
            out.println(", "+getLabel(inst.getThenBB()));
        }
    }


    @Override
    public void visit(call inst){
        if(irroot.builtinfunction.contains(inst.getCallee())){
            printInst("call"+'\t'+inst.getCallee().getName());
        }
        else
            printInst("call"+'\t'+getLabel(inst.getCallee().getEntryBB()));
    }


    @Override
    public void visit(cmp inst){
        if (inst.getDst() != null) {
            out.print(indent);
            switch (inst.getOp()) {
                case EQ:
                    if(inst.getSrc2() instanceof immediate)
                        out.print("xori"+'\t');
                    else
                        out.print("xor"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getSrc1().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.println();
                    out.print(indent+"sltiu"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getDst().accept(this);
                    out.print(",1");
                    out.println();
                    break;
                case NEQ:
                    if(inst.getSrc2() instanceof immediate)
                        out.print("xori"+'\t');
                    else
                        out.print("xor"+'\t');
                    inst.getSrc1().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.print(",");
                    inst.getDst().accept(this);
                    out.println();
                    out.print("sltu"+'\t');
                    inst.getDst().accept(this);
                    out.print(",zero,");
                    inst.getDst().accept(this);
                    out.println();
                    break;
                case LT:
                    if(inst.getSrc2() instanceof immediate)
                        out.print("slti"+'\t');
                    else
                        out.print("slt"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getSrc1().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.println();
                    break;
                //TODO
                case LEQ:
                    if(inst.getSrc2() instanceof immediate)
                        out.print("slti"+'\t');
                    else
                        out.print("slt"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getSrc1().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.println();
                    out.print(indent+"xori"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getDst().accept(this);
                    out.println(", 1");
                    break;
                case GT:
                    if(inst.getSrc1() instanceof immediate)
                        out.print("slti"+'\t');
                    else
                        out.print("slt"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.print(",");
                    inst.getSrc1().accept(this);
                    out.println();
                    break;
                case GEQ:
                    if(inst.getSrc1() instanceof immediate)
                        out.print("slti"+'\t');
                    else
                        out.print("slt"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getSrc2().accept(this);
                    out.print(",");
                    inst.getSrc1().accept(this);
                    out.println();
                    out.print(indent+"xori"+'\t');
                    inst.getDst().accept(this);
                    out.print(",");
                    inst.getDst().accept(this);
                    out.println(", 1");
                    break;
                default:
                    assert false;
            }
        }
    }


    @Override
    public void visit(jump inst){
        printInst("j\t"+getLabel(inst.getDestBB()));
    }

    @Override
    public void visit(load inst){
        String op="";
        switch (((load)inst).getSize()) {
            case 1:
                op = "lb";
                break;
            case 2:
                op = "lh";
                break;
            case 4:
                op = "lw";
                break;
            default:
                op = "FFF";
                break;
        }
        if(inst.getSrc() instanceof globalvar &&((global64Value)inst.getSrc()).isString()){
            op="la";
            out.print(indent+op+"\t");
            inst.getDst().accept(this);
            out.print(", ");
            out.print(getName(((global64Value)inst.getSrc()).getReferencedstring()));
            out.println();
            return;
        }
        // For global var, load means load the address
        if(inst.getSrc() instanceof globalvar && inst.isLoadtoPointer()){
            op="lui";
            out.print(indent+op+"\t");
            inst.getDst().accept(this);
            out.print(", ");
            out.print("%hi(");
            visit((global64Value)inst.getSrc());
            out.print(")");
            out.println();
            return;
        }
        out.print(indent+op+"\t");
        inst.getDst().accept(this);
        out.print(", ");
        if(inst.getSrc() instanceof register&& !(inst.getSrc() instanceof global64Value)){
            out.print("0(");
            inst.getSrc().accept(this);
            out.print(")");
        }
        else{
            inst.getSrc().accept(this);
        }
        out.println();
    }

    @Override
    public void visit(move inst){
        String op="";
        if(inst.getSrc() instanceof immediate){
            op="li";
        }
        else if(inst.getSrc() instanceof globalvar &&((global64Value)inst.getSrc()).isString()){
            op="la";
            out.print(indent+op+"\t");
            inst.getDst().accept(this);
            out.print(", ");
            out.print(getName(((global64Value)inst.getSrc()).getReferencedstring()));
            out.println();
            return;
        }
        else {
            op="mv";
        }
        out.print(indent+op+"\t");
        inst.getDst().accept(this);
        out.print(", ");
        inst.getSrc().accept(this);
        out.println();
    }


    @Override
    public void visit(back inst){
        printInst("ret");
    }


    @Override
    public void visit(store inst){
            String op="";
            switch (((store)inst).getSize()){
                case 1:
                    op="sb";break;
                case 2:
                    op="sh";break;
                case 4:
                    op="sw";break;
                default:assert false;
            }
            out.print(indent+op+"\t");
            inst.getSrc().accept(this);
            out.print(", ");
            if(inst.isInsertedForglobalvar()){
                out.print("%lo(");
                inst.getStoreforglobal().accept(this);
                out.print(")(");
                inst.getDst().accept(this);
                out.print(")");
            }
            else if(inst.getDst() instanceof register){
                out.print("0(");
                inst.getDst().accept(this);
                out.print(")");
            }
            else
                inst.getDst().accept(this);
            out.println();
    }

    @Override
    public void visit(unary inst){
        String op="";
        switch (((unary)inst).getOp()){
            case NEG:
                op="neg";
                break;
            case NOT:
                op="not";
                break;
            default:
                assert false;
        }
        out.print(indent+op+"\t");
        inst.getDst().accept(this);
        out.print(", ");
        inst.getSrc().accept(this);
        out.println("");
    }

    @Override
    public void visit(phi inst){
    }

    @Override
    public void visit(storage stor){
        if(stor instanceof stackdata){
            out.print(((stackdata)stor).toString());
            return;
        }
        if(stor instanceof register){
            out.print(getName(stor));
            return;
        }else if(stor instanceof memory){
                visit(((memory)stor).getOffset());
                out.print("(");
                visit(((memory)stor).getBase());
                out.print(')');
                return;
        }
        out.print("FUCK!");
    }


    private String createName(storage stor, String name){
        int cnt=nameCountMap.getOrDefault(name,0)+1;
        nameCountMap.put(name,cnt);
        String newName=name+"_"+cnt;
        storageStringMap.put(stor,newName);
        return newName;
    }


    public String getName(storage stor){
        if(stor instanceof realregister) return stor.getName();
        else if(stor instanceof virtualregister){
            if(!(stor instanceof globalvar)){
                    return ((virtualregister) stor).color.getName();
            }else{
                   String name=storageStringMap.get(stor);
                   name=name!=null? name : createName(stor,stor.getName()==null ? "t" :stor.getName());
                   return name;
            }
        }
        else if(stor instanceof staticstring){
            String name=storageStringMap.get(stor);
            name=name!=null? name : createName(stor,stor.getName()==null ? "str" :stor.getName());
            return name;
        }
        return "FUCKStorage!";
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

package compilerjava.IR;

import compilerjava.IR.basicblock;
import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.IRvisitor;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import org.apache.commons.text.StringEscapeUtils;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;


public class IRprinter implements IRvisitor{
    private PrintStream out;
    private Map<storage,String> storageStringMap=new HashMap<>();
    private Map<basicblock,String> basicblockStringMap=new HashMap<>();
    private Map<String,Integer> nameCountMap=new HashMap<>();

    private boolean printColor=false;
    private boolean printDefUse=false;

    public void printColor(){
        printColor=true;
    }

    public void noColor(){
        printColor=false;
    }

    public IRprinter(PrintStream out){
        this.out=out;
    }

    public IRprinter(PrintStream out,boolean printColor){
        this.out=out;
        this.printColor=printColor;
    }

    public IRprinter(PrintStream out,boolean printColor,boolean printDefUse){
        this.out=out;
        this.printColor=printColor;
        this.printDefUse=printDefUse;
    }


    @Override
    public void visit(IRroot irroot){
        irroot.getGlobalvarList().forEach(globalvar -> out.println("@"+getName((storage)globalvar)));
        irroot.getStaticStringList().forEach(staticstring -> {
            out.println("@"+getName(staticstring.getBase())+" = " +staticstring.getVal());
        });
        if(!irroot.getGlobalvarList().isEmpty()||!irroot.getStaticStringList().isEmpty())out.println();
        for(Map.Entry<String,function>entry:irroot.getFunctionMap().entrySet())entry.getValue().accept(this);
    }


    @Override
    public void visit(function func){
        boolean isVoid=func.getReturnInstList().get(0).getReturnValue()==null;
        out.print("define "+(isVoid?"void ":"i64 ")+"@"+func.getName()+" ");
        if(func.getReferenceForClassMethod()!=null)func.getReferenceForClassMethod().accept(this);
        out.print(" ");
        func.getParameterList().forEach(x->{
            x.accept(this);
            out.print(" ");
        });
        out.println("{");
        func.getReversePostOrderDFSBBList().forEach(this::visit);
        out.println("}");
        out.println();
    }

    @Override
    public void visit(staticstring sstring){
    }

    @Override
    public void visit(basicblock BB){
        out.println(getLabel(BB)+":");
        for(IRinst irinst=BB.head;irinst!=null;irinst=irinst.getNextInstruction()){
            out.print("   ");
            irinst.accept(this);
            if(printDefUse){
                out.print("     //<def>");
                irinst.calcUseAndDef();
                for(virtualregister def:irinst.getDef())
                    out.print(" "+getName(def));
                out.println();
                out.print("      //<use>");
                for(virtualregister use:irinst.getUse())
                    out.print(" "+getName(use));
                out.println();
            }
        }
        //out.println();
    }

    @Override
    public void visit(alloc inst){
        inst.getPointer().accept(this);
        out.print(" = alloc ");
        inst.getSize().accept(this);
        out.println();
    }

    @Override
    public void visit(binary inst){
        String op=null;
        switch (inst.getOp()){
            case ADD:
                op="add";
                break;
            case SUB:
                op="sub";
                break;
            case MUL:
                op="mul";
                break;
            case DIV:
                op="div";
                break;
            case MOD:
                op="mod";
                break;
            case BITL:
                op="shl";
                break;
            case BITR:
                op="shr";
                break;
            case BITAND:
                op="and";
                break;
            case BITOR:
                op="or";
                break;
            case XOR:
                op="xor";
                break;
        }
        inst.getDst().accept(this);
        out.printf(" = %s ",op);
        inst.getSrc1().accept(this);
        out.print(" ");
        inst.getSrc2().accept(this);
        out.println();
    }

    @Override
    public void visit(branch inst){
        if(inst.defOfCond!=null){
            inst.defOfCond.accept(this);
            String op=null;
            switch(inst.defOfCond.getOp()){
                case LT:
                    op="slt";
                    break;
                case LEQ:
                    op="sle";
                    break;
                case EQ:
                    op="seq";
                    break;
                case GEQ:
                    op="sge";
                    break;
                case GT:
                    op="sgt";
                    break;
                case NEQ:
                    op="sne";
                    break;
            }
            out.print("   ");
            out.print("br  "+op);
            out.println(" "+getLabel(inst.getThenBB())+" "+getLabel(inst.getElseBB()));
        }else{
            out.print("br ");
            inst.getCond().accept(this);
            out.println(" "+getLabel(inst.getThenBB())+" "+getLabel(inst.getElseBB()));
        }
    }

    @Override
    public void visit(call inst){
        if(inst.getResult()!=null){
            inst.getResult().accept(this);
            out.print(" = call ");
        }else out.print("call ");
        out.print(inst.getCallee().getName()+" ");
        if(inst.getObjectPointer()!=null){
            inst.getObjectPointer().accept(this);
            out.print(" ");
        }
        inst.getParameterList().forEach(x->{
            x.accept(this);
            out.print(" ");
        });
        out.println();
    }

    @Override
    public void visit(cmp inst){
        if(inst.getDst()==null){
            out.print("cmp ");
            inst.getSrc1().accept(this);
            out.print(" ");
            inst.getSrc2().accept(this);
            out.println();
        }else{
            String op=null;
            switch (inst.getOp()){
                case LT:
                       op="slt";
                       break;
                case LEQ:
                       op="sle";
                       break;
                case EQ:
                       op="seq";
                       break;
                case GEQ:
                       op="sge";
                       break;
                case GT:
                       op="sgt";
                       break;
                case NEQ:
                       op="sne";
                       break;
            }
            inst.getDst().accept(this);
            out.print(" = "+op+' ');
            inst.getSrc1().accept(this);
            out.print(" ");
            inst.getSrc2().accept(this);
            out.println();
        }
    }

    @Override
    public void visit(jump inst){
        out.println("jump "+getLabel(inst.getDestBB()));
    }

    @Override
    public void visit(load inst){
        inst.getDst().accept(this);
        out.print(" = load ");
        inst.getSrc().accept(this);
        out.println();
    }

    @Override
    public void visit(move inst){
        inst.getDst().accept(this);
        out.print(" = move ");
        inst.getSrc().accept(this);
        out.println();
    }

    @Override
    public void visit(back inst){
         out.print("ret ");
         if(inst.getReturnValue()!=null)inst.getReturnValue().accept(this);
         out.println();
    }

    @Override
    public void visit(store inst){
        out.print("store ");
        inst.getSrc().accept(this);
        out.print(" ");
        inst.getDst().accept(this);
        out.println();
    }

    @Override
    public void visit(unary inst){
        String op=null;
        switch(inst.getOp()){
            case BITNOT:
                op="not";
                break;
            case NEG:
                op="neg";
                break;
            case SUF_ADD:
                op="inc";
                break;
            case SUF_SUB:
                op="dec";
                break;
            case POS:
                op="pos";
                break;
            case NOT:
                throw new RuntimeException();
        }
        inst.getDst().accept(this);
        out.print(" = "+op+" ");
        inst.getSrc().accept(this);
        out.println();
    }

    @Override
    public void visit(phi inst){
        inst.getDst().accept(this);
        out.print(" =phi ");
        inst.getPaths().forEach((BB,op)->{
            out.print(getLabel(BB)+": ");
            if(op!=null){
                op.accept(this);
            }else{
                out.print("undef");
            }
            out.print(" ");
        });
        out.println();
    }

    @Override
    public void visit(storage stor){
        if(stor instanceof register){
            if(stor instanceof globalvar) out.print("@" +getName(stor));
            else out.print("%"+getName(stor));
        }else if(stor instanceof memory){
            if(((memory)stor).getBase()!=null)
                visit(((memory)stor).getBase());
            else
                out.print("null");
            out.print(" ");
            if(((memory)stor).getOffset()!=null){
                visit(((memory)stor).getOffset());
                //out.print(" ");
                //visit(((memory)stor).getScale());
            }else{
                out.print("null 0");
            }
            out.print(" ");
            visit(((memory)stor).getOffset());
        }
    }


    @Override
    public void visit(immediate imme){
        out.print(imme.getImmediate());
    }


    private String createName(storage _storage,String name){
        int cnt=nameCountMap.getOrDefault(name,0)+1;
        nameCountMap.put(name,cnt);
        String newName=name+"_"+cnt;
        storageStringMap.put(_storage,newName);
        return newName;
    }


    public String getName(storage _storage){
        if(_storage instanceof virtualregister){
            if( ((virtualregister)_storage).color!=null&&printColor&&!(_storage instanceof globalvar)){
                return ((virtualregister)_storage).color.getName();
            }else{
                String name=storageStringMap.get(_storage);
                name=name!=null?name:createName(_storage,_storage.getName()==null?"t":_storage.getName());
                return name;
            }
        }else if(_storage instanceof realregister){
            return _storage.getName();
        } else return "None";
    }


    private String createLabel(basicblock BB,String name){
        int cnt=nameCountMap.getOrDefault(name,0)+1;
        nameCountMap.put(name,cnt);
        String newName=name+"_"+cnt;
        basicblockStringMap.put(BB,newName);
        return newName;
    }


    private String getLabel(basicblock BB){
        if(BB==null)return "";
        String name=basicblockStringMap.get(BB);
        return name!=null? name:createLabel(BB,BB.getName());
    }


    public void printAllBlock(IRroot irroot){
        irroot.getFunctionMap().values().forEach(function -> {
            System.out.println("=============================Now print  "+function.getName()+":======================");
            printBlockstructure(function);
            System.out.println("===================================Print done!=======================================");
        });
    }


    public void printBlockstructure(function function){
        function.getReversePostOrderDFSBBList().forEach(basicblock -> {
            System.out.println("---------------------------"+getLabel(basicblock)+":"+"----------------------------");
            System.out.print("Predecessor"+":     ");
            basicblock.getPredecessors().forEach(predecessor->{
                System.out.print(getLabel(predecessor)+",   ");
            });
            System.out.println(" ");
            System.out.print("Sucessors"+":     ");
            basicblock.getSuccessors().forEach(sucessor->{
                System.out.print(getLabel(sucessor)+",   ");
            });
            System.out.println(" ");
        });
    }

}

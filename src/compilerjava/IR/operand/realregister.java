package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


public class realregister extends register{
    public static final realregister rax=new realregister("rax","al",true);
    public static final realregister rcx=new realregister("rcx","cl",true);
    public static final realregister rdx=new realregister("rdx","dl",true);
    public static final realregister rbx=new realregister("rbx","bl",false);
    public static final realregister rsi=new realregister("rsi","sil",true);
    public static final realregister rdi=new realregister("rdi","dil",true);
    public static final realregister rsp=new realregister("rsp","spl",true);
    public static final realregister rbp=new realregister("rbp","bpl",false);
    public static final realregister r8=new realregister("r8","r8b",true);
    public static final realregister r9=new realregister("r9","r9b",true);
    public static final realregister r10=new realregister("r10","r10b",true);
    public static final realregister r11=new realregister("r11","r11b",true);
    public static final realregister r12=new realregister("r12","r12b",false);
    public static final realregister r13=new realregister("r13","r13b",false);
    public static final realregister r14=new realregister("r14","r14b",false);
    public static final realregister r15=new realregister("r15","r15b",false);

    public static final Set<realregister> callerSaveRegisters=new HashSet<>();
    public static final Set<realregister> calleeSaveRegisters=new HashSet<>();
    public static final LinkedList<realregister> argumentPassRegisters=new LinkedList<>();
    public static final LinkedList<realregister> allRegisters=new LinkedList<>();

    public static final virtualregister vrax=new I64Value("vrax",rax);
    public static final virtualregister vrcx=new I64Value("vrcx",rcx);
    public static final virtualregister vrdx=new I64Value("vrdx",rdx);
    public static final virtualregister vrbx=new I64Value("vrbx",rbx);
    public static final virtualregister vrsi=new I64Value("vrsi",rsi);
    public static final virtualregister vrdi=new I64Value("vrdi",rdi);
    public static final virtualregister vrsp=new I64Value("vrsp",rsp);
    public static final virtualregister vrbp=new I64Value("vrbp",rbp);
    public static final virtualregister vr8=new I64Value("vr8",r8);
    public static final virtualregister vr9=new I64Value("vr9",r9);
    public static final virtualregister vr10=new I64Value("vr10",r10);
    public static final virtualregister vr11=new I64Value("vr11",r11);
    public static final virtualregister vr12=new I64Value("vr12",r12);
    public static final virtualregister vr13=new I64Value("vr13",r13);
    public static final virtualregister vr14=new I64Value("vr14",r14);
    public static final virtualregister vr15=new I64Value("vr15",r15);

    public static final Set<virtualregister> callerSaveVRegisters=new HashSet<>();
    public static final Set<virtualregister> calleeSaveVRegisters=new HashSet<>();
    public static final LinkedList<virtualregister> argumentPassVRegisters=new LinkedList<>();
    public static final LinkedList<virtualregister> allVRegisters=new LinkedList<>();


    static{
        argumentPassVRegisters.add(vrdi);
        argumentPassVRegisters.add(vrsi);
        argumentPassVRegisters.add(vrdx);
        argumentPassVRegisters.add(vrcx);
        argumentPassVRegisters.add(vr8);
        argumentPassVRegisters.add(vr9);
        for(virtualregister vregister:argumentPassVRegisters)
            argumentPassRegisters.add(vregister.color);
        allVRegisters.add(vrax);
        allVRegisters.add(vrcx);
        allVRegisters.add(vrdx);
        allVRegisters.add(vrbx);
        allVRegisters.add(vrsi);
        allVRegisters.add(vrdi);
        allVRegisters.add(vrsp);
        allVRegisters.add(vrbp);
        allVRegisters.add(vr8);
        allVRegisters.add(vr9);
        allVRegisters.add(vr10);
        allVRegisters.add(vr11);
        allVRegisters.add(vr12);
        allVRegisters.add(vr13);
        allVRegisters.add(vr14);
        allVRegisters.add(vr15);
        for(virtualregister vreg: allVRegisters){
            allRegisters.add(vreg.color);
            if(vreg.color.isCallerSave){
                callerSaveVRegisters.add(vreg);
                callerSaveRegisters.add(vreg.color);
            }else{
                calleeSaveVRegisters.add(vreg);
                calleeSaveRegisters.add(vreg.color);
            }
        }
    }

    boolean isCallerSave;
    boolean isCalleeSave;
    public String lowByteName;

    private realregister(String name,String lowByteName,boolean callerSave){
        super(name);
        this.lowByteName=lowByteName;
        this.isCallerSave=callerSave;
        this.isCalleeSave=!callerSave;
    }

    @Override
    public void accept(IRvisitor irvisitor){
        irvisitor.visit(this);
    }

    public boolean isCalleeSave(){
        return isCalleeSave;
    }

    public boolean isCallerSave(){
        return isCallerSave;
    }

    public String getLowByteName(){
        return lowByteName;
    }


}

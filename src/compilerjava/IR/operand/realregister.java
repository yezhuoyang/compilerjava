package compilerjava.IR.operand;

import compilerjava.IR.IRvisitor;
import compilerjava.config;
import sun.nio.cs.ext.IBM865;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class realregister extends register {
    public static final realregister zero = new realregister("zero", false,config.registersize);
    public static final realregister ra   = new realregister("ra", true,config.registersize);
    public static final realregister sp   = new realregister("sp", false,config.registersize);
    public static final realregister gp   = new realregister("gp", false,config.registersize);
    public static final realregister tp   = new realregister("tp", false,config.registersize);
    public static final realregister t0   = new realregister("t0", true,config.registersize);
    public static final realregister t1   = new realregister("t1", true,config.registersize);
    public static final realregister t2   = new realregister("t2",  true,config.registersize);
    public static final realregister s0   = new realregister("s0",   false,config.registersize);
    public static final realregister s1   = new realregister("s1", false,config.registersize);
    public static final realregister a0   = new realregister("a0", true,config.registersize);
    public static final realregister a1   = new realregister("a1",  true,config.registersize);
    public static final realregister a2   = new realregister("a2", true,config.registersize);
    public static final realregister a3   = new realregister("a3", true,config.registersize);
    public static final realregister a4   = new realregister("a4", true,config.registersize);
    public static final realregister a5   = new realregister("a5", true,config.registersize);
    public static final realregister a6   = new realregister("a6", true,config.registersize);
    public static final realregister a7   = new realregister("a7", true,config.registersize);

    public static final realregister s2   = new realregister("s2", false,config.registersize);
    public static final realregister s3   = new realregister("s3",  false,config.registersize);
    public static final realregister s4   = new realregister("s4", false,config.registersize);
    public static final realregister s5   = new realregister("s5",  false,config.registersize);
    public static final realregister s6   = new realregister("s6",  false,config.registersize);
    public static final realregister s7   = new realregister("s7",  false,config.registersize);
    public static final realregister s8   = new realregister("s8",  false,config.registersize);
    public static final realregister s9   = new realregister("s9", false,config.registersize);
    public static final realregister s10  = new realregister("s10", false,config.registersize);
    public static final realregister s11  = new realregister("s11", false,config.registersize);

    public static final realregister t3   = new realregister("t3", true,config.registersize);
    public static final realregister t4   = new realregister("t4", true,config.registersize);
    public static final realregister t5  = new realregister("t5", true,config.registersize);
    public static final realregister t6  = new realregister("t6", true,config.registersize);

    public static final Set<realregister> callerSaveRegisters = new HashSet<>();
    public static final Set<realregister> calleeSaveRegisters = new HashSet<>();
    public static final LinkedList<realregister> argumentPassRegisters = new LinkedList<>();
    public static final LinkedList<realregister> allRegisters = new LinkedList<>();

    public static final virtualregister vzero = new I64Value("vzero", zero,config.registersize);
    public static final virtualregister vra   = new I64Value("vra", ra,config.registersize);
    public static final virtualregister vsp   = new I64Value("vsp", sp,config.registersize);
    public static final virtualregister vgp   = new I64Value("vgp", gp,config.registersize);
    public static final virtualregister vtp   = new I64Value("vtp", tp,config.registersize);
    public static final virtualregister vt0   = new I64Value("vt0", t0,config.registersize);
    public static final virtualregister vt1   = new I64Value("vt1", t1,config.registersize);
    public static final virtualregister vt2   = new I64Value("vt2",  t2,config.registersize);
    public static final virtualregister vs0   = new I64Value("vs0",   s0,config.registersize);
    public static final virtualregister vs1   = new I64Value("vs1", s1,config.registersize);
    public static final virtualregister va0   = new I64Value("va0", a0,config.registersize);
    public static final virtualregister va1   = new I64Value("va1",  a1,config.registersize);
    public static final virtualregister va2   = new I64Value("va2", a2,config.registersize);
    public static final virtualregister va3   = new I64Value("va3", a3,config.registersize);
    public static final virtualregister va4   = new I64Value("va4", a4,config.registersize);
    public static final virtualregister va5   = new I64Value("va5", a5,config.registersize);
    public static final virtualregister va6   = new I64Value("va6", a5,config.registersize);
    public static final virtualregister va7   = new I64Value("va7", a7,config.registersize);

    public static final virtualregister vs2   = new I64Value("vs2", s2,config.registersize);
    public static final virtualregister vs3   = new I64Value("vs3",  s3,config.registersize);
    public static final virtualregister vs4   = new I64Value("vs4", s4,config.registersize);
    public static final virtualregister vs5   = new I64Value("vs5",  s5,config.registersize);
    public static final virtualregister vs6   = new I64Value("vs6",  s6,config.registersize);
    public static final virtualregister vs7   = new I64Value("vs7",  s7,config.registersize);
    public static final virtualregister vs8   = new I64Value("vs8",  s8,config.registersize);
    public static final virtualregister vs9   = new I64Value("vs9", s9,config.registersize);
    public static final virtualregister vs10  = new I64Value("vs10", s10,config.registersize);
    public static final virtualregister vs11  = new I64Value("vs11", s11,config.registersize);

    public static final virtualregister vt3   = new I64Value("vt3", t3,config.registersize);
    public static final virtualregister vt4   = new I64Value("vt4", t4,config.registersize);
    public static final virtualregister vt5  = new I64Value("vt5", t5,config.registersize);
    public static final virtualregister vt6  = new I64Value("vt6", t6,config.registersize);

    public static final Set<virtualregister> callerSaveVRegisters = new HashSet<>();
    public static final Set<virtualregister> calleeSaveVRegisters = new HashSet<>();
    public static final LinkedList<virtualregister> argumentPassVRegisters = new LinkedList<>();
    public static final LinkedList<virtualregister> allVRegisters = new LinkedList<>();


    static {
        argumentPassVRegisters.add(va0);
        argumentPassVRegisters.add(va1);
        argumentPassVRegisters.add(va2);
        argumentPassVRegisters.add(va3);
        argumentPassVRegisters.add(va4);
        argumentPassVRegisters.add(va5);
        argumentPassVRegisters.add(va6);
        argumentPassVRegisters.add(va7);

        for (virtualregister virtualregister : argumentPassVRegisters)
            argumentPassRegisters.add(virtualregister.color);

        allVRegisters.add(vzero);
        allVRegisters.add(vra);
        allVRegisters.add(vsp);
        allVRegisters.add(vgp);
        allVRegisters.add(vtp);
        allVRegisters.add(vt0);
        allVRegisters.add(vt1);
        allVRegisters.add(vt2);
        allVRegisters.add(vs0);
        allVRegisters.add(vs1);
        allVRegisters.add(va0);
        allVRegisters.add(va1);
        allVRegisters.add(va2);
        allVRegisters.add(va3);
        allVRegisters.add(va4);
        allVRegisters.add(va5);
        allVRegisters.add(va6);
        allVRegisters.add(va7);

        allVRegisters.add(vs2);
        allVRegisters.add(vs3);
        allVRegisters.add(vs4);
        allVRegisters.add(vs5);
        allVRegisters.add(vs6);
        allVRegisters.add(vs7);
        allVRegisters.add(vs8);
        allVRegisters.add(vs9);
        allVRegisters.add(vs10);
        allVRegisters.add(vs11);

        allVRegisters.add(vt3);
        allVRegisters.add(vt4);
        allVRegisters.add(vt5);
        allVRegisters.add(vt6);

        for (virtualregister vRegister : allVRegisters) {
            allRegisters.add(vRegister.color);
            if (vRegister.color.isCallerSave) {
                callerSaveVRegisters.add(vRegister);
                callerSaveRegisters.add(vRegister.color);
            } else {
                calleeSaveVRegisters.add(vRegister);
                calleeSaveRegisters.add(vRegister.color);
            }
        }
    }

    boolean isCallerSave;
    boolean isCalleeSave;

    private realregister(String name, boolean callerSave,int Size) {
        super(name,Size);
        this.isCallerSave = callerSave;
        this.isCalleeSave = !callerSave;
    }

    @Override
    public void accept(IRvisitor irVisitor) {
        irVisitor.visit(this);
    }

    public boolean isCalleeSave() {
        return isCalleeSave;
    }

    public boolean isCallerSave() {
        return isCallerSave;
    }


}

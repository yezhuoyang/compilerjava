package compilerjava.optimizer;

import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.binary;
import compilerjava.IR.instruction.IRinst;
import compilerjava.IR.operand.I64Value;
import compilerjava.IR.operand.immediate;
import compilerjava.IR.operand.operand;
import compilerjava.config;
import compilerjava.config.*;

class operandTransform extends pass {
    
    operandTransform(IRroot IRroot) {
        super(IRroot);
    }

    @Override
    boolean run() {
        Irroot.getFunctionMap().values().forEach(function -> {
            function.getReversePostOrderDFSBBList().forEach(basicBlock -> {
                for (IRinst IRinst = basicBlock.head; IRinst != null; IRinst = IRinst.getNextInstruction())
                    if (IRinst instanceof binary) {
                        binary inst = (binary) IRinst;
                        if ((inst.getOp() == binary.Op.DIV || inst.getOp() == binary.Op.MOD) && inst.getSrc2() instanceof immediate) {
                            int N =16;
                            int d = ((immediate) inst.getSrc2()).getImmediate();
                            if ((d & (d - 1)) == 0 && inst.getOp() == binary.Op.DIV) {
                                int shift = (int) Math.floor(Math.log(d) / Math.log(2));
                                IRinst.replaceInstruction(new binary(basicBlock, binary.Op.BITR, inst.getSrc1(), new immediate(shift, config.intsize), inst.getDst()));
                            } else {
                                if (d > 0) {
                                    operand n = ((binary) IRinst).getSrc1();
                                    int l = Math.max((int) Math.ceil(Math.log(Math.abs(d)) / Math.log(2)), 1);
                                    long m = 1 + (long) Math.floor((long) Math.pow(2, N + l - 1) / (long) Math.abs(d));
                                    long m_ = m - (long) Math.pow(2, N);
                                    int sh_post = l - 1;

                                    I64Value tmp1 = new I64Value("div_tmp1",config.intsize);
                                    I64Value tmp2 = new I64Value("div_tmp2",config.intsize);
                                    I64Value tmp3 = new I64Value("div_tmp3",config.intsize);
                                    I64Value tmp4 = new I64Value("div_tmp4",config.intsize);
                                    I64Value tmp5 = new I64Value("div_tmp5",config.intsize);
                                    I64Value tmp6 = new I64Value("div_tmp6",config.intsize);
                                    I64Value tmp7 = new I64Value("div_tmp7",config.intsize);
                                    IRinst.prependInstruction(new binary(basicBlock, binary.Op.MUL, n, new immediate((int) m_,config.intsize), tmp1));
                                    IRinst.prependInstruction(new binary(basicBlock, binary.Op.BITR, tmp1, new immediate(32,config.intsize), tmp2));
                                    IRinst.prependInstruction(new binary(basicBlock, binary.Op.ADD, n, tmp2, tmp3));
                                    IRinst.prependInstruction(new binary(basicBlock, binary.Op.BITOR, tmp3, new immediate(sh_post,config.intsize), tmp4));
                                    IRinst.prependInstruction(new binary(basicBlock, binary.Op.BITR, n, new immediate(31,config.intsize), tmp5));

                                    if (inst.getOp() == binary.Op.DIV) {
                                        //get quotient
                                        IRinst.replaceInstruction(new binary(basicBlock, binary.Op.SUB, tmp4, tmp5, inst.getDst()));
                                    } else {
                                        //get quotient
                                        IRinst.prependInstruction(new binary(basicBlock, binary.Op.SUB, tmp4, tmp5, tmp6));
                                        //get remainder
                                        IRinst.prependInstruction(new binary(basicBlock, binary.Op.MUL, tmp6, new immediate(d,config.intsize), tmp7));
                                        IRinst.replaceInstruction(new binary(basicBlock, binary.Op.SUB, n, tmp7, inst.getDst()));
                                    }
                                }
                            }
                        } else if (inst.getOp() == binary.Op.MUL && inst.getSrc2() instanceof immediate) {
                            int d = ((immediate) inst.getSrc2()).getImmediate();
                            if ((d & (d - 1)) == 0) {
                                int shift = (int) Math.floor(Math.log(d) / Math.log(2));
                                IRinst.replaceInstruction(new binary(basicBlock, binary.Op.BITL, inst.getSrc1(), new immediate(shift,config.intsize), inst.getDst()));
                            }
                        }
                    }
            });
        });
        return false;
    }
}

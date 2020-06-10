package compilerjava.optimizer;

import compilerjava.IR.function;
import compilerjava.IR.IRroot;
import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.*;
import compilerjava.config;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class ConstantAndCopy extends pass {

    public ConstantAndCopy(IRroot Irroot) {
        super(Irroot);
    }

    @Override
    public boolean run() {
        changed = false;
        Irroot.getFunctionMap().values().forEach(function -> {
            calcDefUseChain(function);
            constantAndCopyPropagation(function);
        });
        return changed;
    }

    private void constantAndCopyPropagation(function function) {
        LinkedList<IRinst> workList = getAllStatements(function);
        Set<IRinst> inQueue = new HashSet<>(workList);
        while(!workList.isEmpty()){
            IRinst S = workList.poll();
            inQueue.remove(S);
            if(S instanceof phi){
                operand val = ((phi) S).getPaths().values().iterator().next();
                if(val instanceof immediate) {
                    int c = ((immediate) val).getImmediate();
                    if (((phi) S).getPaths().values().stream().allMatch(x -> (x == null) || (x instanceof immediate && ((immediate) x).getImmediate() == c)))
                        substituteoperand(workList, inQueue, S, ((phi) S).getDst(), val);
                }
            } else if (S instanceof move) {
                if (((move) S).getSrc() instanceof immediate || ((move) S).getSrc() instanceof virtualregister) {
                    substituteoperand(workList, inQueue, S, ((move) S).getDst(), ((move) S).getSrc());
                }
            } else if (S instanceof binary) {
                binary inst = (binary) S;
                if (inst.getSrc1() instanceof immediate && inst.getSrc2() instanceof immediate) {
                    changed = true;
                    int src1 = ((immediate) inst.getSrc1()).getImmediate(), src2 = ((immediate) inst.getSrc2()).getImmediate(), res=-1;
                    switch (inst.getOp()) {
                        case ADD:
                            res = src1 + src2;
                            break;
                        case SUB:
                            res = src1 - src2;
                            break;
                        case MUL:
                            res = src1 * src2;
                            break;
                        case BITOR:
                            res = src1 | src2;
                            break;
                        case BITAND:
                            res = src1 & src2;
                            break;
                        case XOR:
                            res = src1 ^ src2;
                            break;
                        case DIV:
                            res = src2 == 0 ? 0 : src1 / src2;
                            break;
                        case MOD:
                            res = src2 == 0 ? 0 : src1 % src2;
                            break;
                        case BITL:
                            res = src1 << src2;
                            break;
                        case BITR:
                            res = src1 >> src2;
                            break;
                    }
                    move newmove = new move(inst.getCurrentBB(), new immediate(res,inst.getSrc1().getSize()), inst.getDst());
                    S.replaceInstruction(newmove);
                    workList.add(newmove);
                    inQueue.add(newmove);
                } else if (((binary) S).getOp() == binary.Op.ADD) {
                    if (((binary) S).getSrc1() instanceof immediate) {
                        if (((immediate) ((binary) S).getSrc1()).getImmediate() == 0) {
                            changed = true;
                            move newmove = new move(inst.getCurrentBB(), ((binary) S).getSrc2(), inst.getDst());
                            S.replaceInstruction(newmove);
                            workList.add(newmove);
                            inQueue.add(newmove);
                        }
                    } else if (((binary) S).getSrc2() instanceof immediate) {
                        if (((immediate) ((binary) S).getSrc2()).getImmediate() == 0) {
                            changed = true;
                            move newmove = new move(inst.getCurrentBB(), ((binary) S).getSrc1(), inst.getDst());
                            S.replaceInstruction(newmove);
                            workList.add(newmove);
                            inQueue.add(newmove);
                        }
                    }
                }
            } else if (S instanceof unary){
                unary inst = (unary) S;
                if (inst.getSrc() instanceof immediate) {
                    changed = true;
                    int src = ((immediate) inst.getSrc()).getImmediate(), res=-1;
                    switch (inst.getOp()) {
                        case SUF_SUB:
                            res = src - 1;
                            break;
                        case SUF_ADD:
                            res = src + 1;
                            break;
                        case BITNOT:
                            res = ~src;
                            break;
                        case NEG:
                            res = -src;
                            break;
                        case POS:
                            res = src;
                            break;
                    }
                    move newmove = new move(inst.getCurrentBB(), new immediate(res,inst.getDst().getSize()), inst.getDst());
                    S.replaceInstruction(newmove);
                    workList.add(newmove);
                    inQueue.add(newmove);
                }
            } else if (S instanceof cmp){
                cmp inst = (cmp) S;
                if (inst.getSrc1() instanceof immediate && inst.getSrc2() instanceof immediate) {
                    changed = true;
                    int src1 = ((immediate) inst.getSrc1()).getImmediate(), src2 = ((immediate) inst.getSrc2()).getImmediate(), res=-1;
                    switch (inst.getOp()){
                        case LT:
                            res = src1 < src2 ? 1 : 0;
                            break;
                        case EQ:
                            res = src1 == src2 ? 1 : 0;
                            break;
                        case GT:
                            res = src1 > src2 ? 1 : 0;
                            break;
                        case GEQ:
                            res = src1 >= src2 ? 1 : 0;
                            break;
                        case LEQ:
                            res = src1 <= src2 ? 1 : 0;
                            break;
                        case NEQ:
                            res = src1 != src2 ? 1 : 0;
                            break;
                    }
                    move newmove =new move(inst.getCurrentBB(), new immediate(res,config.intsize), inst.getDst());
                    S.replaceInstruction(newmove);
                    workList.add(newmove);
                    inQueue.add(newmove);
                }
            } else if (S instanceof call){
                function callee=((call) S).getCallee();
                if(!Irroot.stringConstantfunctions.contains(callee)) continue;
                boolean check0 = ((call) S).getObjectPointer() instanceof global64Value;
                boolean check1 = ((call) S).getParameterList().size() > 0 && ((call) S).getParameterList().get(0) instanceof global64Value;
                boolean check2 = ((call) S).getParameterList().size() > 1 && ((call) S).getParameterList().get(1) instanceof global64Value;
                global64Value _this = check0 ? (global64Value) ((call) S).getObjectPointer() : null;
                global64Value lhs = check1 ? (global64Value) ((call) S).getParameterList().get(0) : null;
                global64Value rhs = check2 ? (global64Value) ((call) S).getParameterList().get(1) : null;
                if (callee == Irroot.builtinStringAdd) {
                    if (check1 && check2) {
                        changed = true;
                        String res = Irroot.staticstringvalMap.get(lhs) + Irroot.staticstringvalMap.get(rhs);
                        staticstring staticstring = new staticstring(new global64Value("_str_const", true,config.pointersize()), res);
                        ((global64Value)staticstring.getBase()).setReferencedstring(staticstring);
                        Irroot.addstaticstring(staticstring);
                        S.replaceInstruction(new move(S.getCurrentBB(), staticstring.getBase(), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringLT) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) < 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringLEQ) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) <= 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringEQ) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) == 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringGEQ) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) >= 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringGT) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) > 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringNEQ) {
                    if (check1 && check2) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(lhs).compareTo(Irroot.staticstringvalMap.get(rhs)) != 0 ? 1 : 0;
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinToString) {
                    if (((call) S).getParameterList().get(0) instanceof immediate) {
                        changed = true;
                        int res = ((immediate) ((call) S).getParameterList().get(0)).getImmediate();
                        staticstring staticstring = new staticstring(new global64Value("_str_const", true,config.pointersize()), String.valueOf(res));
                        ((global64Value)staticstring.getBase()).setReferencedstring(staticstring);
                        Irroot.addstaticstring(staticstring);
                        S.replaceInstruction(new move(S.getCurrentBB(), staticstring.getBase(), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinStringLength) {
                    if (check0) {
                        changed = true;
                        int res = Irroot.staticstringvalMap.get(_this).length();
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinSubstring){
                    if (check0) {
                        if (((call) S).getParameterList().get(0) instanceof immediate && ((call) S).getParameterList().get(1) instanceof immediate) {
                            changed = true;
                            int left = ((immediate) ((call) S).getParameterList().get(0)).getImmediate();
                            int right = ((immediate) ((call) S).getParameterList().get(1)).getImmediate();
                            String res = Irroot.staticstringvalMap.get(_this).substring(left, right);
                            staticstring staticstring = new staticstring(new global64Value("_str__const", true,config.pointersize()), res);
                            ((global64Value)staticstring.getBase()).setReferencedstring(staticstring);
                            Irroot.addstaticstring(staticstring);
                            S.replaceInstruction(new move(S.getCurrentBB(), staticstring.getBase(), ((call) S).getResult()));
                        }
                    }
                } else if (callee == Irroot.builtinParseInt) {
                    if (check0) {
                        changed = true;
                        String str = Irroot.staticstringvalMap.get(_this);
                        char[] charArray = str.toCharArray();
                        int res = 0;
                        for (char ch : charArray) {
                            if (ch < '0' || ch > '9') break;
                            res = res * 10 + ch - '0';
                        }
                        S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                    }
                } else if (callee == Irroot.builtinOrd) {
                    if (check0) {
                        if (((call) S).getParameterList().get(0) instanceof immediate) {
                            int pos = ((immediate) ((call) S).getParameterList().get(0)).getImmediate();
                            if (pos < Irroot.staticstringvalMap.get(_this).length()) {
                                changed = true;
                                int res = (int) Irroot.staticstringvalMap.get(_this).charAt(pos);
                                S.replaceInstruction(new move(S.getCurrentBB(), new immediate(res,config.intsize), ((call) S).getResult()));
                            }
                        }
                    }
                }
            }
        }
    }

    private void substituteoperand(LinkedList<IRinst> workList, Set<IRinst> inQueue, IRinst IRinst, operand oldoperand, operand newoperand) {
        if(newoperand instanceof immediate){
            boolean hasphi = false;
            Set<IRinst> oldUses = new HashSet<>(use.get(oldoperand));
            for(IRinst user : oldUses)
                if(user != IRinst) {
                    if(!(user instanceof phi)) {
                        changed = true;
                        use.get(oldoperand).remove(user);
                        user.replaceUseReg(oldoperand, newoperand);
                        if(!inQueue.contains(user)){
                            workList.add(user);
                            inQueue.add(user);
                        }
                    } else hasphi = true;
                }
            if (!hasphi) IRinst.deleteSelf();
        } else if (newoperand instanceof virtualregister) {
            boolean hasphi = false;
            Set<IRinst> oldUses = new HashSet<>(use.get(oldoperand));
            Set<IRinst> newUses = use.get(newoperand);
            for(IRinst user : oldUses)
                if(user != IRinst){
                    if(!(user instanceof phi)){
                        changed = true;
                        use.get(oldoperand).remove(user);
                        user.replaceUseReg(oldoperand, newoperand);
                        newUses.add(user);
                        if (!inQueue.contains(user)) {
                            workList.add(user);
                            inQueue.add(user);
                        }
                    } else hasphi = true;
                }
            if (!hasphi) {
                newUses.remove(IRinst);
                IRinst.deleteSelf();
            }
        }
    }


}

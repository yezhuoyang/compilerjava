package compilerjava.IR;

import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.immediate;
import compilerjava.IR.operand.staticstring;
import compilerjava.IR.operand.storage;


public interface IRvisitor {

    void visit(IRroot irroot);

    void visit(function func);

    void visit(staticstring sstring);

    void visit(basicblock BB);

    void visit(alloc inst);

    void visit(binary inst);

    void visit(branch inst);

    void visit(call inst);

    void visit(cmp inst);

    void visit(jump inst);

    void visit(load inst);

    void visit(move inst);

    void visit(back inst);

    void visit(store inst);

    void visit(unary inst);

    void visit(phi inst);


    void visit(storage stor);

    void visit(immediate imme);

}


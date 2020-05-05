package compilerjava.AST;

import compilerjava.IR.basicblock;


public interface Loop{
    basicblock getStepBB();

    basicblock getMergeBB();

}
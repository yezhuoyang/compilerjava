package  compilerjava.Env;


import compiler.util.position;



public interface field{

    String getfieldName();

    field getOuterfield();

    void defvar(varsymbol symbol);

    void deffunc(funceymbol symbol);

    void defclass(classsymbol symbol);

    symbol resolvesymbol(String ID,position pos);


}






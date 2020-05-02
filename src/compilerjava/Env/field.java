package  compilerjava.Env;


import compilerjava.util.position;



public interface field{

    String getfieldName();

    field getOuterfield();

    void defvar(varsymbol symbol);

    void deffunc(funcsymbol symbol);

    void defclass(classsymbol symbol);

    symbol resolvesymbol(String ID,position pos);


}






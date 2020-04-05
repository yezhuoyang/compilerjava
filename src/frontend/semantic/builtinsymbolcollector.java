package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;

import java.util.ArrayList;
import java.util.List;



public class builtinsymbolcollector{
    private final static globalfield _globalfield=new _globalfield("Global Field");
    private final static classsymbol string=new classsymbol("string",null,_globalfield);
    private final static basesymbol  intsymbol=new basesymbol("int");
    private final static basesymbol  boolsymbol=new basesymbol("bool");
    private final static basesymbol  voidsymbol=new basesymbol("void");

    public builtinsymbolcollector(programNode ast){
            _globalfield.defbasetype(IntTypefield);
            _globalfield.defbasetype(BoolTypefield);
            _globalfield.defbasetype(VoidTypefield);

            string.deffunc(new funcsymbol("length",intsymbol,null,string));
            string.deffunc(new funcsymbol("substring",string,null,intsymbol,string){{
                    defvar(new varsymbol("left",intsymbol,null);
                    defvar(new varsymbol("right",intsymbol,null));
            }});
            string.deffunc(new funcsymbol("parseInt",intsymbol,null,string));
            string.deffunc(new funcsymbol("ord",intsymbol,null,string){{
                    defvar(new varsymbol("i",intsymbol,null));
            }})

            _globalfield.setArrayfunctionsymbol(new funcsymbol("array.size",intsymbol,null,_globalfield));
    }


    public static globalfield getglobalfield() {
        return _globalfield;
    }




}
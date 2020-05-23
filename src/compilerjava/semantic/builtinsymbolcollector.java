package compilerjava.semantic;

import compilerjava.AST.*;
import compilerjava.Env.*;
import compilerjava.util.*;

import java.util.ArrayList;
import java.util.List;



public class builtinsymbolcollector{
    private final static globalfield _globalfield=new globalfield("Global Field");
    private final static classsymbol string=new classsymbol("string",null,_globalfield);
    private final static basesymbol  intsymbol=new basesymbol("int");
    private final static basesymbol  boolsymbol=new basesymbol("bool");
    private final static basesymbol  voidsymbol=new basesymbol("void");

    public builtinsymbolcollector(programNode ast){

            _globalfield.defbasetype(intsymbol);
            _globalfield.defbasetype(boolsymbol);
            _globalfield.defbasetype(voidsymbol);

            //Class String
            string.deffunc(new funcsymbol("length",intsymbol,null,string));
            string.deffunc(new funcsymbol("substring",string,null,string){{
                    defvar(new varsymbol("left",intsymbol,null));
                    defvar(new varsymbol("right",intsymbol,null));
            }});
            string.deffunc(new funcsymbol("parseInt",intsymbol,null,string));
            string.deffunc(new funcsymbol("ord",intsymbol,null,string){{
                    defvar(new varsymbol("i",intsymbol,null));
            }});

            _globalfield.defclass(string);

            _globalfield.setIntsymbol(intsymbol);
            _globalfield.setBoolsymbol(boolsymbol);
            _globalfield.setVoidsymbol(voidsymbol);
            _globalfield.setString(string);

            _globalfield.deffunc(new funcsymbol("print",voidsymbol,null,_globalfield){{
                defvar(new varsymbol("str",string,null));
            }});

            _globalfield.deffunc(new funcsymbol("println",voidsymbol,null,_globalfield){{
                defvar(new varsymbol("str",string,null));
            }});

            _globalfield.deffunc(new funcsymbol("printInt",voidsymbol,null,_globalfield){{
                defvar(new varsymbol("str",intsymbol,null));
            }});

            _globalfield.deffunc(new funcsymbol("printlnInt",voidsymbol,null,_globalfield){{
                defvar(new varsymbol("str",intsymbol,null));
            }});


            _globalfield.deffunc(new funcsymbol("getString",string,null,_globalfield));
            _globalfield.deffunc(new funcsymbol("getInt",intsymbol,null,_globalfield));
            _globalfield.deffunc(new funcsymbol("toString",string,null,_globalfield){{
                         defvar(new varsymbol("i",intsymbol,null));
            }});

            _globalfield.setArrayfunctionsymbol(new funcsymbol("array.size",intsymbol,null,_globalfield));
            initFuncinit(ast);
    }


    public static globalfield getglobalfield() {
        return _globalfield;
    }


    private void initFuncinit(programNode ast){
        List<stmtNode> stmtNodeList=new ArrayList<>();
        ast.getDeclNodeList().forEach(x->{
            if(x instanceof vardeclNode){
                if(((vardeclNode)x).getExpr()!=null)
                    stmtNodeList.add(new exprstmtNode(new binaryexprNode(new IDexprNode(((vardeclNode)x).getID(),x.getpos()),((vardeclNode)x).getExpr(),binaryexprNode.Optype.ASSIGN,x.getpos()),x.getpos()));
            }
        });

        stmtNodeList.add(new returnNode(new funccallexprNode(new IDexprNode("main",null),new ArrayList<>(),null),null));
        blockstmtNode _blockstmtNode=new blockstmtNode(stmtNodeList,null);

        funcdeclNode initfunc=new funcdeclNode(new inttpNode(null),"__init",new ArrayList<>(),_blockstmtNode,null);
        ast.getDeclNodeList().add(initfunc);

    }

}
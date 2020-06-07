package compilerjava.IR;

import compilerjava.IR.operand.globalvar;
import compilerjava.IR.operand.staticstring;

import java.util.*;


public class IRroot {

    public function builtinStringLength=new function("string_length",null);
    public function builtinSubstring=new function("string_substring","_builtin_string_substring");
    public function builtinParseInt=new function("string_parseInt","_builtin_string_parseInt");
    public function builtinOrd=new function("string_ord","_builtin_string_ord");
    public function builtinPrint=new function("print","_builtin_print");
    public function builtinPrintInt=new function("printInt","_builtin_printInt");
    public function builtinPrintlnInt=new function("printlnInt","_builtin_printlnInt");
    public function builtinPrintln=new function("println","_builtin_println");
    public function builtinGetString=new function("getString","_builtin_getString");
    public function builtinGetInt=new function("getInt","_builtin_getInt");
    public function builtinToString=new function("toString","_builtin_toString");
    public function builtinStringAdd=new function("string_add","_builtin_string_add");
    public function builtinStringLT=new function("string_lt","_builtin_string_less");
    public function builtinStringLEQ=new function("string_leq","_builtin_string_less_equal");
    public function builtinStringEQ=new function("string_eq","_builtin_string_equal");
    public function builtinStringGEQ=new function("string_geq","_builtin_string_great_equal");
    public function builtinStringGT=new function("string_gt","_builtin_string_great");
    public function builtinStringNEQ=new function("string_neq","_builtin_string_inequal");



    private Map<String,function> functionMap=new LinkedHashMap<>();
    private List<staticstring>  staticStringList=new ArrayList<>();
    private List<globalvar> globalvarList=new ArrayList<>();

    public Map<globalvar,String> staticstringvalMap=new HashMap<>();
    public Set<function>  stringConstantfunctions=new HashSet<>();
    public Set<function>  builtinfunction=new HashSet<>();

    public IRroot(){
        stringConstantfunctions.add(builtinStringLength);
        stringConstantfunctions.add(builtinSubstring);
        stringConstantfunctions.add(builtinParseInt);
        stringConstantfunctions.add(builtinOrd);
        stringConstantfunctions.add(builtinToString);
        stringConstantfunctions.add(builtinStringAdd);
        stringConstantfunctions.add(builtinStringLT);
        stringConstantfunctions.add(builtinStringLEQ);
        stringConstantfunctions.add(builtinStringEQ);
        stringConstantfunctions.add(builtinStringGEQ);
        stringConstantfunctions.add(builtinStringGT);
        stringConstantfunctions.add(builtinStringNEQ);

        builtinfunction.add(builtinStringLength);
        builtinfunction.add(builtinSubstring);
        builtinfunction.add(builtinParseInt);
        builtinfunction.add(builtinOrd);
        builtinfunction.add(builtinToString);
        builtinfunction.add(builtinStringAdd);
        builtinfunction.add(builtinStringLT);
        builtinfunction.add(builtinStringLEQ);
        builtinfunction.add(builtinStringEQ);
        builtinfunction.add(builtinStringGEQ);
        builtinfunction.add(builtinStringGT);
        builtinfunction.add(builtinStringNEQ);
        builtinfunction.add(builtinGetInt);
        builtinfunction.add(builtinGetString);
        builtinfunction.add(builtinPrint);
        builtinfunction.add(builtinPrintln);
        builtinfunction.add(builtinPrintlnInt);
        builtinfunction.add(builtinPrintInt);
    }

    public void addfunction(function func){
        functionMap.put(func.getName(),func);
    }

    public void removefunction(function func){
        functionMap.remove(func.getName());
    }

    public void addstaticstring(staticstring staticString){
        staticStringList.add(staticString);
        staticstringvalMap.put((globalvar)staticString.getBase(),staticString.getVal());
    }

    public void addglobalvar(globalvar gbvar){
        globalvarList.add(gbvar);
    }

    public Map<String,function> getFunctionMap(){
        return functionMap;
    }

    public List<staticstring> getStaticStringList(){
        return staticStringList;
    }

    public List<globalvar> getGlobalvarList(){
        return globalvarList;
    }


    public void calcRecursiveCalleeSet(){
        functionMap.values().forEach(func->func.recursivecalleeset.clear());
        Set<function> newRecursivecalleeSet=new HashSet<>();
        boolean changed=true;
        while(changed){
            changed=false;
            for(function func : functionMap.values()){
                newRecursivecalleeSet.clear();
                newRecursivecalleeSet.addAll(func.calleeset);
                func.calleeset.forEach(callee->newRecursivecalleeSet.addAll(callee.recursivecalleeset));
                if(!newRecursivecalleeSet.equals(func.recursivecalleeset)){
                     func.recursivecalleeset.clear();
                     func.recursivecalleeset.addAll(newRecursivecalleeSet);
                     changed=true;
                }
            }
        }
    }




}

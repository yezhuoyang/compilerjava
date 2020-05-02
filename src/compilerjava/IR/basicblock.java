package compilerjava.IR;

import compilerjava.IR.instruction.*;
import compilerjava.IR.operand.virtualregister;

import java.util.HashSet;
import java.util.Set;



public class basicblock {
    public IRinst head;
    public IRinst tail;


    private function currentfunction;
    private String name;
    private Set<basicblock>  predecessors=new HashSet<>();
    private Set<basicblock>  successors=new HashSet<>();
    private boolean finished;


    public basicblock(function currentfunction,String name){
        this.currentfunction=currentfunction;
        this.name=name;
    }








}

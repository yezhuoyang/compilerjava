package compilerjava.optimizer;

import compilerjava.IR.IRroot;

public class optimizer{
    private spillcalculator _spillcalculator;
    private DeadCodeEliminator _deadCodeEliminator;

    private SSABuilder ssaConstructor;
    private SSAremove ssaDestructor;
    private CFGSimplifier cfgSimplifier;
    private DeadCodeEliminator deadCodeEliminator;
    private CommonSubexprElim commonSubexpressionEliminator;
    private InstructionAdjust  instructionCombiner;
    private InstructionAdjust instructionAdjustor;
    private ConstantAndCopy constantAndCopy;
    private frameConstruct _frameConstruct;
    private operandTransform _operandTrans;
    private deadloadElim _deadloadelim;

    public optimizer(IRroot irRoot){
        _spillcalculator = new spillcalculator(irRoot);
        _deadCodeEliminator = new DeadCodeEliminator(irRoot);
        ssaConstructor = new SSABuilder(irRoot);
        ssaDestructor = new SSAremove(irRoot);
        cfgSimplifier = new CFGSimplifier(irRoot);
        commonSubexpressionEliminator = new CommonSubexprElim(irRoot);
        instructionCombiner=new InstructionAdjust(irRoot);
        instructionAdjustor=new InstructionAdjust(irRoot);
        constantAndCopy=new ConstantAndCopy(irRoot);
        _frameConstruct=new frameConstruct(irRoot);
        _operandTrans=new operandTransform(irRoot);
        _deadloadelim=new deadloadElim(irRoot);

    }

    public boolean deadloadelim(){
        return _deadloadelim.run();
    }

    public boolean operandTrans(){
        return _operandTrans.run();
    }


    public void addframe(){
        _frameConstruct.run();
    }

    public boolean runConstAndCopy(){
        return constantAndCopy.run();
    }

    public void SpillPriorityCalculation() {
        _spillcalculator.run();
    }

    public boolean DeadCodeElimination() {
        return _deadCodeEliminator.run();
    }

    public boolean CFGSimplification() {
        return cfgSimplifier.run();
    }

    public void CFGSimplification(boolean eliminateOK) {
        cfgSimplifier.runMore();
    }

    public void SSAConstruction() {
        ssaConstructor.run();
    }

    public void SSADestruction() {
        ssaDestructor.run();
    }

    public boolean CommonSubexpressionElimination() {
        return commonSubexpressionEliminator.run();
    }

    public void InstructionCombination() {
        instructionCombiner.run();
    }

    public void InstructionAdujust() {
        instructionAdjustor.run();
    }

/*
    public boolean ConstantAndCopyPropagation() {
        return constantAndCopyPropagator.run();
    }


    public boolean CommonSubexpressionElimination() {
        return commonSubexpressionEliminator.run();
    }

    public void ArithmeticTransformation() {
        arithmeticTransformer.run();
    }
 */

}


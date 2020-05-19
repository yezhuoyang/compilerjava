package compilerjava.optimizer;

import compilerjava.IR.IRroot;

public class optimizer {
    private spillcalculator _spillcalculator;
    private DeadCodeEliminator _deadCodeEliminator;

    /*
    private SSAConstructor ssaConstructor;
    private SSADestructor ssaDestructor;
    private CFGSimplifier cfgSimplifier;
    private DeadCodeEliminator deadCodeEliminator;
    private ConstantAndCopyPropagator constantAndCopyPropagator;
    private InstructionCombiner instructionCombiner;
    private CommonSubexpressionEliminator commonSubexpressionEliminator;
    private ArithmeticTransformer arithmeticTransformer;
    */

    public optimizer(IRroot irRoot) {
        _spillcalculator = new spillcalculator(irRoot);
        _deadCodeEliminator = new DeadCodeEliminator(irRoot);
        /*
        ssaConstructor = new SSAConstructor(irRoot);
        ssaDestructor = new SSADestructor(irRoot);
        cfgSimplifier = new CFGSimplifier(irRoot);
        constantAndCopyPropagator = new ConstantAndCopyPropagator(irRoot);
        instructionCombiner = new InstructionCombiner(irRoot);
        commonSubexpressionEliminator = new CommonSubexpressionEliminator(irRoot);
        arithmeticTransformer = new ArithmeticTransformer(irRoot);
        */
    }


    public void SpillPriorityCalculation() {
        _spillcalculator.run();
    }


    public boolean DeadCodeElimination() {
        return _deadCodeEliminator.run();
    }

/*
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

    public boolean DeadCodeElimination() {
        return deadCodeEliminator.run();
    }

    public boolean ConstantAndCopyPropagation() {
        return constantAndCopyPropagator.run();
    }

    public void InstructionCombination() {
        instructionCombiner.run();
    }

    public boolean CommonSubexpressionElimination() {
        return commonSubexpressionEliminator.run();
    }

    public void ArithmeticTransformation() {
        arithmeticTransformer.run();
    }
 */
}


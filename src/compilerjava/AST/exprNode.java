package compilerjava.AST;
import compilerjava.util.position;


import compilerjava.IR.basicblock;
import compilerjava.IR.operand.operand;

import compilerjava.Env.type;
import compilerjava.Env.funcsymbol;
import compilerjava.util.position;


public abstract class exprNode extends Node{
    public enum Category{
        LVALUE,RVALUE,CLASS,FUNCTION,
    }

    private type _type;
    private funcsymbol _funcsymbol;
    private Category cat;


    private basicblock thenBB, elseBB;
    private operand resultop;
    int size;

    public exprNode(position pos){
        super(pos);
    }

    public boolean isIntvar(){
        return (cat==Category.LVALUE&&_type.getTypeName().equals("int"));
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }

    public type gettype(){
        return _type;
    }

    public void settype(type _type) {
        this._type = _type;
        size=_type.getTypeSize();
    }

    public operand getResultop(){
        return  resultop;
    }

    public void setResultop(operand resultop) {
        this.resultop = resultop;
    }

    public funcsymbol getfuncsymbol() {
        return _funcsymbol;
    }

    public void setfuncsymbol(funcsymbol _funcsymbol) {
        this._funcsymbol = _funcsymbol;
    }


    public boolean isBooleanVar(){
        return (cat==Category.LVALUE&&_type.getTypeName().equals("bool"));
    }

    public boolean isString(){
        return  ((cat==Category.LVALUE||cat==Category.RVALUE)&&_type.getTypeName().equals("string"));
    }

    public boolean isInteger(){
        return (cat==Category.LVALUE||cat==Category.RVALUE)&&_type.getTypeName().equals("int");
    }

    public boolean isBoolean(){
        return (cat==Category.LVALUE||cat==Category.RVALUE)&&_type.getTypeName().equals("bool");
    }

    public boolean isAssignable(){
        return cat==Category.LVALUE;
    }

    public boolean isCallable(){
        return cat==Category.FUNCTION;
    }

    public boolean isAccessable(){
        return (isValue()&&_type.isClassType());
    }


    public boolean isNullable(){
        return (cat==Category.LVALUE&&(_type.isClassType()||_type.isArrayType())||_type.isNullType());
    }

    public boolean isValue(){
        return cat!=Category.CLASS&&cat!=Category.FUNCTION;
    }

    public boolean isNull(){
        return _type.isNullType();
    }

    public int getSize() {
        return size;
    }

    public basicblock getElseBB() {
        return elseBB;
    }

    public basicblock getThenBB() {
        return thenBB;
    }

    public void setElseBB(basicblock elseBB) {
        this.elseBB = elseBB;
    }

    public void setThenBB(basicblock thenBB) {
        this.thenBB = thenBB;
    }
}

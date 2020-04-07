package compilerjava.Env;
import compilerjava.util.position;


public interface type{
    String getTypeName();

    void compatible(type tp,position pos);

    boolean isBaseType();

    boolean isClassType();

    boolean isArrayType();

    boolean isNullType();

    boolean isPointerType();

    int getTypeSize();


}
package compilerjava.Parser;



import compilerjava.util.position;
import compilerjava.util.syntaxError;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;


public class MXErrorListener extends BaseErrorListener{
    
    @Override
    public void syntaxError(Recognizer<?,?>recognizer,
                            Object offendingSymbol,
                            int line,int charPositionInLine,
                            String msg,
                            RecognitionException e){
        throw new syntaxError(msg,new position(line,charPositionInLine));
    }


}
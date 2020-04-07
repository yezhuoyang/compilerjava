grammar MX;

@header{
package compilerjava.Parser;
}


program
    :  programParts*
    ;


programParts
    : functionDecl
    | classDecl
    | variableDecl
    ;

functionDecl
    : typeForfunc? ID '(' params? ')' block
    ;


classDecl
    :  CLASS ID '{' (functionDecl|variableDecl)* '}'
    ;

variableDecl
    :  type variableList ';'
    ;

variableList
    :  singleVariableDecl ( ',' singleVariableDecl)*
    ;


singleVariableDecl
    : ID ('=' expr)?
    ;

params
    : paramDecl (',' paramDecl)*
    ;

paramDecl
    : type ID
    ;


type
    : type '[' ']'         #arrayType
    | nonArraytype         #narrayType
    ;

typeForfunc
    : type
    | VOID
    ;


nonArraytype
    : INT           #narrayTypeInt
    | BOOL          #narrayTypeBool
    | STRING        #narrayTypeString
    | ID            #narrayID
    ;

stmt
    : block             #blockstmt
    | variableDecl      #vardeclstmt
    | expr ';'          #exprstmt
    | conditionStatement ';' #conditionstmt
    | loopStatement ';'      #loopstmt
    | jumpStatement ';'      #jumpstmt
    | ';'               #blankstmt
    ;

block
    : '{' stmt* '}'
    ;

conditionStatement
    : IF '(' expr ')' thenStmt=stmt (ELSE elseStmt=stmt)*?
    ;

loopStatement
    : WHILE '(' expr ')' stmt                                       #whilestmt
    | FOR '(' init=expr?  ';'  cond=expr? ';' step=expr?')' stmt    #forstmt
    ;

jumpStatement
    : RETURN expr ';'   #returnstmt
    | BREAK ';'         #breakstmt
    | CONTINUE ';'      #continuestmt
    ;


expr
    :   expr op=('++' | '--')                          #postcalcdecl
    |   <assoc=right> 'new' creator                    #newexpr
    |   expr '(' params? ')'                           #functioncall
    |   array = expr '[' index = expr ']'              #subscript
    |   expr '.' ID                                    #memberaccess
    |   <assoc=right> op=('++' | '--') expr            #unaryexpr
    |   <assoc=right> op=('+' | '-') expr              #unaryexpr
    |   <assoc=right> op=('!' | '~') expr              #unaryexpr
    |   src1 = expr op=('*' | '/' | '%') src2 = expr   #binaryexpr
    |   src1 = expr op=('+' | '-') src2 = expr         #binaryexpr
    |   src1 = expr op=('<<' | '>>') src2 = expr       #binaryexpr
    |   src1 = expr op=('<' | '>') src2 = expr         #binaryexpr
    |   src1 = expr op=('<=' | '>=') src2 = expr       #binaryexpr
    |   src1 = expr op=('==' | '!=') src2 = expr       #binaryexpr
    |   src1 = expr op='&' src2 = expr                 #binaryexpr
    |   src1 = expr op='^' src2 = expr                 #binaryexpr
    |   src1 = expr op='|' src2 = expr                 #binaryexpr
    |   src1 = expr op='&&' src2 = expr                #binaryexpr
    |   src1 = expr op='||' src2 = expr                #binaryexpr
    |   <assoc=right> src1 = expr op='=' src2 = expr   #binaryexpr
    |   ID                                             #identifier
    |   constant                                       #constantexpr
    |   THIS                                           #thisexpr
    |   '(' expr ')'                                   #subexpr
    ;


creator
    :  nonArraytype ('[' expr ']')+ ('['  ']')+('[' expr ']')+    #errorCreator
    |  nonArraytype ('[' expr ']')+ ('['  ']')*                   #arrayCreator
    |  nonArraytype '(' ')'                                       #classCreator
    |  nonArraytype                                               #narrayCreator
    ;


constant
    :  INTCONSTANT                                       #integerLiteral
    |  STRINGCONSTANT                                    #stringLiteral
    |  BOOLCONSTANT                                      #boolLiteral
    |  NULL                                              #nullLiteral
    ;



INT: 'int';
BOOL:'bool';
STRING: 'string';
NULL: 'null';
VOID: 'void';
ELSE: 'else';
FOR:  'for';
IF:      'if';
WHILE:  'while';
BREAK: 'break';
CONTINUE: 'continue';
RETURN:  'return';
NEW:    'new';
CLASS:  'class';
THIS:   'this';
TRUE:   'true';
FALSE:   'false';




INTCONSTANT
     : [0-9]+
     ;


STRINGCONSTANT
     : '"' ('//n' | '\\\\' | '\\"'|.)*? ' " '
     ;

BOOLCONSTANT
     : TRUE
     | FALSE
     ;

ID
    :  [a-zA-Z]+[a-zA-Z_0-9]*
    ;


WHITESPACE
    : [ \t\n\r]->skip
    ;


LINECOMMENT
    : '//' ~[\r\n]* ->skip
    ;


BLOCKCOMMENT
    : '/*' .*? '*/' ->skip
    ;

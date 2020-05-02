// Generated from MX.g4 by ANTLR 4.7.1

package compilerjava.Parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MXParser}.
 */
public interface MXListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MXParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MXParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MXParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#programParts}.
	 * @param ctx the parse tree
	 */
	void enterProgramParts(MXParser.ProgramPartsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#programParts}.
	 * @param ctx the parse tree
	 */
	void exitProgramParts(MXParser.ProgramPartsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MXParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MXParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(MXParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(MXParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(MXParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(MXParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#variableList}.
	 * @param ctx the parse tree
	 */
	void enterVariableList(MXParser.VariableListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#variableList}.
	 * @param ctx the parse tree
	 */
	void exitVariableList(MXParser.VariableListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#singleVariableDecl}.
	 * @param ctx the parse tree
	 */
	void enterSingleVariableDecl(MXParser.SingleVariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#singleVariableDecl}.
	 * @param ctx the parse tree
	 */
	void exitSingleVariableDecl(MXParser.SingleVariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(MXParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(MXParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void enterParamDecl(MXParser.ParamDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#paramDecl}.
	 * @param ctx the parse tree
	 */
	void exitParamDecl(MXParser.ParamDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MXParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MXParser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 */
	void enterNarrayType(MXParser.NarrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 */
	void exitNarrayType(MXParser.NarrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#typeForfunc}.
	 * @param ctx the parse tree
	 */
	void enterTypeForfunc(MXParser.TypeForfuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#typeForfunc}.
	 * @param ctx the parse tree
	 */
	void exitTypeForfunc(MXParser.TypeForfuncContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayTypeInt}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void enterNarrayTypeInt(MXParser.NarrayTypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayTypeInt}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void exitNarrayTypeInt(MXParser.NarrayTypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayTypeBool}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void enterNarrayTypeBool(MXParser.NarrayTypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayTypeBool}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void exitNarrayTypeBool(MXParser.NarrayTypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayTypeString}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void enterNarrayTypeString(MXParser.NarrayTypeStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayTypeString}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void exitNarrayTypeString(MXParser.NarrayTypeStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayID}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void enterNarrayID(MXParser.NarrayIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayID}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 */
	void exitNarrayID(MXParser.NarrayIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlockstmt(MXParser.BlockstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlockstmt(MXParser.BlockstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code vardeclstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterVardeclstmt(MXParser.VardeclstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code vardeclstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitVardeclstmt(MXParser.VardeclstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterExprstmt(MXParser.ExprstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitExprstmt(MXParser.ExprstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterConditionstmt(MXParser.ConditionstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitConditionstmt(MXParser.ConditionstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code loopstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterLoopstmt(MXParser.LoopstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code loopstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitLoopstmt(MXParser.LoopstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jumpstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterJumpstmt(MXParser.JumpstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jumpstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitJumpstmt(MXParser.JumpstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blankstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlankstmt(MXParser.BlankstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blankstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlankstmt(MXParser.BlankstmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MXParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MXParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(MXParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(MXParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhilestmt(MXParser.WhilestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhilestmt(MXParser.WhilestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void enterForstmt(MXParser.ForstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 */
	void exitForstmt(MXParser.ForstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnstmt(MXParser.ReturnstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnstmt(MXParser.ReturnstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakstmt(MXParser.BreakstmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakstmt(MXParser.BreakstmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinuestmt(MXParser.ContinuestmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinuestmt(MXParser.ContinuestmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryexpr(MXParser.UnaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryexpr(MXParser.UnaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(MXParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(MXParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterThisexpr(MXParser.ThisexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitThisexpr(MXParser.ThisexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubscript(MXParser.SubscriptContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubscript(MXParser.SubscriptContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberaccess}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMemberaccess(MXParser.MemberaccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberaccess}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMemberaccess(MXParser.MemberaccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNewexpr(MXParser.NewexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNewexpr(MXParser.NewexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctioncall(MXParser.FunctioncallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctioncall(MXParser.FunctioncallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinaryexpr(MXParser.BinaryexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinaryexpr(MXParser.BinaryexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code constantexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConstantexpr(MXParser.ConstantexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code constantexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConstantexpr(MXParser.ConstantexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSubexpr(MXParser.SubexprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSubexpr(MXParser.SubexprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code postcalcdecl}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostcalcdecl(MXParser.PostcalcdeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code postcalcdecl}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostcalcdecl(MXParser.PostcalcdeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MXParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(MXParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MXParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(MXParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterErrorCreator(MXParser.ErrorCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitErrorCreator(MXParser.ErrorCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreator(MXParser.ArrayCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreator(MXParser.ArrayCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterClassCreator(MXParser.ClassCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitClassCreator(MXParser.ClassCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code narrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void enterNarrayCreator(MXParser.NarrayCreatorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code narrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 */
	void exitNarrayCreator(MXParser.NarrayCreatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(MXParser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(MXParser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(MXParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(MXParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(MXParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(MXParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(MXParser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(MXParser.NullLiteralContext ctx);
}
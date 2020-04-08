// Generated from MX.g4 by ANTLR 4.7.1

package compilerjava.Parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MXParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MXVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MXParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MXParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#programParts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgramParts(MXParser.ProgramPartsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MXParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(MXParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(MXParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#variableList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableList(MXParser.VariableListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#singleVariableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleVariableDecl(MXParser.SingleVariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(MXParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#paramDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamDecl(MXParser.ParamDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayType(MXParser.ArrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayType}
	 * labeled alternative in {@link MXParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayType(MXParser.NarrayTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#typeForfunc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeForfunc(MXParser.TypeForfuncContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayTypeInt}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayTypeInt(MXParser.NarrayTypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayTypeBool}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayTypeBool(MXParser.NarrayTypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayTypeString}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayTypeString(MXParser.NarrayTypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayID}
	 * labeled alternative in {@link MXParser#nonArraytype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayID(MXParser.NarrayIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockstmt(MXParser.BlockstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code vardeclstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVardeclstmt(MXParser.VardeclstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprstmt(MXParser.ExprstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code conditionstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionstmt(MXParser.ConditionstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code loopstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopstmt(MXParser.LoopstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jumpstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpstmt(MXParser.JumpstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blankstmt}
	 * labeled alternative in {@link MXParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlankstmt(MXParser.BlankstmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MXParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#conditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(MXParser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whilestmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestmt(MXParser.WhilestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forstmt}
	 * labeled alternative in {@link MXParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForstmt(MXParser.ForstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnstmt(MXParser.ReturnstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code breakstmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakstmt(MXParser.BreakstmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code continuestmt}
	 * labeled alternative in {@link MXParser#jumpStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinuestmt(MXParser.ContinuestmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryexpr(MXParser.UnaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code identifier}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(MXParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code thisexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisexpr(MXParser.ThisexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subscript}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubscript(MXParser.SubscriptContext ctx);
	/**
	 * Visit a parse tree produced by the {@code memberaccess}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberaccess(MXParser.MemberaccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code newexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewexpr(MXParser.NewexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functioncall}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctioncall(MXParser.FunctioncallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryexpr(MXParser.BinaryexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constantexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantexpr(MXParser.ConstantexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code subexpr}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpr(MXParser.SubexprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code postcalcdecl}
	 * labeled alternative in {@link MXParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostcalcdecl(MXParser.PostcalcdeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MXParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(MXParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code errorCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitErrorCreator(MXParser.ErrorCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayCreator(MXParser.ArrayCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassCreator(MXParser.ClassCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code narrayCreator}
	 * labeled alternative in {@link MXParser#creator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNarrayCreator(MXParser.NarrayCreatorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerLiteral(MXParser.IntegerLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(MXParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(MXParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code nullLiteral}
	 * labeled alternative in {@link MXParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(MXParser.NullLiteralContext ctx);
}
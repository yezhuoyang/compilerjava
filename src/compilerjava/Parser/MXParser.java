// Generated from MX.g4 by ANTLR 4.7.1

package compilerjava.Parser;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MXParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, INT=33, BOOL=34, STRING=35, VOID=36, ELSE=37, FOR=38, IF=39, 
		WHILE=40, BREAK=41, CONTINUE=42, RETURN=43, NEW=44, CLASS=45, THIS=46, 
		INTCONSTANT=47, STRINGCONSTANT=48, NULLCONSTANT=49, BOOLCONSTANT=50, ID=51, 
		WHITESPACE=52, LINECOMMENT=53, BLOCKCOMMENT=54;
	public static final int
		RULE_program = 0, RULE_programParts = 1, RULE_functionDecl = 2, RULE_classDecl = 3, 
		RULE_variableDecl = 4, RULE_variableList = 5, RULE_singleVariableDecl = 6, 
		RULE_params = 7, RULE_paramDecl = 8, RULE_type = 9, RULE_typeForfunc = 10, 
		RULE_nonArraytype = 11, RULE_stmt = 12, RULE_block = 13, RULE_conditionStatement = 14, 
		RULE_loopStatement = 15, RULE_jumpStatement = 16, RULE_expr = 17, RULE_paramList = 18, 
		RULE_creator = 19, RULE_constant = 20;
	public static final String[] ruleNames = {
		"program", "programParts", "functionDecl", "classDecl", "variableDecl", 
		"variableList", "singleVariableDecl", "params", "paramDecl", "type", "typeForfunc", 
		"nonArraytype", "stmt", "block", "conditionStatement", "loopStatement", 
		"jumpStatement", "expr", "paramList", "creator", "constant"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "'}'", "';'", "','", "'='", "'['", "']'", "'++'", 
		"'--'", "'.'", "'+'", "'-'", "'!'", "'~'", "'*'", "'/'", "'%'", "'<<'", 
		"'>>'", "'<'", "'>'", "'<='", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", 
		"'&&'", "'||'", "'int'", "'bool'", "'string'", "'void'", "'else'", "'for'", 
		"'if'", "'while'", "'break'", "'continue'", "'return'", "'new'", "'class'", 
		"'this'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "INT", "BOOL", "STRING", 
		"VOID", "ELSE", "FOR", "IF", "WHILE", "BREAK", "CONTINUE", "RETURN", "NEW", 
		"CLASS", "THIS", "INTCONSTANT", "STRINGCONSTANT", "NULLCONSTANT", "BOOLCONSTANT", 
		"ID", "WHITESPACE", "LINECOMMENT", "BLOCKCOMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "MX.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MXParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<ProgramPartsContext> programParts() {
			return getRuleContexts(ProgramPartsContext.class);
		}
		public ProgramPartsContext programParts(int i) {
			return getRuleContext(ProgramPartsContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << ID))) != 0)) {
				{
				{
				setState(42);
				programParts();
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramPartsContext extends ParserRuleContext {
		public FunctionDeclContext functionDecl() {
			return getRuleContext(FunctionDeclContext.class,0);
		}
		public ClassDeclContext classDecl() {
			return getRuleContext(ClassDeclContext.class,0);
		}
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public ProgramPartsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programParts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterProgramParts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitProgramParts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitProgramParts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramPartsContext programParts() throws RecognitionException {
		ProgramPartsContext _localctx = new ProgramPartsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programParts);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				functionDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				classDecl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				variableDecl();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeForfuncContext typeForfunc() {
			return getRuleContext(TypeForfuncContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(53);
				typeForfunc();
				}
				break;
			}
			setState(56);
			match(ID);
			setState(57);
			match(T__0);
			setState(59);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << ID))) != 0)) {
				{
				setState(58);
				params();
				}
			}

			setState(61);
			match(T__1);
			setState(62);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MXParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(CLASS);
			setState(65);
			match(ID);
			setState(66);
			match(T__2);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(69);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
				case 1:
					{
					setState(67);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(68);
					variableDecl();
					}
					break;
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__3);
			setState(75);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableListContext variableList() {
			return getRuleContext(VariableListContext.class,0);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			type(0);
			setState(78);
			variableList();
			setState(79);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableListContext extends ParserRuleContext {
		public List<SingleVariableDeclContext> singleVariableDecl() {
			return getRuleContexts(SingleVariableDeclContext.class);
		}
		public SingleVariableDeclContext singleVariableDecl(int i) {
			return getRuleContext(SingleVariableDeclContext.class,i);
		}
		public VariableListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterVariableList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitVariableList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitVariableList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableListContext variableList() throws RecognitionException {
		VariableListContext _localctx = new VariableListContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_variableList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(81);
			singleVariableDecl();
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(82);
				match(T__5);
				setState(83);
				singleVariableDecl();
				}
				}
				setState(88);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleVariableDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SingleVariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleVariableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterSingleVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitSingleVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitSingleVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleVariableDeclContext singleVariableDecl() throws RecognitionException {
		SingleVariableDeclContext _localctx = new SingleVariableDeclContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_singleVariableDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(ID);
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(90);
				match(T__6);
				setState(91);
				expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamsContext extends ParserRuleContext {
		public List<ParamDeclContext> paramDecl() {
			return getRuleContexts(ParamDeclContext.class);
		}
		public ParamDeclContext paramDecl(int i) {
			return getRuleContext(ParamDeclContext.class,i);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_params);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			paramDecl();
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(95);
				match(T__5);
				setState(96);
				paramDecl();
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParamDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public ParamDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterParamDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitParamDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitParamDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamDeclContext paramDecl() throws RecognitionException {
		ParamDeclContext _localctx = new ParamDeclContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_paramDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			type(0);
			setState(103);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ArrayTypeContext extends TypeContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ArrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NarrayTypeContext extends TypeContext {
		public NonArraytypeContext nonArraytype() {
			return getRuleContext(NonArraytypeContext.class,0);
		}
		public NarrayTypeContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_type, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new NarrayTypeContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(106);
			nonArraytype();
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ArrayTypeContext(new TypeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(108);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(109);
					match(T__7);
					setState(110);
					match(T__8);
					}
					} 
				}
				setState(115);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TypeForfuncContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(MXParser.VOID, 0); }
		public TypeForfuncContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeForfunc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterTypeForfunc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitTypeForfunc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitTypeForfunc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeForfuncContext typeForfunc() throws RecognitionException {
		TypeForfuncContext _localctx = new TypeForfuncContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeForfunc);
		try {
			setState(118);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case BOOL:
			case STRING:
			case ID:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				type(0);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NonArraytypeContext extends ParserRuleContext {
		public NonArraytypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonArraytype; }
	 
		public NonArraytypeContext() { }
		public void copyFrom(NonArraytypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NarrayTypeIntContext extends NonArraytypeContext {
		public TerminalNode INT() { return getToken(MXParser.INT, 0); }
		public NarrayTypeIntContext(NonArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayTypeInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayTypeInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayTypeInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NarrayTypeBoolContext extends NonArraytypeContext {
		public TerminalNode BOOL() { return getToken(MXParser.BOOL, 0); }
		public NarrayTypeBoolContext(NonArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayTypeBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayTypeBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayTypeBool(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NarrayTypeStringContext extends NonArraytypeContext {
		public TerminalNode STRING() { return getToken(MXParser.STRING, 0); }
		public NarrayTypeStringContext(NonArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayTypeString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayTypeString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayTypeString(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NarrayIDContext extends NonArraytypeContext {
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public NarrayIDContext(NonArraytypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayID(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NonArraytypeContext nonArraytype() throws RecognitionException {
		NonArraytypeContext _localctx = new NonArraytypeContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nonArraytype);
		try {
			setState(124);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new NarrayTypeIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				match(INT);
				}
				break;
			case BOOL:
				_localctx = new NarrayTypeBoolContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				match(BOOL);
				}
				break;
			case STRING:
				_localctx = new NarrayTypeStringContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				match(STRING);
				}
				break;
			case ID:
				_localctx = new NarrayIDContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	 
		public StmtContext() { }
		public void copyFrom(StmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ExprstmtContext extends StmtContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterExprstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitExprstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitExprstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LoopstmtContext extends StmtContext {
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public LoopstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterLoopstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitLoopstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitLoopstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpstmtContext extends StmtContext {
		public JumpStatementContext jumpStatement() {
			return getRuleContext(JumpStatementContext.class,0);
		}
		public JumpstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterJumpstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitJumpstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitJumpstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlankstmtContext extends StmtContext {
		public BlankstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBlankstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBlankstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBlankstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VardeclstmtContext extends StmtContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public VardeclstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterVardeclstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitVardeclstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitVardeclstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockstmtContext extends StmtContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBlockstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBlockstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBlockstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConditionstmtContext extends StmtContext {
		public ConditionStatementContext conditionStatement() {
			return getRuleContext(ConditionStatementContext.class,0);
		}
		public ConditionstmtContext(StmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterConditionstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitConditionstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitConditionstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_stmt);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				_localctx = new BlockstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(126);
				block();
				}
				break;
			case 2:
				_localctx = new VardeclstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(127);
				variableDecl();
				}
				break;
			case 3:
				_localctx = new ExprstmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(128);
				expr(0);
				setState(129);
				match(T__4);
				}
				break;
			case 4:
				_localctx = new ConditionstmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(131);
				conditionStatement();
				}
				break;
			case 5:
				_localctx = new LoopstmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(132);
				loopStatement();
				}
				break;
			case 6:
				_localctx = new JumpstmtContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(133);
				jumpStatement();
				}
				break;
			case 7:
				_localctx = new BlankstmtContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(134);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__2);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << INT) | (1L << BOOL) | (1L << STRING) | (1L << FOR) | (1L << IF) | (1L << WHILE) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
				{
				{
				setState(138);
				stmt();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionStatementContext extends ParserRuleContext {
		public StmtContext thenStmt;
		public StmtContext elseStmt;
		public TerminalNode IF() { return getToken(MXParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MXParser.ELSE, 0); }
		public ConditionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterConditionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitConditionStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitConditionStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionStatementContext conditionStatement() throws RecognitionException {
		ConditionStatementContext _localctx = new ConditionStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_conditionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IF);
			setState(147);
			match(T__0);
			setState(148);
			expr(0);
			setState(149);
			match(T__1);
			setState(150);
			((ConditionStatementContext)_localctx).thenStmt = stmt();
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(151);
				match(ELSE);
				setState(152);
				((ConditionStatementContext)_localctx).elseStmt = stmt();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoopStatementContext extends ParserRuleContext {
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
	 
		public LoopStatementContext() { }
		public void copyFrom(LoopStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class WhilestmtContext extends LoopStatementContext {
		public TerminalNode WHILE() { return getToken(MXParser.WHILE, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public WhilestmtContext(LoopStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterWhilestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitWhilestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitWhilestmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForstmtContext extends LoopStatementContext {
		public ExprContext init;
		public ExprContext cond;
		public ExprContext step;
		public TerminalNode FOR() { return getToken(MXParser.FOR, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ForstmtContext(LoopStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterForstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitForstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitForstmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_loopStatement);
		int _la;
		try {
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				_localctx = new WhilestmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				match(WHILE);
				setState(156);
				match(T__0);
				setState(157);
				expr(0);
				setState(158);
				match(T__1);
				setState(159);
				stmt();
				}
				break;
			case FOR:
				_localctx = new ForstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(FOR);
				setState(162);
				match(T__0);
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
					{
					setState(163);
					((ForstmtContext)_localctx).init = expr(0);
					}
				}

				setState(166);
				match(T__4);
				setState(168);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
					{
					setState(167);
					((ForstmtContext)_localctx).cond = expr(0);
					}
				}

				setState(170);
				match(T__4);
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
					{
					setState(171);
					((ForstmtContext)_localctx).step = expr(0);
					}
				}

				setState(174);
				match(T__1);
				setState(175);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JumpStatementContext extends ParserRuleContext {
		public JumpStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpStatement; }
	 
		public JumpStatementContext() { }
		public void copyFrom(JumpStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ReturnstmtContext extends JumpStatementContext {
		public TerminalNode RETURN() { return getToken(MXParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ReturnstmtContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterReturnstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitReturnstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitReturnstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakstmtContext extends JumpStatementContext {
		public TerminalNode BREAK() { return getToken(MXParser.BREAK, 0); }
		public BreakstmtContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBreakstmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBreakstmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBreakstmt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinuestmtContext extends JumpStatementContext {
		public TerminalNode CONTINUE() { return getToken(MXParser.CONTINUE, 0); }
		public ContinuestmtContext(JumpStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterContinuestmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitContinuestmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitContinuestmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpStatementContext jumpStatement() throws RecognitionException {
		JumpStatementContext _localctx = new JumpStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jumpStatement);
		int _la;
		try {
			setState(187);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				_localctx = new ReturnstmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				match(RETURN);
				setState(180);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
					{
					setState(179);
					expr(0);
					}
				}

				setState(182);
				match(T__4);
				}
				break;
			case BREAK:
				_localctx = new BreakstmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(183);
				match(BREAK);
				setState(184);
				match(T__4);
				}
				break;
			case CONTINUE:
				_localctx = new ContinuestmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(185);
				match(CONTINUE);
				setState(186);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnaryexprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnaryexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterUnaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitUnaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitUnaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdentifierContext extends ExprContext {
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public IdentifierContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisexprContext extends ExprContext {
		public TerminalNode THIS() { return getToken(MXParser.THIS, 0); }
		public ThisexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterThisexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitThisexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitThisexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubscriptContext extends ExprContext {
		public ExprContext array;
		public ExprContext index;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public SubscriptContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterSubscript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitSubscript(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitSubscript(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberaccessContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(MXParser.ID, 0); }
		public MemberaccessContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterMemberaccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitMemberaccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitMemberaccess(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NewexprContext extends ExprContext {
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public NewexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNewexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNewexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNewexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctioncallContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParamListContext paramList() {
			return getRuleContext(ParamListContext.class,0);
		}
		public FunctioncallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterFunctioncall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitFunctioncall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitFunctioncall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryexprContext extends ExprContext {
		public ExprContext src1;
		public Token op;
		public ExprContext src2;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinaryexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBinaryexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBinaryexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBinaryexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstantexprContext extends ExprContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ConstantexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterConstantexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitConstantexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitConstantexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubexprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public SubexprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterSubexpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitSubexpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitSubexpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PostcalcdeclContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PostcalcdeclContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterPostcalcdecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitPostcalcdecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitPostcalcdecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				{
				_localctx = new NewexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(190);
				match(NEW);
				setState(191);
				creator();
				}
				break;
			case T__9:
			case T__10:
				{
				_localctx = new UnaryexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				((UnaryexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__9 || _la==T__10) ) {
					((UnaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(193);
				expr(19);
				}
				break;
			case T__12:
			case T__13:
				{
				_localctx = new UnaryexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				((UnaryexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
					((UnaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(195);
				expr(18);
				}
				break;
			case T__14:
			case T__15:
				{
				_localctx = new UnaryexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				((UnaryexprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
					((UnaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(197);
				expr(17);
				}
				break;
			case ID:
				{
				_localctx = new IdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(ID);
				}
				break;
			case THIS:
				{
				_localctx = new ThisexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(THIS);
				}
				break;
			case INTCONSTANT:
			case STRINGCONSTANT:
			case NULLCONSTANT:
			case BOOLCONSTANT:
				{
				_localctx = new ConstantexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				constant();
				}
				break;
			case T__0:
				{
				_localctx = new SubexprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(T__0);
				setState(202);
				expr(0);
				setState(203);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(259);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(208);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(209);
						((BinaryexprContext)_localctx).src2 = expr(17);
						}
						break;
					case 2:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(211);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__12 || _la==T__13) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(212);
						((BinaryexprContext)_localctx).src2 = expr(16);
						}
						break;
					case 3:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(214);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(215);
						((BinaryexprContext)_localctx).src2 = expr(15);
						}
						break;
					case 4:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(217);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(218);
						((BinaryexprContext)_localctx).src2 = expr(14);
						}
						break;
					case 5:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(220);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__23 || _la==T__24) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(221);
						((BinaryexprContext)_localctx).src2 = expr(13);
						}
						break;
					case 6:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(223);
						((BinaryexprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__25 || _la==T__26) ) {
							((BinaryexprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(224);
						((BinaryexprContext)_localctx).src2 = expr(12);
						}
						break;
					case 7:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(226);
						((BinaryexprContext)_localctx).op = match(T__27);
						setState(227);
						((BinaryexprContext)_localctx).src2 = expr(11);
						}
						break;
					case 8:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(228);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(229);
						((BinaryexprContext)_localctx).op = match(T__28);
						setState(230);
						((BinaryexprContext)_localctx).src2 = expr(10);
						}
						break;
					case 9:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(231);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(232);
						((BinaryexprContext)_localctx).op = match(T__29);
						setState(233);
						((BinaryexprContext)_localctx).src2 = expr(9);
						}
						break;
					case 10:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(234);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(235);
						((BinaryexprContext)_localctx).op = match(T__30);
						setState(236);
						((BinaryexprContext)_localctx).src2 = expr(8);
						}
						break;
					case 11:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(237);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(238);
						((BinaryexprContext)_localctx).op = match(T__31);
						setState(239);
						((BinaryexprContext)_localctx).src2 = expr(7);
						}
						break;
					case 12:
						{
						_localctx = new BinaryexprContext(new ExprContext(_parentctx, _parentState));
						((BinaryexprContext)_localctx).src1 = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(240);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(241);
						((BinaryexprContext)_localctx).op = match(T__6);
						setState(242);
						((BinaryexprContext)_localctx).src2 = expr(5);
						}
						break;
					case 13:
						{
						_localctx = new PostcalcdeclContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(244);
						((PostcalcdeclContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__9 || _la==T__10) ) {
							((PostcalcdeclContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 14:
						{
						_localctx = new FunctioncallContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(245);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(246);
						match(T__0);
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__9) | (1L << T__10) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15) | (1L << NEW) | (1L << THIS) | (1L << INTCONSTANT) | (1L << STRINGCONSTANT) | (1L << NULLCONSTANT) | (1L << BOOLCONSTANT) | (1L << ID))) != 0)) {
							{
							setState(247);
							paramList();
							}
						}

						setState(250);
						match(T__1);
						}
						break;
					case 15:
						{
						_localctx = new SubscriptContext(new ExprContext(_parentctx, _parentState));
						((SubscriptContext)_localctx).array = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(251);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(252);
						match(T__7);
						setState(253);
						((SubscriptContext)_localctx).index = expr(0);
						setState(254);
						match(T__8);
						}
						break;
					case 16:
						{
						_localctx = new MemberaccessContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(256);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(257);
						match(T__11);
						setState(258);
						match(ID);
						}
						break;
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ParamListContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ParamListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterParamList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitParamList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitParamList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamListContext paramList() throws RecognitionException {
		ParamListContext _localctx = new ParamListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_paramList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			expr(0);
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(265);
				match(T__5);
				setState(266);
				expr(0);
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreatorContext extends ParserRuleContext {
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	 
		public CreatorContext() { }
		public void copyFrom(CreatorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ClassCreatorContext extends CreatorContext {
		public NonArraytypeContext nonArraytype() {
			return getRuleContext(NonArraytypeContext.class,0);
		}
		public ClassCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterClassCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitClassCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitClassCreator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NarrayCreatorContext extends CreatorContext {
		public NonArraytypeContext nonArraytype() {
			return getRuleContext(NonArraytypeContext.class,0);
		}
		public NarrayCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNarrayCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNarrayCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNarrayCreator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayCreatorContext extends CreatorContext {
		public NonArraytypeContext nonArraytype() {
			return getRuleContext(NonArraytypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ArrayCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterArrayCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitArrayCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitArrayCreator(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ErrorCreatorContext extends CreatorContext {
		public NonArraytypeContext nonArraytype() {
			return getRuleContext(NonArraytypeContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ErrorCreatorContext(CreatorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterErrorCreator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitErrorCreator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitErrorCreator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_creator);
		try {
			int _alt;
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				_localctx = new ErrorCreatorContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				nonArraytype();
				setState(277); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(273);
						match(T__7);
						setState(274);
						expr(0);
						setState(275);
						match(T__8);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(279); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(283); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(281);
						match(T__7);
						setState(282);
						match(T__8);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(285); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(291); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(287);
						match(T__7);
						setState(288);
						expr(0);
						setState(289);
						match(T__8);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(293); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				_localctx = new ArrayCreatorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(295);
				nonArraytype();
				setState(300); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(296);
						match(T__7);
						setState(297);
						expr(0);
						setState(298);
						match(T__8);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(302); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(308);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(304);
						match(T__7);
						setState(305);
						match(T__8);
						}
						} 
					}
					setState(310);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
				}
				}
				break;
			case 3:
				_localctx = new ClassCreatorContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				nonArraytype();
				setState(312);
				match(T__0);
				setState(313);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new NarrayCreatorContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(315);
				nonArraytype();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
	 
		public ConstantContext() { }
		public void copyFrom(ConstantContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NullLiteralContext extends ConstantContext {
		public TerminalNode NULLCONSTANT() { return getToken(MXParser.NULLCONSTANT, 0); }
		public NullLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitNullLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitNullLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringLiteralContext extends ConstantContext {
		public TerminalNode STRINGCONSTANT() { return getToken(MXParser.STRINGCONSTANT, 0); }
		public StringLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntegerLiteralContext extends ConstantContext {
		public TerminalNode INTCONSTANT() { return getToken(MXParser.INTCONSTANT, 0); }
		public IntegerLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitIntegerLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitIntegerLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolLiteralContext extends ConstantContext {
		public TerminalNode BOOLCONSTANT() { return getToken(MXParser.BOOLCONSTANT, 0); }
		public BoolLiteralContext(ConstantContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).enterBoolLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MXListener ) ((MXListener)listener).exitBoolLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MXVisitor ) return ((MXVisitor<? extends T>)visitor).visitBoolLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_constant);
		try {
			setState(322);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INTCONSTANT:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(318);
				match(INTCONSTANT);
				}
				break;
			case STRINGCONSTANT:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(319);
				match(STRINGCONSTANT);
				}
				break;
			case BOOLCONSTANT:
				_localctx = new BoolLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(320);
				match(BOOLCONSTANT);
				}
				break;
			case NULLCONSTANT:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(321);
				match(NULLCONSTANT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 9:
			return type_sempred((TypeContext)_localctx, predIndex);
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 16);
		case 2:
			return precpred(_ctx, 15);
		case 3:
			return precpred(_ctx, 14);
		case 4:
			return precpred(_ctx, 13);
		case 5:
			return precpred(_ctx, 12);
		case 6:
			return precpred(_ctx, 11);
		case 7:
			return precpred(_ctx, 10);
		case 8:
			return precpred(_ctx, 9);
		case 9:
			return precpred(_ctx, 8);
		case 10:
			return precpred(_ctx, 7);
		case 11:
			return precpred(_ctx, 6);
		case 12:
			return precpred(_ctx, 5);
		case 13:
			return precpred(_ctx, 24);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 21);
		case 16:
			return precpred(_ctx, 20);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\38\u0147\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\3\2\7\2.\n\2\f\2\16\2\61\13\2"+
		"\3\3\3\3\3\3\5\3\66\n\3\3\4\5\49\n\4\3\4\3\4\3\4\5\4>\n\4\3\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\3\5\7\5H\n\5\f\5\16\5K\13\5\3\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7W\n\7\f\7\16\7Z\13\7\3\b\3\b\3\b\5\b_\n\b\3\t\3\t\3"+
		"\t\7\td\n\t\f\t\16\tg\13\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\7"+
		"\13r\n\13\f\13\16\13u\13\13\3\f\3\f\5\fy\n\f\3\r\3\r\3\r\3\r\5\r\177\n"+
		"\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u008a\n\16\3\17\3"+
		"\17\7\17\u008e\n\17\f\17\16\17\u0091\13\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\5\20\u009c\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00a7\n\21\3\21\3\21\5\21\u00ab\n\21\3\21\3\21\5\21\u00af"+
		"\n\21\3\21\3\21\5\21\u00b3\n\21\3\22\3\22\5\22\u00b7\n\22\3\22\3\22\3"+
		"\22\3\22\3\22\5\22\u00be\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00d0\n\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00fb\n\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u0106\n\23\f\23\16\23\u0109"+
		"\13\23\3\24\3\24\3\24\7\24\u010e\n\24\f\24\16\24\u0111\13\24\3\25\3\25"+
		"\3\25\3\25\3\25\6\25\u0118\n\25\r\25\16\25\u0119\3\25\3\25\6\25\u011e"+
		"\n\25\r\25\16\25\u011f\3\25\3\25\3\25\3\25\6\25\u0126\n\25\r\25\16\25"+
		"\u0127\3\25\3\25\3\25\3\25\3\25\6\25\u012f\n\25\r\25\16\25\u0130\3\25"+
		"\3\25\7\25\u0135\n\25\f\25\16\25\u0138\13\25\3\25\3\25\3\25\3\25\3\25"+
		"\5\25\u013f\n\25\3\26\3\26\3\26\3\26\5\26\u0145\n\26\3\26\2\4\24$\27\2"+
		"\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*\2\n\3\2\f\r\3\2\17\20\3\2"+
		"\21\22\3\2\23\25\3\2\26\27\3\2\30\31\3\2\32\33\3\2\34\35\2\u0173\2/\3"+
		"\2\2\2\4\65\3\2\2\2\68\3\2\2\2\bB\3\2\2\2\nO\3\2\2\2\fS\3\2\2\2\16[\3"+
		"\2\2\2\20`\3\2\2\2\22h\3\2\2\2\24k\3\2\2\2\26x\3\2\2\2\30~\3\2\2\2\32"+
		"\u0089\3\2\2\2\34\u008b\3\2\2\2\36\u0094\3\2\2\2 \u00b2\3\2\2\2\"\u00bd"+
		"\3\2\2\2$\u00cf\3\2\2\2&\u010a\3\2\2\2(\u013e\3\2\2\2*\u0144\3\2\2\2,"+
		".\5\4\3\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\3\3\2\2\2\61"+
		"/\3\2\2\2\62\66\5\6\4\2\63\66\5\b\5\2\64\66\5\n\6\2\65\62\3\2\2\2\65\63"+
		"\3\2\2\2\65\64\3\2\2\2\66\5\3\2\2\2\679\5\26\f\28\67\3\2\2\289\3\2\2\2"+
		"9:\3\2\2\2:;\7\65\2\2;=\7\3\2\2<>\5\20\t\2=<\3\2\2\2=>\3\2\2\2>?\3\2\2"+
		"\2?@\7\4\2\2@A\5\34\17\2A\7\3\2\2\2BC\7/\2\2CD\7\65\2\2DI\7\5\2\2EH\5"+
		"\6\4\2FH\5\n\6\2GE\3\2\2\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3"+
		"\2\2\2KI\3\2\2\2LM\7\6\2\2MN\7\7\2\2N\t\3\2\2\2OP\5\24\13\2PQ\5\f\7\2"+
		"QR\7\7\2\2R\13\3\2\2\2SX\5\16\b\2TU\7\b\2\2UW\5\16\b\2VT\3\2\2\2WZ\3\2"+
		"\2\2XV\3\2\2\2XY\3\2\2\2Y\r\3\2\2\2ZX\3\2\2\2[^\7\65\2\2\\]\7\t\2\2]_"+
		"\5$\23\2^\\\3\2\2\2^_\3\2\2\2_\17\3\2\2\2`e\5\22\n\2ab\7\b\2\2bd\5\22"+
		"\n\2ca\3\2\2\2dg\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\21\3\2\2\2ge\3\2\2\2hi\5"+
		"\24\13\2ij\7\65\2\2j\23\3\2\2\2kl\b\13\1\2lm\5\30\r\2ms\3\2\2\2no\f\4"+
		"\2\2op\7\n\2\2pr\7\13\2\2qn\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3\2\2\2t\25"+
		"\3\2\2\2us\3\2\2\2vy\5\24\13\2wy\7&\2\2xv\3\2\2\2xw\3\2\2\2y\27\3\2\2"+
		"\2z\177\7#\2\2{\177\7$\2\2|\177\7%\2\2}\177\7\65\2\2~z\3\2\2\2~{\3\2\2"+
		"\2~|\3\2\2\2~}\3\2\2\2\177\31\3\2\2\2\u0080\u008a\5\34\17\2\u0081\u008a"+
		"\5\n\6\2\u0082\u0083\5$\23\2\u0083\u0084\7\7\2\2\u0084\u008a\3\2\2\2\u0085"+
		"\u008a\5\36\20\2\u0086\u008a\5 \21\2\u0087\u008a\5\"\22\2\u0088\u008a"+
		"\7\7\2\2\u0089\u0080\3\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089"+
		"\u0085\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2"+
		"\2\2\u008a\33\3\2\2\2\u008b\u008f\7\5\2\2\u008c\u008e\5\32\16\2\u008d"+
		"\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2"+
		"\2\2\u0090\u0092\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\6\2\2\u0093"+
		"\35\3\2\2\2\u0094\u0095\7)\2\2\u0095\u0096\7\3\2\2\u0096\u0097\5$\23\2"+
		"\u0097\u0098\7\4\2\2\u0098\u009b\5\32\16\2\u0099\u009a\7\'\2\2\u009a\u009c"+
		"\5\32\16\2\u009b\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\37\3\2\2\2\u009d"+
		"\u009e\7*\2\2\u009e\u009f\7\3\2\2\u009f\u00a0\5$\23\2\u00a0\u00a1\7\4"+
		"\2\2\u00a1\u00a2\5\32\16\2\u00a2\u00b3\3\2\2\2\u00a3\u00a4\7(\2\2\u00a4"+
		"\u00a6\7\3\2\2\u00a5\u00a7\5$\23\2\u00a6\u00a5\3\2\2\2\u00a6\u00a7\3\2"+
		"\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00aa\7\7\2\2\u00a9\u00ab\5$\23\2\u00aa"+
		"\u00a9\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\7\7"+
		"\2\2\u00ad\u00af\5$\23\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\u00b0\3\2\2\2\u00b0\u00b1\7\4\2\2\u00b1\u00b3\5\32\16\2\u00b2\u009d\3"+
		"\2\2\2\u00b2\u00a3\3\2\2\2\u00b3!\3\2\2\2\u00b4\u00b6\7-\2\2\u00b5\u00b7"+
		"\5$\23\2\u00b6\u00b5\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00be\7\7\2\2\u00b9\u00ba\7+\2\2\u00ba\u00be\7\7\2\2\u00bb\u00bc\7,\2"+
		"\2\u00bc\u00be\7\7\2\2\u00bd\u00b4\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be#\3\2\2\2\u00bf\u00c0\b\23\1\2\u00c0\u00c1\7.\2\2\u00c1"+
		"\u00d0\5(\25\2\u00c2\u00c3\t\2\2\2\u00c3\u00d0\5$\23\25\u00c4\u00c5\t"+
		"\3\2\2\u00c5\u00d0\5$\23\24\u00c6\u00c7\t\4\2\2\u00c7\u00d0\5$\23\23\u00c8"+
		"\u00d0\7\65\2\2\u00c9\u00d0\7\60\2\2\u00ca\u00d0\5*\26\2\u00cb\u00cc\7"+
		"\3\2\2\u00cc\u00cd\5$\23\2\u00cd\u00ce\7\4\2\2\u00ce\u00d0\3\2\2\2\u00cf"+
		"\u00bf\3\2\2\2\u00cf\u00c2\3\2\2\2\u00cf\u00c4\3\2\2\2\u00cf\u00c6\3\2"+
		"\2\2\u00cf\u00c8\3\2\2\2\u00cf\u00c9\3\2\2\2\u00cf\u00ca\3\2\2\2\u00cf"+
		"\u00cb\3\2\2\2\u00d0\u0107\3\2\2\2\u00d1\u00d2\f\22\2\2\u00d2\u00d3\t"+
		"\5\2\2\u00d3\u0106\5$\23\23\u00d4\u00d5\f\21\2\2\u00d5\u00d6\t\3\2\2\u00d6"+
		"\u0106\5$\23\22\u00d7\u00d8\f\20\2\2\u00d8\u00d9\t\6\2\2\u00d9\u0106\5"+
		"$\23\21\u00da\u00db\f\17\2\2\u00db\u00dc\t\7\2\2\u00dc\u0106\5$\23\20"+
		"\u00dd\u00de\f\16\2\2\u00de\u00df\t\b\2\2\u00df\u0106\5$\23\17\u00e0\u00e1"+
		"\f\r\2\2\u00e1\u00e2\t\t\2\2\u00e2\u0106\5$\23\16\u00e3\u00e4\f\f\2\2"+
		"\u00e4\u00e5\7\36\2\2\u00e5\u0106\5$\23\r\u00e6\u00e7\f\13\2\2\u00e7\u00e8"+
		"\7\37\2\2\u00e8\u0106\5$\23\f\u00e9\u00ea\f\n\2\2\u00ea\u00eb\7 \2\2\u00eb"+
		"\u0106\5$\23\13\u00ec\u00ed\f\t\2\2\u00ed\u00ee\7!\2\2\u00ee\u0106\5$"+
		"\23\n\u00ef\u00f0\f\b\2\2\u00f0\u00f1\7\"\2\2\u00f1\u0106\5$\23\t\u00f2"+
		"\u00f3\f\7\2\2\u00f3\u00f4\7\t\2\2\u00f4\u0106\5$\23\7\u00f5\u00f6\f\32"+
		"\2\2\u00f6\u0106\t\2\2\2\u00f7\u00f8\f\30\2\2\u00f8\u00fa\7\3\2\2\u00f9"+
		"\u00fb\5&\24\2\u00fa\u00f9\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fb\u00fc\3\2"+
		"\2\2\u00fc\u0106\7\4\2\2\u00fd\u00fe\f\27\2\2\u00fe\u00ff\7\n\2\2\u00ff"+
		"\u0100\5$\23\2\u0100\u0101\7\13\2\2\u0101\u0106\3\2\2\2\u0102\u0103\f"+
		"\26\2\2\u0103\u0104\7\16\2\2\u0104\u0106\7\65\2\2\u0105\u00d1\3\2\2\2"+
		"\u0105\u00d4\3\2\2\2\u0105\u00d7\3\2\2\2\u0105\u00da\3\2\2\2\u0105\u00dd"+
		"\3\2\2\2\u0105\u00e0\3\2\2\2\u0105\u00e3\3\2\2\2\u0105\u00e6\3\2\2\2\u0105"+
		"\u00e9\3\2\2\2\u0105\u00ec\3\2\2\2\u0105\u00ef\3\2\2\2\u0105\u00f2\3\2"+
		"\2\2\u0105\u00f5\3\2\2\2\u0105\u00f7\3\2\2\2\u0105\u00fd\3\2\2\2\u0105"+
		"\u0102\3\2\2\2\u0106\u0109\3\2\2\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108%\3\2\2\2\u0109\u0107\3\2\2\2\u010a\u010f\5$\23\2\u010b\u010c"+
		"\7\b\2\2\u010c\u010e\5$\23\2\u010d\u010b\3\2\2\2\u010e\u0111\3\2\2\2\u010f"+
		"\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\'\3\2\2\2\u0111\u010f\3\2\2\2"+
		"\u0112\u0117\5\30\r\2\u0113\u0114\7\n\2\2\u0114\u0115\5$\23\2\u0115\u0116"+
		"\7\13\2\2\u0116\u0118\3\2\2\2\u0117\u0113\3\2\2\2\u0118\u0119\3\2\2\2"+
		"\u0119\u0117\3\2\2\2\u0119\u011a\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u011c"+
		"\7\n\2\2\u011c\u011e\7\13\2\2\u011d\u011b\3\2\2\2\u011e\u011f\3\2\2\2"+
		"\u011f\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u0125\3\2\2\2\u0121\u0122"+
		"\7\n\2\2\u0122\u0123\5$\23\2\u0123\u0124\7\13\2\2\u0124\u0126\3\2\2\2"+
		"\u0125\u0121\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0128"+
		"\3\2\2\2\u0128\u013f\3\2\2\2\u0129\u012e\5\30\r\2\u012a\u012b\7\n\2\2"+
		"\u012b\u012c\5$\23\2\u012c\u012d\7\13\2\2\u012d\u012f\3\2\2\2\u012e\u012a"+
		"\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131"+
		"\u0136\3\2\2\2\u0132\u0133\7\n\2\2\u0133\u0135\7\13\2\2\u0134\u0132\3"+
		"\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137\3\2\2\2\u0137"+
		"\u013f\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\5\30\r\2\u013a\u013b\7"+
		"\3\2\2\u013b\u013c\7\4\2\2\u013c\u013f\3\2\2\2\u013d\u013f\5\30\r\2\u013e"+
		"\u0112\3\2\2\2\u013e\u0129\3\2\2\2\u013e\u0139\3\2\2\2\u013e\u013d\3\2"+
		"\2\2\u013f)\3\2\2\2\u0140\u0145\7\61\2\2\u0141\u0145\7\62\2\2\u0142\u0145"+
		"\7\64\2\2\u0143\u0145\7\63\2\2\u0144\u0140\3\2\2\2\u0144\u0141\3\2\2\2"+
		"\u0144\u0142\3\2\2\2\u0144\u0143\3\2\2\2\u0145+\3\2\2\2#/\658=GIX^esx"+
		"~\u0089\u008f\u009b\u00a6\u00aa\u00ae\u00b2\u00b6\u00bd\u00cf\u00fa\u0105"+
		"\u0107\u010f\u0119\u011f\u0127\u0130\u0136\u013e\u0144";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
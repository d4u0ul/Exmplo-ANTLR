// Generated from Imp.g4 by ANTLR 4.9.3
package imp;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, VAR=17, 
		NUM=18, OP1=19, OP2=20, COMP=21, LOGICO=22, APAR=23, FPAR=24, SPACES=25;
	public static final int
		RULE_start = 0, RULE_dec = 1, RULE_com = 2, RULE_expr = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "dec", "com", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'int'", "'='", "';'", "'++'", "'for'", "'to'", "'do'", "'escreva'", 
			"'while'", "'{'", "'}'", "'if'", "'else'", "'Elvis'", "':'", "'?'", null, 
			null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "VAR", "NUM", "OP1", "OP2", "COMP", "LOGICO", 
			"APAR", "FPAR", "SPACES"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ImpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(ImpParser.EOF, 0); }
		public List<DecContext> dec() {
			return getRuleContexts(DecContext.class);
		}
		public DecContext dec(int i) {
			return getRuleContext(DecContext.class,i);
		}
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitStart(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(8);
				dec();
				}
				}
				setState(13);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(17);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << VAR))) != 0)) {
				{
				{
				setState(14);
				com();
				}
				}
				setState(19);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(20);
			match(EOF);
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

	public static class DecContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(ImpParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public DecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterDec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitDec(this);
		}
	}

	public final DecContext dec() throws RecognitionException {
		DecContext _localctx = new DecContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_dec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__0);
			setState(23);
			match(VAR);
			setState(24);
			match(T__1);
			setState(25);
			expr(0);
			setState(26);
			match(T__2);
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

	public static class ComContext extends ParserRuleContext {
		public ComContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_com; }
	 
		public ComContext() { }
		public void copyFrom(ComContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EscrevaContext extends ComContext {
		public TerminalNode APAR() { return getToken(ImpParser.APAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ImpParser.FPAR, 0); }
		public EscrevaContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterEscreva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitEscreva(this);
		}
	}
	public static class AtribContext extends ComContext {
		public TerminalNode VAR() { return getToken(ImpParser.VAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AtribContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterAtrib(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitAtrib(this);
		}
	}
	public static class Soma1Context extends ComContext {
		public TerminalNode VAR() { return getToken(ImpParser.VAR, 0); }
		public Soma1Context(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterSoma1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitSoma1(this);
		}
	}
	public static class ForContext extends ComContext {
		public TerminalNode VAR() { return getToken(ImpParser.VAR, 0); }
		public List<TerminalNode> NUM() { return getTokens(ImpParser.NUM); }
		public TerminalNode NUM(int i) {
			return getToken(ImpParser.NUM, i);
		}
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public ForContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitFor(this);
		}
	}
	public static class WhileContext extends ComContext {
		public TerminalNode APAR() { return getToken(ImpParser.APAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ImpParser.FPAR, 0); }
		public ComContext com() {
			return getRuleContext(ComContext.class,0);
		}
		public WhileContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitWhile(this);
		}
	}
	public static class IfThenElseContext extends ComContext {
		public TerminalNode APAR() { return getToken(ImpParser.APAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ImpParser.FPAR, 0); }
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public IfThenElseContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterIfThenElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitIfThenElse(this);
		}
	}
	public static class ComSeqContext extends ComContext {
		public List<ComContext> com() {
			return getRuleContexts(ComContext.class);
		}
		public ComContext com(int i) {
			return getRuleContext(ComContext.class,i);
		}
		public ComSeqContext(ComContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterComSeq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitComSeq(this);
		}
	}

	public final ComContext com() throws RecognitionException {
		ComContext _localctx = new ComContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_com);
		int _la;
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new Soma1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(28);
				match(VAR);
				setState(29);
				match(T__3);
				setState(30);
				match(T__2);
				}
				break;
			case 2:
				_localctx = new ForContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(31);
				match(T__4);
				setState(32);
				match(VAR);
				setState(33);
				match(T__1);
				setState(34);
				match(NUM);
				setState(35);
				match(T__5);
				setState(36);
				match(NUM);
				setState(37);
				match(T__6);
				setState(38);
				com();
				}
				break;
			case 3:
				_localctx = new AtribContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				match(VAR);
				setState(40);
				match(T__1);
				setState(41);
				expr(0);
				setState(42);
				match(T__2);
				}
				break;
			case 4:
				_localctx = new EscrevaContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(44);
				match(T__7);
				setState(45);
				match(APAR);
				setState(46);
				expr(0);
				setState(47);
				match(FPAR);
				setState(48);
				match(T__2);
				}
				break;
			case 5:
				_localctx = new WhileContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(50);
				match(T__8);
				setState(51);
				match(APAR);
				setState(52);
				expr(0);
				setState(53);
				match(FPAR);
				setState(54);
				com();
				}
				break;
			case 6:
				_localctx = new ComSeqContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(56);
				match(T__9);
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__11) | (1L << VAR))) != 0)) {
					{
					{
					setState(57);
					com();
					}
					}
					setState(62);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(63);
				match(T__10);
				}
				break;
			case 7:
				_localctx = new IfThenElseContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(64);
				match(T__11);
				setState(65);
				match(APAR);
				setState(66);
				expr(0);
				setState(67);
				match(FPAR);
				setState(68);
				com();
				setState(71);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
				case 1:
					{
					setState(69);
					match(T__12);
					setState(70);
					com();
					}
					break;
				}
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
	public static class GroupContext extends ExprContext {
		public TerminalNode APAR() { return getToken(ImpParser.APAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode FPAR() { return getToken(ImpParser.FPAR, 0); }
		public GroupContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitGroup(this);
		}
	}
	public static class OpContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode OP2() { return getToken(ImpParser.OP2, 0); }
		public TerminalNode OP1() { return getToken(ImpParser.OP1, 0); }
		public TerminalNode COMP() { return getToken(ImpParser.COMP, 0); }
		public TerminalNode LOGICO() { return getToken(ImpParser.LOGICO, 0); }
		public OpContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitOp(this);
		}
	}
	public static class VarContext extends ExprContext {
		public TerminalNode VAR() { return getToken(ImpParser.VAR, 0); }
		public VarContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitVar(this);
		}
	}
	public static class ElvisContext extends ExprContext {
		public TerminalNode NUM() { return getToken(ImpParser.NUM, 0); }
		public ElvisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterElvis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitElvis(this);
		}
	}
	public static class ConstContext extends ExprContext {
		public TerminalNode NUM() { return getToken(ImpParser.NUM, 0); }
		public ConstContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).enterConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ImpListener ) ((ImpListener)listener).exitConst(this);
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
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(86);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NUM:
				{
				_localctx = new ConstContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(76);
				match(NUM);
				}
				break;
			case VAR:
				{
				_localctx = new VarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(VAR);
				}
				break;
			case APAR:
				{
				_localctx = new GroupContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(78);
				match(APAR);
				setState(79);
				expr(0);
				setState(80);
				match(FPAR);
				}
				break;
			case T__13:
				{
				_localctx = new ElvisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(T__13);
				setState(83);
				match(T__14);
				setState(84);
				match(NUM);
				setState(85);
				match(T__15);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(102);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(100);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(88);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(89);
						match(OP2);
						setState(90);
						expr(9);
						}
						break;
					case 2:
						{
						_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(91);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(92);
						match(OP1);
						setState(93);
						expr(8);
						}
						break;
					case 3:
						{
						_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(95);
						match(COMP);
						setState(96);
						expr(7);
						}
						break;
					case 4:
						{
						_localctx = new OpContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(98);
						match(LOGICO);
						setState(99);
						expr(6);
						}
						break;
					}
					} 
				}
				setState(104);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33l\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\7\2\f\n\2\f\2\16\2\17\13\2\3\2\7\2\22\n\2\f\2\16"+
		"\2\25\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4J\n\4\5\4L\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\5\5Y\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5g\n\5\f\5"+
		"\16\5j\13\5\3\5\2\3\b\6\2\4\6\b\2\2\2x\2\r\3\2\2\2\4\30\3\2\2\2\6K\3\2"+
		"\2\2\bX\3\2\2\2\n\f\5\4\3\2\13\n\3\2\2\2\f\17\3\2\2\2\r\13\3\2\2\2\r\16"+
		"\3\2\2\2\16\23\3\2\2\2\17\r\3\2\2\2\20\22\5\6\4\2\21\20\3\2\2\2\22\25"+
		"\3\2\2\2\23\21\3\2\2\2\23\24\3\2\2\2\24\26\3\2\2\2\25\23\3\2\2\2\26\27"+
		"\7\2\2\3\27\3\3\2\2\2\30\31\7\3\2\2\31\32\7\23\2\2\32\33\7\4\2\2\33\34"+
		"\5\b\5\2\34\35\7\5\2\2\35\5\3\2\2\2\36\37\7\23\2\2\37 \7\6\2\2 L\7\5\2"+
		"\2!\"\7\7\2\2\"#\7\23\2\2#$\7\4\2\2$%\7\24\2\2%&\7\b\2\2&\'\7\24\2\2\'"+
		"(\7\t\2\2(L\5\6\4\2)*\7\23\2\2*+\7\4\2\2+,\5\b\5\2,-\7\5\2\2-L\3\2\2\2"+
		"./\7\n\2\2/\60\7\31\2\2\60\61\5\b\5\2\61\62\7\32\2\2\62\63\7\5\2\2\63"+
		"L\3\2\2\2\64\65\7\13\2\2\65\66\7\31\2\2\66\67\5\b\5\2\678\7\32\2\289\5"+
		"\6\4\29L\3\2\2\2:>\7\f\2\2;=\5\6\4\2<;\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3"+
		"\2\2\2?A\3\2\2\2@>\3\2\2\2AL\7\r\2\2BC\7\16\2\2CD\7\31\2\2DE\5\b\5\2E"+
		"F\7\32\2\2FI\5\6\4\2GH\7\17\2\2HJ\5\6\4\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2"+
		"\2K\36\3\2\2\2K!\3\2\2\2K)\3\2\2\2K.\3\2\2\2K\64\3\2\2\2K:\3\2\2\2KB\3"+
		"\2\2\2L\7\3\2\2\2MN\b\5\1\2NY\7\24\2\2OY\7\23\2\2PQ\7\31\2\2QR\5\b\5\2"+
		"RS\7\32\2\2SY\3\2\2\2TU\7\20\2\2UV\7\21\2\2VW\7\24\2\2WY\7\22\2\2XM\3"+
		"\2\2\2XO\3\2\2\2XP\3\2\2\2XT\3\2\2\2Yh\3\2\2\2Z[\f\n\2\2[\\\7\26\2\2\\"+
		"g\5\b\5\13]^\f\t\2\2^_\7\25\2\2_g\5\b\5\n`a\f\b\2\2ab\7\27\2\2bg\5\b\5"+
		"\tcd\f\7\2\2de\7\30\2\2eg\5\b\5\bfZ\3\2\2\2f]\3\2\2\2f`\3\2\2\2fc\3\2"+
		"\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i\t\3\2\2\2jh\3\2\2\2\n\r\23>IKXfh";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
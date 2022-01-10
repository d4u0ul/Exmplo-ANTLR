// Generated from Imp.g4 by ANTLR 4.9.3
package imp;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ImpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, ATRIB=13, PV=14, ESCREVA=15, TYPE=16, FALSE=17, 
		TRUE=18, VAR=19, NUM=20, STRING=21, OP1=22, OP2=23, COMP=24, LOGICO=25, 
		APAR=26, FPAR=27, SPACES=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "ATRIB", "PV", "ESCREVA", "TYPE", "FALSE", 
			"TRUE", "VAR", "NUM", "STRING", "OP1", "OP2", "COMP", "LOGICO", "APAR", 
			"FPAR", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'++'", "'for'", "'to'", "'do'", "'while'", "'{'", "'}'", "'if'", 
			"'else'", "'Elvis'", "':'", "'?'", "'='", "';'", "'escreva'", null, "'false'", 
			"'true'", null, null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "ATRIB", "PV", "ESCREVA", "TYPE", "FALSE", "TRUE", "VAR", "NUM", 
			"STRING", "OP1", "OP2", "COMP", "LOGICO", "APAR", "FPAR", "SPACES"
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


	public ImpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Imp.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\36\u00bb\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\2\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21~\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\6\24\u008c"+
		"\n\24\r\24\16\24\u008d\3\25\5\25\u0091\n\25\3\25\6\25\u0094\n\25\r\25"+
		"\16\25\u0095\3\26\3\26\3\26\3\26\7\26\u009c\n\26\f\26\16\26\u009f\13\26"+
		"\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\5\31\u00ac\n\31"+
		"\3\32\3\32\3\32\3\32\5\32\u00b2\n\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35"+
		"\3\35\2\2\36\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34"+
		"\67\359\36\3\2\t\3\2c|\3\2\62;\3\2$$\4\2--//\4\2,,\61\61\4\2>>@@\5\2\13"+
		"\f\17\17\"\"\2\u00c4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2"+
		"\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3"+
		"\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2"+
		"\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2"+
		"\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2"+
		"\2\2\29\3\2\2\2\3;\3\2\2\2\5>\3\2\2\2\7B\3\2\2\2\tE\3\2\2\2\13H\3\2\2"+
		"\2\rN\3\2\2\2\17P\3\2\2\2\21R\3\2\2\2\23U\3\2\2\2\25Z\3\2\2\2\27`\3\2"+
		"\2\2\31b\3\2\2\2\33d\3\2\2\2\35f\3\2\2\2\37h\3\2\2\2!}\3\2\2\2#\177\3"+
		"\2\2\2%\u0085\3\2\2\2\'\u008b\3\2\2\2)\u0090\3\2\2\2+\u0097\3\2\2\2-\u00a2"+
		"\3\2\2\2/\u00a4\3\2\2\2\61\u00ab\3\2\2\2\63\u00b1\3\2\2\2\65\u00b3\3\2"+
		"\2\2\67\u00b5\3\2\2\29\u00b7\3\2\2\2;<\7-\2\2<=\7-\2\2=\4\3\2\2\2>?\7"+
		"h\2\2?@\7q\2\2@A\7t\2\2A\6\3\2\2\2BC\7v\2\2CD\7q\2\2D\b\3\2\2\2EF\7f\2"+
		"\2FG\7q\2\2G\n\3\2\2\2HI\7y\2\2IJ\7j\2\2JK\7k\2\2KL\7n\2\2LM\7g\2\2M\f"+
		"\3\2\2\2NO\7}\2\2O\16\3\2\2\2PQ\7\177\2\2Q\20\3\2\2\2RS\7k\2\2ST\7h\2"+
		"\2T\22\3\2\2\2UV\7g\2\2VW\7n\2\2WX\7u\2\2XY\7g\2\2Y\24\3\2\2\2Z[\7G\2"+
		"\2[\\\7n\2\2\\]\7x\2\2]^\7k\2\2^_\7u\2\2_\26\3\2\2\2`a\7<\2\2a\30\3\2"+
		"\2\2bc\7A\2\2c\32\3\2\2\2de\7?\2\2e\34\3\2\2\2fg\7=\2\2g\36\3\2\2\2hi"+
		"\7g\2\2ij\7u\2\2jk\7e\2\2kl\7t\2\2lm\7g\2\2mn\7x\2\2no\7c\2\2o \3\2\2"+
		"\2pq\7k\2\2qr\7p\2\2r~\7v\2\2st\7d\2\2tu\7q\2\2uv\7q\2\2v~\7n\2\2wx\7"+
		"u\2\2xy\7v\2\2yz\7t\2\2z{\7k\2\2{|\7p\2\2|~\7i\2\2}p\3\2\2\2}s\3\2\2\2"+
		"}w\3\2\2\2~\"\3\2\2\2\177\u0080\7h\2\2\u0080\u0081\7c\2\2\u0081\u0082"+
		"\7n\2\2\u0082\u0083\7u\2\2\u0083\u0084\7g\2\2\u0084$\3\2\2\2\u0085\u0086"+
		"\7v\2\2\u0086\u0087\7t\2\2\u0087\u0088\7w\2\2\u0088\u0089\7g\2\2\u0089"+
		"&\3\2\2\2\u008a\u008c\t\2\2\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2"+
		"\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e(\3\2\2\2\u008f\u0091\7"+
		"/\2\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0093\3\2\2\2\u0092"+
		"\u0094\t\3\2\2\u0093\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0093\3\2"+
		"\2\2\u0095\u0096\3\2\2\2\u0096*\3\2\2\2\u0097\u009d\7$\2\2\u0098\u009c"+
		"\n\4\2\2\u0099\u009a\7^\2\2\u009a\u009c\7$\2\2\u009b\u0098\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7$\2\2\u00a1"+
		",\3\2\2\2\u00a2\u00a3\t\5\2\2\u00a3.\3\2\2\2\u00a4\u00a5\t\6\2\2\u00a5"+
		"\60\3\2\2\2\u00a6\u00ac\t\7\2\2\u00a7\u00a8\7?\2\2\u00a8\u00ac\7?\2\2"+
		"\u00a9\u00aa\7#\2\2\u00aa\u00ac\7?\2\2\u00ab\u00a6\3\2\2\2\u00ab\u00a7"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\62\3\2\2\2\u00ad\u00ae\7(\2\2\u00ae"+
		"\u00b2\7(\2\2\u00af\u00b0\7~\2\2\u00b0\u00b2\7~\2\2\u00b1\u00ad\3\2\2"+
		"\2\u00b1\u00af\3\2\2\2\u00b2\64\3\2\2\2\u00b3\u00b4\7*\2\2\u00b4\66\3"+
		"\2\2\2\u00b5\u00b6\7+\2\2\u00b68\3\2\2\2\u00b7\u00b8\t\b\2\2\u00b8\u00b9"+
		"\3\2\2\2\u00b9\u00ba\b\35\2\2\u00ba:\3\2\2\2\13\2}\u008d\u0090\u0095\u009b"+
		"\u009d\u00ab\u00b1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
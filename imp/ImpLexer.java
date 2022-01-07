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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, VAR=9, 
		NUM=10, OP1=11, OP2=12, COMP=13, LOGICO=14, APAR=15, FPAR=16, SPACES=17;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "VAR", 
			"NUM", "OP1", "OP2", "COMP", "LOGICO", "APAR", "FPAR", "SPACES"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "';'", "'escreva'", "'while'", "'{'", "'}'", "'if'", "'else'", 
			null, null, null, null, null, null, "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "VAR", "NUM", "OP1", 
			"OP2", "COMP", "LOGICO", "APAR", "FPAR", "SPACES"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\23i\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\6\nE\n\n\r\n\16"+
		"\nF\3\13\5\13J\n\13\3\13\6\13M\n\13\r\13\16\13N\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\5\16Z\n\16\3\17\3\17\3\17\3\17\5\17`\n\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\b\3\2c|\3\2\62"+
		";\4\2--//\4\2,,\61\61\4\2>>@@\5\2\13\f\17\17\"\"\2n\2\3\3\2\2\2\2\5\3"+
		"\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"+
		"\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\3%\3\2\2\2\5\'"+
		"\3\2\2\2\7)\3\2\2\2\t\61\3\2\2\2\13\67\3\2\2\2\r9\3\2\2\2\17;\3\2\2\2"+
		"\21>\3\2\2\2\23D\3\2\2\2\25I\3\2\2\2\27P\3\2\2\2\31R\3\2\2\2\33Y\3\2\2"+
		"\2\35_\3\2\2\2\37a\3\2\2\2!c\3\2\2\2#e\3\2\2\2%&\7?\2\2&\4\3\2\2\2\'("+
		"\7=\2\2(\6\3\2\2\2)*\7g\2\2*+\7u\2\2+,\7e\2\2,-\7t\2\2-.\7g\2\2./\7x\2"+
		"\2/\60\7c\2\2\60\b\3\2\2\2\61\62\7y\2\2\62\63\7j\2\2\63\64\7k\2\2\64\65"+
		"\7n\2\2\65\66\7g\2\2\66\n\3\2\2\2\678\7}\2\28\f\3\2\2\29:\7\177\2\2:\16"+
		"\3\2\2\2;<\7k\2\2<=\7h\2\2=\20\3\2\2\2>?\7g\2\2?@\7n\2\2@A\7u\2\2AB\7"+
		"g\2\2B\22\3\2\2\2CE\t\2\2\2DC\3\2\2\2EF\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\24"+
		"\3\2\2\2HJ\7/\2\2IH\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KM\t\3\2\2LK\3\2\2\2MN"+
		"\3\2\2\2NL\3\2\2\2NO\3\2\2\2O\26\3\2\2\2PQ\t\4\2\2Q\30\3\2\2\2RS\t\5\2"+
		"\2S\32\3\2\2\2TZ\t\6\2\2UV\7?\2\2VZ\7?\2\2WX\7#\2\2XZ\7?\2\2YT\3\2\2\2"+
		"YU\3\2\2\2YW\3\2\2\2Z\34\3\2\2\2[\\\7(\2\2\\`\7(\2\2]^\7~\2\2^`\7~\2\2"+
		"_[\3\2\2\2_]\3\2\2\2`\36\3\2\2\2ab\7*\2\2b \3\2\2\2cd\7+\2\2d\"\3\2\2"+
		"\2ef\t\7\2\2fg\3\2\2\2gh\b\22\2\2h$\3\2\2\2\b\2FINY_\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
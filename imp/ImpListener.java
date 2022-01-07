// Generated from Imp.g4 by ANTLR 4.9.3
package imp;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImpParser}.
 */
public interface ImpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImpParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ImpParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImpParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ImpParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void enterAtrib(ImpParser.AtribContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Atrib}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void exitAtrib(ImpParser.AtribContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Escreva}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void enterEscreva(ImpParser.EscrevaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Escreva}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void exitEscreva(ImpParser.EscrevaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code While}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void enterWhile(ImpParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code While}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void exitWhile(ImpParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComSeq}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void enterComSeq(ImpParser.ComSeqContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComSeq}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void exitComSeq(ImpParser.ComSeqContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(ImpParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfThenElse}
	 * labeled alternative in {@link ImpParser#com}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(ImpParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Group}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGroup(ImpParser.GroupContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Group}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGroup(ImpParser.GroupContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterOp(ImpParser.OpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Op}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitOp(ImpParser.OpContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVar(ImpParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Var}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVar(ImpParser.VarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Const}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterConst(ImpParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Const}
	 * labeled alternative in {@link ImpParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitConst(ImpParser.ConstContext ctx);
}
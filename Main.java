/*
O antlr pega a descrição de uma linguagem sintatica+lexica e gera um analisador lexico e sintatico realiza a partir  de uma entrada que pode ser um arquivo ou um string etc.. o analisador sintatico pode ser executado por meio de da operação de um método start() que corrensponde a um dos não-terminais da linguagem e se não ocorrer nenhum erro cria-se o startContext que representa a árvore sintática
*/
 import expr.*;
 import org.antlr.v4.runtime.*;
 import org.antlr.v4.runtime.tree.*;
 import java.io.*;
 
 
 class Main {
   //Implementação do front-end
   public static void printTree(String prefix, ParseTree tree){
      //imprime a árvore sintática prefix é usado para identação e tree é o nó em si 
      if(tree instanceof TerminalNode){
        //se o nó for um não-terminal expr,start,soma,prod ... imprima a identação e o nome do nó
        System.out.println(prefix+"'"+tree.getText()+"'");
        return;
      }
      String className = tree.getClass().getSimpleName().replace("Context",""); //recupera o nome da classe e retira COntext do nome
      System.out.println(prefix+ className + "["+tree.getText()+"]"); //imprime o [NomeDaClasse]
      for (int c=0; c<tree.getChildCount();c++){
        //para cada um dos seus filhos chama o prinTree Recursivamente
        printTree(prefix + "|   " , tree.getChild(c));

      }

   }
  public static void main(String[] args) throws IOException {
    System.out.println("Executando o reconhecedor!");
    
    CharStream src = CharStreams.fromFileName("teste.expr"); // charstream recebe fluxo de caracteres de um arquivo teste.expr
    //CharStream src = CharStreams.fromString("1+2"); // charstream recebe fluxo de caracteres de uma string

    
    ExprLexer lexer = new ExprLexer(src); //fluxo usado para construir um analisador lexico
    TokenStream tokens = new CommonTokenStream(lexer); //o analisador lexico constroi um array de tokens
    ExprParser parser = new ExprParser(tokens); //o array de tokens é usado para o analisador sintático que os agrupa numa árvore sintática 'tree'
    
    ParseTree tree = parser.start(); // chamado do não terminal inicial start e obtenção da árvore 'tree' objeto ParseTree(uma árvore tradicional com metodos como getParent(), getChild(), getText() e getChildCount())
    /*
    Para nós não-terminais(start & expr) deve existir uma classe "...Context " que implementa a ParseTree que representa cada tipo de nó. Pode-se ainda utilizar tags para cada possibilidade  de um não-terminal e utilizá-los como subclasses de ParseTree logo criando
    ExprContext,SomaContext,ProdutoContext,IdContext,NumContext,GrupoContext etc
    */
    if(parser.getNumberOfSyntaxErrors()>0){
      System.out.println("entrada errada");
      return;
    }
    else
      System.out.println("entrada valida");
      System.out.println("árvore ->"+tree);
      System.out.println("Código Fonte ->"+tree.getText());
      System.out.println("Num de filhos ->"+tree.getChildCount());
      printTree("",tree);
  }
}
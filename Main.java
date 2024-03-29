/*
O antlr pega a descrição de uma linguagem sintatica+lexica e gera um analisador lexico e sintatico realiza a partir  de uma entrada que pode ser um arquivo ou um string etc.. o analisador sintatico pode ser executado por meio de da operação de um método start() que corrensponde a um dos não-terminais da linguagem e se não ocorrer nenhum erro cria-se o startContext que representa a árvore sintática
*/
import imp.*;
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
      System.out.println(prefix+ className + "["+tree.getText()+"]");  //imprime o [NomeDaClasse]
      for (int c=0; c<tree.getChildCount();c++){
        //para cada um dos seus filhos chama o prinTree Recursivamente
        printTree(prefix + "|   " , tree.getChild(c));
      }
  }
  
  //public static int avalie(ParseTree tree){
  //  //Inicio de implementação do back-end que caminha pela árvore //sintática e realiza alguns tipos de procedimentos //pre=definidos de acordo com cada tipo de nó encontrado
  //  //caminha pela estrutura da árvore e calcula o valor dela 
  //  //primeiro deve-se saber o tipo da árvore (terminal|//não-terminal)
  //  String className = tree.getClass().getSimpleName().replace//("Context",""); //busca o nome da classe e retira Contex do //nome
  //  //OBS- o código que faz a avaliação de uma linguagem formal é //um código orientado à sintaxe, pois geralmente o que ele faz //é fazer um switch de acordo com o tipo do nó e executar //alguma coisa em função do tipo dos nós da linguagem(start,//expr,soma...)
  //  switch (className){
  //    case "Start":{
  //      //neste nó temos uma árvore que representa uma expressão //seguido do eof
  //      ParseTree exp = tree.getChild(0);
  //      return avalie(exp);
  //    }
  //    case "Const":{
  //      //Neste caso temos apenas um filho que é um dígito de 0-9 //com um ou mais casos ex: 0, 2, 4 , 12312312, 9034834975938
  //      String num = tree.getText();
  //      //retorna a conversão em int do número escrito em String
  //      return Integer.parseInt(num);
  //    } 
  //    case "Group":{
  //      // Neste caso, a árgore tem 3 nós: 1 AbreParenteses, 1 //expressão e 1 FechaParenteses
  //      ParseTree exp  = tree.getChild(1);
  //      return avalie(exp);
  //    }
  //    case "Op":{
  //      //neste caso temos uma árvore com 3 filhos o primeiro //número, a operação desejada e o segundo número, mas agora //com todo mundo junto +-*/
  //      ParseTree esq = tree.getChild(0);
  //      String op  = tree.getChild(1).getText();
  //      ParseTree dir = tree.getChild(2);
  //      //não é preciso verificar se temos relamente 3 filhos, //pois o front-end já o fez permitindo apenas "Op" com 3 //filhos
  //      if (op.equals("+")){
  //        return avalie(esq) + avalie(dir);
  //      }
  //      //não precisamos verifica se a outra op é o outro tipo, //pois o front-end já verificou que a árvore Soma só pode //ter + | - | * | /
  //      else if (op.equals("-")){
  //        return avalie(esq) - avalie(dir);
  //      }
  //      else if (op.equals("*")){
  //        return avalie(esq) * avalie(dir);
  //      }
  //      else {
  //        return avalie(esq) / avalie(dir);
  //      }
  //    }
  //    default:
  //      throw new RuntimeException("não sei avaliar "+ //tree.getText());
  //  }
//
  //}
//
  public static void main(String[] args) throws IOException {
    
    System.out.println("Executando o reconhecedor!");
    
    CharStream src = CharStreams.fromFileName("teste.expr"); // charstream recebe fluxo de caracteres de um arquivo teste.expr
    //CharStream src = CharStreams.fromString("1+2"); // charstream recebe fluxo de caracteres de uma string

    ImpLexer lexer = new ImpLexer(src); //fluxo usado para construir um analisador lexico
    TokenStream tokens = new CommonTokenStream(lexer); //o analisador lexico constroi um array de tokens
    ImpParser parser = new ImpParser(tokens); //o array de tokens é usado para o analisador sintático que os agrupa numa árvore sintática 'tree'
    
    ParseTree tree = parser.start(); // chamado do não terminal inicial start e obtenção da árvore 'tree' objeto ParseTree(uma árvore tradicional com metodos como getParent(), getChild(), getText() e getChildCount())
    /*
    Para nós não-terminais(start & expr) deve existir uma classe "...Context " que implementa a ParseTree que representa cada tipo de nó. Pode-se ainda utilizar tags para cada possibilidade  de um não-terminal e utilizá-los como subclasses de ParseTree logo criando
    ImpContext,SomaContext,ProdutoContext,IdContext,NumContext,GrupoContext etc
    */
    if(parser.getNumberOfSyntaxErrors()>0){
      System.out.println("entrada errada");
      return;
    }
    else
      System.out.println("entrada valida");

      AnalisadorSemantico analisador = new AnalisadorSemantico();

     if (analisador.analise(tree)==false){
        System.err.println("erros de tipos detectados \n");
        return;
      }else{
        System.out.println("nenhum erro encontrado");
      }

      //System.out.println("Código Fonte ->"+tree.getText());
      //System.out.println("Num de filhos ->"+tree.getChildCount());
      //printTree("",tree);
      


      //analise da semântica do programa antes de executá-lo implementado entre entre a fase sintática e a fase de geração/interpretação de código
 



      //Passado o analisador semântico, inicializa-se a interpretação do programa
      //Interpretador inter = new Interpretador();
      //inter.avalie(tree);
  }
}
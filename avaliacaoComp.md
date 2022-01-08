<h1>
  <a name="tipagem-din%C3%A2mica" href="#tipagem-din%C3%A2mica" class="anchor">
  </a>
  POLI-UPE<br>
  Avaliação de Compiladores
</h1>
<h3>Aluno: Adauto de Holanda Barbosa</h3>
<p>

<h4>1) Descreva as etapas de um compilador vistas durante a disciplina enfatizando a sua importância
no processo de compilador e quais formalismos / técnicas utilizados para descrever / implementar
cada etapa</h4>
</p>

Olhando por uma visão da arquitetura, um compilador pode ser dividido em 2 grupos:
Um primeiro grupo de reconhecimento que lê, valida o código fonte inserido eo transforma numa estrutura de dados e um segundo grupo de geração/interpretação que utiliza essa estrutura de dados criada para gerar o resultado desejado pelo compilador.

Neste conxteto, pode-se dizer que  esse primeiro grupo chamado de front-end tem a missão de receber/validar o código fonte, gerar menssagens de  erro caso esta fonte não seja válida e criar uma estrutura de dados em forma de uma árvore por exemplo que é analisada pelo segundo grupo o qual é chamado de back-end e que é responsável por atividades como a geração/interpretação  do código e pela transformação desta árvore para produzir o resultado esperado pelo compilador.

Para a implementação destes 2 grupos, estudamos alguns formalismos para modelagens de linguagens(Linguagens são grupos de palavras válidas para um determinado alfabeto). Essas definições podem ser feitas por meio de por exemplo, de expressões regulares(RegEx) ou gramáticas de livre contexto GLC. Os compiladores feitos com apenas expressões regulares RegEx tinham uma implementação eficiente dos autômatos, mas reconheciam apenas linguagens simples. Por outro lado, os autômatos feitos com GLC tinham uma implementação menos eficiente, mas conseguiram reconhecer linguagens mais complexas. Neste sentido, os compiladores tradicionais, utilizavam um misto disso.
Por exemplo para o front-end, usamos RegEx na parte da descrição léxica e GLC na descrição sintática e para o back-end, ou seja a análise da ED formada no front-end,
estudamos Autômatos Livres de Contextos (ALC) e Algorítimos  de reconhecedores recursivos, tais como o LL(1).


Assim sendo, a parte do reconhecimento de um compilador é dividida em 3 partes que são:

1)A análise lexica que recebe o código fonte e com eles cria tokens, filtra caracteres desnecessários e reduz a complexidade da entrada.

2)A análise sintática  que agrupa em uma série de frases estes tokens passados e os organiza em uma estrutura de árvore, além de dar hierarquia ao código.

3)A análise semântica que é adicionada entre a fase sintática e a fase de geração/interpretação de código, é responsável por caminhar por todo o código verificando quais foram as variáveis que foram declaradas e quais são as que estão sendo utilizadas em todos os comandos do programa não importando se este foi ou não executado evitando assim, erros de variáveis não declaradas.Está análise será feita pelo analisador semântico que se parece com o interpretador do compilador, mas em vez de executar o código, ele verifica se todas as variáveis utilizadas no programa foram declaradas. É muito nocivo a um sistema a existência de um erro como este, pois pode-se ter um certa parte de um programa que dificilmente será executada e que só seja acessada após muito tempo da existência e execução do programa.Se esta parte do programa, tiver uma variavel não declarada ela gerará um comportamento anormal do sistema que pode só ser descoberto quando este programa já estiver em produção.

A partir daqui, temos mais uma parte que é a da interpretação/geração do código, onde criamos uma ferramenta que é responsável por interpretar e executar o programa. Durante essa execução, o computador caminhará pelos nós da árvore sintática e a medida do caminhar serão analisados os tipode cada nós(Start, Group, Op, Const...) e serão executados os comandos para os quais estes nós foram criados. 

<p><h4>
2) Implemente as seguintes estruturas de programação em IMP. A sua solução deve apresentar
apenas o código necessário para implementar os conceitos escolhidos.
</p></h4>
a) Comando de incremento ou decremento. Escolham uma das versões:

a++;<br>
b--;<br>
a += 10;<br>
b -= 10;<br>

<i>Comando escolhido: ** a++;** <br>
Comando implementado e apresentado nos testes.</i>

b) Comando for com uma das seguintes sintaxes possíveis:<br><br>
for v = 1 to 10 do<br>
comando<br>
for (v=0; v< 10; v = v+1)<br>
comando<br>
for v in 1 .. 10 do<br>
comando<br>

<i>Comando escolhido: <br>**for v = 1 to 10 do<br>
comando<br>** <br>
Comando implementado e apresentado nos testes.</i>

c) A expressão "Elvis":a?<br>
Que retorna o valor da variável "a" se ela for positiva ou "0" caso contrário.

Boa sorte,
Luis Carlos.

<h1>
  <a name="tipagem-din%C3%A2mica" href="#tipagem-din%C3%A2mica" class="anchor">
  </a>
  Respostas<br>
</h1>

Descrição léxica e sintática Tokens #Soma1, #For e #Elvis
<div class="highlight">
<pre class="highlight c">
<code>//Descrição sintatica 
start : dec* com* EOF ;
//Declarações
dec: 'int' VAR '=' expr ';';
com : VAR '++' ';' #Soma1
    | 'for' VAR '=' NUM 'to' NUM 'do' com #For
    | VAR '=' expr ';' #Atrib
    | 'escreva' '(' expr ')' ';' #Escreva
    | 'while' '(' expr ')' com  #While
    | '{' com* '}' #ComSeq
    | 'if' '(' expr  ')' com ('else' com)? #IfThenElse
    ;
expr : expr OP2 expr  #Op
     | expr OP1 expr  #Op
     | expr COMP expr #Op
     | expr LOGICO expr #Op
     | NUM            #Const
     | VAR            #Var
     | APAR expr FPAR #Group
     | 'Elvis' ':' NUM '?' #Elvis
	 ;
//Descrição LEXICA
VAR : [a-z]+ ;
NUM : '-'?[0-9]+ ;
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
COMP: '<' | '>' | '==' | '!=';
LOGICO: '&&' | '||';
APAR : '(' ;
FPAR : ')' ;
SPACES : (' ' | '\n' | '\t' | '\r') -> skip;
</code></pre></div>

Código do interpretador Tokens #Soma1, #For e #Elvis

<div class="highlight">
<pre class="highlight c">
<code>case "Soma1":{
        //neste caso a árvore sintática tem VAR '++' ';'; #Soma1 3 filhos, sendo 1 variavel um operador soma mais um e o EOF. Dessa forma, a variável existente  já e declarada(confirmada pelo analisador semântico) deve receber o seu valor +1;
        //imprimeposicaoNo(t);
        String nomeVar = t.getChild(0).getText();
        Integer valor = vars.get(nomeVar);
        if(valor==2147483647){
          throw new RuntimeException("Valor " + valor+" está com o tamanho máximo para um int q é de 2147483647");
        }
        valor++;  
        vars.put(nomeVar,valor);
        return 0; 
      }
      case "For":{
        String nomeVar = t.getChild(1).getText();
        Integer valor1 = Integer.parseInt(t.getChild(3).getText());
        Integer valor2 = Integer.parseInt(t.getChild(5).getText());
        if (valor1>valor2) System.err.printf("ERROR: Valor1 %s menor do que o Valor2 %s \n",valor1,valor2);
        ParseTree comRep = t.getChild(7);
        for (int c=valor1;c< valor2;c++){
          <br>
          avalie(comRep);
        }
        return 0; 
      }
      case "Elvis":{
        //'Elvis' ':' VAR '?' #Elvis
        String nomeValor = t.getChild(2).getText();
        int valor = Integer.parseInt(nomeValor);
        if (valor< 0) return 0;
        else return valor; 
      }
}
</code></pre></div>


Análise semântica Tokens #Soma1, #For e #Elvis


<div class="highlight">
<pre class="highlight c">
<code>case "Soma1":{
        String nomeVar = t.getChild(0).getText();
        if(vars.containsKey(nomeVar)) {//se a variável existe
          
          return true;
        }
        else{ 
          System.err.printf("Variavel "+nomeVar+" ainda não declarada\n");
          return false;
        }
      }
case "For":{
        //'for' VAR '=' NUM 'to' NUM 'do' com #For
        //for x = 1 to 10 do escreva(1+5);
        if(t.getChild(3).getText().length()>10||t.getChild(5).getText().length()>10){
          System.err.println("Constante "+t.getChild(0).getText() +" muito grande");
          return false;
        }
        return true;
      }
case "Elvis":{
        //'Elvis' ':' VAR '?' #Elvis
        //O único erro que poderia dar seria em VAR que na análise léxica já se descobre se é ou não um número
      }
} 
</code></pre></div>

<h1>
  <a name="tipagem-din%C3%A2mica" href="#tipagem-din%C3%A2mica" class="anchor">
  </a>
  Testes<br>
</h1>


Input


<div class="highlight">
<pre class="highlight c">
<code>int z = 11;
int x = z;
int y =2147483646;
escreva(2);
escreva(x);
x=2;
x++;
escreva(x);
escreva(y);
y++;
escreva(y);
for x = 1 to 10 do escreva(1+5);
for x = 10 to 15 do{
  escreva(z);
  x++;
  escreva(x);
}
for x = 20 to 15 do{
  escreva(z);
  x++;
  escreva(x);
}
escreva(2+3);
escreva(Elvis: 15?);
escreva(Elvis: -15?);
escreva(Elvis: 42?);
escreva(Elvis: -70?);
</code></pre></div>


Main()


<div class="highlight">
<pre class="highlight c">
<code>/*
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
      for (int c=0;c< tree.getChildCount();c++){
        //para cada um dos seus filhos chama o prinTree Recursivamente
        printTree(prefix + "|   " , tree.getChild(c));
      }
}
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
      System.out.println("árvore ->"+tree);
      System.out.println("Código Fonte ->"+tree.getText());
      System.out.println("Num de filhos ->"+tree.getChildCount());
      printTree("",tree);
      AnalisadorSemantico analisador = new AnalisadorSemantico();
      //analise da semântica do programa antes de executá-lo implementado entre entre a fase sintática e a fase de geração/interpretação de código
      if (analisador.analise(tree)==false){
        System.err.println("erros de tipos detectados \n");
        return;
      }else{
        System.out.println("nenhum erro encontrado");
      }
      //Passado o analisador semântico, inicializa-se a interpretação do programa
      Interpretador inter = new Interpretador();
      inter.avalie(tree);
  }
}
</code></pre></div>


Output


<div class="highlight">
<pre class="highlight c">
<code>~/Exmplo-ANTLR$ source compile.sh 
Executando o reconhecedor!
entrada valida
Código Fonte ->intz=11;intx=z;inty=2147483646;escreva(2);escreva(x);x=2;x++;escreva(x);escreva(y);y++;escreva(y);forx=1to10doescreva(1+5);forx=10to15do{escreva(z);x++;escreva(x);}forx=20to15do{escreva(z);x++;escreva(x);}escreva(2+3);escreva(Elvis:15?);escreva(Elvis:-15?);escreva(Elvis:42?);escreva(Elvis:-70?);
Num de filhos ->20
Start[intz=11;intx=z;inty=2147483646;escreva(2);escreva(x);x=2;x++;escreva(x);escreva(y);y++;escreva(y);forx=1to10doescreva(1+5);forx=10to15do{escreva(z);x++;escreva(x);}forx=20to15do{escreva(z);x++;escreva(x);}escreva(2+3);escreva(Elvis:15?);escreva(Elvis:-15?);escreva(Elvis:42?);escreva(Elvis:-70?);<EOF>]
|   Dec[intz=11;]
|   |   'int'
|   |   'z'
|   |   '='
|   |   Const[11]
|   |   |   '11'
|   |   ';'
|   Dec[intx=z;]
|   |   'int'
|   |   'x'
|   |   '='
|   |   Var[z]
|   |   |   'z'
|   |   ';'
|   Dec[inty=2147483646;]
|   |   'int'
|   |   'y'
|   |   '='
|   |   Const[2147483646]
|   |   |   '2147483646'
|   |   ';'
|   Escreva[escreva(2);]
|   |   'escreva'
|   |   '('
|   |   Const[2]
|   |   |   '2'
|   |   ')'
|   |   ';'
|   Escreva[escreva(x);]
|   |   'escreva'
|   |   '('
|   |   Var[x]
|   |   |   'x'
|   |   ')'
|   |   ';'
|   Atrib[x=2;]
|   |   'x'
|   |   '='
|   |   Const[2]
|   |   |   '2'
|   |   ';'
|   Soma1[x++;]
|   |   'x'
|   |   '++'
|   |   ';'
|   Escreva[escreva(x);]
|   |   'escreva'
|   |   '('
|   |   Var[x]
|   |   |   'x'
|   |   ')'
|   |   ';'
|   Escreva[escreva(y);]
|   |   'escreva'
|   |   '('
|   |   Var[y]
|   |   |   'y'
|   |   ')'
|   |   ';'
|   Soma1[y++;]
|   |   'y'
|   |   '++'
|   |   ';'
|   Escreva[escreva(y);]
|   |   'escreva'
|   |   '('
|   |   Var[y]
|   |   |   'y'
|   |   ')'
|   |   ';'
|   For[forx=1to10doescreva(1+5);]
|   |   'for'
|   |   'x'
|   |   '='
|   |   '1'
|   |   'to'
|   |   '10'
|   |   'do'
|   |   Escreva[escreva(1+5);]
|   |   |   'escreva'
|   |   |   '('
|   |   |   Op[1+5]
|   |   |   |   Const[1]
|   |   |   |   |   '1'
|   |   |   |   '+'
|   |   |   |   Const[5]
|   |   |   |   |   '5'
|   |   |   ')'
|   |   |   ';'
|   For[forx=10to15do{escreva(z);x++;escreva(x);}]
|   |   'for'
|   |   'x'
|   |   '='
|   |   '10'
|   |   'to'
|   |   '15'
|   |   'do'
|   |   ComSeq[{escreva(z);x++;escreva(x);}]
|   |   |   '{'
|   |   |   Escreva[escreva(z);]
|   |   |   |   'escreva'
|   |   |   |   '('
|   |   |   |   Var[z]
|   |   |   |   |   'z'
|   |   |   |   ')'
|   |   |   |   ';'
|   |   |   Soma1[x++;]
|   |   |   |   'x'
|   |   |   |   '++'
|   |   |   |   ';'
|   |   |   Escreva[escreva(x);]
|   |   |   |   'escreva'
|   |   |   |   '('
|   |   |   |   Var[x]
|   |   |   |   |   'x'
|   |   |   |   ')'
|   |   |   |   ';'
|   |   |   '}'
|   For[forx=20to15do{escreva(z);x++;escreva(x);}]
|   |   'for'
|   |   'x'
|   |   '='
|   |   '20'
|   |   'to'
|   |   '15'
|   |   'do'
|   |   ComSeq[{escreva(z);x++;escreva(x);}]
|   |   |   '{'
|   |   |   Escreva[escreva(z);]
|   |   |   |   'escreva'
|   |   |   |   '('
|   |   |   |   Var[z]
|   |   |   |   |   'z'
|   |   |   |   ')'
|   |   |   |   ';'
|   |   |   Soma1[x++;]
|   |   |   |   'x'
|   |   |   |   '++'
|   |   |   |   ';'
|   |   |   Escreva[escreva(x);]
|   |   |   |   'escreva'
|   |   |   |   '('
|   |   |   |   Var[x]
|   |   |   |   |   'x'
|   |   |   |   ')'
|   |   |   |   ';'
|   |   |   '}'
|   Escreva[escreva(2+3);]
|   |   'escreva'
|   |   '('
|   |   Op[2+3]
|   |   |   Const[2]
|   |   |   |   '2'
|   |   |   '+'
|   |   |   Const[3]
|   |   |   |   '3'
|   |   ')'
|   |   ';'
|   Escreva[escreva(Elvis:15?);]
|   |   'escreva'
|   |   '('
|   |   Elvis[Elvis:15?]
|   |   |   'Elvis'
|   |   |   ':'
|   |   |   '15'
|   |   |   '?'
|   |   ')'
|   |   ';'
|   Escreva[escreva(Elvis:-15?);]
|   |   'escreva'
|   |   '('
|   |   Elvis[Elvis:-15?]
|   |   |   'Elvis'
|   |   |   ':'
|   |   |   '-15'
|   |   |   '?'
|   |   ')'
|   |   ';'
|   Escreva[escreva(Elvis:42?);]
|   |   'escreva'
|   |   '('
|   |   Elvis[Elvis:42?]
|   |   |   'Elvis'
|   |   |   ':'
|   |   |   '42'
|   |   |   '?'
|   |   ')'
|   |   ';'
|   Escreva[escreva(Elvis:-70?);]
|   |   'escreva'
|   |   '('
|   |   Elvis[Elvis:-70?]
|   |   |   'Elvis'
|   |   |   ':'
|   |   |   '-70'
|   |   |   '?'
|   |   ')'
|   |   ';'
|   '<EOF>'
nenhum erro encontrado
O valor de : 2 é 2
O valor de : x é 11
O valor de : x é 3
O valor de : y é 2147483646
O valor de : y é 2147483647
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : 1+5 é 6
O valor de : z é 11
O valor de : x é 4
O valor de : z é 11
O valor de : x é 5
O valor de : z é 11
O valor de : x é 6
O valor de : z é 11
O valor de : x é 7
O valor de : z é 11
O valor de : x é 8
ERROR de parâmetros do For:  
Valor1 20 menor do que o Valor2 15 
for x = Valor1 to Valor2 do{comandos;} 
O valor de : 2+3 é 5
O valor de : Elvis:15? é 15
O valor de : Elvis:-15? é 0
O valor de : Elvis:42? é 42
O valor de : Elvis:-70? é 0
real    0m1.384s
user    0m0.574s
sys 0m0.082s
~/Exmplo-ANTLR$
</code></pre></div>

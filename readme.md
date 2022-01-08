<h1>
  <a name="tipagem-din%C3%A2mica" href="#tipagem-din%C3%A2mica" class="anchor">
  </a>
  Criando um Compilador e Interpretador de uma linguagem Imperativa
</h1>
<p>
Agora, a partir da liguagem de expressões criada, conseguiremos definir um compilador e um interpretador de uma liguagem imperativa.

Com uma linguagem que entenda, por exemplo:
</p>

<div class="highlight">
<pre class="highlight c">
<code>a = 10 ; //comando de atribuição
b = a + 1 ; 
if (b >10){ //comando de seleção
  escreva(a); //comando de escreva
} else {
  escreva(b);
}
while (b>0){ //comando de repetição
  escreva(b);
  b = b/2;
}
</code></pre></div>

Então definiremos cada um desses na forma de uma regra sintática e no comando de avaliação ver o efeito no cálculo de cada uma dessas expressões.
Qual a utilidade deste tipo de código?
Calcular uma variável de expressões ou um comando tradicional não parece ser muito, pois nós já temos compiladores como por exemplo o Java que entende esse tipo de coisa.
Então, qual seria a principal motivação para se estudar compiladores no desenvolvimento de softwares modernos para a  definição de linguagens e geração automática de códigos?
imagine a seguinte situação, a vc foi pedido para que construísse uma classe de dados que represente pessoas com nome e endereço. Com, por exemplo Java, é bem fácil de se fazer, seria uma coisa do tipo:

<div class="highlight">
<pre class="highlight c">
<code>class Pessoa{
    String nome;
    String endereco;
} 
</code></pre></div>


Na década de 70~80 era isso que um programador faria, todavia, isso não é sufuciente para uma boa prática de programação.
Então, como primeira mudança deve-se ter um construtor para a classe Pessoa o que seria assim:

<div class="highlight">
<pre class="highlight c">
<code>class Pessoa{
    String nome;
    String endereco;
    Pessoa(String _nome, String _endereco){
      nome = _nome;
      endereco = _endereco;
    }
} 
</code></pre></div>

Ainda não é muito interessante, perceba que a classe em Java é uma subclasse de Object que, por sua vez, implementa métodos como equals(),clone() e toString().
As variáveis de um objeto não podem ser públicas, mas sim privada s e acessadas por métodos get() e set().
Além disso, deve haver uma separaação entre interface e implementação, no caso da classe Pessoa, deve-se criar uma interface IPessoa para implementar diferentes tipos de Pessoas que podem aparecer durante a construção do sistema.
Se essa aplicação for rodar num sistema fullstack pode ser que precisemos de uma class pessoa para javascript para o sistema web e outra php para o back-end e ficar fazendo conversões. PHP não é uma liguagem persistente, logo ele precisa de um BD para persistir as suas informações, logo é preciso se fazer a ponte do php com o bd.
Outra dificuldade é na definiçãod e um sistema responsivo, ou seja a classe deve se adaptar para cada tipo de aparelho em que o sistema será utilizado. 
Agora, imagine que seja pedido que vc faça tudo isso para outros 20 tipos distintos.

Depois de tudo isso, o cliente devide modificar nome para nome e sobrenome o que modificaria todo o código.
Programar essa ED em java ficaria extremamente complicada, massante e sujeito à erros.

Então, para resolver essa situação, a ideia aqui seria definir uma DSL().
Logo, poderíamos construir uma linguagem que gere automaticamente todos os métodos default repetitivos necessários sem o esforço do programador.
Por exemplo:

<div class="highlight">
<pre class="highlight c">
<code>data class Pessoa(String nome, String endereco, int idade);
data class Ponto(int x, int y);
data class Produto(String descricao, int preco, int qualidade);
</code></pre></div>

Definindo um gerador de código que crie automaticamente todo aquele código determinado acima.
Há algumas mohlorias em Java implementadas em Kotlin, Scala, etc.
E com a vinda do Java 14 tbm foi implementada em Java.
Daí, fica bastante simples definir essa linguagem, mas lembre-se que é utilizado apaenas para classes que armazenam dados e que tenham umaa série de métodos default.

Um exemplo muito bom é o SQL. Quando executamos:

<div class="highlight">
<pre class="highlight c">
<code>SELECT nome from Estudando where curso = 'Computacao';
</code></pre></div>

Perceba que a linha acima faz tudo o que fazemos usando apenas Java de uma maneira muito mais simples.
Se isso fosse aplicado em java puro, precisaríamos de:


<div class="highlight">
<pre class="highlight c">
<code>Database estudantes = open("estudantes.db");
List<String> result = new List<\String>();
for (int c=0;c.estudantes.size();c++){
  Record e = estudante.get(c);
  if (e.get("curso").equals("Computacao")){
    result.add(e.get("nome"));
  }
}
</code></pre></div>

Observa-se que no comando SQL queremos saber O que o usuário quer? e no Java queremos saber como o computador calcula. Se nós utilizamos Java para fazer uma coisa que ele não fi projetado para fazer, podemos nos perder(Para quem só usa martelo, todo parafuso é prego)
Usando a DSL podemos, descrever a nossa intenção em um nível mais alto do que nós faríamos se estivéssemos escrevendo em JAVA ou C. 

Chegamos aqui no conceito de ***Programação declarativa*** - O programador pensa mais em o que ele quer que o computador faça e como o computador fará para calcular o que é desejado. Isso é muito mais fácil de ser alcançado quando usamos DSLs.

***Pior do que escrever um programa é escrever um programa que escreve um programa***

Declaração dinâmica de variáveis

Num programa onde as variáveis são declaradas dinâmicamente erros como o de variáveis não definidas podem aparecer ou não em programas que usem variáveis não definidas.
Por exemplo:

<div class="highlight">
<pre class="highlight c">
<code>if(2<0)
  escreva(x+3);
else 
  escreva(0);
</code></pre></div>

Perceba que x ainda não foi declarado. Logo, se a primeira condição é falsa o seu comando não é executado e um erro possível de escreva(x+3) nunca ocorre. Então é necessário que a cada passo de iteração o programa verificar se a variável foi ou não definida. Programas que fazem essa checagem em tempo de execução são muito perigosos pois pode-se ter erros latentes no seu programa que só serão descobertos quando o programa já estiver em produção.
Assim, linguagens como declarações dinâmicas de variaveis permitem um desenvolvimento mais fácil e mais rápido, mas em compensação elas dão menos garantias de que os programas sejam livres de erros.
Para tornar as liguagens mais seguras em relação a este problema, linguagens mais tradicionais como C, Java, Pascal  incorporam um tipo especial de elemento sintático que são as declarações DEC.
Uma declaração é um elemento que vem antes dos comandos que serve para indicar que o programa vai utilizar uma variavel. Então, toda vez que o programa for utilizar uma variavel, ele deve declará-la obrigatoriamente ou então o programa é inválido.
Quando verificamos a declaração da variável quando o comando for executado pode não ser possível identificar um arro até que ele ocorra. Isto pode acontecer depois da primeira execução do programa, assim como pode acontecer depois da milhonésima execução deste programa, o que gera um erro de variavel não declarada latente. 
Para resolver isso, o compilador adiciona entre a fase sintática e a fase de geração/interpretação de código, uma outra fase que é a da análise semantica do programa, onde deve-se caminhar por todo o código verificando quais foram as variáveis que foram declaradas e quais são as que estão sendo utilizadas em todos os comandos do programa não importando se este foi ou não executado.
Assim, antes de executar a primeira linha do programa, é preciso se fazer essa anpalise semântica para garantir que no meu programa eu não tenha nenhum erro como este de variável não declarada.
Está análise será feita pela classe analisador semântico que tem uma estrutura parecida com a do interpretador, mas em vez de executar o código, nós queremos saber quais variáveis foram declaradas e se o program utiliza apenas as variáveis que foram declaradas.


   
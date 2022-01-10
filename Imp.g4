//.g4gramatica para a versao 4 do antr 
// Ele consegue reduzir alguns problemas do alg LL como a recursividade a esquerda, prefixos incomuns quando os prefixos são diretos
grammar Imp;

//sintatica Combina os tokens da analise lexica em frases 

start : dec* com* EOF ; 

//Declarações
dec: TYPE VAR '=' expr ';';

//comandos são os elementos mais importantes em linguagens de programação. Eles tÊm por objetivo não retornar um valor, mas sim modificar o valor de uma variável. Por exemplo o comando de atribuição tem como estruturas básicas uma variável, um op de atribuição e o ;(separador de comandos).

com : VAR '++' ';' #Soma1
    | 'for' VAR '=' NUM 'to' NUM 'do' com #For
    | VAR '=' expr ';' #Atrib
    | 'escreva' '(' expr ')' ';' #Escreva
    | 'while' '(' expr ')' com  #While
    | '{' com* '}' #ComSeq
    | 'if' '(' expr  ')' com ('else' com)? #IfThenElse
     
    ;
//Um comando pode estar correto ou não, diferente de expressões que é preciso saber o seu tipo para analisar se ela está certa ou não
expr : expr OP2 expr  #Op
     | expr OP1 expr  #Op
     | expr COMP expr #Op
     | expr LOGICO expr #Op
     | FALSE          #CFalse
     | TRUE           #CTrue
     | NUM            #Const
     | STRING         #CString
     | VAR            #Var 
	   | APAR expr FPAR #Group
     | 'Elvis' ':' NUM '?' #Elvis
	 ;

//LEXICA classifica seq de caracteres em tokes/lexema/simb terminais

ATRIB : '=' ; //como temos um padrão constante '=' é possível definí-lo diretamente na descrição sintática colocando-os entre aspas 
PV : ';' ;
ESCREVA : 'escreva' ;
TYPE : 'int' | 'bool' | 'string' ;
FALSE : 'false' ;
TRUE : 'true' ;
VAR : [a-z]+ ;
NUM : '-'?[0-9]+ ; 
STRING : '"' (~["] | '\\"')* '"' ;
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
COMP: '<' | '>' | '==' | '!=';
LOGICO: '&&' | '||';
APAR : '(' ;
FPAR : ')' ;

SPACES : (' ' | '\n' | '\t' | '\r') -> skip;
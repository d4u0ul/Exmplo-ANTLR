//.g4gramatica para a versao 4 do antr 
// Ele consegue reduzir alguns problemas do alg LL como a recursividade a esquerda, prefixos incomuns quando os prefixos são diretos
grammar Expr;

//sintatica Combina os tokens da analise lexica em frases 

start : expr EOF ; 

expr : expr OP2 expr  #Mult
     | expr OP1 expr  #Soma
     | NUM            #Const
	 | APAR expr FPAR   #Group
	 ;

//LEXICA classifica seq de caracteres em tokes/lexema/simb terminais

NUM : [0-9]+ ;
OP1 : '+' | '-' ;
OP2 : '*' | '/' ;
APAR : '(' ;
FPAR : ')' ;

SPACES : (' ' | '\n' | '\t' | '\r') -> skip;
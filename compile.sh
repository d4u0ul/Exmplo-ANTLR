#arquivo de lote <- arquivo com uma série de comando que é executado em sequência por muitas vezes só bastando executar o arquivo de lote para que todos os comandos sejam executados

export CLASSPATH=antlr.jar:. #definição de caminho de bibliotecas adicionais
java -jar antlr.jar -package expr -o expr Expr.g4 #geração via antlr do código java com package gerado direto no código e salvamento na pasta expr
javac *.java expr/*.java #compilação dos arquivos java
java Main #teste do main
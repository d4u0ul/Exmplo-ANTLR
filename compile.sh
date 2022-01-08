#arquivo de lote <- arquivo com uma série de comando que é executado em sequência por muitas vezes só bastando executar o arquivo de lote para que todos os comandos sejam executados

export CLASSPATH=antlr.jar:. #definição de caminho de bibliotecas adicionais
java -jar antlr.jar -package imp -o imp Imp.g4 #geração via antlr do código java com package gerado direto no código e salvamento na pasta imp
javac *.java imp/*.java #compilação dos arquivos java
time java Main #teste do main
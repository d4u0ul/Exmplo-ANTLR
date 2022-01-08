//classe que é responsável por analisar semanticamente o programa. Antes mesmo da execução do interpretador, o computador caminhará pelos nós da árvore sintática e a medida do caminhar serão verificados se todas as variaveis utilizadas pelo programa foram previamente declaradas
// A área de pesquisa que sinaliza quando um programa está errado ou não é uma área chamada de semântica de linguagens de programação
import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;


class AnalisadorSemantico{

  //essa classe deverá ter o metodo analise que verifica se todas as variáveis que serão usadas na execução do programa foram declaradas

  //Quando precisamos atribuir um tipo a uma certa variável é preciso guardar o tipo dela através de um mapeamento NomedaVariavel->tipoDaVariável  existentes em vars
  Map<String,String> vars = new HashMap<String,String>();
  boolean analise(ParseTree t){
    //primeiro fazemos uma seleção de acordo com o tipo do nó que se está atualmente
    String tipo = t.getClass().getSimpleName().replace("Context","");
    //System.out.println("Tentando avaliar o nó do tipo: "+tipo);
    switch(tipo){ 
      case "Start":{
      //No caso do Start precisaremos analisar cada um dos seus filhos para verificar se cada declaração está correta, logo se para algum dos nós for retornado falso analise achará um erro caso não tenha erros em nenhum nó ele retornará verdadeiro
        for (int c=0;c<t.getChildCount()-1;c++) 
          if(!analise(t.getChild(c)))
            return false;    
        return true; 
      }
      case "Dec":{
        //na declaração de variáveis temos dec: 'int' VAR '=' expr ';' que são 5 filhos com 1 sendo a variável em si e 3 sendo a expressão que será armazenada

        String tipoD = t.getChild(0).getText();
        String nomeVar= t.getChild(1).getText();
        ParseTree expr = t.getChild(3);
        if(vars.containsKey(nomeVar)){
          System.err.printf("variavel "+nomeVar+" já declarada\n");
          return false;
        }
        if(!analise(expr)) return false;
        vars.put(nomeVar,tipoD);
        return true;// O retorno é true pois não existia nenhuma variavel com esse nome no mapeamento  
      } 
      case "Var":{
        String nomeVar = t.getChild(0).getText();
        if(vars.containsKey(nomeVar)) return true;
        else{ 
          System.err.printf("Variavel "+nomeVar+" ainda não declarada\n");
          return false;
        }

      }
      case "Const":{
        if(t.getChild(0).getText().length()>10){
          System.err.println("Constante "+t.getChild(0).getText() +" muito grande");
          return false;
        }
        return true;
      } 
      case "Escreva":{
        ParseTree expr = t.getChild(2);
        if (analise(expr)) return true;
        else return false;
      }
      case "Atrib":{
        String nomeVar= t.getChild(0).getText();
        ParseTree expr = t.getChild(2);
        if(vars.containsKey(nomeVar)==false){
          System.err.println("Variavel "+nomeVar+ " não declarada" );
          return false;
        } 
        return analise(expr);  
      }
      case "Op":{
        ParseTree esq = t.getChild(0);
        String op = t.getChild(1).getText();
        ParseTree dir = t.getChild(2);
        return analise (esq) && analise (dir);
      }
      case "Soma1":{
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
        return true;
      }
    default:{
        System.err.println("não sei analisar o nó do tipo: "+tipo );
        return true;
      }
  
    }

  }

}
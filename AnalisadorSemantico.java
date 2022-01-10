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

String tipoDe(ParseTree exp){
    String tipo = exp.getClass().getSimpleName().replace("Context","");
    
    switch(tipo){

      case "Op":{
        ParseTree esq = exp.getChild(0);
        String op = exp.getChild(1).getText();
        ParseTree dir = exp.getChild(2);
        String tipoEsq = tipoDe(esq);
        String tipoDir = tipoDe(dir);
        if(tipoDe(esq).equals("error")||tipoDe(dir).equals("error")) return "error";
        if(tipoEsq.equals("int") && ( op.equals("+") || 
                                      op.equals("-") ||
                                      op.equals("*") || 
                                      op.equals("/")  ) && tipoDir.equals("int")) return "int";
        if(tipoEsq.equals("string")  && op.equals("+") && tipoDir.equals("string")) return "string";
        if(tipoEsq.equals("bool") && (op.equals("==") || 
                                      op.equals("!=") ||
                                      op.equals("<")  || 
                                      op.equals(">")  ) && tipoDir.equals("bool")) return "bool";
        if(tipoEsq.equals(tipoDir)  && (op.equals("==") || 
                                        op.equals("!=")))  return "bool";                              
        
 
                 
        System.out.printf("não sei o tipo de  %s ,%s ,%s \n", esq.getText(),op,dir.getText());
        return "error";
      }
      
      case "Var":{
        String nomeVar = exp.getChild(0).getText();
        if(vars.containsKey(nomeVar)) return vars.get(nomeVar);
        else{ 
          System.err.printf("Variavel "+nomeVar+" ainda não declarada\n");
          return "error";
        }
      }

      case "Const":{
        if(exp.getChild(0).getText().length()>10){
          System.err.println("Constante "+exp.getChild(0).getText() +" muito grande");
          return "error";
        }
        return "int";
      } 

      case "CTrue":
      case "CFalse":{
        return "bool";
      }
       
      case "CString":{
        return "string";
      }
      default: return "error";
    }
   
    
  }

  //analisa Comandos e Declarações
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
        String tipoExpr = tipoDe(expr);
        if(!tipoD.equals(tipoExpr)){
            System.err.printf("Erro na declaração:  Tipos incompatíveis %s e %s \n" ,tipoD, tipoExpr );
            return false;
        } 
        System.err.printf("Tipos compatíveis %s e %s \n" ,tipoD, tipoExpr );
        
        vars.put(nomeVar,tipoD);
        return true;// O retorno é true pois não existia nenhuma variavel com esse nome no mapeamento  
      } 

      case "Escreva":{
        ParseTree expr = t.getChild(2);
        String tipoExpr = tipoDe(expr);
        if (tipoExpr.equals("error")){
          System.err.printf("Erro de tipo na Escrita: %s não é %s", expr.getText(), tipoExpr);
          return false;                
        }else return true;
      } 

      case "Atrib":{
        String nomeVar= t.getChild(0).getText();
        ParseTree expr = t.getChild(2);
        if(vars.containsKey(nomeVar)==false){
          System.err.println("Erro na Atrib: Variavel "+nomeVar+ " não declarada" );
          return false;
        } 

        String tipoVar = vars.get(nomeVar);
        String tipoExpr = tipoDe(expr);
        
        if (tipoExpr.equals("error")) return false;
        if (!tipoVar.equals(tipoExpr)) {
            System.err.printf("Erro de Atrib: Tipos incompatíveis %s e %s \n" ,tipoVar, tipoExpr );
            return false;
        }
        return true;
      }
     

      case "Var":{
        String nomeVar = t.getChild(0).getText();
        String tipoD = vars.get(nomeVar);
        if(vars.containsKey(nomeVar)) return true;
        else{ 
          System.err.printf("Variavel "+nomeVar+" ainda não declarada\n");
          return false;
        }     
           
      } 
      default:{
        System.err.println("não sei analisar o nó do tipo: "+tipo );
        return true;
      }
  
    }

  }

  

}
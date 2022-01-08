//classe que é responsável por interpretar e executar o programa. Durante essa execução, o computador caminhará pelos nós da árvore sintática e a medida do caminhar serão analisados os tipode cada nós(Start, Escreva, Const...) e serão executados os comandos
import imp.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.*;
import java.util.*;


class Interpretador{

  //essa classe deverá ter o metodo avalie que pre uma árvore e retorna o resultado da sua avaliação

  //Quando precisamos atribuir um vlaor a uma certa variável é preciso saber qual o tipo de todas as variáveis já construídas no programa até o momento, dessa forma uma maneira de se guardar essa informação é através de um mapeamento dos tipos das variáveis existentes em vars
  Map<String,Integer> vars = new HashMap<String,Integer>();
  int avalie(ParseTree t){
    //primeiro fazemos uma seleção de acordo com o tipo do nó que se está atualmente
    String tipo = t.getClass().getSimpleName().replace("Context","");
    //System.out.println("Tentando avaliar o nó do tipo: "+tipo);
    switch(tipo){ 
      case "Start":{
      //No caso do Start temos uma série de comandos com e um último EOF
        for (int c=0;c<t.getChildCount()-1;c++)                 avalie(t.getChild(c));    
        System.out.println("qtde de filhos ->"+qtdeTotalDeNos(t));    
        return 0; 
      }
      case "Escreva":{
        int v = avalie(t.getChild(2));
        System.out.println("O valor de : "+t.getChild(2).getText()+" é "+v);
        return 0;
      }
      case "Const":{
        return Integer.parseInt(t.getChild(0).getText());
      }
      case "Op":{
        ParseTree esq = t.getChild(0);
        String op = t.getChild(1).getText();
        ParseTree dir = t.getChild(2);
        int vEsq = avalie(esq);
        int vDir = avalie(dir);
        if (op.equals("+")){ return vEsq + vDir; }
        if (op.equals("-")){ return vEsq - vDir; }
        if (op.equals("*")){ return vEsq * vDir; }
        if (op.equals("/")){ return vEsq / vDir; }
        //1=verdadeiro e 0 = falso
        if (op.equals(">")){  return (vEsq > vDir)?1:0;}
        if (op.equals("<")){  return (vEsq < vDir)?1:0;}
        if (op.equals("==")){ return  (vEsq == vDir)?1:0;}
        if (op.equals("!=")){ return  (vEsq != vDir)?1:0;}
        if (op.equals("&&")){ return  (vEsq!=0 && vDir!=0)?1:0;}
        if (op.equals("||")){ return  (vEsq!=0 || vDir!=0)?1:0;}
      } 
      case "Group":{
        return avalie(t.getChild(1));
      }
      case "Atrib":{
        String nomeVar= t.getChild(0).getText();
        ParseTree expr = t.getChild(2);
        vars.put(nomeVar,avalie(expr));
        return 0;// O retorno é 0 pois o resultado de um comando não é um valor , mas a mudança do valor de uma variavel
      }
      case "Var":{
        String nomeValor =t.getChild(0).getText() ;
        Integer valor = vars.get(nomeValor);
        if (valor==null) throw new RuntimeException("Variavel :"+nomeValor + " não foi definida ainda");
        return valor;

      }
      case "While":{
        ParseTree test = t.getChild(2);
        ParseTree comRep = t.getChild(4);
        while(avalie(test)!=0)
          avalie(comRep);
        return 0;
      }
      case "ComSeq":{
        for(int c=1;c<t.getChildCount()-1;c++){
          avalie(t.getChild(c));
        }
        return 0;
      }
      case "IfThenElse":{
        ParseTree test = t.getChild(2);
        ParseTree comRepCasoVerd = t.getChild(4);
        ParseTree comRepCasofalso = t.getChild(6);
        System.out.println("qtde de filhos:"+t.getChildCount());

        //imprimeposicaoNo(t);
        if(t.getChildCount()<6){
          if (avalie(test)!=0) avalie(comRepCasoVerd);
          return 0;
        }else{
          if (avalie(test)!=0) avalie(comRepCasoVerd);
          else avalie(comRepCasofalso);
          return 0;
        }
      }
      default:{
        System.err.println("não sei avaliar o nó do tipo: "+tipo );
        return 0;
      }
  
    }

  }
  int qtdeTotalDeNos(ParseTree t){
    int qtde =0;
    for(int c=0;c<t.getChildCount();c++){
      return 1+qtdeTotalDeNos(t.getChild(c)){
    }
  }
  void imprimeposicaoNo(ParseTree t){
    for(int c=0;c<t.getChildCount();c++){
      System.out.println("O filho "+c+" é o "+ t.getChild(c) + " de tipo: "+t.getChild(c).getClass().getSimpleName().replace("Context",""));
    }
  }
}
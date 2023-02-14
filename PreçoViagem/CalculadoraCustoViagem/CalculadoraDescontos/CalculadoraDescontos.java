package PreçoViagem.CalculadoraCustoViagem.CalculadoraDescontos;

import java.util.Scanner;

/**
 * CalculadoraDescontos
 */
public class CalculadoraDescontos {
    Scanner sc = new Scanner(System.in);
   public void calcular20(){
    System.out.println("informe o Preço do Produto");
    double precoProduto = sc.nextDouble();
    final int desconto20 = 20;
    double precoComDesconto = precoProduto-(precoProduto*desconto20/100);
    System.out.println( "O Preço com Desconto é " +precoComDesconto+" reais");
    
   }   
   public void calcular30(){
    System.out.println("informe o Preço do Produto");
    double precoProduto = sc.nextDouble(); 
    final int desconto20 = 30;
    double precoComDesconto = precoProduto-(precoProduto*desconto20/100);
    System.out.println( "O Preço com Desconto é " +precoComDesconto+" reais");
   
}


}  

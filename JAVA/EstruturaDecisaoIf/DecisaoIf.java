package EstruturaDecisaoIf;

import java.util.Scanner;

public class DecisaoIf {
    Scanner sc = new Scanner(System.in);
    public void descontoIf(){
        System.out.println("Informe o Preço do Produto");
        double precoProduto = sc.nextDouble();
        double desconto = 0.0;
        if (precoProduto>=100 && precoProduto<200){desconto=5.0;
        }
        if (precoProduto>=200 && precoProduto<300){desconto=10.0;
        }
        if (precoProduto>=300){desconto=15.0;
        }
        //Calculo do Desconto
        double valorDesconto = precoProduto*desconto/100;
        double precoFinal = precoProduto - valorDesconto;
        System.out.println("O Valor do Produto é R$ "+precoFinal);




    }
    public void descomtoIfElse(){
        System.out.println("informe o Preço do Produto");
        double precoProduto = sc.nextDouble();
        double desconto;
        if (precoProduto>=300){
            desconto=15.0;
        }else if (precoProduto>=200){
            desconto=10.0;
        }else if (precoProduto>=100){
            desconto=5.0;
        }else{
            desconto=0.0;
        }

        //Calculo do desconto
        double valorDesconto = precoProduto*desconto/100;
        double precoFinal = precoProduto - valorDesconto;
        System.out.println("O Valor do Produto é R$ "+precoFinal);


    }
}

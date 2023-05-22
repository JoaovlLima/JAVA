package AttFormativa2;

import java.util.Random;
import java.util.Scanner;

public class Atividades {
    Scanner sc= new Scanner(System.in);
    Random rd = new Random();
    
    public void exercicio1(){
        System.out.println("digite o numero de linhas desejadas");
        int linha = sc.nextInt();
        System.out.println("digite o numero de Colunas desejadas");
        int coluna = sc.nextInt();


        int tab[][] = new int[linha][coluna];
        for (int i = 0; i < linha; i++) {
            for (int j = 0; j < coluna; j++) {
                tab[i][j] = rd.nextInt(9);

            }
        }
    
    for (int i = 0; i < linha; i++) {
        for (int j = 0; j < coluna; j++) {
            System.out.println("tab[" + i + "][" + j + "]=" + tab[i][j]);
        }
    }
    for (int i = 0; i < linha; i++) {
        System.out.print("| ");
        for (int j = 0; j < coluna; j++) {
            System.out.print(+tab[i][j] + " ");
        }
        System.out.println("|");
}


for (int i = 0; i < linha; i++) {
    for (int j = 0; j < coluna; j++) {
        if(i>j){
           tab [i][j] = 1; 
        }else if(i==j){
            tab [i][j] = 0;
        }else{
            tab[i][j] = 2;
        }

    }
}

for (int i = 0; i < linha; i++) {
for (int j = 0; j < coluna; j++) {
    System.out.println("tab[" + i + "][" + j + "]=" + tab[i][j]);
}
}
for (int i = 0; i < linha; i++) {
System.out.print("| ");
for (int j = 0; j < coluna; j++) {
    System.out.print(+tab[i][j] + " ");
}
System.out.println("|");
}
}
public void exercicio2(){
    int valorSorteado = rd.nextInt(1000);
    boolean tenteNovamente = true;
    int tentativas = 0;
    while (tenteNovamente){
        System.out.println("Dígite um Nº");
        int nDigitado = sc.nextInt();
        if(nDigitado == valorSorteado){
            System.out.println("Você acertou!!!!");
            System.out.println("Seu numeros de tentativas foi = "+tentativas);
            System.out.println("tente novamente e quebre seu record");
            tenteNovamente = false;

        }else{
            System.out.println("Você Errou, Tente Novamente");
        }
        if(nDigitado<valorSorteado){
            System.out.println("Mais para cima");
        }else if (nDigitado>valorSorteado){
            System.out.println("Mais para baixo");
        }
        if(tenteNovamente = true){
            tentativas++;
        }
     
    }
   
}
public void exercicio3(){
    int Nvetor = rd.nextInt(900)+100;
    int vetorA[] = new int[Nvetor];
    int contadorImp = 0;
    int contadorPar = 0;
    for (int i = 0; i < vetorA.length; i++) {
        vetorA[i] = rd.nextInt(99)+1;
        System.out.println("Vetor [" + i + "] = " + vetorA[i]);


        
    }
    System.out.println("=================================");
    for (int i = 0; i < vetorA.length; i++) {
        vetorA[i] = rd.nextInt(99)+1;
        if(vetorA[i]%2==0){
        System.out.println(" (Par) Vetor [" + i + "] = " + vetorA[i]);
  contadorPar++;
        }
    }
    System.out.println("=======================================");
    for (int i = 0; i < vetorA.length; i++) {
        vetorA[i] = rd.nextInt(99)+1;
        if(vetorA[i]%2==1){
        System.out.println(" (Impar) Vetor [" + i + "] = " + vetorA[i]);  
        contadorImp++;
    }
    
}
System.out.println("Quantidade Par = "+contadorPar+" Quantidade Impar = "+contadorImp);
}
}


    
    

        
       

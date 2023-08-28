package exerciciosIfElse;

import java.util.Scanner;

public class Exercicio1 {

    Scanner sc = new Scanner(System.in);

    public void exercicio1() {
        System.out.println("Escreva os numeros abaixo");
        int valor1 = sc.nextInt();
        int valor2 = sc.nextInt();

        if (valor1 > valor2) {
            System.out.println("maior valor = " + valor1);
        } else {
            System.out.println("maior valor = " + valor2);
        }
    }

    public void exercicio2() {
        System.out.println("Insira seu ano de Nascimento");
        int anoNascimento = sc.nextInt();
        double idade = 2023 - anoNascimento;
        if (idade >= 16) {
            System.out.println("Você está apto a votar");
        } else {
            System.out.println("Você ainda não tem idade para votar, volte quando estiver com 16 anos ou mais");
        }
    }
    public void exercicio3(){
        System.out.println("Insira a senha de acesso (4 digitos)");
        int Senha = sc.nextInt();
        int SenhaCorreta = 1234;
        if (Senha==SenhaCorreta){
            System.out.println("Acesso Permitido");
        }else{
            System.out.println("Acesso Negado");
        }

    }
    public void exercicio4(){
System.out.println("Quantas maças você deseja comprar?");
int macasCompradas = sc.nextInt();
double precoMacas = 0.30;
if (macasCompradas>=12){
    precoMacas = 0.25;
}
double PrecoFinal = macasCompradas*precoMacas;
System.out.println("Sua compra deu R$ "+PrecoFinal);
    }

}

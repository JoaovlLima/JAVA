package ExercicioPOO1;

import java.util.Scanner;

public class pessoa {
    Scanner sc = new Scanner(System.in);
    private String nome;
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = sc.next() ;
    }
   
    
    public double getAltura() {
        return altura;
    }
    public pessoa(int mes, int dia, int ano) {
        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public pessoa(String nome, double altura) {
        this.nome = nome;
        this.altura = altura;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    private double altura;

   int mes;
   int dia;
   int ano;
    
    int idade;
    

    
}

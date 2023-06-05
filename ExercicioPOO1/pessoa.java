package ExercicioPOO1;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class pessoa {
    Scanner sc = new Scanner(System.in);
    private String nome;
    private double altura;

    int mes;
    int dia;
    int ano;

  

    // construtor

    public pessoa(String nome, double altura, int mes, int dia, int ano) {
        this.nome = nome;
        this.altura = altura;
        this.mes = mes;
        this.dia = dia;
        this.ano = ano;
    }
    // construtor Vazio

    public pessoa() {
        
    }

       //gets and sets

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

// metodo para imprimir 

public void imprimir(){
    JOptionPane.showMessageDialog(null, "Nome:"+nome);
    JOptionPane.showMessageDialog(null, "Altura:"+altura);
    JOptionPane.showMessageDialog(null,"Nascimento:"+dia+"/"+mes+"/"+ano);


}
//metodo para retornar a idade
public int idade(){
    int calculo;
    if(dia<=5 && mes<=6){
    calculo = 2023 - ano;
    }else{
        calculo = 2023 - ano - 1;
    }
    return calculo;

}


   

   
}

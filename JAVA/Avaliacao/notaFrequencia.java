package Avaliacao;

import java.util.Scanner;

public class notaFrequencia {
    Scanner sc = new Scanner(System.in);
    public void notaFrequencia(){
        System.out.println("informe a Nota 1 do Aluno");
        int nota1 = sc.nextInt();
        System.out.println("informe a Nota 2 do Aluno");
        int nota2 = sc.nextInt();
        System.out.println("informe a Nota 3 do Aluno");
        int nota3 = sc.nextInt();
        System.out.println("informe a Nota 4 do Aluno");
        int nota4 = sc.nextInt();
         double notaAluno =(nota1+nota2+nota3+nota4)/4;
         System.out.println("a Média do Aluno é" +notaAluno);
         boolean notaAprovada= notaAluno >= 50;
         System.out.println("O Aluno foi aprovado em Notas?" +notaAprovada);
         System.out.println("Informe a Frequencia do Aluno");
         int frequenciaAluno = sc.nextInt();
         System.out.println("a Frequencia do Aluno é"+frequenciaAluno);
         boolean frequenciaAprovada = frequenciaAluno>=75;
         System.out.println("o Aluno foi aprovado em Frequencia?"+frequenciaAprovada);
         boolean resultadoFinal = (notaAprovada==true) && (frequenciaAprovada==true);
         System.out.println("o Aluno está aprovado no curso?"+resultadoFinal);









    } 
    
}

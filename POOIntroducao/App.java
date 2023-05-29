package POOIntroducao;

/**
 * App
 */
public class App {
public static void main(String[] args) {
    //criar 3 objetos ResgistraAluno
RegistraAluno ana = new RegistraAluno();
RegistraAluno beto = new RegistraAluno();
RegistraAluno carlos = new RegistraAluno();
Quadrado figura1 = new Quadrado(7);
Retangulo figura2 = new Retangulo(10, 4);
Trapezio figura3 = new Trapezio(10, 7, 5, 6, 7);
Trapezio figTrapezio[] = new Trapezio[5];
figTrapezio[0] = new Trapezio(10, 5, 6, 7, 8);
for (int i = 0; i < figTrapezio.length; i++) {
    figTrapezio[i] = new Trapezio(i+5, i, i+1, i+2, i+3);
    
}

// altera as informações com o set
ana.setNome("Ana Machado");
ana.setEndereco("Rua Santos,523");
ana.setIdade(15);
ana.setNotaCiencias(10);
ana.setNotaMatematica(7);
ana.setNotaPortugues(10);

beto.setNome("Roberto da Silva");
beto.setEndereco("Rua Palmeiras,678");
beto.setIdade(17);
beto.setNotaCiencias(6);
beto.setNotaMatematica(9);
beto.setNotaPortugues(8);

carlos.setNome("Carlos Alberto");
carlos.setEndereco("Rua Vasco,432");
carlos.setIdade(13);
carlos.setNotaCiencias(7);
carlos.setNotaMatematica(8);
carlos.setNotaPortugues(9);




//printa com as informações
System.out.println(ana.getNome());
System.out.println(ana.getEndereco());
System.out.println(ana.getIdade());
System.out.println(ana.getMedia());
System.out.println("======================");
System.out.println(beto.getNome());
System.out.println(beto.getEndereco());
System.out.println(beto.getIdade());
System.out.println(beto.getMedia());
System.out.println("=======================");
System.out.println(carlos.getNome());
System.out.println(carlos.getEndereco());
System.out.println(carlos.getIdade());
System.out.println(carlos.getMedia());
System.out.println("=========================");
System.out.println("Contador: "
+RegistraAluno.getQuantidadeAlunos());
System.out.println("============================");
System.out.println("nome Figura é "+figura1.getNomeFigura()
                    +" \n Area = "+figura1.getArea()
                    +" \n Perimetro = "+figura1.getPerimetro());

System.out.println("===========================");

System.out.println("nome Figura é "+figura2.getNomeFigura()
                    +" \n Area = "+figura2.getArea()
                    +" \n Perimetro = "+figura2.getPerimetro());

                    System.out.println("===========================");

System.out.println("nome Figura é "+figura3.getNomeFigura()
                    +" \n Area = "+figura3.getArea()
                    +" \n Perimetro = "+figura3.getPerimetro());
}

}
    

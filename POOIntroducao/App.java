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
}

}
    

package ExercicioPOO1;

import java.lang.reflect.AnnotatedArrayType;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class App {
    Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //criar um objeto da classe pessoa
        pessoa pessoa1 = new pessoa("Fabiana", 1.67, 15, 04, 1997);
        pessoa1.imprimir();
        JOptionPane.showMessageDialog(null,"idade: "+pessoa1.idade());

   
  
   




       
    }
}

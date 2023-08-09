package Colecoes;

import java.util.*;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    public void test() {

        ArrayList<String> carros = new ArrayList<>();

        carros.add("Fusca");
        carros.add("Brasilia");
        carros.add("Monza");
        carros.add("Chevette");

        System.out.println(carros);

        Collections.sort(carros);
        System.out.println(carros);

        Collections.reverse(carros);
        System.out.println(carros);

        for (int i = 0; i < carros.size(); i++) {
            System.out.println(carros.get(i));

        } // forEach //
        for (String string : carros) {
            System.out.println(string);
        }
        carros.clear();
        System.out.println(carros);

    }

    public void exec1() {

        ArrayList<String> numeros = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Me informe 5 numeros");

        int n1 = Integer.parseInt(JOptionPane.showInputDialog(""));
        int n2 = Integer.parseInt(JOptionPane.showInputDialog(""));
        int n3 = Integer.parseInt(JOptionPane.showInputDialog(""));
        int n4 = Integer.parseInt(JOptionPane.showInputDialog(""));
        int n5 = Integer.parseInt(JOptionPane.showInputDialog(""));

        numeros.add(Integer.toString(n1));
        numeros.add(Integer.toString(n2));
        numeros.add(Integer.toString(n3));
        numeros.add(Integer.toString(n4));
        numeros.add(Integer.toString(n5));
        System.out.println(numeros);
        Collections.sort(numeros);
        System.out.println(numeros);

        

    }
}

package Colecoes;

import java.util.LinkedList;

public class ExemploLinkedList {
    LinkedList<String> pessoas = new LinkedList<>();

    public void teste(){
        pessoas.add("Pedro");
        pessoas.add("vito");
        pessoas.add("jonas");
        pessoas.addFirst("Arnaldo");
        pessoas.removeLast();
        System.out.println(pessoas);


    }

}

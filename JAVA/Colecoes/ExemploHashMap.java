package Colecoes;

import java.util.HashMap;

public class ExemploHashMap {

    HashMap<String,String> capitalEstado = new HashMap<>();

    public void teste(){

        capitalEstado.put("SP","São Paulo");
        capitalEstado.put("RJ", "Rio de Janeiro");
        capitalEstado.put("BA", "Salvador");
        System.out.println(capitalEstado.get("BA"));

        for (String i : capitalEstado.keySet()) {
            System.out.println(i+": "+capitalEstado.get(i));
            
        }
    }
    public void exec1(){
        HashMap<String,Integer> credencial = new HashMap<>();
        credencial.put("Jonas", 18);
        credencial.put("Mario", 50);
        credencial.put("Neymar", 30);

        for (String i : credencial.keySet()) {
            System.out.println(i+": "+credencial.get(i)+" anos");
            
        }
    }
    
}

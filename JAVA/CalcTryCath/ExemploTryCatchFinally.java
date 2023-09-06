package CalcTryCath;

import javax.swing.JOptionPane;

public class ExemploTryCatchFinally {
public static void main(String[] args) {
    

     String fraseInicial=null;
    String fraseFinal=null;
    
        fraseInicial = JOptionPane.showInputDialog(null, "Digite um frase");
        if(fraseInicial.equals("")){
            fraseInicial = null;

        }
        try {
            fraseFinal = fraseInicial.toUpperCase();
       
    } catch (Exception e) {
        fraseInicial = "Não foi digitado uma frase";
        
    
    }finally{
      fraseFinal = fraseInicial.toUpperCase();
      JOptionPane.showMessageDialog(null,fraseFinal);
    }
    }
}


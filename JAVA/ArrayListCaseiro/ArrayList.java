package ArrayListCaseiro;

import javax.swing.JOptionPane;

public class ArrayList {
   
       
       int cont=0;
       int v1[] = new int[cont];
     
       
       
       

    
    public void add(int add) {
          int v2[] = new int [cont++];
        for (int i = 0; i < v1.length; i++) {
            v2[i] =v1[i];
            
        }
     v2[v2.length-1] = add;

     int v1[] = new int [cont+1];
for (int i = 0; i < v1.length; i++) {
    v1[i] = v2[i];
}
cont++;

    }
    public void imprimir(){
        for (int i = 0; i < v1.length; i++) {
            
        
        System.out.println("Vetor"+ v1[i]);
        }
    }
}

    


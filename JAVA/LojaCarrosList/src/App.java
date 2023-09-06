import java.util.*;

import javax.print.attribute.standard.JobHoldUntil;
import javax.swing.JOptionPane;
public class App {
    public static void main(String[] args) throws Exception {
    //class Carros - atributos e os métodos
    // manipular esssa classe no app.
    List<Carros> ListaCarros = new ArrayList<>();

    boolean lojaAberta = true;
    JOptionPane.showMessageDialog(null, "Seja Bem vindo a Nossa Loja de Carros");

    while (lojaAberta) {
        int part1 = Integer.parseInt(JOptionPane.showInputDialog(null,"O que Você deseja?\n 1- Cadastrar Carro \n 2- Ver todos os Carros \n 3- Consultar Carros \n 4- Apagar Carro \n 5 - Sair"));

        switch (part1) {
            case 1:
            JOptionPane.showMessageDialog(null, "Preencha as informações sobre seu Carro");
            Carros c = new Carros(); 
            c.setMarca(JOptionPane.showInputDialog("Insira Marca do Carro"));
            c.setModelo(JOptionPane.showInputDialog("Insira Modelo do Carro"));
            c.setAno(JOptionPane.showInputDialog("Insira Ano do Carro"));
            c.setCor(JOptionPane.showInputDialog("Insira Cor do Carro"));
        
            ListaCarros.add(c);
             
             
                break;
                 case 2:
                 String listar="";
                for (Carros carros : ListaCarros) {
                    listar+=carros.getMarca()+" "+carros.getModelo()+"\n";
                }
                JOptionPane.showMessageDialog(null, listar);
                break;
                 case 3:
                String consultar = JOptionPane.showInputDialog("Qual carro Deseja Consultar?");
                for (int i = 0; i < ListaCarros.size(); i++) {
                    if(consultar.equals(ListaCarros.get(i).getMarca()+ListaCarros.get(i).getModelo())){
                        JOptionPane.showMessageDialog(null,"Carro Encontrado\n"+"Marca: "+ListaCarros.get(i).getMarca()+"\nModelo: "+ListaCarros.get(i).getModelo()+"\nAno: "+ListaCarros.get(i).getAno()+"\nCor: "+ListaCarros.get(i).getCor() );
                }else{JOptionPane.showMessageDialog(null, "Esse Carro Não está Cadastrado");}
                    
                    }
                    
                
                break;
                 case 4:
                
                break;
                 case 5:
                lojaAberta = false;
                break;
        
            default: JOptionPane.showMessageDialog(null,"Opção Não encontrada");
                break;
        }
        
    }
   
    //1. Cadastrar novo Carro
    //2. Listar todos os Carros Cadastrados
    //3. Consultar um Carros Cadastrado
    //4. Apagar um Carro Cadastrado




    }
}

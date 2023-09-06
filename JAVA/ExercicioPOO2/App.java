package ExercicioPOO2;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
     //criar um vetor de objetos de 10 valores
     Agenda contatos[] = new Agenda[10];
     //criar os objetos e preencher os valores
     for (int i = 0; i < contatos.length; i++) {
        //construir o objeto
        contatos[i]= new Agenda();
        //preencher
        contatos[i].setNome(JOptionPane.showInputDialog("Digite o nome:"));
        contatos[i].setIdade(JOptionPane.showInputDialog("Digite a Idade:"));
        contatos[i].setTelefone(JOptionPane.showInputDialog("Digite o Telefone:"));
        
     }
     //pesquisar a minha lista de contatos
     int cont=0; //contador
     String nomeBuscado = JOptionPane.showInputDialog("Digite um Nome para buscar: ");
     boolean  naoEncontrei = true;
     while(naoEncontrei){
        if(nomeBuscado.equals(contatos[cont].getNome())){
            naoEncontrei = false;
            JOptionPane.showMessageDialog(null,"idade: "+contatos[cont].getIdade());
            JOptionPane.showMessageDialog(null,"Telefone: "+contatos[cont].getTelefone());
        }
        cont++;                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            

     }
    }
}

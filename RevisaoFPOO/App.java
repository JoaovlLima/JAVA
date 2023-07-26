package RevisaoFPOO;

import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Animais;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;

public class App {
    public static void main(String[] args) {
        
        Cachorro cadastroCachorro[] = new Cachorro[5];
        Gato cadastroGato[] = new Gato[5];
        Outros cadastroOutros[] = new Outros[5];
        boolean aberto = true;
        
        while (aberto) {
            
                
            
            int tipo = Integer.parseInt(JOptionPane.showInputDialog(null," Escolha Seu Tipo de Animal \n 1-Cachorro\n 2-Gato\n 3-Outros\n 4-Sair"));
            switch (tipo) {
                case 1: 
                for (int i = 0; i < cadastroCachorro.length; i++) {
                    
                }
                    JOptionPane.showMessageDialog(null, "Informe suas Informações: "+cadastroCachorro[i].setProprietario(Integer.parseInt(JOptionPane.showInputDialog(null,"Nome Proprietário:")));;);
                    break;
            case 2: 
                    
                    break;
                case 3: 
                    
                    break;
                case 4: aberto = false;
                    
                    break;
                default: JOptionPane.showMessageDialog(null, "Numero Incorreto");
                    break;
            }
        }

    }
}

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
        int contGato = 0;
        int contCachorro = 0;
        int contOutro = 0;
        JOptionPane.showMessageDialog(null, "Bem Vindo Ao Consultório")
        while (aberto) {
            
                
            
            int tipo = Integer.parseInt(JOptionPane.showInputDialog(null," 1-Cadastrar Pet\n 2-Agendar consulta\n 3-Sair"));
            switch (tipo) {
                case 1: 
                int acao = Integer.parseInt(JOptionPane.showInputDialog(null," 1-Cachorro\n 2-Gato\n 3-Outros"));
                   switch (acao) {
                    case 1:
                        
                        break;
                    case 2:
                        
                        break;
                         case 3:
                        
                        break;
                        
                    default:JOptionPane.showMessageDialog(null, "Numero Incorreto");
                        break;
                   } 
                    break;
            case 2: 
                    
                    break;
                case 3: aberto = false;
                    
                default: JOptionPane.showMessageDialog(null, "Numero Incorreto");
                    break;
            }
        }

    }
}

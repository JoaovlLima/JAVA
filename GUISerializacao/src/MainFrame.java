import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MainFrame extends JFrame {
    public MainFrame() {
        super();

        setDefaultCloseOperation(2);
        JTabbedPane abas = new JTabbedPane();
        abas.add("Cadastro", new CadastroUsuarios());
        abas.add("Agendamento", new CadastroAgendamento());


        

        add(abas);
    }
    public void run(){
        pack();
        setVisible(true);
    }
    
}

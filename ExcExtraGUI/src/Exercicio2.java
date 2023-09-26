import java.awt.*;
import java.util.zip.GZIPInputStream;

import javax.swing.*;

public class Exercicio2 extends JFrame {

    public Exercicio2() {
        super("Exercicio 2");
    
        JPanel mainP = new JPanel();

        CardLayout cl = new CardLayout();
        mainP.setLayout(cl);

        JPanel home = new JPanel();
        JPanel login = new JPanel();
        JPanel cadastro = new JPanel();

        mainP.add(home);
        mainP.add(login);
        mainP.add(cadastro);

        // Componentes home
        Font fontTitulo = new Font("Serif", Font.PLAIN, 20);

        JPanel mainHome = new JPanel(new BorderLayout());
        home.add(mainHome);

        JLabel tituloHome = new JLabel("SEJA BEM VINDO");
        tituloHome.setFont(fontTitulo);

        JButton botaoLogin = new JButton("Login");
        JButton botaoCadastro = new JButton("Cadastro");

        mainHome.add(tituloHome, BorderLayout.NORTH);
        mainHome.add(botaoLogin, BorderLayout.CENTER);
        mainHome.add(botaoCadastro, BorderLayout.SOUTH);

        //Componentes Login

        JPanel mainLogin = new JPanel(new BorderLayout());
        login.add(mainLogin);

        JLabel tituloLogin = new JLabel("FAÇA SEU LOGIN");
        tituloLogin.setFont(fontTitulo);

        JPanel campoPreenchimento = new JPanel(new GridLayout(2,1));

        JPanel areaNome = new JPanel(new GridLayout(2,1));
        JPanel areaSenha = new JPanel(new GridLayout(2,1));

        JLabel tituloNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

        JLabel tituloSenha = new JLabel("Senha:");
        JTextField campoSenha = new JTextField();

        login.add(tituloLogin);
        

        

       
        this.add(mainP);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);









    }
    
}

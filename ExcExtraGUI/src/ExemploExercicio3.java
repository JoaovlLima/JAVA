import java.awt.*;
import java.util.zip.GZIPInputStream;

import javax.swing.*;


public class ExemploExercicio3 extends JFrame {
    public ExemploExercicio3() {
        super();

        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        this.add(mainPanel);

        JPanel cardHome = new JPanel();
        cardHome.add(new JLabel("SEJA BEM VINDOS"));
        JButton botaoLogin = new JButton("Login");
        JButton botaoCad = new JButton("Cadastro");
        cardHome.add(botaoLogin);
        cardHome.add(botaoCad);
        mainPanel.add(cardHome,"Home");

        JPanel cardLogin = new JPanel();
        cardLogin.add(new JLabel("Login"));
        JButton botaoHome = new JButton("Home");
        JButton botaoCad2 = new JButton("Cadastro");
        cardLogin.add(botaoHome);
        cardLogin.add(botaoCad2);
        mainPanel.add(cardLogin,"Login");

        JPanel cardCad = new JPanel();
        cardCad.add(new JLabel("Cadastro"));
        JButton botaoHome2 = new JButton("Home");
        JButton botaoLogin2 = new JButton("Login");
        cardCad.add(botaoHome2);
        cardCad.add(botaoLogin2);
        mainPanel.add(cardCad,"Cadastro");

        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //Tratamento de eventos

        botaoLogin.addActionListener(e ->{
          ///troca do card
          cl.show(mainPanel,botaoLogin.getText());

        });

        botaoCad.addActionListener(e ->{

            cl.show(mainPanel,botaoCad.getText());

        });

        botaoHome.addActionListener(e ->{

            cl.show(mainPanel,botaoHome.getText());

        });
        botaoCad2.addActionListener(e ->{

            cl.show(mainPanel,botaoCad2.getText());

        });
        botaoHome2.addActionListener(e ->{

            cl.show(mainPanel,botaoHome2.getText());

        });
        botaoLogin2.addActionListener(e ->{

            cl.show(mainPanel,botaoLogin2.getText());
            
        });







    }
    
}

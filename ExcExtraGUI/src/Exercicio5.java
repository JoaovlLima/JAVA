import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Exercicio5 extends JFrame {
     ArrayList<String> Termo = new ArrayList<String> ();

    public Exercicio5() {
        super();
    
        JPanel mainPanel = new JPanel();
        CardLayout cl = new CardLayout();
        mainPanel.setLayout(cl);
        this.add(mainPanel);

        //Criando pagina Home

        JPanel cardHome = new JPanel();
        cardHome.add(new JLabel("SEJA BEM VINDOS"));
        cardHome.add(new JLabel("Regras: Você terá que descobrir qual palavra aleátoria está no campo a seguir,\n terá 5 tentativas, aonde as unicas dicas serão,\n caso alguma letra digitada conter na palavra, terá um indicativo de próximo, e caso a letra estiver no mesmo campo terá um outro indicativo"));
        JButton botaoComecar = new JButton("cardJogo1");
        cardHome.add(botaoComecar);
        mainPanel.add(cardHome,"Home");

        JPanel cardJogo1 = new JPanel();
        cardJogo1.add(new JLabel("Adivinhe a Palavra"));

        JPanel campoPalavra = new JPanel();
        JLabel letra1 = new JLabel(" ");
        JLabel letra2 = new JLabel(" ");
        JLabel letra3 = new JLabel(" ");
        JLabel letra4 = new JLabel(" ");
        JLabel letra5 = new JLabel(" ");

        JPanel campoDigita = new JPanel();
        EmptyBorder tamDig = new EmptyBorder(10, 10, 10, 10);
        JTextField dig1 = new JTextField(1);
        dig1.setBorder(tamDig);
        JTextField dig2 = new JTextField(1);
        dig2.setBorder(tamDig);
        JTextField dig3 = new JTextField(1);
        dig3.setBorder(tamDig);
        JTextField dig4 = new JTextField(1);
        dig4.setBorder(tamDig);
        JTextField dig5 = new JTextField(1);
        dig5.setBorder(tamDig);
        

        JButton botaoEnter = new JButton("cardJogo2");
        campoPalavra.add(letra1);
        campoPalavra.add(letra2);
        campoPalavra.add(letra3);
        campoPalavra.add(letra4);
        campoPalavra.add(letra5);
        campoDigita.add(dig1);
        campoDigita.add(dig2);
        campoDigita.add(dig3);
        campoDigita.add(dig4);
        campoDigita.add(dig5);
        cardJogo1.add(campoDigita);

        cardJogo1.add(botaoEnter);
        cardJogo1.add(campoPalavra);

        mainPanel.add(cardJogo1,"cardJogo1");



        JPanel cardJogo2 = new JPanel();
        cardJogo2.add(new JLabel("Adivinhe a Palavra"));

        JButton botaoEnter1 = new JButton("cardJogo3");
        cardJogo2.add(botaoEnter1);
        mainPanel.add(cardJogo2,"cardJogo2");



        JPanel cardJogo3 = new JPanel();
        cardJogo3.add(new JLabel("Adivinhe a Palavra"));

        JButton botaoEnter2 = new JButton("cardJogo4");
        cardJogo3.add(botaoEnter2);
        mainPanel.add(cardJogo3,"cardJogo3");



        JPanel cardJogo4 = new JPanel();
        cardJogo4.add(new JLabel("Adivinhe a Palavra"));

        JButton botaoEnter3 = new JButton("cardJogo5");
        cardJogo4.add(botaoEnter3);
        mainPanel.add(cardJogo4,"cardJogo4");



        JPanel cardJogo5 = new JPanel();
        cardJogo5.add(new JLabel("Adivinhe a Palavra"));

        JButton botaoEnter4 = new JButton("telaFinal");
        cardJogo5.add(botaoEnter4);
        mainPanel.add(cardJogo5,"cardJogo5");



        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //Tratamento de eventos
          botaoComecar.addActionListener(e ->{
          ///troca do card
          cl.show(mainPanel,botaoComecar.getText());

        });

       /*  botaoEnter.addActionListener(e ->{
          ///troca do card
          cl.show(mainPanel,botaoEnter.getText());

        }); */

        botaoEnter1.addActionListener(e ->{

            cl.show(mainPanel,botaoEnter1.getText());

        });

        botaoEnter2.addActionListener(e ->{

            cl.show(mainPanel,botaoEnter2.getText());

        });
        botaoEnter3.addActionListener(e ->{

            cl.show(mainPanel,botaoEnter3.getText());

        });
        botaoEnter4.addActionListener(e ->{

            cl.show(mainPanel,botaoEnter4.getText());

        });
       
        Termo.add("t");
        Termo.add("e");
        Termo.add("r");
        Termo.add("m");
        Termo.add("o");


botaoEnter.addActionListener(e ->{
          StringBuilder concactenarPalavra = new StringBuilder();
          /* for (int 1 = 0; < 5;i++); */
          

        });


    }
}

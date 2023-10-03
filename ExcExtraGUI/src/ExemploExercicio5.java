import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploExercicio5 extends JFrame{
    int pontuacao;
    public ExemploExercicio5() {
        super();
        CardLayout cl = new CardLayout();
        JPanel mainPanel = new JPanel(cl);
        this.add(mainPanel);
        // card1 - inicio

        JPanel card1 = new JPanel();;
        card1.add(new JLabel("Seja Bem Vindos\n Aperte Start Para Começar"));
        JButton but1 = new JButton("Start");
        card1.add(but1);
        mainPanel.add(card1, "Start");

        //Card 2 - Primeira Pergunta
         JPanel card2 = new JPanel();;
        card2.add(new JLabel("Quem Ganhou a Copa de 10?"));
        JTextField caixa1 = new JTextField(25);
        JButton but2 = new JButton("Next");
        card2.add(caixa1);
        card2.add(but2);
        mainPanel.add(card2, "P1");

         JPanel card3 = new JPanel();;
        card3.add(new JLabel("Quem Onde Foi a Copa de 18?"));
        JTextField caixa2 = new JTextField(25);
        JButton but3 = new JButton("Next");
        card3.add(caixa2);
        card3.add(but3);
        mainPanel.add(card3, "P2");

        JPanel card4 = new JPanel();
        card4.add(new JLabel("Resultado Final"));
        JLabel pontuacaoFinal = new JLabel();
        card4.add(pontuacaoFinal);
        JButton but4 = new JButton("Reiniciar");
        card4.add(but4);
        mainPanel.add(card4);


        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        //Tratamento  de eventos

        but1.addActionListener(e->{
            
         cl.next(mainPanel);  

        });

        but2.addActionListener(e->{

         if(caixa1.getText().toUpperCase().equals("ESPANHA")){  
            pontuacao++; 
         cl.next(mainPanel);  
         }
        });

         but3.addActionListener(e->{

         if(caixa2.getText().toUpperCase().equals("RUSSIA")){   
            pontuacao++;
         cl.next(mainPanel);  
         }
         pontuacaoFinal.setText("Seu Resultado Final foi de "+pontuacao);


        });



    }
}

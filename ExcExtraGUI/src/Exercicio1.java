
    import javax.swing.*;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.logging.Handler;
import java.awt.*;

public class Exercicio1 extends JFrame{
      JPanel cards;
    private String painel1 = "PAINÉL 1";
    private String painel2 = "PAINÉL 2";
    private String painel3 = "PAINÉL 3";
    private int contPainel1 = 1;
     private int contPainel2 = 2;
      private int contPainel3 = 0;

    public Exercicio1() {
        super("Exercicio 1"); 

        JPanel jpanel1 = new JPanel();
        String comboBoxItems[] = { painel1, painel2, painel3 };
        JComboBox cb = new JComboBox(comboBoxItems);
        jpanel1.add(cb);
        // Criando os Cards
        JPanel card1 = new JPanel(new BorderLayout());
        JButton proximo1 = new JButton("Próximo");
        card1.add(proximo1, BorderLayout.SOUTH);
        card1.add(new JLabel("Painel 1"),BorderLayout.NORTH);
       
        JPanel card2 = new JPanel(new BorderLayout());
        JButton proximo2 = new JButton("Próximo");
        card2.add(proximo2,BorderLayout.SOUTH);
        card2.add(new JLabel("Painel 2"),BorderLayout.NORTH);
        JPanel card3 = new JPanel(new BorderLayout());
        JButton proximo3 = new JButton("Próximo");
        card3.add(proximo3,BorderLayout.SOUTH);
        card3.add(new JLabel("Painel 3"),BorderLayout.NORTH);
        // Adicionando Cards a um CardsLayout
        cards = new JPanel(new CardLayout());
        cards.add(card1, painel1);
        cards.add(card2, painel2);
        cards.add(card3, painel3);
        this.add(jpanel1, BorderLayout.PAGE_START);
        this.add(cards, BorderLayout.CENTER);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);
        Handler handler = new Handler();
        cb.addItemListener(handler);


        proximo1.addActionListener(e ->{

          
             

       
        });
         proximo2.addActionListener(e ->{
             contPainel2++;


       
        });
         proximo3.addActionListener(e ->{
             contPainel3++;


       
        });

    }
    public class Handler implements ItemListener {
        public void itemStateChanged(ItemEvent event) {
        CardLayout cl = (CardLayout) (cards.getLayout());
        cl.show(cards, (String) event.getItem());
        }
        }
        
}


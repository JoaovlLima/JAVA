
    import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Label;

public class ExemploExercicio1 extends JFrame{
    public ExemploExercicio1() {
        super("Exemplo Exercicio1");
        //criei um painel principal
        JPanel mainP = new JPanel();
        //setLayout - cardLayout
        CardLayout cl = new CardLayout();
        mainP.setLayout(cl);

        JPanel card1 = new JPanel();
        card1.add(new JLabel("Card 1"));
         JPanel card2 = new JPanel();
        card2.add(new JLabel("Card 2"));
         JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        JButton bNext1 = new JButton("Next");
        JButton bNext2 = new JButton("Next");
        JButton bNext3 = new JButton("Next");

        card1.add(bNext1);
        card2.add(bNext2);
        card3.add(bNext3);

        mainP.add(card1);
        mainP.add(card2);
        mainP.add(card3);

        this.add(mainP);
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

        bNext1.addActionListener(e->{
            cl.next(mainP);
        });

         bNext2.addActionListener(e->{
            cl.next(mainP);
        });
         bNext3.addActionListener(e->{
            cl.next(mainP);
        });

}
}

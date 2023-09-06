import java.awt.*;
import javax.swing.*;
public class ExemploBorder extends JFrame {

    public ExemploBorder() {
        super("janela");
        //add Jpanel

        JPanel painel = new JPanel(new BorderLayout());
        this.add(painel);
        //add componentes

        painel.add(new JButton("south"),BorderLayout.SOUTH);
        painel.add(new JTextField(25),BorderLayout.NORTH);
        painel.add(new JButton("Center"),BorderLayout.CENTER);
        painel.add(new JButton("East"),BorderLayout.EAST);
         painel.add(new JButton("West"),BorderLayout.WEST);


this.setDefaultCloseOperation(2);
this.pack();
this.setVisible(true);
    }
}

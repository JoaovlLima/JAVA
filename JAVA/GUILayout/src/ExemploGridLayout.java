import java.awt.Button;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExemploGridLayout extends JFrame{
    public ExemploGridLayout() {
        super("janela Principal");

        JPanel painel = new JPanel();
        this.add(painel);
        //modificar layout

        GridLayout grid = new GridLayout(2,2);
        painel.setLayout(grid);

        //add componentes

        for (int i = 0; i < 4; i++) {
            painel.add(new Button(""+i));
        }

        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);


    }
}

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

        JLabel tituloHome = new JLabel("SEJA BEM VINDO");
        tituloHome.






    }
    
}

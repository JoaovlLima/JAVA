package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        super();

        jTPane = new JTabbedPane();
        add(jTPane);
        // criandos as tabs
        // tab1 carros
        CarrosPainel tab1 = new CarrosPainel();
        jTPane.add("Carros", tab1);
        VendasView tab2 = new VendasView();
        jTPane.add("Venda", tab2);
        ClientePainel tab3 = new ClientePainel();
        jTPane.add("Clientes", tab3);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jTPane.addChangeListener(e -> {
            tab2.atualizarVendas();
        });
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}

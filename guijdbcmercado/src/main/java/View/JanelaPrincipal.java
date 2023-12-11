package View;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane painelRei;

    public JanelaPrincipal() {
        super();

        painelRei = new JTabbedPane();
        add(painelRei);
        // criandos as tabs
        
        ComprasPainel tab1 = new ComprasPainel();
        painelRei.add("Compras", tab1);
        ProdutosPainel tab2 = new ProdutosPainel();
        painelRei.add("Produtos", tab2);
        ClientesVipPainel tab3 = new ClientesVipPainel();
        painelRei.add("Clientes VIP", tab3);
        setBounds(100, 100, 600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      /*   painelRei.addChangeListener(e -> {
            tab2.atualizarVendasCli();
            tab2.atualizarVendasCar();
        }); */
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}

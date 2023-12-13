package View;

import java.awt.Component;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import Connection.ClientesVipDAO;
import Model.ClientesVip;

public class JanelaPrincipal extends JFrame {
    private JTabbedPane painelRei;
    private List<ClientesVip> clientes;
    private boolean clienteVipCheck = false, cpfCorreto = true;;

    public JanelaPrincipal() {
        super("Relatório de Vendas - Mercado");

        painelRei = new JTabbedPane();
        add(painelRei);
        // criandos as tabs

        ComprasPainel tab1 = new ComprasPainel();
        if (JOptionPane.showConfirmDialog(null, "O cliente é VIP?",
                "Cliente VIP", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
            painelRei.add("Compras", tab1);
        } else {
            clientes = new ClientesVipDAO().listarTodos();
            boolean clienteVipCheck = false;
            boolean cpfCorreto = false;

            while (!clienteVipCheck) {
                String cpf = JOptionPane.showInputDialog(null, "Informe o CPF:");
                String cpfFormatado = formatarCPF(cpf);

                for (ClientesVip cliente : clientes) {
                    if (cpfFormatado.equals(cliente.getCpf())) {
                        JOptionPane.showMessageDialog(null, "Bem vindo " + cliente.getNome() + "!");
                        clienteVipCheck = true;
                        painelRei.add("Compras", tab1);
                        cpfCorreto = true;
                        break; // Sair do loop assim que encontrar o cliente
                    }
                }

                if (!cpfCorreto) {
                    JOptionPane.showMessageDialog(null, "CPF Incorreto, por favor digite novamente", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        ProdutosPainel tab2 = new ProdutosPainel();
        painelRei.add("Produtos", tab2);
        ClientesVipPainel tab3 = new ClientesVipPainel();
        painelRei.add("Clientes VIP", tab3);

        setBounds(100, 100, 700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        painelRei.addChangeListener(e -> {
            tab1.atualizarTabelaProd();
            tab2.atualizarTabelaProd2();
        });
    }

    // Função para formatar o CPF
    public static String formatarCPF(String cpf) {
        // Remove qualquer caractere não numérico
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF tem 11 dígitos
        if (cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." +
                    cpf.substring(6, 9) + "-" + cpf.substring(9);
        } else {
            return "CPF inválido";
        }
    }

    // métodos para tornar a janela visível
    public void run() {
        this.setVisible(true);
    }

}

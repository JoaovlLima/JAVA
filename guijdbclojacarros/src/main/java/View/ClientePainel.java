package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.ClienteDAO;
import Controller.ClientesControl;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

import Model.Clientes;
import View.VendasView;

public class ClientePainel extends JPanel {
    // atributos
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField cliNomeField, cliEmailField, cliCpfField;

    
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private boolean placaIgual = false;

    // Construtor(GUI-JPanel)
    public ClientePainel() {
        super();
    
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nome"));
        cliNomeField = new JTextField(20);
        inputPanel.add(cliNomeField);
        inputPanel.add(new JLabel("Email"));
        cliEmailField = new JTextField(20);
        inputPanel.add(cliEmailField);
        inputPanel.add(new JLabel("CPF"));
        cliCpfField = new JTextField(20);
        inputPanel.add(cliCpfField);

        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Email", "CPF" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Tratamento de eventos

        new ClienteDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    cliNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cliEmailField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    cliCpfField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    /* cliCpfField.setEditable(false); */
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        cadastrar.addActionListener(e -> {
            if (cliNomeField.getText().isEmpty() || cliEmailField.getText().isEmpty()
                    || cliCpfField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                String cpf = cliCpfField.getText().toUpperCase();
                if (cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {

                    clientes = new ClienteDAO().listarTodos();
                    for (Clientes cliente : clientes) {
                        if (cpf.equals(cliente.getCpf())) {
                            placaIgual = true;
                            break;
                        } else {
                            placaIgual = false;
                        }
                    }
                    if (placaIgual == false) {
                        operacoes.cadastrar(cliNomeField.getText(), cliEmailField.getText(), cpf);

                        cliNomeField.setText("");
                        cliEmailField.setText("");
                        cliCpfField.setText("");

                    } else {
                        JOptionPane.showMessageDialog(null, "CPF ja cadastrado", "Aviso", JOptionPane.WARNING_MESSAGE);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "CPF Incorreta\nSiga o Padrão a Seguir:\n 123.456.789-12",
                            "Aviso", JOptionPane.WARNING_MESSAGE);
                }
            }
           
        });
        editar.addActionListener(e -> {

            if (cliNomeField.getText().isEmpty() || cliEmailField.getText().isEmpty()
                    || cliCpfField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {
                String cpf = cliCpfField.getText().toUpperCase();
                if (cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {

                    operacoes.atualizar(cliNomeField.getText(), cliEmailField.getText(), cpf);

                    cliNomeField.setText("");
                    cliEmailField.setText("");
                    cliCpfField.setText("");

                } else {
                    JOptionPane.showMessageDialog(null, "Placa Incorreta\nSiga o Padrão a Seguir:\n ABC-1234", "Aviso",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        apagar.addActionListener(e -> {

            int validacao = JOptionPane.showConfirmDialog(null, "Dejesa realmente EXCLUIR?", "Confirme",
                    JOptionPane.YES_NO_OPTION);
            if (validacao == JOptionPane.YES_NO_OPTION) {

                operacoes.apagar(cliCpfField.getText());

                cliNomeField.setText("");
                cliEmailField.setText("");
                cliCpfField.setText("");
            } else {

            }

        });
        limpar.addActionListener(e -> {
            operacoes.limpar(cliNomeField.getText(), cliEmailField.getText(),cliCpfField.getText());

            cliNomeField.setText("");
                cliEmailField.setText("");
                cliCpfField.setText("");

        });

    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        clientes = new ClienteDAO().listarTodos();
        for (Clientes cliente : clientes) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getEmail(),

                    cliente.getCpf()});
        }
    }
}

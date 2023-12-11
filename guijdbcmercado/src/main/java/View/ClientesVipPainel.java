package View;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import Connection.ClientesVipDAO;
import Controller.ClientesVipController;
import Model.ClientesVip;

public class ClientesVipPainel extends JPanel {
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField nomeField, cpfField;

    private List<ClientesVip> clientesVips;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ClientesVipPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nome"));
        nomeField = new JTextField(20);
        inputPanel.add(nomeField);
        inputPanel.add(new JLabel("CPF"));
        cpfField = new JTextField(20);
        inputPanel.add(cpfField);
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
                new String[] { "Nome", "CPF" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Tratamento de eventos
        new ClientesVipDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    nomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    cpfField.setText((String) table.getValueAt(linhaSelecionada, 1));

                }
            }
        });

        ClientesVipController operacoes = new ClientesVipController(clientesVips, tableModel, table);

        cadastrar.addActionListener(e -> {
            if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                operacoes.cadastrar(nomeField.getText(), cpfField.getText());

                nomeField.setText("");
                cpfField.setText("");
            }
        });
        editar.addActionListener(e -> {
            if (nomeField.getText().isEmpty() || cpfField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha Todos os Campos", "Aviso", JOptionPane.WARNING_MESSAGE);
            } else {

                operacoes.atualizar(nomeField.getText(), cpfField.getText());

                nomeField.setText("");
                cpfField.setText("");

            }

        });
        apagar.addActionListener(e -> {

            int validacao = JOptionPane.showConfirmDialog(null, "Dejesa realmente EXCLUIR?", "Confirme",
                    JOptionPane.YES_NO_OPTION);
            if (validacao == JOptionPane.YES_NO_OPTION) {

                operacoes.apagar(cpfField.getText());

                nomeField.setText("");
                cpfField.setText("");

            } else {

            }

        });
        
        limpar.addActionListener(e -> {
            operacoes.limpar(nomeField.getText(), cpfField.getText());

            nomeField.setText("");
            cpfField.setText("");

        });

    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        clientesVips = new ClientesVipDAO().listarTodos();
        for (ClientesVip cliente : clientesVips) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { cliente.getNome(), cliente.getCpf()});
        }
    }
}

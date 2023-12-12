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

import Connection.ProdutosDAO;
import Controller.ProdutosController;
import Model.Produtos;

public class ProdutosPainel extends JPanel {
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField prodNomeField, prodCodigoField, prodDescricaoField, prodPrecoField,
            prodQuantidadeField;

    private List<Produtos> produtos;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Construtor(GUI-JPanel)
    public ProdutosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro produtos"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Nome"));
        prodNomeField = new JTextField(20);
        inputPanel.add(prodNomeField);
        inputPanel.add(new JLabel("Codigo"));
        prodCodigoField = new JTextField(20);
        inputPanel.add(prodCodigoField);
        inputPanel.add(new JLabel("Descrição"));
        prodDescricaoField = new JTextField(30);
        inputPanel.add(prodDescricaoField);
        inputPanel.add(new JLabel("Preço"));
        prodPrecoField = new JTextField(20);
        inputPanel.add(prodPrecoField);
        inputPanel.add(new JLabel("Quantidade"));
        prodQuantidadeField = new JTextField(20);
        inputPanel.add(prodQuantidadeField);
        /* inputPanel.add(new JLabel("Situação")); */
        /*
         * carSituacaoCombo.addItem("Vendido");
         * carSituacaoCombo.addItem("Não Vendido");
         * inputPanel.add(carSituacaoCombo);
         */
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
                new String[] { "Nome", "Código", "Descrição", "preço", "Quantidade" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Tratamento de eventos
        new ProdutosDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    prodNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    prodCodigoField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    prodDescricaoField.setText((String) table.getValueAt(linhaSelecionada, 2));
                    prodPrecoField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    prodQuantidadeField.setText((String) table.getValueAt(linhaSelecionada, 4));

                    prodCodigoField.setEditable(false);
                    cadastrar.setEnabled(false);
                    editar.setEnabled(true);
                } else {
                    // Ativa o textfield da placa
                    prodCodigoField.setEditable(true);
                    // Ativa o botão
                    cadastrar.setEnabled(true);

                    editar.setEnabled(false);
                }
            }
        });

        ProdutosController operacoes = new ProdutosController(produtos, tableModel, table);

        cadastrar.addActionListener(e -> {
            operacoes.cadastrar(prodNomeField.getText(), prodCodigoField.getText(), prodDescricaoField.getText(),
                    prodPrecoField.getText(), prodQuantidadeField.getText());

            prodNomeField.setText("");
            prodCodigoField.setText("");
            prodDescricaoField.setText("");
            prodPrecoField.setText("");
            prodQuantidadeField.setText("");

        });
        editar.addActionListener(e -> {

            operacoes.atualizar(prodNomeField.getText(), prodCodigoField.getText(), prodDescricaoField.getText(),
                    prodPrecoField.getText(), prodQuantidadeField.getText());

            prodNomeField.setText("");
            prodCodigoField.setText("");
            prodDescricaoField.setText("");
            prodPrecoField.setText("");
            prodQuantidadeField.setText("");
            cadastrar.setEnabled(true);
            prodCodigoField.setEditable(true);
            table.clearSelection();

        });
        apagar.addActionListener(e -> {

            int validacao = JOptionPane.showConfirmDialog(null, "Dejesa realmente EXCLUIR?", "Confirme",
                    JOptionPane.YES_NO_OPTION);
            if (validacao == JOptionPane.YES_NO_OPTION) {

                operacoes.apagar(prodCodigoField.getText());

                prodNomeField.setText("");
                prodCodigoField.setText("");
                prodDescricaoField.setText("");
                prodPrecoField.setText("");
                prodQuantidadeField.setText("");
            }

        });
        limpar.addActionListener(e -> {
            operacoes.limpar(prodNomeField.getText(), prodCodigoField.getText(), prodDescricaoField.getText(),
                    prodPrecoField.getText(), prodQuantidadeField.getText());

            prodNomeField.setText("");
            prodCodigoField.setText("");
            prodDescricaoField.setText("");
            prodPrecoField.setText("");
            prodQuantidadeField.setText("");

            prodCodigoField.setEditable(true);
            cadastrar.setEnabled(true);
            editar.setEnabled(false);
            table.clearSelection();
        });

    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { produto.getNome(), produto.getCodigo(), produto.getDescricao(),
                    produto.getPreco(), produto.getQuantidade() });
        }
    }

    public void atualizarTabelaProd2() {
        atualizarTabela();
    }
}

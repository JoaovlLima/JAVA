package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Compras;
import Model.Produtos;

import java.awt.*;
import java.awt.event.*;

import Connection.ProdutosDAO;

import Controller.ComprasController;

public class ComprasPainel extends JPanel {

    // JPanels
    // Principal
    private JPanel mainPanel;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel rightPanel;
    private JPanel centerPanel;
    // Descrição
    private JPanel descPanelTop;
    private JPanel descPanelBottom;
    private JPanel descPanelBottomLeft;
    private JPanel descPanelBottomRight;
    private JPanel descCompraPanel;
    private JPanel descImgPanel;
    private JPanel descInfo;
    private JPanel descQuantidadePanel;
    // Compra
    private JPanel compraPanelTop;
    private JPanel compraPanelBottom;
    private JPanel compraPanelBtn;
    private JPanel compraPanelTotal;
    // Apenas teste, depois precisa excluir
    private JPanel teste;
    // Labels
    private JLabel nomeProd;
    private JLabel descProd;
    private JLabel precoProd;
    private JLabel qtdeProd;
    private JLabel valorTotal;
    // Botões
    private JButton comprarBtn;
    private JButton finalizarCompraBtn;
    private JButton removerCompraBtn;
    // JSpinner para números
    private SpinnerNumberModel spinnerModel;
    private JSpinner qtdeSpinner;
    // Imagem

    // Lista
    private List<Produtos> produtos;
    private List<Compras> compras;
    private JTable tableProd;
    private JTable tableCompra;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Outras Variaveis
    private String total = "00,00";
    private String quantidadeAtual = "1";

    private ComprasController novaCompra;

    public ComprasPainel() {
        super();

        // Declarando os painéis
        mainPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        rightPanel = new JPanel();
        centerPanel = new JPanel();
        descPanelTop = new JPanel();
        descPanelBottom = new JPanel();
        descPanelBottomLeft = new JPanel();
        descPanelBottomRight = new JPanel();
        descQuantidadePanel = new JPanel();
        descCompraPanel = new JPanel();
        descImgPanel = new JPanel();
        descInfo = new JPanel();
        compraPanelTop = new JPanel();
        compraPanelBottom = new JPanel();
        compraPanelBtn = new JPanel();
        compraPanelTotal = new JPanel();
        novaCompra = new ComprasController();

        teste = new JPanel();

        // Declarando as Labels
        nomeProd = new JLabel("Nome: ");
        descProd = new JLabel("Descricação: ");
        precoProd = new JLabel("Preço: R$ ");
        qtdeProd = new JLabel("Quantidade: ");
        valorTotal = new JLabel("Valor Total: R$ " + total);

        // Declarando os botões
        comprarBtn = new JButton("Comprar");
        finalizarCompraBtn = new JButton("Finalizar Compra");
        removerCompraBtn = new JButton("Remover Compra");

        // Declaração do JSpinner
        spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        // Valor inicial, mínimo, máximo, passo

        qtdeSpinner = new JSpinner(spinnerModel);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(rightPanel, BorderLayout.EAST);

        // -------------------------------------------------------------------------------------------

        // Painel do centro
        centerPanel.setLayout(new BorderLayout());
        centerPanel.add(topPanel, BorderLayout.NORTH);
        centerPanel.add(bottomPanel, BorderLayout.CENTER);

        // Lista de Produtos no painel top
        // tabela de produtos
        JScrollPane jSPane = new JScrollPane();
        topPanel.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Código", "Descrição", "preço", "Quantidade" });
        tableProd = new JTable(tableModel);
        jSPane.setViewportView(tableProd);

        // Define a largura das colunas
        tableProd.getColumnModel().getColumn(0).setPreferredWidth(100); // Coluna "Nome"
        tableProd.getColumnModel().getColumn(1).setPreferredWidth(100); // Coluna "Quantidade"

        // Define a altura preferida da tabela
        tableProd.setPreferredScrollableViewportSize(new Dimension(320, 200)); // Largura 320, Altura 200

        //
        new ProdutosDAO().criaTabela();
        atualizarTabela();

        // -------------------------------------------------------------------------------------------

        // Descrição
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(descPanelTop, BorderLayout.NORTH);
        bottomPanel.add(descPanelBottom, BorderLayout.CENTER);
        bottomPanel.setPreferredSize(new Dimension(180, 50));

        // Descrição TOP
        descPanelTop.setLayout(new BorderLayout());

        // Imagem
        teste.setPreferredSize(new Dimension(50, 50));
        teste.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        descImgPanel.add(teste);
        descPanelTop.add(descImgPanel, BorderLayout.WEST);

        // Nome e Descrição
        descInfo.setLayout(new GridLayout(2, 1));
        descInfo.add(nomeProd);
        descInfo.add(descProd);
        descPanelTop.add(descInfo, BorderLayout.CENTER);

        // Descrição BOTTOM
        descPanelBottom.setLayout(new BorderLayout());
        descPanelBottom.add(descPanelBottomLeft, BorderLayout.WEST);
        descPanelBottom.add(descPanelBottomRight, BorderLayout.EAST);

        descPanelBottomLeft.add(precoProd);
        descPanelBottomRight.setLayout(new BorderLayout());
        descQuantidadePanel.add(qtdeProd);
        descQuantidadePanel.add(qtdeSpinner);
        descCompraPanel.add(comprarBtn);
        descPanelBottomRight.add(descQuantidadePanel, BorderLayout.NORTH);
        descPanelBottomRight.add(descCompraPanel, BorderLayout.CENTER);

        // -------------------------------------------------------------------------------------------

        // Lista do carrinho no painel da direita
        // tabela de produtos
        JScrollPane jSPane1 = new JScrollPane();
        compraPanelTop.add(jSPane1);

        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Codigo", "Quantidade" });
        tableCompra = new JTable(tableModel);

        // Define a largura das colunas
        tableCompra.getColumnModel().getColumn(0).setPreferredWidth(100); // Coluna "Nome"
        tableCompra.getColumnModel().getColumn(1).setPreferredWidth(100); // Coluna "Quantidade"

        // Define a altura preferida da tabela
        tableCompra.setPreferredScrollableViewportSize(new Dimension(200, 420)); // Largura 200, Altura 200

        jSPane1.setViewportView(tableCompra);

        compraPanelBottom.setLayout(new BorderLayout());
        compraPanelBottom.add(compraPanelBtn,BorderLayout.CENTER);
        compraPanelBottom.add(compraPanelTotal,BorderLayout.NORTH);
        compraPanelTotal.setLayout(new GridLayout());
        compraPanelBtn.add(finalizarCompraBtn);
        compraPanelBtn.add(removerCompraBtn);
        compraPanelTotal.add(valorTotal);

        rightPanel.setLayout(new GridLayout(2, 1));
        rightPanel.add(compraPanelTop);
        rightPanel.add(compraPanelBottom);

        this.add(mainPanel);

        // EVENTOS

        tableProd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = tableProd.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    String nome = (String) tableProd.getValueAt(linhaSelecionada, 0);
                    String descricao = (String) tableProd.getValueAt(linhaSelecionada, 2);
                    String preco = (String) tableProd.getValueAt(linhaSelecionada, 3);
                    String quantidade = (String) tableProd.getValueAt(linhaSelecionada, 4);

                    nomeProd.setText("Nome: " + nome);
                    descProd.setText("Descrição: " + descricao);
                    precoProd.setText("Preço: R$ " + preco);
                }
            }
        });

        comprarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionada = tableProd.getSelectedRow();

                // Verifica se alguma linha foi selecionada
                if (linhaSelecionada != -1) {
                    // Obtém os dados da linha selecionada na tabela de produtos
                    String nome = tableProd.getValueAt(linhaSelecionada, 0).toString();
                    String codigo = tableProd.getValueAt(linhaSelecionada, 1).toString();

                    // Obtém a quantidade desejada do JSpinner
                    int quantidadeSelecionada = (int) qtdeSpinner.getValue();

                    // Adiciona os dados à tabela do carrinho
                    DefaultTableModel carrinhoTableModel = (DefaultTableModel) tableCompra.getModel();
                    carrinhoTableModel.addRow(new Object[] { nome, codigo, quantidadeSelecionada });

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto para comprar.");
                }
            }
        });

        finalizarCompraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtendo a lista de produtos no carrinho
                DefaultTableModel carrinhoTableModel = (DefaultTableModel) tableCompra.getModel();
                int rowCount = carrinhoTableModel.getRowCount();

                // Verificando se há produtos no carrinho antes de prosseguir
                if (rowCount == 0) {
                    JOptionPane.showMessageDialog(null,
                            "Seu carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                    return; // Retorna caso o carrinho esteja vazio
                }

                // Adicionando os produtos ao carrinho e atualizando as quantidades
                for (int i = 0; i < rowCount; i++) {
                    String nome = carrinhoTableModel.getValueAt(i, 0).toString();
                    String codigo = carrinhoTableModel.getValueAt(i, 1).toString();
                    int quantidade = Integer.parseInt(carrinhoTableModel.getValueAt(i, 2).toString());

                    // Adiciona os produtos ao carrinho
                    novaCompra.adicionarProduto(codigo, String.valueOf(quantidade));

                    // Atualiza as quantidades no banco de dados
                    novaCompra.atualizarQuantidadesNoBanco();
                }

                // Limpar o carrinho após finalizar a compra (se necessário)
                carrinhoTableModel.setRowCount(0);
            }
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

}

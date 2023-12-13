package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import Model.Compras;
import Model.Produtos;

import java.awt.*;
import java.awt.event.*;

import Connection.ProdutosDAO;

import Controller.ComprasController;

public class ComprasPainel extends JPanel {
    private ProdutosDAO produtosDAO;
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
    private DefaultTableModel tableModelProd;
    private DefaultTableModel tableModelCar;
    private int linhaSelecionada = -1;
    private int linhaSelecionadaComp = -1;

    // Outras Variaveis
    private double total = 0;
    private String quantidadeAtual = "0";
    private String quantidadeComprada = "0";
    private ComprasController novaCompra;

    public ComprasPainel() {
        super();
        produtosDAO = new ProdutosDAO();
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
        spinnerModel = new SpinnerNumberModel(0, 0, Integer.parseInt(quantidadeAtual), 1);
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
        tableModelProd = new DefaultTableModel(new Object[][] {},
                new String[] { "Nome", "Código", "Descrição", "preço", "Quantidade" });
        tableProd = new JTable(tableModelProd);
        jSPane.setViewportView(tableProd);

        // Define a largura das colunas
        tableProd.getColumnModel().getColumn(0).setPreferredWidth(100); // Coluna "Nome"
        tableProd.getColumnModel().getColumn(1).setPreferredWidth(100); // Coluna "Quantidade"

        // Define a altura preferida da tabela
        tableProd.setPreferredScrollableViewportSize(new Dimension(320, 200)); // Largura 320, Altura 200

        //
        // new ProdutosDAO().criaTabela();
        atualizarTabela();
        // -------------------------------------------------------------------------------------------

        // Descrição
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(descPanelTop, BorderLayout.NORTH);
        bottomPanel.add(descPanelBottom, BorderLayout.CENTER);
        // bottomPanel.setPreferredSize(new Dimension(180, 50));

        // Descrição TOP
        descPanelTop.setLayout(new BorderLayout());

        // Imagem
        teste.setPreferredSize(new Dimension(70, 100));
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

        tableModelCar = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "Codigo", "Quantidade" });
        tableCompra = new JTable(tableModelCar);

        // Define a largura das colunas
        tableCompra.getColumnModel().getColumn(0).setPreferredWidth(100); // Coluna "Nome"
        tableCompra.getColumnModel().getColumn(1).setPreferredWidth(100); // Coluna "Quantidade"

        // Define a altura preferida da tabela
        tableCompra.setPreferredScrollableViewportSize(new Dimension(200, 420)); // Largura 200, Altura 200

        jSPane1.setViewportView(tableCompra);

        compraPanelBottom.setLayout(new BorderLayout());
        compraPanelBottom.add(compraPanelBtn, BorderLayout.CENTER);
        compraPanelBottom.add(compraPanelTotal, BorderLayout.NORTH);
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
                    quantidadeAtual = (String) tableProd.getValueAt(linhaSelecionada, 4);

                    nomeProd.setText("Nome: " + nome);
                    descProd.setText("Descrição: " + descricao);
                    precoProd.setText("Preço: R$ " + preco);
                    // Atualiza o valor máximo do Spinner com a nova quantidade disponível
                    spinnerModel.setMaximum(Integer.parseInt(quantidadeAtual));
                    // Atualiza o valor atual do Spinner para zero
                    spinnerModel.setValue(0);

                }
            }
        });
        tableCompra.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionadaComp = tableCompra.rowAtPoint(evt.getPoint());
                if (linhaSelecionadaComp != -1) {
                    String nome = (String) tableCompra.getValueAt(linhaSelecionadaComp, 0);
                    String codigo = (String) tableCompra.getValueAt(linhaSelecionadaComp, 1);
                    quantidadeComprada = tableCompra.getValueAt(linhaSelecionadaComp, 2).toString();
                    
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
                    if (quantidadeSelecionada > 0) {
                        int quantidadeAtual = produtosDAO.obterQuantidade(codigo);
                        int novaQuantidade = quantidadeAtual - quantidadeSelecionada;
                        // Atualiza a quantidade no banco de dados antes de adicionar ao carrinho
                        new ProdutosDAO().atualizarQuantidade(codigo,
                                String.valueOf(novaQuantidade));

                        // Adiciona os dados à tabela do carrinho
                        DefaultTableModel carrinhoTableModel = (DefaultTableModel) tableCompra.getModel();
                        carrinhoTableModel.addRow(new Object[] { nome, codigo, quantidadeSelecionada });
                        atualizarTabelaProd();
                        calcTotal();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Quantidade Inválida, por favor selecione uma quantidade válida.", "Aviso",
                                JOptionPane.WARNING_MESSAGE);
                    }

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
                    System.out.println("codigo" + codigo + "    quantidade: " + quantidade);

                    // Adiciona os produtos ao carrinho
                    novaCompra.adicionarProduto(codigo, String.valueOf(quantidade));
                    System.out.println(novaCompra);
                    // Atualiza as quantidades no banco de dados
                    /* novaCompra.atualizarQuantidadesNoBanco(); */
                }

                // Limpar o carrinho após finalizar a compra (se necessário)
                carrinhoTableModel.setRowCount(0);
                spinnerModel.setValue(0);
            }
        });

        removerCompraBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int linhaSelecionadaComp = tableCompra.getSelectedRow();

                if (linhaSelecionadaComp != -1) {
                    // Obtém os dados da linha selecionada na tabela de produtos
                    String nome = tableCompra.getValueAt(linhaSelecionadaComp, 0).toString();
                    String codigo = tableCompra.getValueAt(linhaSelecionadaComp, 1).toString();

                    int quantidadeAtualRemove = produtosDAO.obterQuantidade(codigo);
                    int novaQuatidadeRemove = quantidadeAtualRemove + Integer.parseInt(quantidadeComprada);
                    new ProdutosDAO().atualizarQuantidade(codigo,
                            String.valueOf(novaQuatidadeRemove));
                    DefaultTableModel carrinhoTableModel = (DefaultTableModel) tableCompra.getModel();
                    carrinhoTableModel.removeRow(linhaSelecionadaComp);
                    atualizarTabelaProd();
                } else {
                    System.out.println("selecione para continuar");
                }
            }
        });

    }

    private void atualizarTabela() {
        tableModelProd.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            if (!(produto.getQuantidade().equals("0"))) {
                tableModelProd.addRow(new Object[] { produto.getNome(), produto.getCodigo(), produto.getDescricao(),
                        produto.getPreco(), produto.getQuantidade() });
            }
        }
    }

    private void calcTotal() {
        int linhas = tableCompra.getRowCount();

        for (int i = 0; i < linhas; i++) {
            String codigo = (String) tableCompra.getValueAt(i, 1); // Obtém o código da linha
            int quantidade = Integer.parseInt(tableCompra.getValueAt(i, 2).toString()); // Obtém a quantidade da linha

            // Encontra o produto correspondente ao código na lista de produtos
            for (Produtos produto : produtos) {
                if (produto.getCodigo().equals(codigo)) { // Verifica se o código corresponde
                    double preco = Double.parseDouble(produto.getPreco()); // Converte o preço para double
                    System.out.println(preco);
                    // Calcula o valor comprado para este produto e adiciona ao total
                    double valorComprado = preco * quantidade;
                    total += valorComprado;
                    break; // Sai do loop assim que encontrar o produto correspondente ao código
                }
            }

        }
        valorTotal.setText("Valor Total: R$ " + total); // Define o valor total depois de calcular
    }

    public void atualizarTabelaProd() {
        atualizarTabela();
    }
}

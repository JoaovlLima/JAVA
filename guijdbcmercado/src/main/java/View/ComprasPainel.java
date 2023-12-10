package View;

import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Model.Compras;
import Model.Produtos;

import java.awt.*;
import java.awt.event.*;


public class ComprasPainel extends JPanel{

    // JPanels
    // Principal
    private JPanel mainPanel; 
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JPanel rightPanel;
    // Descrição
    private JPanel descPanelTop;
    private JPanel descPanelBottom;
    private JPanel descPanelBottomLeft;
    private JPanel descPanelBottomRight;
    private JPanel descImgPanel;
    private JPanel descInfo;
    // Compra
    private JPanel compraPanelTop;
    private JPanel compraPanelBottom;
    // Apenas teste, depois precisa excluir
    private JPanel teste;
    // Labels
    private JLabel nomeProd;
    private JLabel descProd;
    private JLabel precoProd;
    private JLabel qtdeProd;
    // Botões
    private JButton comprarBtn;
    // Imagem
    
    // Lista
    private List<Produtos> produtos;
    private List<Compras> compras;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    // Outras Variaveis
    private String nome;
    private String desc;
    private String preco;
    private String qtde;


    public ComprasPainel(){
        super();
        
        // Declarando os painéis
        mainPanel = new JPanel();
        topPanel = new JPanel();
        bottomPanel = new JPanel();
        rightPanel = new JPanel();
        descPanelTop = new JPanel();
        descPanelBottom = new JPanel();
        descPanelBottomLeft = new JPanel();
        descPanelBottomRight = new JPanel();
        descImgPanel = new JPanel();
        descInfo = new JPanel();
        compraPanelTop = new JPanel();
        compraPanelBottom = new JPanel();

        teste = new JPanel();

        // Declarando as Labels
        nomeProd = new JLabel("Nome: " + nome);
        descProd = new JLabel("Descricação: " + desc);
        precoProd = new JLabel("Preço: " + preco);
        qtdeProd = new JLabel("Quantidade: " + qtde);

        // Declarando os botões
        comprarBtn = new JButton("Comprar");

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(topPanel,BorderLayout.NORTH);
        mainPanel.add(bottomPanel,BorderLayout.SOUTH);
        mainPanel.add(rightPanel,BorderLayout.EAST);

        // -------------------------------------------------------------------------------------------

        //Lista de Produtos no painel top
        // tabela de produtos
        JScrollPane jSPane = new JScrollPane();
        topPanel.add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
        new String[] { "Nome", "Código", "Descrição", "preço", "Quantidade" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // -------------------------------------------------------------------------------------------

        // Descrição
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(descPanelTop,BorderLayout.NORTH);
        bottomPanel.add(descPanelBottom,BorderLayout.SOUTH);

        // Descrição TOP
        descPanelTop.setLayout(new BorderLayout());

        // Imagem
        teste.setSize(50,50);
        teste.setBorder(BorderFactory.createLineBorder(Color.black,1));
        descImgPanel.add(teste);
        descPanelTop.add(descImgPanel,BorderLayout.WEST);

        // Nome e Descrição
        descInfo.setLayout(new GridLayout(2,1));
        descInfo.add(nomeProd);
        descInfo.add(descProd);
        descPanelTop.add(descInfo,BorderLayout.CENTER);


        // Descrição BOTTOM
        descPanelBottom.setLayout(new BorderLayout());
        descPanelBottom.add(descPanelBottomLeft,BorderLayout.WEST);
        descPanelBottom.add(descPanelBottomRight,BorderLayout.EAST);

        descPanelBottomLeft.add(precoProd);
        descPanelBottomRight.setLayout(new FlowLayout());
        descPanelBottomRight.add(qtdeProd);
        descPanelBottomRight.add(comprarBtn);

        // -------------------------------------------------------------------------------------------

        // Lista do carrinho no painel da direita
        // tabela de produtos
        JScrollPane jSPane1 = new JScrollPane();
        compraPanelTop.add(jSPane1);
        tableModel = new DefaultTableModel(new Object[][] {},
        new String[] { "Nome", "Quantidade" });
        table = new JTable(tableModel);
        jSPane1.setViewportView(table);
        

        this.add(mainPanel);
    }
}

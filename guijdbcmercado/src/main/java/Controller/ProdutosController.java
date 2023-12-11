package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;
import Connection.ProdutosDAO;

public class ProdutosController {
    private List<Produtos> produtos;
    private DefaultTableModel tableModel;
    private JTable table;

    // Construtor
    public ProdutosController(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
        this.produtos = produtos;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Gets and Sets
    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setCarros(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void setTableModel(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;

        new ProdutosDAO().criaTabela();
        atualizarTabelaProd();
    }

    private void atualizarTabelaProd() {
        tableModel.setRowCount(0);
        produtos = new ProdutosDAO().listarTodos();
        for (Produtos produto : produtos) {
            tableModel.addRow(new Object[] { produto.getNome(), produto.getCodigo(), produto.getDescricao(),
                    produto.getPreco(), produto.getQuantidade() });
        }

    }

    public void cadastrar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {
        try {

            if (!(nome.isEmpty() || Codigo.isEmpty()
                    || Descricao.isEmpty() || Preco.isEmpty()
                    || Quantidade.isEmpty())) {
                        if(Codigo.toLowerCase().matches("[A-Z]\\[A]"))
                new ProdutosDAO().cadastrar(nome, Codigo, Descricao, Preco, Quantidade);
                atualizarTabelaProd();
            } else {
                throw new NullPointerException("Informações inválidas. Por favor preencha as informações vazias.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso",
            JOptionPane.WARNING_MESSAGE);
        }

    }

    public void apagar(String placa) {
        new ProdutosDAO().apagar(placa);
        atualizarTabelaProd();
    }

    public void atualizar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {
        new ProdutosDAO().atualizar(nome, Codigo, Descricao, Preco, Quantidade);
        atualizarTabelaProd();
    }

    public void limpar(String nome, String Codigo, String Descricao, String Preco, String Quantidade) {

        atualizarTabelaProd();
    }
}

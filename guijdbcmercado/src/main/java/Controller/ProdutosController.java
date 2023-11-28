package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Produtos;
import Connection.ProdutosDAO;

public class ProdutosController {
private List<Produtos> produtos;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public ProdutosController(List<Produtos> produtos, DefaultTableModel tableModel, JTable table) {
    this.produtos = produtos;
    this.tableModel = tableModel;
    this.table = table;
}

//Gets and Sets
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


private void atualizarTabelaProd(){
    tableModel.setRowCount(0);
    produtos = new ProdutosDAO().listarTodos();
    for (Produtos produto : produtos) {
        tableModel.addRow(new Object[]{produto.getNome(), produto.getCodigo(), produto.getDescricao(), produto.getPreco(), produto.getQuantidade()});
    }


}
public void cadastrar(String Nome, String Codigo, String Descricao, String Preco, String Quantidade){
    new ProdutosDAO().cadastrar(Nome, Codigo, Descricao, Preco, Quantidade);
    atualizarTabelaProd();
}
public void apagar(String placa){
    new ProdutosDAO().apagar(placa);
    atualizarTabelaProd();
}

public void atualizar(String Nome, String Codigo, String Descricao, String Preco, String Quantidade){
    new ProdutosDAO().atualizar(Nome, Codigo, Descricao, Preco, Quantidade);
    atualizarTabelaProd();
}
public void limpar(String Nome, String Codigo, String Descricao, String Preco, String Quantidade){
  
    atualizarTabelaProd();
}
}

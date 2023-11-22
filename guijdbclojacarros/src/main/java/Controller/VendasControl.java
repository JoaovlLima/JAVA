package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.VendaDAO;

import Model.Vendas;

public class VendasControl {
    // Atributos
private List<Vendas> vendas;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
    this.vendas = vendas;
    this.tableModel = tableModel;
    this.table = table;
}

//Gets and Sets
public List<Vendas> getVendas() {
    return vendas;
}

public void setVendas(List<Vendas> vendas) {
    this.vendas = vendas;
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

    new VendaDAO().criaTabela();
    atualizarTabela();  
}


private void atualizarTabela(){
    tableModel.setRowCount(0);
    vendas = new VendaDAO().listarTodos();
    for (Vendas venda : vendas) {
        tableModel.addRow(new Object[]{venda.getMarca(), venda.getModelo(), venda.getPlaca(), venda.getComprador()});
    }


}
public void cadastrar(String marca, String modelo, String placa, String comprador){
    new VendaDAO().cadastrar(marca, modelo, placa, comprador);
    atualizarTabela();
}
public void apagar(String placa){
    new VendaDAO().apagar(placa);
    atualizarTabela();
}

public void atualizar(String marca, String modelo, String placa, String comprador){
    new VendaDAO().atualizar(marca, modelo, placa, comprador);
    atualizarTabela();
}
public void limpar(String marca, String modelo, String placa, String comprador){
  
    atualizarTabela();
}
}
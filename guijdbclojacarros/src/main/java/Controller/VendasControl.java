package Controller;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Connection.VendaDAO;
import Model.Carros;
import Model.Vendas;
import Controller.CarrosControl;


public class VendasControl {
    // Atributos
private List<Vendas> vendas;
private List<Carros> carros;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
    this.vendas = vendas != null ? vendas : new ArrayList<>();
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
    atualizarTabelaVen();  
}

private void atualizarTabelaCar(){
    tableModel.setRowCount(0);
    carros = new CarrosDAO().listarTodos();
    for (Carros carro : carros) {
        tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPlaca(), carro.getValor(), carro.getSituacao()});
    }
}

private void atualizarTabelaVen(){
    tableModel.setRowCount(0);
    vendas = new VendaDAO().listarTodos();
    for (Vendas venda : vendas) {
        tableModel.addRow(new Object[]{venda.getMarca(), venda.getModelo(), venda.getPlaca(), venda.getComprador(), venda.getData()});
    }


}
public void cadastrarVen(String marca, String modelo, String placa, String comprador, Timestamp data) {
    new VendaDAO().cadastrar(marca, modelo, placa, comprador, data);

    atualizarTabelaVen();
    atualizarTabelaCar();
    
}
public void apagar(String placa){
    new VendaDAO().apagar(placa);
    atualizarTabelaVen();
}

public void atualizar(String marca, String modelo, String placa, String comprador){
    new VendaDAO().atualizar(marca, modelo, placa, comprador);
    atualizarTabelaVen();
}
public void limpar(String marca, String modelo, String placa, String comprador){
  
    atualizarTabelaVen();
}

public boolean verificarPlacaExistente(String placa) {
    for (Vendas venda : vendas) {
        if (venda.getPlaca().equals(placa)) {
            return true;
        }
    }
    return false;
}
}
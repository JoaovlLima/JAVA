package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

public class CarrosControl {
    // Atributos
private List<Carros> carros;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public CarrosControl(List<Carros> carros, DefaultTableModel tableModel, JTable table) {
    this.carros = carros;
    this.tableModel = tableModel;
    this.table = table;
}

//Gets and Sets
public List<Carros> getCarros() {
    return carros;
}

public void setCarros(List<Carros> carros) {
    this.carros = carros;
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

    new CarrosDAO().criaTabela();
    atualizarTabela();  
}


private void atualizarTabela(){
    tableModel.setRowCount(0);
    carros = new CarrosDAO().listarTodos();
    for (Carros carro : carros) {
        tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getAno(), carro.getPlaca(), carro.getValor()});
    }


}
public void cadastrar(String Marca, String Modelo, String ano, String placa, String Valor){
    new CarrosDAO().cadastrar(Marca, Modelo, ano,placa, Valor);
    atualizarTabela();
}
public void apagar(String placa){
    new CarrosDAO().apagar(placa);
    atualizarTabela();
}

public void atualizar(String Marca, String Modelo, String ano,String placa, String Valor){
    new CarrosDAO().atualizar(Marca, Modelo, ano, placa , Valor);
    atualizarTabela();
}
public void limpar(String Marca, String Modelo, String ano,String placa, String Valor){
  
    atualizarTabela();
}
}
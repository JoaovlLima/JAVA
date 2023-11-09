package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
}
}

package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClienteDAO;
import Model.Clientes;

public class ClientesControl {
    // Atributos
private List<Clientes> clientes;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public ClientesControl(List<Clientes> clientes, DefaultTableModel tableModel, JTable table) {
    this.clientes = clientes;
    this.tableModel = tableModel;
    this.table = table;
}

//Gets and Sets
public List<Clientes> getClientes() {
    return clientes;
}

public void setClientes(List<Clientes> clientes) {
    this.clientes = clientes;
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

    new ClienteDAO().criaTabela();
    atualizarTabela();  
}


private void atualizarTabela(){
    tableModel.setRowCount(0);
    clientes = new ClienteDAO().listarTodos();
    for (Clientes cliente : clientes) {
        tableModel.addRow(new Object[]{cliente.getNome(), cliente.getEmail(), cliente.getCpf()});
    }


}
public void cadastrar(String Nome, String Email, String cpf){
    new ClienteDAO().cadastrar(Nome, Email, cpf);
    atualizarTabela();
}
public void apagar(String cpf){
    new ClienteDAO().apagar(cpf);
    atualizarTabela();
}

public void atualizar(String Nome, String Email, String cpf){
    new ClienteDAO().atualizar(Nome, Email, cpf);
    atualizarTabela();
}
public void limpar(String Nome, String Email, String cpf){
  
    atualizarTabela();
}
}
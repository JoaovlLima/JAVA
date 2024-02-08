package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ListDAO;
import Model.Tarefas;

public class TarefasController {
    // Atributos
private List<Tarefas> tarefas;
private DefaultTableModel tableModel;
private JTable table;

//Construtor
public TarefasController(List<Tarefas> tarefas, DefaultTableModel tableModel, JTable table) {
    this.tarefas= tarefas;
    this.tableModel = tableModel;
    this.table = table;
}

//Gets and Sets
public List<Tarefas> getCarros() {
    return tarefas;
}

public void setCarros(List<Tarefas> carros) {
    this.tarefas = carros;
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

    new ListDAO().criaTabela();
    atualizarTabelaTarefa();  
}


private void atualizarTabelaTarefa(){
    tableModel.setRowCount(0);
    tarefas = new ListDAO().listarTodos();
    for (Tarefas tarefa : tarefas) {
        if(tarefa.isConcluida() == true)
    tableModel.addRow(new Object[] { tarefa.getTarefas(), "true"  });
    else{
        tableModel.addRow(new Object[] { tarefa.getTarefas(), "false"  });
    }
    }


}
public void cadastrar(String tarefas, Boolean situacao ){
    new ListDAO().cadastrar(tarefas, situacao);
    atualizarTabelaTarefa();
}
public void apagar(String tarefas){
    new ListDAO().apagar(tarefas);
    atualizarTabelaTarefa();
}

public void atualizar(String tarefas, Boolean situacao){
    new ListDAO().atualizar(tarefas,situacao);
    atualizarTabelaTarefa();
}
public void limpar(String tarefas, boolean situacao){
  
    atualizarTabelaTarefa();
}
}
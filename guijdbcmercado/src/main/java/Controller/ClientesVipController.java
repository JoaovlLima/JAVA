package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesVipDAO;
import Model.ClientesVip;

public class ClientesVipController {

    private List<ClientesVip> clientesVip;
    private DefaultTableModel tableModel;
    private JTable table;

    public ClientesVipController(List<ClientesVip> clientesVip, DefaultTableModel tableModel, JTable table) {
        this.clientesVip = clientesVip;
        this.tableModel = tableModel;
        this.table = table;
    }

    // Método para atualizar a tabela de exibição com dados do banco de dados
    private void atualizarTabela() {
        tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
        clientesVip = new ClientesVipDAO().listarTodos();
        // Obtém os carros atualizados do banco de dados
        for (ClientesVip clientes : clientesVip) {
            // Adiciona os dados de cada carro como uma nova linha na tabela Swing
            tableModel.addRow(new Object[] { clientes.getNome(), clientes.getCpf() });
        }
    }

    // ATUALIZAR OS MÉTODOS DEPOIS

    // Método para cadastrar um novo cliente no banco de dados
    public void cadastrar(String nome, String cpf) {
        new ClientesVipDAO().cadastrar(nome, cpf);
        // Chama o método de cadastro no banco de dados

        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
    }

    // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nome, String cpf) {
        new ClientesVipDAO().Atualizar(nome, cpf);
        // Chama o método de atualização no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a atualização
    }

    // Método para apagar um cliente do banco de dados
    public void apagar(String cpf) {
        new ClientesVipDAO().apagar(cpf);
        // Chama o método de exclusão no banco de dados
        atualizarTabela(); // Atualiza a tabela de exibição após a exclusão
    }

    public void limpar(String Nome, String cpf) {

        atualizarTabela();
    }

    public void desconto(String cpfDesconto) {

    }
}
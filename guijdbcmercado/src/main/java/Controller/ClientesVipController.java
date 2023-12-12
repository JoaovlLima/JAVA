package Controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.ClientesVipDAO;
import Exception.*;
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
        try {
            if (!(nome.isEmpty() || cpf.isEmpty())) {
                if (cpf.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")) {
                    clientesVip = new ClientesVipDAO().listarTodos();
                    boolean cpfJaCadastrado = false;

                    for (ClientesVip clientes : clientesVip) {
                        if (cpf.equals(clientes.getCpf())) {
                            cpfJaCadastrado = true;
                            break; // CPF já está cadastrado, então podemos parar de procurar
                        }
                    }

                    if (!cpfJaCadastrado) {
                        new ClientesVipDAO().cadastrar(nome, cpf);
                        // Chama o método de cadastro no banco de dados

                        atualizarTabela(); // Atualiza a tabela de exibição após o cadastro
                    } else {
                        throw new CpfValidationException("CPF já cadastrado. Por favor, digite um novo CPF.");
                    }
                } else {
                    throw new CpfValidationException(
                            "CPF inválido. Por favor, digite um número de CPF válido.\n\nExemplo: 123.456.789-99");
                }
            } else {
                throw new NullPointerException("Informações inválidas. Por favor, preencha as informações vazias.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        } catch (CpfValidationException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para atualizar os dados de um cliente no banco de dados
    public void atualizar(String nome, String cpf) {
        try {
            if (!(nome.isEmpty() || cpf.isEmpty())) {
                new ClientesVipDAO().Atualizar(nome, cpf);
                // Chama o método de atualização no banco de dados
                atualizarTabela(); // Atualiza a tabela de exibição após a atualização
            } else {
                throw new NullPointerException("Informações inválidas. Por favor preencha as informações vazias.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    // Método para apagar um cliente do banco de dados
    public void apagar(String cpf) {
        try {
            if (!(cpf.isEmpty())) {
                new ClientesVipDAO().apagar(cpf);
                // Chama o método de exclusão no banco de dados
                atualizarTabela(); // Atualiza a tabela de exibição após a exclusão^
            } else {
                throw new NullPointerException("Erro de Seleção, por favor selecione uma linha.");
            }
        } catch (NullPointerException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void limpar(String Nome, String cpf) {

        atualizarTabela();
    }

    public void desconto(String cpfDesconto) {

    }
}
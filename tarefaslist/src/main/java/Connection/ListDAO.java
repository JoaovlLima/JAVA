package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;
import Model.Tarefas;

public class ListDAO {
    // atributo
    private Connection connection;
    private List<Tarefas> tarefasList;

    // construtor
    public ListDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS Tarefas (tarefa VARCHAR (255), situacao BOOLEAN )";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (

        SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }
// Listar todos os valores cadastrados
public List<Tarefas> listarTodos() {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    tarefasList = new ArrayList<>();
    try {
        stmt = connection.prepareStatement("SELECT * FROM Tarefas");
        rs = stmt.executeQuery();
        while (rs.next()) {
            Tarefas tarefa = new Tarefas(
                    rs.getString("tarefa"),
                    rs.getBoolean("Situação"));
            tarefasList.add(tarefa); // Corrigido para adicionar à lista clientesVip
        }
    } catch (SQLException ex) {
        System.out.println(ex);
    } finally {
        ConnectionFactory.closeConnection(connection, stmt, rs);
    }
    return tarefasList;
}

// Cadastrar Carro no banco
public void cadastrar(String tarefas, boolean situacao) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para cadastrar na tabela
    String sql = "INSERT INTO Tarefas (tarefa, situacao) VALUES (?, ?)";
    try {
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, tarefas);
        stmt.setBoolean(2, situacao);
        stmt.executeUpdate();
        System.out.println("Dados inseridos com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
    } finally {
        ConnectionFactory.closeConnection(connection, stmt);
    }
}

// Atualizar dados no banco
public void Atualizar(String tarefas, Boolean situacao) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para atualizar dados pela tarefa
    String sql = "UPDATE Tarefas SET situacao = ? WHERE tarefa = ?";
    try {
        stmt = connection.prepareStatement(sql);
        stmt.setBoolean(1, situacao);
        stmt.setString(2, tarefas);
        stmt.executeUpdate();
        System.out.println("Dados atualizados com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
    } finally {
        ConnectionFactory.closeConnection(connection, stmt);
    }
}

// Apagar dados do banco
public void apagar(String tarefa) {
    PreparedStatement stmt = null;
    // Define a instrução SQL parametrizada para apagar dados pelo cpf
    String sql = "DELETE FROM Tarefas WHERE tarefa = ?";
    try {
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, tarefa);
        stmt.executeUpdate(); // Executa a instrução SQL
        System.out.println("Dado apagado com sucesso");
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
    } finally {
        ConnectionFactory.closeConnection(connection, stmt);
    }
}

}

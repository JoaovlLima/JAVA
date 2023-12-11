package Connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Connection.ConnectionFactory;
import Model.Produtos;

public class ProdutosDAO {
    // atributo
    private Connection connection;
    private List<Produtos> produtos;

    // construtor
    public ProdutosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // criar Tabela
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS produto_mercado (NOME VARCHAR(255),CODIGO VARCHAR(255) PRIMARY KEY,DESCRICAO VARCHAR(255),PRECO VARCHAR(255), QUANTIDADE VARCHAR(255))";
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
    public List<Produtos> listarTodos() {
        PreparedStatement stmt = null;
        // Declaração do objeto PreparedStatement para executar a consulta
        ResultSet rs = null;
        // Declaração do objeto ResultSet para armazenar os resultados da consulta
        produtos = new ArrayList<>();
        // Cria uma lista para armazenar os carros recuperados do banco de dados
        try {
            stmt = connection.prepareStatement("SELECT * FROM produto_mercado");
            // Prepara a consulta SQL para selecionar todos os registros da tabela
            rs = stmt.executeQuery();
            // Executa a consulta e armazena os resultados no ResultSet
            while (rs.next()) {
                // Para cada registro no ResultSet, cria um objeto Carros com os valores do
                // registro

                Produtos produto = new Produtos(
                        rs.getString("nome"),
                        rs.getString("codigo"),
                        rs.getString("descricao"),
                        rs.getString("preco"),
                        rs.getString("quantidade"));
                 
                    produtos.add(produto); // Adiciona o objeto Carros à lista de carros
            }
        } catch (SQLException ex) {
            System.out.println(ex); // Em caso de erro durante a consulta, imprime o erro
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);

            // Fecha a conexão, o PreparedStatement e o ResultSet
        }
        return produtos; // Retorna a lista de carros recuperados do banco de dados
    }

    // Cadastrar Carro no banco
    public void cadastrar(String nome, String codigo, String descricao, String preco, String quantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para cadastrar na tabela
        String sql = "INSERT INTO produto_mercado (nome, codigo, descricao, preco, quantidade) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, codigo);
            stmt.setString(3, descricao);
            stmt.setString(4, preco);
            stmt.setString(5, quantidade);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Atualizar dados no banco
    public void atualizar(String nome, String codigo, String descricao, String preco, String quantidade) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para atualizar dados pela placa
        String sql = "UPDATE produto_mercado SET nome = ?, descricao = ?, preco = ?, quantidade = ? WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setString(3, preco);
            stmt.setString(4, quantidade);
            stmt.setString(5, codigo);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Apagar dados do banco
    public void apagar(String codigo) {
        PreparedStatement stmt = null;
        // Define a instrução SQL parametrizada para apagar dados pelo codigo
        String sql = "DELETE FROM produto_mercado WHERE codigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, codigo);
            stmt.executeUpdate(); // Executa a instrução SQL
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }
        // Obtém a quantidade de um produto pelo código
        public int obterQuantidade(String codigo) {
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int quantidade = 0;
    
            try {
                
                String sql = "SELECT quantidade FROM produto_mercado WHERE codigo = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, codigo);
                rs = stmt.executeQuery();
    
                if (rs.next()) {
                    quantidade = rs.getInt("quantidade");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao obter a quantidade do produto.", e);
            } finally {
                // Não feche a conexão aqui, mantenha-a aberta para uso posterior
                closeStatementAndResultSet(stmt, rs);
            }
    
            return quantidade;
        }
        
        public void atualizarQuantidade(String codigo, String quantidade) {
            PreparedStatement stmt = null;
            String sql = "UPDATE produto_mercado SET quantidade = ? WHERE codigo = ?";
            try {
                stmt = connection.prepareStatement(sql);
                stmt.setString(1, quantidade);
                stmt.setString(2, codigo);
                stmt.executeUpdate();
                System.out.println("Quantidade atualizada com sucesso");
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao atualizar quantidade no banco de dados.", e);
            } finally {
                ConnectionFactory.closeConnection(connection, stmt);
            }
        }

        // Método para fechar PreparedStatement e ResultSet
        private void closeStatementAndResultSet(PreparedStatement stmt, ResultSet rs) {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                // Lida com qualquer erro ao fechar os recursos
                e.printStackTrace();
            }
        }
    
        // Método para fechar a conexão
        public void fecharConexao() {
            ConnectionFactory.closeConnection(connection);
        }
    }
    


// package Connection;

// import Model.Compras;

// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.sql.Statement;
// import java.util.ArrayList;
// import java.util.List;
// import Connection.ConnectionFactory;

// public class ComprasDAO {

//     private List<Compras> comprado;
//     private Object connection;

//     public ComprasDAO() {

//         this.connection = ConnectionFactory.getConnection();

//     }

//     public void criaTabela() {
//         String sql = "CREATE TABLE IF NOT EXISTS compras_mercado (QUANTIDADE_ITENS VARCHAR(255),TOTAL_PRECO VARCHAR(255),DATA TIMESTAMP)";
//         try (Statement stmt = ((Object) this.connection).createStatement()) {
//             stmt.execute(sql);
//             System.out.println("Tabela criada com sucesso.");

//         } catch (SQLException e) {
//             throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
//         } finally {
//             ConnectionFactory.closeConnection(this.connection);
//         }
//     }
// }

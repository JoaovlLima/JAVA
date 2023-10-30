import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        try {
            Statement s;
            String usuario = "postgres";
            String senha = "postgres";
            String url = "jdbc:postgresql://localhost:5432/postgres";

            Connection c = DriverManager.getConnection(url, usuario, senha);
            s= c.createStatement();
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog(null,"1-criar\n"+"2-deletar"));
            switch (acao1) {
                case 1:
                    s.executeQuery("INSERT INTO CONTATO VALUES('2', 'Jonas', 'joao.lima@gmail.com')");
                    break;
                case 2:
                s.executeQuery("DELETE FROM CONTATO WHERE id ('1')"); 
                             
                default:
                    break;
            }
            
            c.close();
        } catch (Exception e) {
            System.out.println("\n"+e);
        }
    }
}

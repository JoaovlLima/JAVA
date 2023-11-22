package View;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

import Connection.ClienteDAO;
import Model.Clientes;

import Connection.VendaDAO;
import Controller.CarrosControl;
import Controller.VendasControl;
import Model.Vendas;

public class VendasView extends JPanel{
    public JComboBox<String> carrosComboBox,clienteComboBox;
    List<Carros> carros;
    List<Clientes> clientes;
    List<Vendas> vendas;
    DefaultTableModel tableModel;
    JTable table;
    JPanel areaAcao;
    JButton comprar;

    public VendasView() {
        super();
        areaAcao = new JPanel();
        carrosComboBox = new JComboBox<>();
        //preencha o JComboBox com os carros
        carros = new CarrosDAO().listarTodos();
        carrosComboBox.addItem("Selecione o Carro");
        for(Carros carro : carros){
            carrosComboBox.addItem(carro.getMarca()
            +""+ carro.getModelo()+""+ carro.getPlaca());
        
        }
         clientes = new ClienteDAO().listarTodos();
         clienteComboBox = new JComboBox<>();
         clienteComboBox.addItem("Selecione o Cliente");
         for(Clientes cliente : clientes){
            clienteComboBox.addItem(cliente.getNome());
         }

         comprar = new JButton("Comprar");
        areaAcao.add(carrosComboBox);
        areaAcao.add(clienteComboBox);
        areaAcao.add(comprar);

        add(areaAcao);

        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Placa","Comprador" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        VendasControl operacoes = new VendasControl(vendas, tableModel, table);

        comprar.addActionListener(e -> {
           
                        operacoes.cadastrar(cliNomeField.getText(), cliEmailField.getText(), cpf);

                        cliNomeField.setText("");
                        cliEmailField.setText("");
                        cliCpfField.setText("");

                    }); 
    }

    public void atualizarVendas(){
         clientes = new ClienteDAO().listarTodos();
         clienteComboBox.removeAllItems();
         clienteComboBox.addItem("Selecione o Cliente");
         for(Clientes cliente : clientes){
            clienteComboBox.addItem(cliente.getNome());
         }
    }
    
}

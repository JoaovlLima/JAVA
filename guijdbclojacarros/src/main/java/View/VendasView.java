package View;

import java.util.List;
import java.time.LocalDate;
import java.sql.Timestamp;
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
    private String carroConc, clienteConc;
    Timestamp data;

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
                new String[] { "Marca", "Modelo", "Placa","Comprador","Data" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        new VendaDAO().criaTabela();
     

        VendasControl operacoes = new VendasControl(vendas, tableModel, table);
        CarrosControl operacoesCar = new CarrosControl(carros, tableModel, table);

        comprar.addActionListener(e -> {
           carroConc = (String) carrosComboBox.getSelectedItem();
           clienteConc = (String) clienteComboBox.getSelectedItem();
           String[] carroSeparacao = carroConc.split(" ");
           String marca = carroSeparacao[0];
           String modelo = carroSeparacao[1];
           String placa = carroSeparacao[2];
           
           LocalDate localDate = LocalDate.now();
           data = Timestamp.valueOf(localDate.atStartOfDay());
           boolean placaExiste = operacoes.verificarPlacaExistente(placa);

           if(!placaExiste){

           int validacao = JOptionPane.showConfirmDialog(null,"Dejesa realmente realizar a compra?","Confirme",JOptionPane.YES_NO_OPTION);
           if(validacao == JOptionPane.YES_NO_OPTION){
           

                        operacoes.cadastrarVen(marca, modelo, placa, clienteConc, data);

                        carrosComboBox.removeItem(carroConc);

                       

           }
}else{JOptionPane.showMessageDialog(null, "Carro Já Vendido","Aviso",JOptionPane.WARNING_MESSAGE);
}
                    }); 
    }

    public void atualizarVendasCli(){
         clientes = new ClienteDAO().listarTodos();
         clienteComboBox.removeAllItems();
         clienteComboBox.addItem("Selecione o Cliente");
         for(Clientes cliente : clientes){
            clienteComboBox.addItem(cliente.getNome());
         }
    }

    public void atualizarVendasCar(){
         carros = new CarrosDAO().listarTodos();
         carrosComboBox.removeAllItems();
         carrosComboBox.addItem("Selecione o Carro");
         for(Carros carro : carros){
            carrosComboBox.addItem(carro.getMarca()
            +" "+ carro.getModelo()+" "+ carro.getPlaca());
         }
    }
    
}

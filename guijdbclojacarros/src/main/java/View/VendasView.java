package View;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Model.Carros;

public class VendasView extends JPanel{
    JComboBox<String> carrosComboBox,clienteComboBox;
    List<Carros> carros;
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
         clienteComboBox = new JComboBox<>();
         clienteComboBox.addItem("Selecione o Cliente");
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
        
    }
    
}

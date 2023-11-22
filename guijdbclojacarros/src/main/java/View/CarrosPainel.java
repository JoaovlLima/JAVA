package View;

import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Connection.CarrosDAO;
import Controller.CarrosControl;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import Model.Carros;

public class CarrosPainel extends JPanel {
    // atributos
    private JButton cadastrar, apagar, editar, limpar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField,
            carValorField;
    private JComboBox carSituacaoCombo;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private boolean placaIgual = false;

    // Construtor(GUI-JPanel)
    public CarrosPainel() {
        super();
        // entrada de dados
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Carros"));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));
        inputPanel.add(new JLabel("Marca"));
        carMarcaField = new JTextField(20);
        inputPanel.add(carMarcaField);
        inputPanel.add(new JLabel("Modelo"));
        carModeloField = new JTextField(20);
        inputPanel.add(carModeloField);
        inputPanel.add(new JLabel("Ano"));
        carAnoField = new JTextField(20);
        inputPanel.add(carAnoField);
        inputPanel.add(new JLabel("Placa"));
        carPlacaField = new JTextField(20);
        inputPanel.add(carPlacaField);
        inputPanel.add(new JLabel("Valor"));
        carValorField = new JTextField(20);
        inputPanel.add(carValorField);
        inputPanel.add(new JLabel("Situação"));
       /*  carSituacaoCombo.addItem("Vendido");
        carSituacaoCombo.addItem("Não Vendido");
        inputPanel.add(carSituacaoCombo); */
        add(inputPanel);
        JPanel botoes = new JPanel();
        botoes.add(cadastrar = new JButton("Cadastrar"));
        botoes.add(editar = new JButton("Editar"));
        botoes.add(apagar = new JButton("Apagar"));
        botoes.add(limpar = new JButton("Limpar"));
        add(botoes);
        // tabela de carros
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][] {},
                new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor","Situação" });
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        //Tratamento de eventos

    
 new CarrosDAO().criaTabela();
    atualizarTabela();  





table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
        linhaSelecionada = table.rowAtPoint(evt.getPoint());
        if(linhaSelecionada != -1){
            carMarcaField.setText((String) table.getValueAt(linhaSelecionada,0)) ;
            carModeloField.setText((String) table.getValueAt(linhaSelecionada,1)) ;
            carAnoField.setText((String) table.getValueAt(linhaSelecionada,2)) ;
            carPlacaField.setText((String) table.getValueAt(linhaSelecionada,3)) ;
            carValorField.setText((String) table.getValueAt(linhaSelecionada,4)) ;
            carPlacaField.setEditable(false);
        }
    }
});

CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

cadastrar.addActionListener(e->{
    if(carMarcaField.getText().isEmpty() || carModeloField.getText().isEmpty() || carAnoField.getText().isEmpty() || carPlacaField.getText().isEmpty() || carValorField.getText().isEmpty()){
 JOptionPane.showMessageDialog(null, "Preencha Todos os Campos","Aviso",JOptionPane.WARNING_MESSAGE);
    }else{
    String placa = carPlacaField.getText().toUpperCase();
    if(placa.matches("[A-Z]{3}-\\d{4}")){

   
    int ano = Integer.parseInt(carAnoField.getText());
    if(ano >=1900 && ano <=2024){
        carros = new CarrosDAO().listarTodos();
        for (Carros carro : carros) {
            if(placa.equals(carro.getPlaca())){
                placaIgual = true;
                break;
            }else{
                placaIgual = false;
            }
        }
if(placaIgual == false){
    operacoes.cadastrar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(), placa, carValorField.getText());
    
    carMarcaField.setText("");
    carModeloField.setText("");
    carAnoField.setText("");
    carPlacaField.setText("");
    carValorField.setText("");
    }else{
         JOptionPane.showMessageDialog(null, "Placa ja cadastrada","Aviso",JOptionPane.WARNING_MESSAGE);
    }
    }else{
        JOptionPane.showMessageDialog(null, "Ano Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
    }
}else{
      JOptionPane.showMessageDialog(null, "Placa Incorreta\nSiga o Padrão a Seguir:\n ABC-1234","Aviso",JOptionPane.WARNING_MESSAGE);
}
    }
});
editar.addActionListener(e->{

    if(carMarcaField.getText().isEmpty() || carModeloField.getText().isEmpty() || carAnoField.getText().isEmpty() || carPlacaField.getText().isEmpty() || carValorField.getText().isEmpty()){
 JOptionPane.showMessageDialog(null, "Preencha Todos os Campos","Aviso",JOptionPane.WARNING_MESSAGE);
    }else{
    String placa = carPlacaField.getText().toUpperCase();
    if(placa.matches("[A-Z]{3}-\\d{4}")){

   
    int ano = Integer.parseInt(carAnoField.getText());
    if(ano >=1900 && ano <=2024){
        

    operacoes.atualizar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(), placa, carValorField.getText());
    
    carMarcaField.setText("");
    carModeloField.setText("");
    carAnoField.setText("");
    carPlacaField.setText("");
    carValorField.setText("");
   
    
    }else{
        JOptionPane.showMessageDialog(null, "Ano Invalido","Aviso",JOptionPane.WARNING_MESSAGE);
    }
}else{
      JOptionPane.showMessageDialog(null, "Placa Incorreta\nSiga o Padrão a Seguir:\n ABC-1234","Aviso",JOptionPane.WARNING_MESSAGE);
}
}   
});
apagar.addActionListener(e->{
   
    int validacao = JOptionPane.showConfirmDialog(null,"Dejesa realmente EXCLUIR?","Confirme",JOptionPane.YES_NO_OPTION);
    if(validacao == JOptionPane.YES_NO_OPTION){

    operacoes.apagar(carPlacaField.getText());
    
    carMarcaField.setText("");
    carModeloField.setText("");
    carAnoField.setText("");
    carPlacaField.setText("");
    carValorField.setText("");
    }else{

    }
    
});
limpar.addActionListener(e->{
    operacoes.limpar(carMarcaField.getText(), carModeloField.getText(), carAnoField.getText(), carPlacaField.getText(), carValorField.getText());
    
    carMarcaField.setText("");
    carModeloField.setText("");
    carAnoField.setText("");
    carPlacaField.setText("");
    carValorField.setText("");
    
});
  
    }

private void atualizarTabela(){
    tableModel.setRowCount(0);
    carros = new CarrosDAO().listarTodos();
    for (Carros carro : carros) {
        // Adiciona os dados de cada carro como uma nova linha na tabela Swing
tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),

    carro.getAno(), carro.getPlaca(), carro.getValor() });
    }
    }
}

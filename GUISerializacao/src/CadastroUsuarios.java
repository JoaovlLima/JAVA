import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CadastroUsuarios extends JFrame {
    private JTextField inputNome;
    private JTextField inputIdade;
    private DefaultTableModel tableModel;
    private JTable table;
    private List<Usuario> usuarios = new ArrayList<>();
    private int linhaSelecionada = -1;  
    private JTabbedPane janelas;
    private JPanel aba1;
    private JPanel aba2;
    private JComboBox<String> filterDescricao;
    private JComboBox<String> filterCliente;
    private JTextField nomeUsuario;
    private JTextField data;
    private JTextField hora;

    //construtor

    public CadastroUsuarios() {
        super();

        setTitle("Cadastro de Usuários");
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        janelas = new JTabbedPane();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Idade");

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        //montando a input de dados e botões
        inputNome = new JTextField(20);
        inputIdade = new JTextField(5);
        JButton cadastrarButton = new JButton("Cadastrar");
        JButton atualizarButton = new JButton("Atualizar");
        JButton apagarButton = new JButton("Apagar");
        JButton apagarTodosButton = new JButton("Apagar Todos");
        JButton salvarButton = new JButton("Salvar");
        // Estruturando o frame
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Nome:"));
        inputPanel.add(inputNome);
        inputPanel.add(new JLabel("Idade:"));
        inputPanel.add(inputIdade);
        inputPanel.add(cadastrarButton);
        inputPanel.add(atualizarButton);
        inputPanel.add(apagarButton);
        inputPanel.add(apagarTodosButton);
        inputPanel.add(salvarButton);
        //add ao layout
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        aba1 = new JPanel();
        aba1.add(inputPanel);
        aba1.add(scrollPane);

        
        

        File arquivo = new File("dados.txt");
if (arquivo.exists()) {
usuarios = Serializacao.deserializar("dados.txt");
atualizarTabela();
}
table.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt) {
linhaSelecionada = table.rowAtPoint(evt.getPoint());
if (linhaSelecionada != -1) {

    inputNome.setText((String) table.getValueAt(linhaSelecionada, 0));
inputIdade.setText(table.getValueAt(linhaSelecionada, 1).toString());
}
}
});
OperacoesUsuarios operacoes = new OperacoesUsuarios(usuarios, tableModel, table);
cadastrarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.cadastrarUsuario(inputNome.getText(), inputIdade.getText());
inputNome.setText("");
inputIdade.setText("");
}
});
atualizarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.atualizarUsuario(linhaSelecionada, inputNome.getText(),

inputIdade.getText());

}
});
apagarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.apagarUsuario(linhaSelecionada);
}
});
apagarTodosButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.apagarTodosUsuarios();
}
});
salvarButton.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.salvarUsuarios();
}
});
this.setDefaultCloseOperation(2);
this.setVisible(true);
this.setBounds(100, 100, 900, 300);

//////////////
tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Data");
        tableModel.addColumn("Hora");
        tableModel.addColumn("Descrição");

        table = new JTable(tableModel);
        JScrollPane scrollPane2 = new JScrollPane(table);

        //montando a input de dados e botões
        nomeUsuario = new JTextField(20);
        data = new JTextField(5);
        hora = new JTextField(5);
        filterDescricao = new JComboBox<>(new String[] { "Manutenção", "CheckUp", "Urgencia","Estético" });
        JButton cadastrarButton2 = new JButton("Cadastrar");
        JButton atualizarButton2 = new JButton("Atualizar");
        JButton apagarButton2 = new JButton("Apagar");
        JButton apagarTodosButton2 = new JButton("Apagar Todos");
        JButton salvarButton2 = new JButton("Salvar");
        // Estruturando o frame
        JPanel inputPanel2 = new JPanel();
        inputPanel2.add(new JLabel("Nome:"));
        inputPanel2.add(nomeUsuario);
        inputPanel2.add(new JLabel("Data:"));
        inputPanel2.add(data);
        inputPanel2.add(new JLabel("Hora:"));
        inputPanel2.add(hora);
        inputPanel2.add(new JLabel("Descrição:"));
        inputPanel2.add(filterDescricao);
        inputPanel2.add(cadastrarButton2);
        inputPanel2.add(atualizarButton2);
        inputPanel2.add(apagarButton2);
        inputPanel2.add(apagarTodosButton2);
        inputPanel2.add(salvarButton2);
        //add ao layout
        setLayout(new BorderLayout());
        add(inputPanel2, BorderLayout.NORTH);
        add(scrollPane2, BorderLayout.CENTER);
////////////////////////////////////////
aba2 = new JPanel();
aba2.add(inputPanel2);
aba2.add(scrollPane2);

       File arquivo2 = new File("dados.txt");
if (arquivo.exists()) {
usuarios = Serializacao.deserializar("dados.txt");
atualizarTabela();
}
table.addMouseListener(new MouseAdapter() {
@Override
public void mouseClicked(MouseEvent evt) {
linhaSelecionada = table.rowAtPoint(evt.getPoint());
if (linhaSelecionada != -1) {

nomeUsuario.setText((String) table.getValueAt(linhaSelecionada, 0));
data.setText(table.getValueAt(linhaSelecionada, 1).toString());
hora.setText((String) table.getValueAt(linhaSelecionada, 2));
/* filterDescricao.setText((String) table.getValueAt(linhaSelecionada, 3)); */
}
}
});
OperacoesUsuarios operacoes2 = new OperacoesUsuarios(usuarios, tableModel, table);
cadastrarButton2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes2.cadastrarUsuario(nomeUsuario.getText(), data.getText());
nomeUsuario.setText("");
data.setText("");
}
});
atualizarButton2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes.atualizarUsuario(linhaSelecionada, nomeUsuario.getText(),

data.getText());

}
});
apagarButton2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes2.apagarUsuario(linhaSelecionada);
}
});
apagarTodosButton2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes2.apagarTodosUsuarios();
}
});
salvarButton2.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
operacoes2.salvarUsuarios();
}
});

janelas.add("Cadastro",aba1);
janelas.add("Agendamento",aba2);
this.add(janelas);
}
private void atualizarTabela() {
tableModel.setRowCount(0);
for (Usuario usuario : usuarios) {
tableModel.addRow(new Object[] { usuario.getNome(), usuario.getIdade() });
    }
    
}
}

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class OperacoesAgenda {
    private List<Agendamento> agendamentos;
    private DefaultTableModel tableModel;
    private JTable table;

    public OperacoesAgenda(List<Agendamento> agendamentos, DefaultTableModel tableModel, JTable table) {
        this.agendamentos = agendamentos;
        this.tableModel = tableModel;
        this.table = table;
    }

    public void cadastrarAgendamento(String data, String hora, Usuario usuarios, String descricao) {
        Agendamento agendamento = new Agendamento(data, hora, usuarios, descricao);
        agendamentos.add(agendamento);
        atualizarTabela();
        
    }

    public void atualizarAgendamento(int linhaSelecionada, String data, String hora, Usuario usuarios, String descricao) {
        if (linhaSelecionada != -1) {
            Agendamento agendamento = new Agendamento(data, hora, usuarios, descricao);
            agendamentos.set(linhaSelecionada, agendamento);
            atualizarTabela();
        }
    }

    public void apagarAgendamento(int linhaSelecionada) {
        if (linhaSelecionada != -1) {
            agendamentos.remove(linhaSelecionada);
            atualizarTabela();
        }
    }

    // public void salvarUsuarios() {
    //     Serializacao.serializar("dados.txt", usuarios);
    // }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        for (Agendamento agendamento : agendamentos) {
            tableModel.addRow(new Object[] { agendamento.getData(), agendamento.getHora(), agendamento.getUsuario(), agendamento.getDescricao() });
        }
    }
}

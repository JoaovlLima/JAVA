package Model;

public class Tarefas {
    private String tarefas;
    private boolean situacao;
    
    public Tarefas(String tarefas, boolean situacao) {
        this.tarefas = tarefas;
        this.situacao = situacao;
    }

    public String getTarefas() {
        return tarefas;
    }

    public void setTarefas(String tarefas) {
        this.tarefas = tarefas;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    

}

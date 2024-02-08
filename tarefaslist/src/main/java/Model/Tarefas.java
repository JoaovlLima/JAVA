package Model;

public class Tarefas {
    private String tarefas;
    private boolean concluida;
    
    public Tarefas(String tarefas, boolean concluida) {
        this.tarefas = tarefas;
        this.concluida = concluida;
    }

    public String getTarefas() {
        return tarefas;
    }

    public void setTarefas(String tarefas) {
        this.tarefas = tarefas;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
    

}

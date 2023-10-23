import java.io.Serializable;

public class Agendamento implements Serializable {
    private String nome;
    private String data;
    private String hora;
    private String descricao;
    
    public Agendamento(String nome, String data, String hora, String descricao) {
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}

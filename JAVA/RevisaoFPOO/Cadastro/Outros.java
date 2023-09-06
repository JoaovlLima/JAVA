package RevisaoFPOO.Cadastro;

public class Outros extends Animais{
    String especie;
    String observacao;
    public Outros(String porte, double peso, String proprietario, String genero, String especie, String especie2,
            String observacao) {
        super(porte, peso, proprietario, genero, especie);
        especie = especie2;
        this.observacao = observacao;
    }
    public Outros(String especie, String observacao) {
        this.especie = especie;
        this.observacao = observacao;
    }
public Outros(){
    
}
public String getEspecie() {
    return especie;
}
public void setEspecie(String especie) {
    this.especie = especie;
}
public String getObservacao() {
    return observacao;
}
public void setObservacao(String observacao) {
    this.observacao = observacao;
}

}
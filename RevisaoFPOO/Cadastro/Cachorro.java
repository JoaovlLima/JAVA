package RevisaoFPOO.Cadastro;

public class Cachorro extends Animais{
    String raca;

    public Cachorro(String porte, double peso, String proprietario, String genero, String especie, String raca, int cpf) {
        super(porte, peso, proprietario, genero, especie, cpf);
        this.raca = raca;
    }

    public Cachorro(String raca) {
        this.raca = raca;
    }
public Cachorro(){

}

public String getRaca() {
    return raca;
}

public void setRaca(String raca) {
    this.raca = raca;
}

}

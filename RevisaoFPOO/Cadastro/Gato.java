package RevisaoFPOO.Cadastro;

public class Gato extends Animais  {
   String raca;

public Gato(String porte, double peso, String proprietario, String genero, String especie, String raca, int cpf) {
    super(porte, peso, proprietario, genero, especie, cpf);
    this.raca = raca;
}

public Gato(String raca) {
    this.raca = raca;
}
public Gato(){

}

public String getRaca() {
    return raca;
}

public void setRaca(String raca) {
    this.raca = raca;
}
   
}

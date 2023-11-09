package Model;

public class Carros {

    //Atributos
private String marca;
private String modelo;
private String ano;
private String placa;
private String valor;

//construtor
public Carros() {
    super();
}
public Carros(String marca, String modelo, String ano, String placa, String valor) {
    this.marca = marca;
    this.modelo = modelo;
    this.ano = ano;
    this.placa = placa;
    this.valor = valor;
}

//Gets and Sets
public String getMarca() {
    return marca;
}

public void setMarca(String marca) {
    this.marca = marca;
}

public String getModelo() {
    return modelo;
}

public void setModelo(String modelo) {
    this.modelo = modelo;
}

public String getAno() {
    return ano;
}

public void setAno(String ano) {
    this.ano = ano;
}

public String getPlaca() {
    return placa;
}

public void setPlaca(String placa) {
    this.placa = placa;
}

public String getValor() {
    return valor;
}

public void setValor(String valor) {
    this.valor = valor;
}



}

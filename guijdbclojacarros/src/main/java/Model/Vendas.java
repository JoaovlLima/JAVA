package Model;

public class Vendas {
    private String marca;
    private String modelo;
    private String placa;
    private String comprador;

    
    public Vendas(String marca, String modelo, String placa, String comprador) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.comprador = comprador;
    }


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


    public String getPlaca() {
        return placa;
    }


    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public String getComprador() {
        return comprador;
    }


    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

}

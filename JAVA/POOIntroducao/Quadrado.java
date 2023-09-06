package POOIntroducao;

public class Quadrado implements FigurasGeometricas {
    int lado;

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        this.lado = lado;
    }

    @Override
    public double getArea() {
        int area = lado*lado;
        return area;
    }

    @Override
    public String getNomeFigura() {
        
        return "Quadrado";
    }

    @Override
    public double getPerimetro() {
        int perimetro = lado*4;
        return perimetro;
    }

    public Quadrado(int lado) {
        this.lado = lado;
        
    }

    
    
}

package POOIntroducao;

public class Trapezio implements FigurasGeometricas {
    int baseMaior;
    int baseMenor;
    int altura;
    int lad1;
    int lad2;

    
    public Trapezio(int baseMaior, int baseMenor, int altura, int lad1, int lad2) {
        this.baseMaior = baseMaior;
        this.baseMenor = baseMenor;
        this.altura = altura;
        this.lad1 = lad1;
        this.lad2 = lad2;
    }
    @Override
    public double getArea() {
        
        return ((baseMaior+baseMenor)*altura)/2;
    }
    @Override
    public String getNomeFigura() {
        
        return "Trapézio";
    }
    @Override
    public double getPerimetro() {
        
        return baseMaior+baseMenor+lad1+lad2;
    }
    
}

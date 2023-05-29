package POOIntroducao;

public class Retangulo implements FigurasGeometricas {
    //atributos
    int base;

    int altura; 

    //métodos
    //construtor
    public Retangulo(int base, int altura) {
        this.base = base;
        this.altura = altura;
    }



    @Override
    public double getArea() {
        
        return base*altura;
    }

    
    @Override
    public String getNomeFigura() {
        
        return "Retangulo";
    }

    @Override
    public double getPerimetro() {
      
        return (base+altura)*2;
    }
    
}

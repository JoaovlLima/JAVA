package PreçoViagem.CalculadoraCustoViagem;

public class CustoViagem {
    public static void main(String[] args) {
        double PreçoGasolina = 5.99;
        int KmL = 9;
        int Distância = 230;
        double LitrosGastos=Distância/KmL;
        double ValorGasto=LitrosGastos*PreçoGasolina;
        System.out.println("O custo Médio é "+ValorGasto+" Reais");



    }
}

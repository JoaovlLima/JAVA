import java.awt.*;
import java.util.zip.GZIPInputStream;

import javax.swing.*;


public class CalcCombustivel extends JFrame{
    public CalcCombustivel() {
        super();
        this.setSize(500, 500);

/* CRIANDO PAINEIS PRINCIPAIS */
        JPanel painelRei = new JPanel(new BorderLayout());
        painelRei.setSize(500, 500);
        this.add(painelRei);
        JPanel titulo  = new JPanel();
        JPanel calc = new JPanel();
        JPanel areaBotoes = new JPanel(new BorderLayout());

        painelRei.add(titulo, BorderLayout.NORTH);
        painelRei.add(calc, BorderLayout.CENTER);
        painelRei.add(areaBotoes, BorderLayout.SOUTH);
        
        JPanel calcDistancia = new JPanel();
        calcDistancia.setLayout(new GridLayout(2, 1));
        JPanel calcConsumo = new JPanel();
        calcConsumo.setLayout(new GridLayout(2, 1));
        JPanel calcPreco = new JPanel();
        calcPreco.setLayout(new GridLayout(2, 1));

        JPanel resultado = new JPanel();
        
        JPanel botoes = new JPanel();
        
        areaBotoes.add(resultado, BorderLayout.WEST);
        areaBotoes.add(botoes, BorderLayout.EAST);

        calc.add(calcDistancia);
        calc.add(calcConsumo);
        calc.add(calcPreco);

       
       

/* Criando componentes */
       /* Area titulo */
       JLabel titulo1 = new JLabel("Calculo de Combustivel");
      
       /* Area Calculo */    
       int tamanhoInput = 20;
       Font fontInput = new Font( "Serif", Font.PLAIN, 20);
       Font fontLabel = new Font( "Serif", Font.PLAIN, 15);
       
       JLabel titDistancia = new JLabel("Distância Percorrida");
       JLabel titConsumo = new JLabel("Consumo Médio");
       JLabel titPreco = new JLabel("Preço Litro");

        JPanel espInputDist = new JPanel(new GridBagLayout());
        JPanel espInputCons = new JPanel(new GridBagLayout());
        JPanel espInputPrec = new JPanel(new GridBagLayout());
         
       JTextField distancia = new JTextField("0", tamanhoInput);
       JTextField consumo = new JTextField("0",tamanhoInput);
       JTextField preco = new JTextField("0,00", tamanhoInput);

       JPanel divKm = new JPanel();
       divKm.setBackground(Color.gray);
       JPanel divKmL = new JPanel();
       divKmL.setBackground(Color.gray);
       JPanel divPorL = new JPanel();
       divPorL.setBackground(Color.gray);

       JLabel km = new JLabel("km  ");
       JLabel kmL = new JLabel("km/L");
       JLabel porL = new JLabel("Por L");
       
       divKm.add(km);
       divKmL.add(kmL);
       divPorL.add(porL);

       distancia.setFont(fontInput);
       consumo.setFont(fontInput);
       preco.setFont(fontInput);
       km.setFont(fontLabel);
       kmL.setFont(fontLabel);
       porL.setFont(fontLabel);
       
       /* Area Botão */

       JLabel LabelResult = new JLabel("Resultado");
       JTextField inputResult = new JTextField(tamanhoInput);
       inputResult.setFont(fontInput);

       JButton calcular = new JButton("Calcular");
       JButton limpar = new JButton("Limpar");


/* ADD COMPONENTES */      
       titulo.add(titulo1);

       calcDistancia.add(titDistancia);
       calcDistancia.add(espInputDist);
       espInputDist.add(distancia);
       espInputDist.add(divKm);

       calcConsumo.add(titConsumo);
       calcConsumo.add(espInputCons);
       espInputCons.add(consumo);
       espInputCons.add(divKmL);

       calcPreco.add(titPreco);
       calcPreco.add(espInputPrec);
       espInputPrec.add(preco);
       espInputPrec.add(divPorL);
       
       resultado.add(LabelResult);
       resultado.add(inputResult);
       botoes.add(calcular);
       botoes.add(limpar);
       
this.setDefaultCloseOperation(2);
this.pack();
this.setVisible(true);

    }
}

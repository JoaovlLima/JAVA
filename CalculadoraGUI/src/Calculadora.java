import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {

    public Calculadora() {
        super();

        this.setBounds(500, 500, 500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        // criando Layers para posicionamento
        JPanel painelRei = new JPanel();
        painelRei.setLayout(new GridLayout(4, 1));

        JPanel painelLay1 = new JPanel();
        
        JPanel painelLay2 = new JPanel();
        JPanel painelLay3 = new JPanel();
        JPanel painelLay4 = new JPanel();

        this.add(painelRei);

        // Criando Botões
        JButton botaoDividir = new JButton("/");
        JButton botaoNum7 = new JButton("7");
        JButton botaoNum8 = new JButton("8");
        JButton botaoNum9 = new JButton("9");
        JButton botaoMultiplicar = new JButton("X");
        JButton botaoNum4 = new JButton("4");
        JButton botaoNum5 = new JButton("5");
        JButton botaoNum6 = new JButton("6");
        JButton botaoSubtrair = new JButton("-");
        JButton botaoNum1 = new JButton("1");
        JButton botaoNum2 = new JButton("2");
        JButton botaoNum3 = new JButton("3");
        JButton botaoSomar = new JButton("+");
        JButton botaoIgual = new JButton("=");

        // add botões
        painelLay1.add(botaoDividir);
        painelLay1.add(botaoNum7);
        painelLay1.add(botaoNum8);
        painelLay1.add(botaoNum9);
        painelLay2.add(botaoMultiplicar);
        painelLay2.add(botaoNum4);
        painelLay2.add(botaoNum5);
        painelLay2.add(botaoNum6);
        painelLay3.add(botaoSubtrair);
        painelLay3.add(botaoNum1);
        painelLay3.add(botaoNum2);
        painelLay3.add(botaoNum3);
        painelLay4.add(botaoSomar);
        painelLay4.add(botaoIgual);

        // add Layers
        painelRei.add(painelLay1);
        painelRei.add(painelLay2);
        painelRei.add(painelLay3);
        painelRei.add(painelLay4);

        this.setVisible(true);

    }
}

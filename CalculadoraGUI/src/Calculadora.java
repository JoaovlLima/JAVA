import java.awt.*;
import javax.swing.*;

public class Calculadora extends JFrame {
  private  int num = 0;
  private int memoria = 0;
  private char operador;

    public Calculadora() {
        super();

        this.setBounds(500, 500, 500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
       
        // criando Layers para posicionamento
        JPanel painelRei = new JPanel();
        painelRei.setLayout(new GridLayout(4, 1));
        painelRei.setLayout(null);

        JPanel painelText = new JPanel();
        painelText.setLayout(new GridLayout(1, 1));
        painelText.setBorder(BorderFactory.createLineBorder(Color.gray,5));
        painelText.setBounds(100, 0, 250, 100);
        
        JPanel painelLay1 = new JPanel();
        painelLay1.setBackground(Color.gray);
        painelLay1.setBounds(100, 100, 250, 40);

        JPanel painelLay2 = new JPanel();
        painelLay2.setBackground(Color.gray);
        painelLay2.setBounds(100, 140, 250, 40);

        JPanel painelLay3 = new JPanel();
        painelLay3.setBackground(Color.gray);
        painelLay3.setBounds(100, 180, 250, 40);

        JPanel painelLay4 = new JPanel();
        painelLay4.setBackground(Color.gray);
        painelLay4.setBounds(100, 220, 250, 40);

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
        JButton botaoNum0 = new JButton("0");
        JButton botaoSomar = new JButton("+");
        JButton botaoVirgula = new JButton(",");
        JButton botaoIgual = new JButton("=");

        /* JLabel resultado = new JLabel("345",JLabel.CENTER); */
        Font fonteResultado = new Font( "Serif", Font.PLAIN, 30);
      /*   resultado.setFont(fonteResultado); */
        JTextField result = new JTextField();
        result.setSize(200, 100);
        result.setFont(fonteResultado);
        // add botões
        painelText.add(result);
      /*   painelText.add(resultado); */
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
        painelLay4.add(botaoNum0);
        painelLay4.add(botaoVirgula);
        painelLay4.add(botaoIgual);
        


        // add Layers
        painelRei.add(painelText);
        painelRei.add(painelLay1);
        painelRei.add(painelLay2);
        painelRei.add(painelLay3);
        painelRei.add(painelLay4);

        this.setVisible(true);

         /* DEIXANDO FUNCIONAL */

    

    botaoNum1.addActionListener(e ->{
    num = num*10+1;
    result.setText(result.getText() + "1");

    });

    botaoNum2.addActionListener(e ->{
    num = num*10+2;
    result.setText(result.getText() + "2");

    });

    botaoNum3.addActionListener(e ->{
    num = num*10+3;
    result.setText(result.getText() + "3");

    });

    botaoNum4.addActionListener(e ->{
    num = num*10+4;
    result.setText(result.getText() + "4");

    });

    botaoNum5.addActionListener(e ->{
    num = num*10+5;
    result.setText(result.getText() + "5");

    });

    botaoNum6.addActionListener(e ->{
    num = num*10+6;
    result.setText(result.getText() + "6");

    });

    botaoNum7.addActionListener(e ->{
    num = num*10+7;
    result.setText(result.getText() + "7");

    });

    botaoNum8.addActionListener(e ->{
    num = num*10+8;
    result.setText(result.getText() + "8");

    });

    botaoNum9.addActionListener(e ->{
    num = num*10+9;
    result.setText(result.getText() + "9");

    });

    botaoNum0.addActionListener(e ->{
    num = num*10;
    result.setText(result.getText() + "0");

    });

   botaoSomar.addActionListener(e ->{
operador = '+';
memoria += num;
num=0;
result.setText("");

   });

    botaoSubtrair.addActionListener(e ->{
operador = '-';
memoria += num;
num=0;
result.setText("");

   });

   botaoMultiplicar.addActionListener(e ->{
operador = '*';
memoria += num;
num=0;
result.setText("");

   }); 

    botaoDividir.addActionListener(e ->{
operador = '/';
memoria += num;
num=0;
result.setText("");

   });

 botaoIgual.addActionListener(e ->{
 if(num != 0){ 
    switch (operador) {
        case '+':
            memoria+=num;
            result.setText(""+memoria);
            break;
        case '-':
            memoria-=num;
            result.setText(""+memoria);
            break;
        case '*':
            memoria*=num;
            result.setText(""+memoria);
            break;
        case '/':
            memoria/=num;
            result.setText(""+memoria);
            break;
    
        default:
            break;
    }
    } else{result.setText("Error");}
 });

    }
   
}

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class ExemploFlowLayout{
      int cont;
    public ExemploFlowLayout() {
        JFrame janela1 = new JFrame("Janela 1 "); 
        ///modificar o Layout
        janela1.setBounds(500, 500, 400, 400);
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        //criando componentes
        JLabel text1 = new JLabel("Informe o Nº de Botões");
        JTextField painel1 = new JTextField("Inserir Nº",25);
        JButton botao1 = new JButton("Enviar");
        //adicionar os componentes 
        janela1.add(text1);
        janela1.add(painel1);
        janela1.add(botao1);

        //set frame

        janela1.setDefaultCloseOperation(2);
        janela1.pack();
        janela1.setVisible(true);

       
        botao1.addActionListener(e ->{ 
          
             int numDigitado = Integer.parseInt(painel1.getText());
        for (int i = 0; i < numDigitado; i++) {
            cont++;
            JButton botoes = new JButton("botão "+cont);
            janela1.add(botoes);
            janela1.pack();
        }
        });
        
    }
}

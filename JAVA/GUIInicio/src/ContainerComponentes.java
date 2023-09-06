import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class ContainerComponentes extends JFrame{
       int cont=0;
public ContainerComponentes() {
    super();
  
        this.setBounds(500, 500, 500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //criar um outro container
        JPanel painel1 = new JPanel();
        this.add(painel1);
        JButton botao1 = new JButton("ADD botão");
        JLabel text1 = new JLabel("N° Click"); 
        painel1.add(botao1);
        painel1.add(text1);
 
  botao1.addActionListener(e ->{
cont++;
JButton botoes = new JButton("botão" + cont);
painel1.add(botoes);
text1.setText("Nº Click = "+cont);
  });
        
        this.setVisible(true);
        
}
}

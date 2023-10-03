import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercicioConcactenar extends JFrame {
private JButton concatenar;
    public ExercicioConcactenar() {
        super();

        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        this.add(mainPanel);

        JPanel area1 = new JPanel();
        JLabel nome = new JLabel("Nome: ");
        JTextField areaNome = new JTextField(22);
        area1.add(nome);
        area1.add(areaNome);

        JPanel area2 = new JPanel();
        JLabel sobrenome = new JLabel("Sobrenome: ");
        JTextField areaSobrenome = new JTextField(22);
        area2.add(sobrenome);
        area2.add(areaSobrenome);

        JPanel area3 = new JPanel();
        JLabel nomeCompleto = new JLabel("Nome Completo");
        concatenar = new JButton("Concactenar");
        area3.add(nomeCompleto);
        area3.add(concatenar);


        mainPanel.add(area1);
        mainPanel.add(area2);
        mainPanel.add(area3);
        
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

       //Add evento

       /* concatenar.addActionListener(e->{
        nomeCompleto.setText(areaNome.getText()+" "+areaSobrenome.getText());
       }); */

         concatenar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                nomeCompleto.setText(areaNome.getText()+" "+areaSobrenome.getText());
            }
         }); 
    }
}

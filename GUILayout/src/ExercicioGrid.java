import java.awt.GridLayout;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ExercicioGrid extends JFrame{
    public ExercicioGrid() {
        super();
GridLayout gridNum = new GridLayout(4,4);
JPanel calc = new JPanel();
calc.setLayout(gridNum);
this.add(calc);

//criar vetor

String valores[] = {"7","8","9","x","4","5","6","-","3","2","1","+","/","0",".","="};

for (int i = 0; i < 16; i++) {
    calc.add(new Button(valores[i]));
}
this.setDefaultCloseOperation(2);
this.pack();
this.setVisible(true);
    }
    
}

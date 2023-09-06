import javax.swing.JFrame;

public class GUISwingJFrameExemplo extends JFrame{
    //construtor
    public GUISwingJFrameExemplo() {
        super("Minha Primeira Janela GUI Swing");
         this.setSize(400, 600);
         this.setDefaultCloseOperation(EXIT_ON_CLOSE);
         this.setVisible(true);
    }
    
}

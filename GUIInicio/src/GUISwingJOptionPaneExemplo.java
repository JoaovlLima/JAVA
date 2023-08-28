import javax.swing.JOptionPane;

public class GUISwingJOptionPaneExemplo  extends JOptionPane{
   String informacao = "Minha Primeira Dialog";

   public GUISwingJOptionPaneExemplo() {
    super();

    this.showMessageDialog(getComponentPopupMenu(), informacao,informacao,ERROR_MESSAGE, icon);
   } 
}

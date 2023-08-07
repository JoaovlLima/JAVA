package CalcTryCath;

import javax.swing.JOptionPane;

public class ExemploThrow {
    public static void main(String[] args) {
        boolean tenteNovamente = true;
        String senha;
        String login;
        String dataNascimento;
        while (tenteNovamente) {
         try{
            login = JOptionPane.showInputDialog("Informe seu Usuário");
            senha = JOptionPane.showInputDialog("Informe uma senha: ");
            dataNascimento = JOptionPane.showInputDialog("Informe Sua data de Nascimento \n Modelo:[dd/mm/aaaa]");
            if(senha.length()<8){
                throw new Exception("Senha muito curta, minímo 8 caracteres");

            }if(login.equals(senha)){
                throw new Exception("Usuário igual a senha");

            }if(senha.equals(dataNascimento)){
                throw new Exception("Data de nascimento Igual a senha");
            }
            tenteNovamente = false;
            JOptionPane.showMessageDialog(null, "Senha Cadastrada com Sucesso", "senha", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Senha", 0);
            
        }
    }
    
}
}

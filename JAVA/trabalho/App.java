package trabalho;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int cont = 0;
        ContaPF contasPf[] = new ContaPF[5];
        ContaPJ contasPj[] = new ContaPJ[5];
        boolean agenciaAberta = true;
        while(agenciaAberta){
        int acaoMenu;
        JOptionPane.showMessageDialog(null, "1-Entrar Conta\n 2-Criar Conta \n 3-Sair");
        acaoMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe Aqui"));
        switch (acaoMenu) {
            case 1: int acaoAcesso = Integer.parseInt(JOptionPane.showInputDialog(null, "infome a Ação"+
            "\n 1-Pessoa Juridica"
            +"\n 2-Pessoa Fisica"));
            if(acaoAcesso == 1){
                int pesqConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe seu Numero da Conta"));
                for (int i = 0; i < contasPj.length; i++) {
                    if(pesqConta == Integer.parseInt(contasPj[i].getNum())){
                    

                        JOptionPane.showMessageDialog(null,"Seu nome: "+contasPj[i].getNome()+"\n Saldo: "+contasPj[i].getSaldo()+"\n Numero da conta: "+contasPj[i].getNum());

                    }
                }
                }else{int pesqConta = Integer.parseInt(JOptionPane.showInputDialog(null,"Informe seu Numero da Conta"));
                for (int i = 0; i < contasPf.length; i++) {
                    if(pesqConta == Integer.parseInt(contasPf[i].getNum())){
                        JOptionPane.showMessageDialog(null,"Seu nome: "+contasPf[i].getNome()+"\n Saldo: "+contasPf[i].getSaldo()+"\n Numero da conta: "+contasPf[i].getNum());
            }
        }
                break;
            }
            case 2: int acaoConta;
            acaoConta = Integer.parseInt(JOptionPane.showInputDialog(null, "infome a Ação"+
                         "\n 1-Pessoa Juridica"
                         +"\n 2-Pessoa Fisica"));
                         if(acaoConta == 1){
                            contasPj[cont] = new ContaPJ();
                            contasPj[cont].setNome(JOptionPane.showInputDialog(null,"Informe Seu Nome"));
                            contasPj[cont].setCnpj(JOptionPane.showInputDialog(null,"Informe seu CNPJ"));
                            contasPj[cont].setTel(JOptionPane.showInputDialog(null,"Informe seu Telefone"));
                            int ncont = 2000+cont+1;
                            contasPj[cont].setNum(Integer.toString(ncont));
                            contasPj[cont].setSaldo("0");
                            JOptionPane.showMessageDialog(null,"       Parabens !!!!!!! \n Conta criada com Sucesso");
                            JOptionPane.showMessageDialog(null,"Seu nome: "+contasPj[cont].getNome()+"\n Saldo: "+contasPj[cont].getSaldo()+"\n Numero da conta: "+contasPj[cont].getNum());
                            
                            cont++;

                         }else{contasPf[cont] = new ContaPF();
                            contasPf[cont].setNome(JOptionPane.showInputDialog(null,"Informe Seu Nome"));
                            contasPf[cont].setCpf(JOptionPane.showInputDialog(null,"Informe seu CPF"));
                            contasPf[cont].setTel(JOptionPane.showInputDialog(null,"Informe seu Telefone"));
                            int ncont = 1000+cont+1;
                            contasPf[cont].setNum(Integer.toString(ncont));
                            contasPf[cont].setSaldo("0");
                            JOptionPane.showMessageDialog(null,"       Parabens !!!!!!! \n Conta criada com Sucesso");
                            JOptionPane.showMessageDialog(null,"Seu nome: "+contasPf[cont].getNome()+"\n Saldo: "+contasPf[cont].getSaldo()+"\n Numero da conta: "+contasPf[cont].getNum());
                            
                            cont++;
                        }
            break;
            case 3: agenciaAberta = false;
            break;
            default:
            
                break;
        }
    } 
 
    }
}
    


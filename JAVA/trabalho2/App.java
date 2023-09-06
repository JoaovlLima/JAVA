package trabalho;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        int contPf = 0;
        int contPj = 0;
        ContaPF contasPf[] = new ContaPF[5];
        ContaPJ contasPj[] = new ContaPJ[5];
        boolean agenciaAberta = true;
        int deposito;
        int saque;
        int emprestimo;
        int contAtual = 0;
        while (agenciaAberta) {
            int acaoMenu;
            JOptionPane.showMessageDialog(null, "1-Entrar Conta\n 2-Criar Conta \n 3-Sair");
            acaoMenu = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe Aqui"));
            switch (acaoMenu) {
                case 1:
                    int acaoAcesso = Integer.parseInt(JOptionPane.showInputDialog(null, "infome a Ação" +
                            "\n 1-Pessoa Juridica"
                            + "\n 2-Pessoa Fisica"));
                    if (acaoAcesso == 1) {
                        int pesqConta = Integer .parseInt(JOptionPane.showInputDialog(null, "Informe seu Numero da Conta"));
                        for (int i = 0; i < contasPj.length; i++) {
                            if (pesqConta == Integer.parseInt(contasPj[i].getNum())) {

                                JOptionPane.showMessageDialog(null,
                                        "Seu nome: " + contasPj[i].getNome() + "\n Saldo: "
                                                + contasPj[i].getSaldo() + "\n Numero da conta: "
                                                + contasPj[i].getNum());
                                contAtual = i;

                                boolean acessoConta = true;
                                while (acessoConta) {

                                    int menuEntrar = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "1 - Depositar \n 2 - Sacar \n 3 - Emprestimo \n 4 - Sair "));
                                    switch (menuEntrar) {
                                        case 1:
                                            deposito = Integer
                                                    .parseInt(JOptionPane.showInputDialog(null,
                                                            "Insira o valor do Deposito"));

                                            int x = Integer.parseInt(contasPj[contAtual].getSaldo()) + deposito;
                                            contasPj[contAtual].setSaldo(Integer.toString(x));
                                            JOptionPane.showMessageDialog(null,
                                                    "Seu Saldo Atual = " + contasPj[contAtual].getSaldo());

                                            break;
                                        case 2:
                                            saque = Integer.parseInt(
                                                    JOptionPane.showInputDialog(null, "Insira o valor do Saque"));
                                            if (saque <= Integer.parseInt(contasPj[contAtual].getSaldo())) {
                                                contasPj[contAtual].setSaldo(Integer.toString(
                                                        Integer.parseInt(contasPj[contAtual].getSaldo()) - saque));

                                                JOptionPane.showMessageDialog(null, "Saque realizado com Sucesso");
                                                JOptionPane.showMessageDialog(null,
                                                        "Seu Saldo Atual = " + contasPj[contAtual].getSaldo());

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
                                            }

                                            break;
                                        case 3:
                                            emprestimo = Integer.parseInt(
                                                    JOptionPane.showInputDialog(null, "Insira o valor do emprestimo"));
                                            if (Integer.parseInt(contasPj[contAtual].getSaldo()) <= 1000) {
                                                if (emprestimo <= 2000) {
                                                    contasPj[contAtual].setSaldo(Integer
                                                            .toString(Integer.parseInt(contasPj[contAtual].getSaldo())
                                                                    + emprestimo));
                                                    JOptionPane.showMessageDialog(null,
                                                            "PARABENS!!! Seu Empréstimo foi aceito");

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Empréstimo recusado");

                                                }
                                            } else if (Integer.parseInt(contasPj[contAtual].getSaldo()) <= 5000) {
                                                if (emprestimo <= 10000) {
                                                    contasPj[contAtual].setSaldo(Integer
                                                            .toString(Integer.parseInt(contasPj[contAtual].getSaldo())
                                                                    + emprestimo));
                                                    JOptionPane.showMessageDialog(null,
                                                            "PARABENS!!! Seu Empréstimo foi aceito");

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Empréstimo recusado");
                                                }
                                            } else {
                                                contasPj[contAtual].setSaldo(Integer.toString(
                                                        Integer.parseInt(contasPj[contAtual].getSaldo()) + emprestimo));
                                                JOptionPane.showMessageDialog(null,
                                                        "PARABENS!!! Seu Empréstimo foi aceito");

                                            }

                                            break;
                                        case 4:

                                            acessoConta = false;

                                            break;
                                        default:acessoConta = true;
                                            break;
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Numero não existente");
                            }
                        }
                    } else if (acaoAcesso == 2){ // ACESSO CONTA PF
                        int pesqConta = Integer
                                .parseInt(JOptionPane.showInputDialog(null, "Informe seu Numero da Conta: "));
                        // int pesqSenha = Integer
                        // .parseInt(JOptionPane.showInputDialog(null, "Informe sua Senha: "));
                        for (int i = 0; i < contasPf.length; i++) {
                            if (pesqConta == Integer.parseInt(contasPf[i].getNum())) { // & pesqSenha ==
                                                                                       // Integer.parseInt(contasPf[i].getSenha()))
                                                                                       // {
                                // JOptionPane.showMessageDialog(null, "Seu nome: " + contasPf[i].getNome() +
                                // "\n Saldo: "
                                // + contasPf[i].getSaldo() + "\n Numero da conta: " + contasPf[i].getNum());
                                contAtual = i;
                                boolean acessoConta = true;
                                while (acessoConta) {
                                    JOptionPane.showMessageDialog(null,
                                            "Seu nome: " + contasPf[contAtual].getNome() + "\n Saldo: "
                                                    + contasPf[contAtual].getSaldo() + "\n Numero da conta: "
                                                    + contasPf[contAtual].getNum());
                                    int menuEntrar = Integer.parseInt(JOptionPane.showInputDialog(null,
                                            "1 - Depositar \n 2 - Sacar \n 3 - Emprestimo \n 4 - Sair "));
                                    switch (menuEntrar) {
                                        case 1:
                                            deposito = Integer
                                                    .parseInt(JOptionPane.showInputDialog(null,
                                                            "Insira o valor do Deposito"));

                                            int x = Integer.parseInt(contasPf[contAtual].getSaldo()) + deposito;
                                            contasPf[contAtual].setSaldo(Integer.toString(x));
                                            JOptionPane.showMessageDialog(null,
                                                    "Seu Saldo Atual = " + contasPf[contAtual].getSaldo());

                                            break;
                                        case 2:
                                            saque = Integer.parseInt(
                                                    JOptionPane.showInputDialog(null, "Insira o valor do Saque"));
                                            if (saque <= Integer.parseInt(contasPf[contAtual].getSaldo())) {
                                                contasPf[contAtual].setSaldo(Integer.toString(
                                                        Integer.parseInt(contasPf[contAtual].getSaldo()) - saque));

                                                JOptionPane.showMessageDialog(null, "Saque realizado com Sucesso");
                                                JOptionPane.showMessageDialog(null,
                                                        "Seu Saldo Atual = " + contasPf[contAtual].getSaldo());

                                            } else {
                                                JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
                                            }

                                            break;
                                        case 3:
                                            emprestimo = Integer.parseInt(
                                                    JOptionPane.showInputDialog(null, "Insira o valor do emprestimo"));
                                            if (Integer.parseInt(contasPf[contAtual].getSaldo()) <= 1000) {
                                                if (emprestimo <= 2000) {
                                                    contasPf[contAtual].setSaldo(Integer
                                                            .toString(Integer.parseInt(contasPf[contAtual].getSaldo())
                                                                    + emprestimo));
                                                    JOptionPane.showMessageDialog(null,
                                                            "PARABENS!!! Seu Empréstimo foi aceito");

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Empréstimo recusado");

                                                }
                                            } else if (Integer.parseInt(contasPf[contAtual].getSaldo()) <= 5000) {
                                                if (emprestimo <= 10000) {
                                                    contasPf[contAtual].setSaldo(Integer
                                                            .toString(Integer.parseInt(contasPf[contAtual].getSaldo())
                                                                    + emprestimo));
                                                    JOptionPane.showMessageDialog(null,
                                                            "PARABENS!!! Seu Empréstimo foi aceito");

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Empréstimo recusado");
                                                }
                                            } else {
                                                contasPf[contAtual].setSaldo(Integer.toString(
                                                        Integer.parseInt(contasPf[contAtual].getSaldo()) + emprestimo));
                                                JOptionPane.showMessageDialog(null,
                                                        "PARABENS!!! Seu Empréstimo foi aceito");

                                            }

                                            break;
                                        case 4:

                                            acessoConta = false;

                                            break;
                                        default:
                                            break;
                                    }
                                }

                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Verifique se o numero da Conta ou a Senha estão Corretos");
                            }
                        }
                    }else{JOptionPane.showMessageDialog(null,
                                        "Valor incorreto");}
                    break;

                case 2:
                    int acaoConta;
                    acaoConta = Integer.parseInt(JOptionPane.showInputDialog(null, "infome a Ação" +
                            "\n 1-Pessoa Juridica"
                            + "\n 2-Pessoa Fisica"));
                    if (acaoConta == 1) { /// Criação Conta PJ
                        contasPj[contPj] = new ContaPJ();
                        contasPj[contPj].setNome(JOptionPane.showInputDialog(null, "Informe Seu Nome"));
                        contasPj[contPj].setCnpj(JOptionPane.showInputDialog(null, "Informe seu CNPJ"));
                        contasPj[contPj].setTel(JOptionPane.showInputDialog(null, "Informe seu Telefone"));
                        int ncont = 2000 + contPj + 1;
                        contasPj[contPj].setNum(Integer.toString(ncont));
                        contasPj[contPj].setSaldo("0");
                        JOptionPane.showMessageDialog(null,
                                "       Parabens !!!!!!! \n Conta criada com Sucesso \n Agora crie uma senha.");
                        // contasPj[cont].setSenha((JOptionPane.showInputDialog(null, "Crie uma
                        // senha")));
                        // JOptionPane.showMessageDialog(null, "Senha Criado com Sucesso");
                        JOptionPane.showMessageDialog(null, "Seu nome: " + contasPj[contPj].getNome() + "\n Saldo: "
                                + contasPj[contPj].getSaldo() + "\n Numero da conta: " + contasPj[contPj].getNum());

                        contPj++;

                    } else if (acaoConta == 2){
                        contasPf[contPf] = new ContaPF(); /// Criação Conta PF
                        contasPf[contPf].setNome(JOptionPane.showInputDialog(null, "Informe Seu Nome"));
                        contasPf[contPf].setCpf(JOptionPane.showInputDialog(null, "Informe seu CPF"));
                        contasPf[contPf].setTel(JOptionPane.showInputDialog(null, "Informe seu Telefone"));
                        int ncont = 1000 + contPf + 1;
                        contasPf[contPf].setNum(Integer.toString(ncont));
                        contasPf[contPf].setSaldo("0");
                        JOptionPane.showMessageDialog(null,
                                "       Parabens !!!!!!! \n Conta criada com Sucesso \n Agora crie uma senha.");
                        // contasPj[cont].setSenha((JOptionPane.showInputDialog(null, "Crie uma
                        // senha")));
                        // JOptionPane.showMessageDialog(null, "Senha Criado com Sucesso");
                        JOptionPane.showMessageDialog(null, "Seu nome: " + contasPf[contPf].getNome() + "\n Saldo: "
                                + contasPf[contPf].getSaldo() + "\n Numero da conta: " + contasPf[contPf].getNum());

                        contPf++;
                    }else{JOptionPane.showMessageDialog(null,
                                        "Valor incorreto");}
                    break;
                case 3:
                    agenciaAberta = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, " Numero nulo");

                    break;
            }
        }

    }
}

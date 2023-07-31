package RevisaoFPOO;

import javax.management.openmbean.OpenMBeanConstructorInfoSupport;
import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Animais;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;
import RevisaoFPOO.Agendamento.Agenda;

public class App {
    public static void main(String[] args) {

        Cachorro cadastroCachorro[] = new Cachorro[5];
        Gato cadastroGato[] = new Gato[5];
        Outros cadastroOutros[] = new Outros[5];
        Agenda agendamento[] = new Agenda[10];
        boolean aberto = true;
        int contGato = 0;
        int contCachorro = 0;
        int contOutro = 0;
        int contAgenda = 0;
        JOptionPane.showMessageDialog(null, "Bem Vindo Ao Consultório");

        while (aberto) {

            int tipo = Integer
                    .parseInt(JOptionPane.showInputDialog(null, " 1-Cadastrar Pet\n 2-Agendar consulta\n 3-Sair"));
            switch (tipo) {
                case 1:
                    int acao = Integer.parseInt(JOptionPane.showInputDialog(null, " 1-Cachorro\n 2-Gato\n 3-Outros"));
                    switch (acao) {
                        case 1:
                            cadastroCachorro[contCachorro] = new Cachorro();
                            cadastroCachorro[contCachorro]
                                    .setProprietario(JOptionPane.showInputDialog(null, "Insira seu nome:"));
                            cadastroCachorro[contCachorro]
                                    .setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu CPF:")));
                            cadastroCachorro[contCachorro]
                                    .setRaca(JOptionPane.showInputDialog(null, "Insira a Raça do Cachorro:"));
                            cadastroCachorro[contCachorro]
                                    .setGenero(JOptionPane.showInputDialog(null, "Insira o Genero do cachorro:"));
                            cadastroCachorro[contCachorro]
                                    .setPorte(JOptionPane.showInputDialog(null, "Insira o Porte do cachorro"));
                            contCachorro++;

                            break;
                        case 2:
                            cadastroGato[contGato] = new Gato();
                            cadastroGato[contGato]
                                    .setProprietario(JOptionPane.showInputDialog(null, "Insira seu nome:"));
                            cadastroGato[contGato]
                                    .setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu CPF:")));
                            cadastroGato[contGato].setRaca(JOptionPane.showInputDialog(null, "Insira a Raça do Gato:"));
                            cadastroGato[contGato]
                                    .setGenero(JOptionPane.showInputDialog(null, "Insira o Genero do Gato:"));
                            cadastroGato[contGato]
                                    .setPorte(JOptionPane.showInputDialog(null, "Insira o Porte do Gato"));
                            contGato++;

                            break;
                        case 3:
                            cadastroOutros[contOutro] = new Outros();
                            cadastroOutros[contOutro]
                                    .setProprietario(JOptionPane.showInputDialog(null, "Insira seu nome:"));
                            cadastroOutros[contOutro]
                                    .setCpf(Integer.parseInt(JOptionPane.showInputDialog(null, "Insira seu CPF:")));
                            cadastroOutros[contOutro]
                                    .setEspecie(JOptionPane.showInputDialog(null, "Insira a Espécie do Animal:"));
                            cadastroOutros[contOutro]
                                    .setGenero(JOptionPane.showInputDialog(null, "Insira o Genero do Animal:"));
                            cadastroOutros[contOutro]
                                    .setPorte(JOptionPane.showInputDialog(null, "Insira o Porte do Animal: "));
                            contOutro++;

                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Numero Incorreto");
                            break;
                    }
                    break;
                case 2:
                    int entrarConta = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Qual Pet deseja consultar?\n 1-Cachorro\n 2-Gato\n 3-Outros"));
                    if (entrarConta == 1) {
                        // Consultar Cachorro
                        int compararCpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Busque com o CPF:"));
                        for (int i = 0; i < contCachorro; i++) {
                            if (compararCpf == cadastroCachorro[i].getCpf()) {
                                JOptionPane.showMessageDialog(null, "Encontramos seu PET");
                                JOptionPane.showMessageDialog(null,
                                        "Proprietario: " + cadastroCachorro[i].getProprietario() +
                                                "\nRaça: " + cadastroCachorro[i].getRaca() + "\nGenero: "
                                                + cadastroCachorro[i].getGenero() + "\nPorte: "
                                                + cadastroCachorro[i].getPorte());

                                boolean areaAgenda = true;
                                do{
                                    JOptionPane.showMessageDialog(null,
                                            "Coloque a Data e hora de seu Agendamento com o Seguinte padrão: \nData: dd/mm/yyyy \nHora: hh:mm ");
                                    String dataAgenda = JOptionPane.showInputDialog(null, "Data: ");
                                    String horaAgenda = JOptionPane.showInputDialog(null, "Hora: ");
                                    String dataHora = dataAgenda + horaAgenda;
                                    for (int j = 0; j <= contAgenda; j++) {
                                        if (dataHora.equals(agendamento[j].getDataHora())) {
                                            
                                            areaAgenda = false;

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Horário já Agendado, escolha outro.");
                                        }
                                    } //
                                     agendamento[contAgenda] = new Agenda();
                                            agendamento[contAgenda].setData(dataAgenda);
                                            agendamento[contAgenda].setHora(horaAgenda);
                                            JOptionPane.showMessageDialog(null, "Agendamento Confirmado!!!!");
                                            contAgenda++;
                                            
                                } while (areaAgenda);
                            }

                        }

                    } else if (entrarConta == 2) {
                        // Consultar Gato
                        int compararCpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Busque com o CPF:"));
                        for (int i = 0; i < cadastroGato.length; i++) {
                            if (compararCpf == cadastroGato[i].getCpf()) {
                                JOptionPane.showMessageDialog(null, "Encontramos seu PET");
                                JOptionPane.showMessageDialog(null,
                                        "Proprietario: " + cadastroGato[i].getProprietario() +
                                                "\nRaça: " + cadastroGato[i].getRaca() + "\nGenero: "
                                                + cadastroGato[i].getGenero() + "\nPorte: "
                                                + cadastroGato[i].getPorte());
                            }
                        }

                    } else if (entrarConta == 3) {
                        // Consultar Outros
                        int compararCpf = Integer.parseInt(JOptionPane.showInputDialog(null, "Busque com o CPF:"));
                        for (int i = 0; i < cadastroOutros.length; i++) {
                            if (compararCpf == cadastroOutros[i].getCpf()) {
                                JOptionPane.showMessageDialog(null, "Encontramos seu PET");
                                JOptionPane.showMessageDialog(null,
                                        "Proprietario: " + cadastroOutros[i].getProprietario() +
                                                "\nEspécie: " + cadastroOutros[i].getEspecie() + "\nGenero: "
                                                + cadastroOutros[i].getGenero() + "\nPorte: "
                                                + cadastroOutros[i].getPorte());
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Numero Incorreto");
                    }

                    break;
                case 3:
                    aberto = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Numero Incorreto");
                    break;
            }
        }

    }
}

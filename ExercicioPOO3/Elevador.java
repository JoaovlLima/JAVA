package ExercicioPOO3;

import javax.swing.JOptionPane;

import ExercicioPOO1.pessoa;

public class Elevador {
    //contruir o elevador 
    //atributos do elevador
    int nMaxAndares;
    int nMaxPessoas;
    int andarAtual;
    int capacidadeAtual;
    //construtor
    public Elevador(int nMaxAndares, int nMaxPessoas) {
        this.nMaxAndares = nMaxAndares;
        this.nMaxPessoas = nMaxPessoas;
    }
    //construir os métodos
    //set and gets
    public int getAndarAtual() {
        return andarAtual;
    }
    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }
    public int getCapacidadeAtual() {
        return capacidadeAtual;
    }
    public void setCapacidadeAtual(int capacidadeAtual) {
        this.capacidadeAtual = capacidadeAtual;
    }
    //metodos adicionais
    //iniciar
    public void iniciar(){
        capacidadeAtual = 0;
        andarAtual = 0;

    }
    //entrar
    public void entrar(int pessoas){
        if(capacidadeAtual+pessoas>=nMaxPessoas){
            JOptionPane.showMessageDialog(null, "capacidade Maxima atingida");
            JOptionPane.showMessageDialog(null,"Pessoas para fora"
                       +(capacidadeAtual+pessoas-nMaxPessoas));
        }else{
            capacidadeAtual+=pessoas;
        }


    }
    //sair
    public void sair(int pessoas){
        if(pessoas<capacidadeAtual){
            capacidadeAtual-=pessoas;
        }else{
            JOptionPane.showMessageDialog(null,"informe um nº válido, Quantidade atual: "+capacidadeAtual);
        }
    }
    //subir
    public void subir(int nAndares){
        if(nAndares+andarAtual>nMaxAndares){
            JOptionPane.showMessageDialog(null,"Não pode subir");
            JOptionPane.showMessageDialog(null,"Andar Atual "+andarAtual);
        }else{
            andarAtual+=nAndares;

        }
    }
        //descer
        public void descer(int nAndares){
            if(nAndares< andarAtual){
                andarAtual -= nAndares;
            }else {
                JOptionPane.showMessageDialog(null, "informe um nº válido, andar atual: "+andarAtual);
            }
            
    }
}

package POOIntroducao;

public class Alunos extends Pessoas {
    int nota;

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Alunos(int nota) {
        this.nota = nota;
    }

    public Alunos() {
    }
}

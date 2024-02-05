package View;
public class Task { //Task significa Tarefa
    //Atributos
    String description;
    boolean done; //done = Finalizado

    //construtor
    public Task(String description) {//Construtor é um metodo que contem o mesmo nome da minha classe, serve para a construção. //Para metro são aqueles que estão entre parenteses
        
        this.description = description;
        this.done = false;
    }

    //Gerar os getters (Buscar a informação) e setters (Alterar a informação), são metodos/funções especiais
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() { //isDone, pois a variavel esta em boolean ela so pode ser dois valores. Porem se eu preferir mudar o nome para getDone, não há problma nenhum
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    
}

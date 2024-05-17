import java.io.Serializable;

public class Exercicio implements Serializable {

    private Actividade actividade;
    private String professor;
    private String codExercicio;

    public Actividade getActividade() {
        return this.actividade;
    }

    public String getProfessor() {
        return this.professor;
    }

}

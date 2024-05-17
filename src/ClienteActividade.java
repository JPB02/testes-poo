import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteActividade implements Serializable {

    private String nome;
    private String codCliente;
    private Map<LocalDate, List<Exercicio>> meusExercicios;

    public Map<LocalDate, List<Exercicio>> getMeusExercicios() {
        return new HashMap<>(this.meusExercicios);
    }

    public Map<String, List<Exercicio>> exerciciosPorProf() {

        Map<String, List<Exercicio>> exerciciosPorProf = new HashMap<>();

        for(List<Exercicio> exercicios : meusExercicios.values()) {
            for(Exercicio exercicio : exercicios) {
                String professor = exercicio.getProfessor();
                exerciciosPorProf.computeIfAbsent(professor, k -> new ArrayList<>()).add(exercicio);
            }
        }
        return exerciciosPorProf;
    }

}

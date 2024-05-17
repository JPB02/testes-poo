import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GinasioPOO implements Serializable {

    private Map<String, ClienteActividade> clientes;

    public double valorTotalCaloriasGastas(String codCliente) throws ClienteNaoExiste {

        if(!this.clientes.containsKey(codCliente)) {
            throw new ClienteNaoExiste();
        }

        double caloriasTotais = 0.0;

        ClienteActividade cliente = clientes.get(codCliente);

        Map<LocalDate, List<Exercicio>> exerciciosCliente = cliente.getMeusExercicios();

        if(!exerciciosCliente.isEmpty()) {

            for(LocalDate date : exerciciosCliente.keySet()) {
                List<Exercicio> exercicios = exerciciosCliente.get(date);

                for(Exercicio exercicio : exercicios) {
                    Actividade actividade = exercicio.getActividade();
                    caloriasTotais += actividade.getCaloriasGastas();
                }
            }

        }
        return caloriasTotais;
    }

    public double totalKmsCliente ( String codCliente , LocalDate dataExercicio )
            throws ClienteNaoExiste , ExercicioInexistente {

        if(!this.clientes.containsKey(codCliente)) {
            throw new ClienteNaoExiste();
        }

        double kmsTotais = 0.0;

        ClienteActividade cliente = this.clientes.get(codCliente);

        Map<LocalDate, List<Exercicio>> exerciciosCliente = cliente.getMeusExercicios();

        if(!exerciciosCliente.get(dataExercicio).isEmpty()) {
            throw new ExercicioInexistente();
        }

        List<Exercicio> listaExercicio = exerciciosCliente.get(dataExercicio);

        for(Exercicio exercicio : listaExercicio) {
            Actividade actividade = exercicio.getActividade();

            if(actividade instanceof Corrida) {

                double kms = ((Corrida) actividade).getKmsPercorridos();
                kmsTotais += kms;

            }
        }

        return kmsTotais;
    }

    public boolean existeProfessor(String prof) {

        for(ClienteActividade cliente : this.clientes.values()) {

            Map<LocalDate, List<Exercicio>> exerciciosCliente = cliente.getMeusExercicios();
            if(!exerciciosCliente.isEmpty()) {
                for(LocalDate date : exerciciosCliente.keySet()) {
                    List<Exercicio> exercicios = exerciciosCliente.get(date);
                    for(Exercicio exercicio : exercicios) {
                        if(exercicio.getProfessor().equals(prof)) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    public String professorMaisExigente() {

        String profMaisExigente = "";
        double caloriasGastas = 0.0;

        Map<String, Double> caloriasProfs = new HashMap<>();

        for(ClienteActividade cliente : this.clientes.values()) {
            Map<String, List<Exercicio>> listaProf = cliente.exerciciosPorProf();

            for(String prof : listaProf.keySet()) {
                if(!caloriasProfs.containsKey(prof)) {
                    caloriasProfs.put(prof, 0.0);
                }

                List<Exercicio> exercicios = listaProf.get(prof);

                for(Exercicio exercicio : exercicios) {
                    Actividade actividade = exercicio.getActividade();
                    double calorias  = caloriasProfs.get(prof);
                    calorias += actividade.getCaloriasGastas();
                    caloriasProfs.put(prof, calorias);
                }
            }
        }

        for(String prof : caloriasProfs.keySet()) {
            if(caloriasProfs.get(prof) > caloriasGastas) {
                profMaisExigente = prof;
                caloriasGastas = caloriasProfs.get(prof);
            }
        }

        return profMaisExigente;
    }

}

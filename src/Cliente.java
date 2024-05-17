import java.io.Serializable;
import java.util.List;

public class Cliente implements Serializable {

    private String nome;
    private String codCliente;
    private List<Aluguer> meusAluguers;

    public List<Aluguer> getMeusAluguers() {
        return this.meusAluguers;
    }

    public String getCodCliente() {
        return this.codCliente;
    }

}

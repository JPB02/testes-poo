import java.util.Enumeration;

public class Abdominais extends Actividade {

    private int numRepeticoes;
    private String tipoExercicio;

    @Override
    public double caloriasGastas() {
        return this.numRepeticoes * getCaloriasPorUnidadeTreino();
    }
}

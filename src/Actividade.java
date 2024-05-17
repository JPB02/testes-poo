import java.io.Serializable;

public abstract class Actividade implements Serializable, Comparable<Actividade> {

    private String designacao;
    private double caloriasPorUnidadeTreino;

    public abstract double caloriasGastas();

    public double getCaloriasPorUnidadeTreino() {
        return this.caloriasPorUnidadeTreino;
    }

    public double getCaloriasGastas() {
        return this.caloriasGastas();
    }

    public String getDesignacao() {
        return this.designacao;
    }

    public int compareTo(Actividade o) {
        return Double.compare(this.caloriasGastas(), o.getCaloriasGastas());
    }

}

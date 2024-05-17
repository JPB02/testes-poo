import java.io.Serializable;

public abstract class Imovel implements Serializable {

    private String codImovel;
    private String morada;
    private String nifProprietario;
    private double area;
    private double precoBase;

    public abstract double precoDia();

    public String getCodImovel() {
        return this.codImovel;
    }

    public double getPrecoBase() {
        return this.precoBase;
    }

    public double getPrecoDia() {
        return this.precoDia();
    }
}
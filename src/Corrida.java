public class Corrida extends Actividade implements ComDistancia {

    private double kmsPercorridos;
    private double elevacao;
    private double velocidade;

    @Override
    public double caloriasGastas() {
        return (this.kmsPercorridos * getCaloriasPorUnidadeTreino()) +
                ((0.25 * getCaloriasPorUnidadeTreino()) * this.elevacao);
    }

    public double getKmsPercorridos() {
        return this.kmsPercorridos;
    }
}

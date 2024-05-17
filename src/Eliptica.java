public class Eliptica extends Actividade implements ComDistancia {

    private double kmsPercorridos;
    private double nivelEsforco;
    private double minutos;

    @Override
    public double caloriasGastas() {
        double calorias = this.kmsPercorridos * getCaloriasPorUnidadeTreino();
        if(this.nivelEsforco<4) {
            calorias += this.minutos*(0.2*getCaloriasPorUnidadeTreino());
        }

        else {
            calorias += this.minutos*(0.05*getCaloriasPorUnidadeTreino());
        }
        return calorias;
    }
}

public class Moradia extends Imovel {

    private double areaPrivativa;
    private double areaExterior;

    // moradia é um rácio de 30% sobre a área privativa e
    // 70% sobre a área exterior
    @Override
    public double precoDia() {
        return (getPrecoBase()*(0.3*this.areaPrivativa) + (0.7*this.areaExterior));
    }
}

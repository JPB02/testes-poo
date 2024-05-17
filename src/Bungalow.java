public class Bungalow extends Imovel {

    private double factorQualidade;
    private double espessuraParedes;

    // bungalow é calculado com base em
    // iguais parcelas de factor de qualidade geral e da espessura das paredes
    @Override
    public double precoDia() {
        return (getPrecoBase()*(0.5*this.factorQualidade + 0.5*this.espessuraParedes));
    }
}

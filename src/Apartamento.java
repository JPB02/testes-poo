public class Apartamento extends Imovel {

    private String andar;
    private double  factorQualidade;

    // preço por dia de um apartamento é função do factor de qualidade
    // em relação ao preço base
    @Override
    public double precoDia() {
        return this.factorQualidade * getPrecoBase();
    }
}

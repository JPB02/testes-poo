public class ImovelJaExistente extends Exception {

    public ImovelJaExistente() {
        super("O imóvel já existe.");
    }

    public ImovelJaExistente(String msg) {
        super(msg);
    }
}

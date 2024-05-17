import java.io.Serializable;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.time.LocalDate;

public class POOAirBnB implements Serializable {

    private Map<String, Imovel> imoveis;
    private Map<String, Cliente> clientes;

    public void insereImovel(Imovel i) throws ImovelJaExistente {

        String codImovel = i.getCodImovel();

        if (this.imoveis.containsKey(codImovel)) {
            throw new ImovelJaExistente();
        }

        else {
            this.imoveis.put(codImovel, i);
        }
    }

    public double valorTotalAluguerCliente(String codCliente) {

        double aluguerTotal = 0.0;

        if(!this.clientes.containsKey(codCliente)) {
            return 0;
        }

        else {
            Cliente cliente = clientes.get(codCliente);

            List<Aluguer> alugueres = cliente.getMeusAluguers();

            for(Aluguer aluguer : alugueres) {

                LocalDate inicio = aluguer.getDataInicio();
                LocalDate fim = aluguer.getDataFim();
                long diasAluguer = ChronoUnit.DAYS.between(inicio, fim);

                String codImovel = aluguer.getCodImovel();
                Imovel imovel = this.imoveis.get(codImovel);

                double preco = imovel.getPrecoDia();
                aluguerTotal += preco * diasAluguer;

            }
        }

        return aluguerTotal;
    }

    public String clienteMaisGastador() {

        Cliente clienteMaisGastador = null;
        double aluguerMaisGastador = 0.0;

        for(Cliente cliente : clientes.values()) {
            String codCliente = cliente.getCodCliente();

            double precoGasto = valorTotalAluguerCliente(codCliente);

            if(precoGasto > aluguerMaisGastador) {
                aluguerMaisGastador = precoGasto;
                clienteMaisGastador = cliente;
            }
        }

        if(clienteMaisGastador!=null) {
            return clienteMaisGastador.getCodCliente();
        }

        return null;
    }

    public Map<String, Set<String>> clientesPorImovel() {

        Map<String, Set<String>> clientesPorImovel = new HashMap<String, Set<String>>();

        for(Cliente cliente : clientes.values()) {
            String codCliente = cliente.getCodCliente();

            List<Aluguer> alugueres = cliente.getMeusAluguers();

            for(Aluguer aluguer : alugueres) {
                String codImovel = aluguer.getCodImovel();

                Set<String> clientes = clientesPorImovel.getOrDefault(codImovel, new HashSet<>());
                clientes.add(codCliente);

            }
        }
        return clientesPorImovel;
    }
}

package repository;

import Classes.Venda;

import java.util.ArrayList;
import java.util.List;

public final class VendaDAO {

    static List<Venda> vendas = new ArrayList<>();

    public static void salvar(Venda venda) {
        vendas.add(venda);
    }

    public static List<Venda> buscarTodos() {
        System.out.println(vendas);
        return vendas;
    }

    public static List<Venda> buscarPorNome(String nome) {
        List<Venda> filtradas = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getCliente().getNomeCliente().contains(nome)) {
                filtradas.add(venda);
            }
        }
        return filtradas;
    }

    public static Object[] findsgmcInArray() {
        List<Venda> vendas = VendaDAO.buscarTodos();
        List<String> segurosNomes = new ArrayList<>();

        for (Venda venda : vendas) {
            segurosNomes.add(venda.getCliente().getNomeCliente());
        }

        return segurosNomes.toArray();
    }

}

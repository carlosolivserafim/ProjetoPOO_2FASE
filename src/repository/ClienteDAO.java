package repository;

import Classes.Cliente;
import Classes.Colaborador;


import java.util.ArrayList;
import java.util.List;

public final class ClienteDAO {

    static List<Cliente> Clients = new ArrayList<>();

    public static void grava(){
        if (Clients.isEmpty()){

            Cliente cli01 = new Cliente();
            cli01.setNomeCliente("Fernando");
            cli01.setCpf("152.635.251-59");

            Cliente cli02 = new Cliente();
            cli02.setNomeCliente("Pedro");
            cli02.setCpf("452.785.450-47");

            Cliente cli03 = new Cliente();
            cli03.setNomeCliente("Paula");
            cli03.setCpf("542.986.351-14");

            Clients.add(cli01);
            Clients.add(cli02);
            Clients.add(cli03);

        }
    }

    public static void salvarClient(Cliente clienteSalvar) {
        Clients.add(clienteSalvar);
    }

    public static List<Cliente> buscarTodos() {
        grava();
        System.out.println(Clients);
        return Clients;
    }
    public static List<Cliente> buscarPorNome(String nome) {
        List<Cliente> pessoasFiltradas = new ArrayList<>();
        for (Cliente cliente : Clients) {
            if (cliente.getNomeCliente().contains(nome)) {
                pessoasFiltradas.add(cliente);
            }
        }
        return pessoasFiltradas;
    }

    public static Object[] findPessoasInArray() {
        List<Cliente> clients = ClienteDAO.buscarTodos();
        List<String> pessoasNomes = new ArrayList<>();

        for (Cliente cliente : clients) {
            pessoasNomes.add(cliente.getNomeCliente());
        }

        return pessoasNomes.toArray();
    }

    public void salvar(Cliente cliente) {
        if (cliente.getId() == null) {
            cliente.setId((long) (Clients.size() + 1));
        } else {
            Clients.remove((int) (cliente.getId() - 1));
        }
        Clients.add(cliente);
    }

    public void remover(Cliente cliente) {
        if (cliente.getId() != null) {
            Clients.remove((int) (cliente.getId() - 1));
        }
    }

}

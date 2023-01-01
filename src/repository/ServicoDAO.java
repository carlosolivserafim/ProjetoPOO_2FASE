package repository;

import Classes.Colaborador;
import Classes.Servico;

import java.util.ArrayList;
import java.util.List;

public final class ServicoDAO {

    static List<Servico> servicos = new ArrayList<>();

    public static void grava(){
        if (servicos.isEmpty()){

            Servico serv01 = new Servico();
            serv01.setNomeServico("Construir");
            serv01.setValorHoraTrab(20.00);

            Servico serv02 = new Servico();
            serv02.setNomeServico("Pintar");
            serv02.setValorHoraTrab(20.00);

            Servico serv03 = new Servico();
            serv03.setNomeServico("Frete");
            serv03.setValorHoraTrab(20.00);

            servicos.add(serv01);
            servicos.add(serv02);
            servicos.add(serv03);

        }
    }

    public static List<Servico> buscarTodos() {
        grava();
        System.out.println(servicos);
        return servicos;
    }

    public static List<Servico> buscarPorNome(String nome) {
        List<Servico> servicoFiltrados = new ArrayList<>();
        for (Servico servico : servicos) {
            if (servico.getNomeServico().contains(nome)) {
                servicoFiltrados.add(servico);
            }
        }
        return servicoFiltrados;
    }

    public static Object[] findServicoInArray() {
        List<Servico> servicos = ServicoDAO.buscarTodos();
        List<String> servicosNomes = new ArrayList<>();

        for (Servico servico : servicos) {
            servicosNomes.add(servico.getNomeServico());
        }

        return servicosNomes.toArray();
    }

    public void salvar(Servico servico) {
        if (servico.getId() == null) {
            servico.setId((long) (servicos.size() + 1));
        } else {
            servicos.remove((int) (servico.getId() - 1));
        }
        servicos.add(servico);
    }

    public void remover(Servico servico) {
        if (servico.getId() != null) {
            servicos.remove((int) (servico.getId() - 1));
        }
    }

}

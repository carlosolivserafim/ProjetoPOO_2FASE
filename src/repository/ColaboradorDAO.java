package repository;

import Classes.Cliente;
import Classes.Colaborador;

import java.util.ArrayList;
import java.util.List;

public final class ColaboradorDAO {

    static List<Colaborador> colabs = new ArrayList<>();

    public static void grava(){
        if (colabs.isEmpty()){

            Colaborador colab01 = new Colaborador();
            colab01.setNomeColaborador("Bruno");
            colab01.setMatricula("19563/7");
            colab01.setCargoColaborador("Vendedor");
            colab01.setSituacao("Ativo");
            colab01.setDt_admissao("09/03/2020");

            Colaborador colab02 = new Colaborador();
            colab02.setNomeColaborador("Jorge");
            colab02.setMatricula("19589/2");
            colab02.setCargoColaborador("Mestre de Obras");
            colab02.setSituacao("Ativo");
            colab02.setDt_admissao("23/01/2016");

            Colaborador colab03 = new Colaborador();
            colab03.setNomeColaborador("Tiago");
            colab03.setMatricula("19963/5");
            colab03.setCargoColaborador("Auxiliar de Obras");
            colab03.setSituacao("Ativo");
            colab03.setDt_admissao("26/08/2021");

            colabs.add(colab01);
            colabs.add(colab02);
            colabs.add(colab03);
        }
    }

    public static List<Colaborador> buscarTodos() {
        grava();
        System.out.println(colabs);
        return colabs;
    }
    public static List<Colaborador> buscarPorNome(String nome) {
        List<Colaborador> pessoasFiltradas = new ArrayList<>();
        for (Colaborador colaborador : colabs) {
            if (colaborador.getNomeColaborador().contains(nome)) {
                pessoasFiltradas.add(colaborador);
            }
        }
        return pessoasFiltradas;
    }

    public static Object[] findPessoasInArray() {
        List<Colaborador> colabs = ColaboradorDAO.buscarTodos();
        List<String> pessoasNomes = new ArrayList<>();

        for (Colaborador colaborador : colabs) {
            pessoasNomes.add(colaborador.getNomeColaborador());
        }

        return pessoasNomes.toArray();
    }

    public void salvar(Colaborador colaborador) {
        if (colaborador.getId() == null) {
            colaborador.setId((long) (colabs.size() + 1));
        } else {
            colabs.remove((int) (colaborador.getId() - 1));
        }
        colabs.add(colaborador);
    }

    public void remover(Colaborador colaborador) {
        if (colaborador.getId() != null) {
            colabs.remove((int) (colaborador.getId() - 1));
        }
    }

}

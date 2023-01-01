package repository;

import Classes.Produto;

import java.util.ArrayList;
import java.util.List;

public final class ProdutoDAO {

    static List<Produto> produtos = new ArrayList<>();

    public static void grava(){
        if (produtos.isEmpty()){

            Produto prod01 = new Produto();
            prod01.setNomeProd("Cimento 50kg");
            prod01.setQuantidadeProdutoCadastrado(20);
            prod01.setMarcaProd("Votoran");
            prod01.setValorPod(35.00);

            Produto prod02 = new Produto();
            prod02.setNomeProd("Tinta 18L");
            prod02.setQuantidadeProdutoCadastrado(12);
            prod02.setMarcaProd("Suvinil");
            prod02.setValorPod(202.00);

            Produto prod03 = new Produto();
            prod03.setNomeProd("Argamassa 20kg");
            prod03.setQuantidadeProdutoCadastrado(5);
            prod03.setMarcaProd("Argamil");
            prod03.setValorPod(12.00);

            produtos.add(prod01);
            produtos.add(prod02);
            produtos.add(prod03);

        }
    }


    public static List<Produto> buscarTodos() {
        grava();
        System.out.println(produtos);
        return produtos;
    }

    public static List<Produto> buscarPorNome(String nome) {
        List<Produto> produtosFiltrados = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNomeProd().contains(nome)) {
                produtosFiltrados.add(produto);
            }
        }
        return produtosFiltrados;
    }

    public static Object[] findProdutoInArray() {
        List<Produto> produtos = ProdutoDAO.buscarTodos();
        List<String> produtosNomes = new ArrayList<>();

        for (Produto produto : produtos) {
            produtosNomes.add(produto.getNomeProd());
        }

        return produtosNomes.toArray();
    }

    public void salvar(Produto produto) {
        if (produto.getId() == null) {
            produto.setId((long) (produtos.size() + 1));
        } else {
            produtos.remove((int) (produto.getId() - 1));
        }
        produtos.add(produto);
    }

    public void remover(Produto produto) {
        if (produto.getId() != null) {
            produtos.remove((int) (produto.getId() - 1));
        }
    }

}

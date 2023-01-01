package Classes;
import java.util.Random;

public class Produto extends Id {

    Random random = new Random();

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer getCodigoProdAleatorio() {
        return codigoProdAleatorio;
    }

    public void setCodigoProdAleatorio(Integer codigoProdAleatorio) {
        this.codigoProdAleatorio = codigoProdAleatorio;
    }

    public Double getValorProd() {
        return valorProd;
    }

    public void setValorProd(Double valorProd) {
        this.valorProd = valorProd;
    }

    private Integer codigoProdAleatorio = random.nextInt(1000000000);
    private String nomeProd;

    private String codigoProd;

    private Double valorProd;

    private String marcaProd;
    private Integer quantidadeProduoCadastrado;

    public Integer getQuantidadeProdutoCadastrado() {
        return quantidadeProduoCadastrado;
    }

    public void setQuantidadeProdutoCadastrado(Integer quantidadeProduoCadastrado) {
        this.quantidadeProduoCadastrado = quantidadeProduoCadastrado;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }

    public String getCodigoProd() {
        return codigoProd;
    }

    public void setCodigoProd(String codigoProd) {
        this.codigoProd = codigoProd;
    }

    public Double getValorPod() {
        return valorProd;
    }

    public void setValorPod(Double valorPod) {
        this.valorProd = valorPod;
    }

    public String getMarcaProd() {
        return marcaProd;
    }

    public void setMarcaProd(String marcaProd) {
        this.marcaProd = marcaProd;
    }
}

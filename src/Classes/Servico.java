package Classes;
import java.util.Random;

public class Servico extends Id {

    Random random = new Random();
    private Integer codigoServicoAleatorio = random.nextInt(1000000000);
    private String nomeServico;
    private Double valorHoraTrab;
    private int quantidadeHoras;

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer getCodigoServicoAleatorio() {
        return codigoServicoAleatorio;
    }

    public void setCodigoServicoAleatorio(Integer codigoServicoAleatorio) {
        this.codigoServicoAleatorio = codigoServicoAleatorio;
    }

    public String getNomeServico() {
        return nomeServico;
    }

    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    public Double getValorHoraTrab() {
        return valorHoraTrab;
    }

    public void setValorHoraTrab(Double valorHoraTrab) {
        this.valorHoraTrab = valorHoraTrab;
    }

    public int getQuantidadeHoras() {
        return quantidadeHoras;
    }

    public void setQuantidadeHoras(int quantidadeHoras) {
        this.quantidadeHoras = quantidadeHoras;
    }
}

package Classes;
import java.util.Random;

public class Pessoa extends Id {

    Random random = new Random();
    private TipoPessoa tipo;
    private String nomeCliente ;
    private String nomeColaborador ;
    private String nomeCupon = "CLIENTE";
    private Integer codigoPessoa = random.nextInt(1000000000);
    public String getNomeCupon() {
        return nomeCupon;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(Integer codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    public void setNomeCupon(String nomeCupon) {
        this.nomeCupon = nomeCupon;
    }

    public TipoPessoa getTipo() {
        return tipo;
    }

    public void setTipo(TipoPessoa tipo) {
        this.tipo = tipo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeColaborador() {
        return nomeColaborador;
    }

    public void setNomeColaborador(String nomeColaborador) {
        this.nomeColaborador = nomeColaborador;
    }

    @Override
    public String toString() {
        return "\nCliente ou Colaborador " + tipo +
                "\nNome: " + nomeCliente;
    }

    public String getDocumento() {
        return "";
    }
}

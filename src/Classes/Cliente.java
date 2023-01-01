package Classes;
import java.util.Random;

public class Cliente extends Pessoa {

    Random random = new Random();
    private String cpf;
    private Integer codigoCliente = random.nextInt(1000000000);

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Cliente() {
        setTipo(TipoPessoa.CLIENTE);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getDocumento() {
        return this.getCpf();
    }
}

package Classes;
import java.util.Random;

public class Colaborador extends Pessoa {

    Random random = new Random();
    private String cargoColaborador;
    private String matricula;
    private String situacao;
    private String dt_admissao;

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public Integer getCodigoColaborador() {
        return codigoColaborador;
    }

    public void setCodigoColaborador(Integer codigoColaborador) {
        this.codigoColaborador = codigoColaborador;
    }

    private Integer codigoColaborador = random.nextInt(1000000000);

    public Colaborador() {
        setTipo(TipoPessoa.COLABORADOR);
    }

    public String getCargoColaborador() {
        return cargoColaborador;
    }

    public void setCargoColaborador(String cargoColaborador) {
        this.cargoColaborador = cargoColaborador;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getDt_admissao() {
        return dt_admissao;
    }

    public void setDt_admissao(String dt_admissao) {
        this.dt_admissao = dt_admissao;
    }

    @Override
    public String getDocumento() {
        return this.getMatricula();
    }
}

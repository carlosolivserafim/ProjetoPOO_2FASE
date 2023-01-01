package Classes;

import java.util.Random;

public class Venda extends Id {

    Random random = new Random();
    private Integer codVenda = random.nextInt(1000000000);
    private Pessoa cliente;
    private Double desconto;
    private String formaPagamento;
    private Double valorProdutos;
    private Double valorVenda;
    private Double valorImposto;
    private String descBaixa;
    private Boolean baixa;
    private Integer quantidadeP;
    private String descVenda;

    public Integer getQuantidadeP() {
        return quantidadeP;
    }

    public void setQuantidadeP(Integer quantidadeP) {
        this.quantidadeP = quantidadeP;
    }

    public Integer getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(Integer codVenda) {
        this.codVenda = codVenda;
    }

    public Pessoa getCliente() {
        return cliente;
    }

    public void setCliente(Pessoa cliente) {
        this.cliente = cliente;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Double getValorVenda() {
        return valorVenda + imposto();
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda ;
    }

    public Double getValorProdutos() {
        return valorProdutos;
    }

    public void setValorProdutos(Double valorProdutos) {
        this.valorProdutos = valorProdutos;
    }

    public void setValorImposto(Double valorImposto) {
        this.valorImposto = valorImposto;
    }

    public Double getValorImposto() {
        return valorImposto;
    }

    public String getDescBaixa() {
        return descBaixa;
    }

    public void setDescBaixa(String descBaixa) {
        this.descBaixa = descBaixa;
    }

    public Boolean getBaixa() {
        return baixa;
    }

    public void setBaixa(Boolean baixa) {
        this.baixa = baixa;
    }

    public String getDescVenda() {
        return descVenda;
    }

    public void setDescVenda(String descVenda) {
        this.descVenda = descVenda;
    }

    public Double imposto(){
        valorImposto = (valorVenda * 0.07);
        return valorImposto;
    }

}

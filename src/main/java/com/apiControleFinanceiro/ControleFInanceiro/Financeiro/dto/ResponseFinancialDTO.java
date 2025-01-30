package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto;

public class ResponseFinancialDTO {
    private Number entrada;
    private Number saida;
    private Number saldo;

    // Construtor, getters e setters
    public ResponseFinancialDTO(Number entrada, Number saida, Number saldo) {
        this.entrada = entrada;
        this.saida = saida;
        this.saldo = saldo;
    }

    public Number getEntrada() {
        return entrada;
    }

    public void setEntrada(Number entrada) {
        this.entrada = entrada;
    }

    public Number getSaida() {
        return saida;
    }

    public void setSaida(Number saida) {
        this.saida = saida;
    }

    public Number getSaldo() {
        return saldo;
    }

    public void setSaldo(Number saldo) {
        this.saldo = saldo;
    }
}

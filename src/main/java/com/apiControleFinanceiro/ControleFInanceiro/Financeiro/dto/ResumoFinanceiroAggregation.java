package com.apiControleFinanceiro.ControleFInanceiro.Financeiro.dto;

public class ResumoFinanceiroAggregation {
    private double entrada;
    private double saida;
    private double saldo;

    // Construtor, getters e setters
    public ResumoFinanceiroAggregation(double entrada, double saida, double saldo) {
        this.entrada = entrada;
        this.saida = saida;
        this.saldo = saldo;
    }

    public double getEntrada() {
        return entrada;
    }

    public void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    public double getSaida() {
        return saida;
    }

    public void setSaida(double saida) {
        this.saida = saida;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}

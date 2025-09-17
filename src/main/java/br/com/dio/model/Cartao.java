package br.com.dio.model;

import java.util.ArrayList;
import java.util.List;

public class Cartao {
    private String numero;
    private double limite;
    private double saldo;
    private List<Transacao> extrato = new ArrayList<>();

    public Cartao(String numero, double limite) {
        this.numero = numero;
        this.limite = limite;
        this.saldo = limite;
    }

    public String getNumero() {
        return numero;
    }

    public double getLimite() {
        return limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Transacao> getExtrato() {
        return extrato;
    }

    public void debitar(double valor) {
        this.saldo -= valor;
        extrato.add(new Transacao("Compra realizada", valor));
    }
}

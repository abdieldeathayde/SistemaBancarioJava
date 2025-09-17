package br.com.dio.model;

import java.time.LocalDateTime;

public class Transacao {
    private final String descricao;
    private final double valor;
    private final LocalDateTime data;

    public Transacao(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    @Override
    public String toString() {
        return data + " - " + descricao + " - R$ " + valor;
    }
}

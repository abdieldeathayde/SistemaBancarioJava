package br.com.dio.controller;

import br.com.dio.model.Cartao;
import br.com.dio.service.CartaoService;

import java.util.List;

public class CartaoController {
    private final CartaoService cartaoService = new CartaoService();

    public void cadastrarCartao(Cartao cartao) {
        cartaoService.cadastrarCartao(cartao);
        System.out.println("Cartão cadastrado com sucesso!");
    }

    public void listarCartoes() {
        List<Cartao> cartoes = cartaoService.listarCartoes();
        if (cartoes.isEmpty()) {
            System.out.println("Nenhum cartão cadastrado.");
        } else {
            cartoes.forEach(c ->
                    System.out.println("Cartão: " + c.getNumero() + " | Saldo: R$ " + c.getSaldo())
            );
        }
    }

    public void consultarSaldo(String numero) {
        try {
            Cartao cartao = cartaoService.buscarCartao(numero);
            System.out.println("Saldo disponível: R$ " + cartao.getSaldo());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void comprar(String numero, double valor) {
        try {
            Cartao cartao = cartaoService.buscarCartao(numero);
            cartaoService.realizarCompra(cartao, valor);
            System.out.println("Compra de R$ " + valor + " realizada com sucesso!");
            System.out.println("Novo saldo do cartão: " + cartao.getSaldo());
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void verExtrato(String numero) {
        try {
            Cartao cartao = cartaoService.buscarCartao(numero);
            cartaoService.mostrarExtrato(cartao);
        } catch (RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

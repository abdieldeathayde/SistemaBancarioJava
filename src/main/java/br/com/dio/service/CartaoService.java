package br.com.dio.service;

import br.com.dio.exception.SaldoInsuficienteException;
import br.com.dio.exception.ValorInvalidoException;
import br.com.dio.model.Cartao;
import br.com.dio.repository.CartaoRepository;
import br.com.dio.repository.CartaoRepositoryImpl;

import java.util.List;

public class CartaoService {

    private final CartaoRepository repository = new CartaoRepositoryImpl();

    public void cadastrarCartao(Cartao cartao) {
        repository.salvar(cartao);
    }

    public Cartao buscarCartao(String numero) {
        Cartao cartao = repository.buscarPorNumero(numero);
        if (cartao == null) {
            throw new IllegalArgumentException("Cartão não encontrado!");
        }
        return cartao;
    }

    public List<Cartao> listarCartoes() {
        return repository.listarTodos();
    }

    public void excluirCartao(String numero) {
        repository.deletar(numero);
    }

    public boolean realizarCompra(Cartao cartao, double valor) {
        if (valor <= 0) {
            throw new ValorInvalidoException("O valor da compra deve ser maior que zero.");
        }
        if (valor > cartao.getSaldo()) {
            throw new SaldoInsuficienteException("Saldo insuficiente para a compra.");
        }
        cartao.debitar(valor);
        return true;
    }

    public void mostrarExtrato(Cartao cartao) {
        System.out.println("\n=== Extrato do Cartão ===");
        if (cartao.getExtrato().isEmpty()) {
            System.out.println("Nenhuma transação encontrada.");
        } else {
            cartao.getExtrato().forEach(System.out::println);
        }
    }
}

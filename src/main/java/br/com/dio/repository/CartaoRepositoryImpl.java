package br.com.dio.repository;

import br.com.dio.model.Cartao;

import java.util.ArrayList;
import java.util.List;

public class CartaoRepositoryImpl implements CartaoRepository {

    private final List<Cartao> cartoes = new ArrayList<>();

    @Override
    public void salvar(Cartao cartao) {
        cartoes.add(cartao);
    }

    @Override
    public Cartao buscarPorNumero(String numero) {
        return cartoes.stream()
                .filter(c -> c.getNumero().equals(numero))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Cartao> listarTodos() {
        return new ArrayList<>(cartoes);
    }

    @Override
    public void deletar(String numero) {
        cartoes.removeIf(c -> c.getNumero().equals(numero));
    }
}

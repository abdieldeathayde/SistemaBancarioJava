package br.com.dio.repository;

import br.com.dio.model.Cartao;
import java.util.List;

public interface CartaoRepository {
    void salvar(Cartao cartao);
    Cartao buscarPorNumero(String numero);
    List<Cartao> listarTodos();
    void deletar(String numero);
}

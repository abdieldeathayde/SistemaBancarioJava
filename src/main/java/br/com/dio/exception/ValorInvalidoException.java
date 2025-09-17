package br.com.dio.exception;

public class ValorInvalidoException extends RuntimeException {
    private static final String VALOR_INVALIDO = "Valor inválido! Por favor, tente novamente!";
    public ValorInvalidoException(String s) {
        super(VALOR_INVALIDO);
    }
}

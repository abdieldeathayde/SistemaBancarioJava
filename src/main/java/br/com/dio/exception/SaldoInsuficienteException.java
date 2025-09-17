package br.com.dio.exception;

public class SaldoInsuficienteException extends RuntimeException {
  private static final String SALDO_INSUFICIENTE = "Saldo é insuficiente para esta operação";
  public SaldoInsuficienteException(String s) {
    super(SALDO_INSUFICIENTE);
  }
}

package br.com.dio;

import br.com.dio.controller.CartaoController;
import br.com.dio.model.Cartao;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CartaoController controller = new CartaoController();

        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Cadastrar cartão");
            System.out.println("2 - Listar cartões");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Realizar compra");
            System.out.println("5 - Ver extrato");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o número do cartão: ");
                    String numero = sc.next();
                    System.out.print("Digite o limite inicial: ");
                    double limite = sc.nextDouble();
                    controller.cadastrarCartao(new Cartao(numero, limite));
                    break;

                case 2:
                    controller.listarCartoes();
                    break;

                case 3:
                    System.out.print("Digite o número do cartão: ");
                    String numeroSaldo = sc.next();
                    controller.consultarSaldo(numeroSaldo);
                    break;

                case 4:
                    System.out.print("Digite o número do cartão: ");
                    String numeroCompra = sc.next();
                    System.out.print("Digite o valor da compra: ");
                    double valor = sc.nextDouble();
                    controller.comprar(numeroCompra, valor);
                    break;

                case 5:
                    System.out.print("Digite o número do cartão: ");
                    String numeroExtrato = sc.next();
                    controller.verExtrato(numeroExtrato);
                    break;

                case 6:
                    System.out.println("Saindo do sistema... até logo!");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente!");
            }
        } while (opcao != 6);

        sc.close();
    }
}

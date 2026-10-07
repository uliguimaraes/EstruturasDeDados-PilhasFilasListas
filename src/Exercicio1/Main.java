package Exercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pilha<Pedido> cancelados = new Pilha<>();
        Fila<Pedido> pendentes = new Fila<>();
        Scanner scanner = new Scanner(System.in);
        int contadorId = 1;

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== GERENCIAMENTO DE PEDIDOS =====");
            System.out.println("1. Adicionar Novo Pedido");
            System.out.println("2. Atender Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Restaurar Pedido");
            System.out.println("5. Imprimir Pedidos Pendentes");
            System.out.println("6. Imprimir Pedidos Cancelados");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Descrição do pedido: ");
                    String desc = scanner.nextLine();
                    Pedido novo = new Pedido("PED-" + contadorId++, desc);
                    pendentes.enqueue(novo);
                    System.out.println("Pedido inserido com sucesso!");
                    break;

                case 2:
                    Pedido atendido = pendentes.dequeue();
                    if (atendido != null) {
                        System.out.println("Pedido Atendido: " + atendido);
                    } else {
                        System.out.println("Nenhum pedido pendente para atender.");
                    }
                    break;

                case 3:
                    Pedido cancelado = pendentes.dequeue();
                    if (cancelado != null) {
                        cancelados.push(cancelado);
                        System.out.println("Pedido Cancelado: " + cancelado);
                    } else {
                        System.out.println("Nenhum pedido pendente para cancelar.");
                    }
                    break;

                case 4:
                    Pedido restaurado = cancelados.pop();
                    if (restaurado != null) {
                        pendentes.enqueue(restaurado);
                        System.out.println("Pedido Restaurado para a fila: " + restaurado);
                    } else {
                        System.out.println("Nenhum pedido cancelado para restaurar.");
                    }
                    break;

                case 5:
                    pendentes.printQueue();
                    break;

                case 6:
                    cancelados.printStack();
                    break;

                case 0:
                    System.out.println("Encerrando Exercício 1...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

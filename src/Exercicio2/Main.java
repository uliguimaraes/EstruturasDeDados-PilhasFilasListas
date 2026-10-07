package Exercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaDupla<Musica> playlist = new ListaDupla<>();
        Scanner scanner = new Scanner(System.in);

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n===== PLAYER DE MÚSICA (PLAYLIST) =====");
            System.out.println("1. Tocar música atual");
            System.out.println("2. Próxima música");
            System.out.println("3. Música anterior");
            System.out.println("4. Adicionar música");
            System.out.println("5. Remover música");
            System.out.println("6. Listar músicas");
            System.out.println("7. Ordenar playlist");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (!scanner.hasNextInt()) {
                scanner.nextLine();
                continue;
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa buffer

            switch (opcao) {
                case 1:
                    playlist.tocarAtual();
                    break;
                case 2:
                    playlist.proximo();
                    break;
                case 3:
                    playlist.anterior();
                    break;
                case 4:
                    System.out.print("Título: ");
                    String t = scanner.nextLine();
                    System.out.print("Artista: ");
                    String art = scanner.nextLine();
                    System.out.print("Álbum: ");
                    String alb = scanner.nextLine();
                    System.out.print("Duração (ex: 3:45): ");
                    String dur = scanner.nextLine();

                    System.out.println("Onde adicionar? (1-Início, 2-Fim, 3-Posição Específica): ");
                    int posOp = scanner.nextInt();
                    scanner.nextLine();

                    Musica m = new Musica(t, alb, art, dur);
                    if (posOp == 1) {
                        playlist.adicionarInicio(m);
                    } else if (posOp == 3) {
                        System.out.print("Digite o índice (0 a " + playlist.getTamanho() + "): ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        playlist.adicionarPosicao(idx, m);
                    } else {
                        playlist.adicionarFim(m);
                    }
                    System.out.println("Música adicionada!");
                    break;

                case 5:
                    if (playlist.estaVazia()) {
                        System.out.println("Playlist vazia!");
                        break;
                    }
                    System.out.print("Digite a posição da música a remover (0 a " + (playlist.getTamanho() - 1) + "): ");
                    int rmIdx = scanner.nextInt();
                    scanner.nextLine();
                    if (playlist.removerPorPosicao(rmIdx)) {
                        System.out.println("Música removida!");
                    } else {
                        System.out.println("Posição inválida!");
                    }
                    break;

                case 6:
                    playlist.listar();
                    break;

                case 7:
                    System.out.println("Ordenar por: 1-Título | 2-Artista");
                    int ord = scanner.nextInt();
                    scanner.nextLine();
                    playlist.ordenarPorTituloOuArtista(ord == 1);
                    break;

                case 0:
                    System.out.println("Encerrando Player...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
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
                    System.out.print("Duração em segundos: ");
                    if (!scanner.hasNextInt()) {
                        scanner.nextLine();
                        System.out.println("Duração inválida. Informe um número inteiro.");
                        break;
                    }
                    int dur = scanner.nextInt();
                    scanner.nextLine();
                    if (dur < 0) {
                        System.out.println("A duração não pode ser negativa.");
                        break;
                    }

                    System.out.println("Onde adicionar? (1-Início, 2-Fim, 3-Posição Específica): ");
                    int posOp = scanner.nextInt();
                    scanner.nextLine();

                    Musica m = new Musica(t, alb, art, dur);
                    boolean adicionada;
                    if (posOp == 1) {
                        playlist.adicionarInicio(m);
                        adicionada = true;
                    } else if (posOp == 3) {
                        System.out.print("Digite o índice (0 a " + playlist.getTamanho() + "): ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();
                        adicionada = playlist.adicionarPosicao(idx, m);
                    } else if (posOp == 2) {
                        playlist.adicionarFim(m);
                        adicionada = true;
                    } else {
                        System.out.println("Opção de inserção inválida!");
                        break;
                    }
                    System.out.println(adicionada ? "Música adicionada!" : "Posição inválida!");
                    break;

                case 5:
                    if (playlist.estaVazia()) {
                        System.out.println("Playlist vazia!");
                        break;
                    }
                    System.out.println("Remover por: 1-Posição | 2-Título");
                    int tipoRemocao = scanner.nextInt();
                    scanner.nextLine();
                    boolean removida;
                    if (tipoRemocao == 1) {
                        System.out.print("Digite a posição da música a remover (0 a "
                                + (playlist.getTamanho() - 1) + "): ");
                        int rmIdx = scanner.nextInt();
                        scanner.nextLine();
                        removida = playlist.removerPorPosicao(rmIdx);
                    } else if (tipoRemocao == 2) {
                        System.out.print("Digite o título da música: ");
                        removida = playlist.removerPorTitulo(scanner.nextLine());
                    } else {
                        System.out.println("Opção de remoção inválida!");
                        break;
                    }
                    System.out.println(removida ? "Música removida!" : "Música não encontrada ou posição inválida!");
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

package Exercicio2;

public class ListaDupla<T> {
    private No<T> inicio;
    private No<T> fim;
    private No<T> atual;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.atual = null;
        this.tamanho = 0;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public int getTamanho() {
        return tamanho;
    }

    // Adiciona no início
    public void adicionarInicio(T dado) {
        No<T> novo = new No<>(dado);
        if (estaVazia()) {
            inicio = fim = atual = novo;
        } else {
            novo.setProximo(inicio);
            inicio.setAnterior(novo);
            inicio = novo;
        }
        tamanho++;
    }

    // Adiciona no fim
    public void adicionarFim(T dado) {
        No<T> novo = new No<>(dado);
        if (estaVazia()) {
            inicio = fim = atual = novo;
        } else {
            fim.setProximo(novo);
            novo.setAnterior(fim);
            fim = novo;
        }
        tamanho++;
    }

    // Adiciona em posição específica (0-indexed)
    public boolean adicionarPosicao(int pos, T dado) {
        if (pos < 0 || pos > tamanho) return false;
        if (pos == 0) {
            adicionarInicio(dado);
            return true;
        }
        if (pos == tamanho) {
            adicionarFim(dado);
            return true;
        }

        No<T> aux = inicio;
        for (int i = 0; i < pos; i++) {
            aux = aux.getProximo();
        }

        No<T> novo = new No<>(dado);
        novo.setAnterior(aux.getAnterior());
        novo.setProximo(aux);
        aux.getAnterior().setProximo(novo);
        aux.setAnterior(novo);

        tamanho++;
        return true;
    }

    // Remover por posição
    public boolean removerPorPosicao(int pos) {
        if (estaVazia() || pos < 0 || pos >= tamanho) return false;

        No<T> aux = inicio;
        for (int i = 0; i < pos; i++) {
            aux = aux.getProximo();
        }

        removerNo(aux);
        return true;
    }

    // Remove a primeira música encontrada pelo título, sem diferenciar maiúsculas/minúsculas.
    public boolean removerPorTitulo(String titulo) {
        if (titulo == null || estaVazia()) return false;

        No<T> aux = inicio;
        while (aux != null) {
            if (aux.getDado() instanceof Musica musica
                    && musica.getTitulo().equalsIgnoreCase(titulo.trim())) {
                removerNo(aux);
                return true;
            }
            aux = aux.getProximo();
        }
        return false;
    }

    private void removerNo(No<T> no) {
        if (no == atual) {
            atual = (no.getProximo() != null) ? no.getProximo() : no.getAnterior();
        }

        if (no == inicio && no == fim) {
            inicio = fim = atual = null;
        } else if (no == inicio) {
            inicio = inicio.getProximo();
            inicio.setAnterior(null);
        } else if (no == fim) {
            fim = fim.getAnterior();
            fim.setProximo(null);
        } else {
            no.getAnterior().setProximo(no.getProximo());
            no.getProximo().setAnterior(no.getAnterior());
        }
        tamanho--;
    }

    // Próxima música
    public void proximo() {
        if (atual != null && atual.getProximo() != null) {
            atual = atual.getProximo();
            System.out.println("Avançado para a próxima música.");
        } else {
            System.out.println("Você já está na última música.");
        }
    }

    // Música anterior
    public void anterior() {
        if (atual != null && atual.getAnterior() != null) {
            atual = atual.getAnterior();
            System.out.println("Voltado para a música anterior.");
        } else {
            System.out.println("Você já está na primeira música.");
        }
    }

    // Tocar música atual
    public void tocarAtual() {
        if (atual == null) {
            System.out.println("Nenhuma música na playlist para tocar.");
        } else {
            System.out.println("\n▶ TOCANDO AGORA: " + atual.getDado());
        }
    }

    // Listar todas as músicas
    public void listar() {
        if (estaVazia()) {
            System.out.println("Playlist vazia.");
            return;
        }
        No<T> temp = inicio;
        int i = 0;
        System.out.println("\n--- PLAYLIST ---");
        while (temp != null) {
            String marcado = (temp == atual) ? " -> [MÚSICA ATUAL]" : "";
            System.out.println("[" + i + "] " + temp.getDado() + marcado);
            temp = temp.getProximo();
            i++;
        }
    }

    // Método para ordenação (Bubble Sort por Título ou Artista)
    public void ordenarPorTituloOuArtista(boolean porTitulo) {
        if (tamanho < 2) return;

        for (No<T> i = inicio; i != null; i = i.getProximo()) {
            for (No<T> j = i.getProximo(); j != null; j = j.getProximo()) {
                Musica musicaI = (Musica) i.getDado();
                Musica musicaJ = (Musica) j.getDado();
                String val1 = porTitulo ? musicaI.getTitulo() : musicaI.getArtista();
                String val2 = porTitulo ? musicaJ.getTitulo() : musicaJ.getArtista();

                if (val1.compareToIgnoreCase(val2) > 0) {
                    T aux = i.getDado();
                    i.setDado(j.getDado());
                    j.setDado(aux);
                }
            }
        }
        System.out.println("Playlist ordenada com sucesso!");
    }
}

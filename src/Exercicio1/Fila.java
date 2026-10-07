package Exercicio1;

public class Fila<T> {
    private No<T> inicio;
    private No<T> fim;

    public Fila() {
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia() {
        return inicio == null;
    }

    public void enqueue(T dado) {
        No<T> novoNo = new No<>(dado);
        if (estaVazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
    }

    public T dequeue() {
        if (estaVazia()) {
            return null;
        }
        T dadoRemovido = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;
        }
        return dadoRemovido;
    }

    public void printQueue() {
        if (estaVazia()) {
            System.out.println("Nenhum pedido na fila.");
            return;
        }
        No<T> atual = inicio;
        System.out.println("\n--- Fila de Pedidos Pendentes ---");
        while (atual != null) {
            System.out.println(atual.getDado());
            atual = atual.getProximo();
        }
    }
}
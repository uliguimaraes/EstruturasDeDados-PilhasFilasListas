package Exercicio1;

public class Pilha<T> {
    private No<T> topo;

    public Pilha() {
        this.topo = null;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public void push(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.setProximo(topo);
        topo = novoNo;
    }

    public T pop() {
        if (estaVazia()) {
            return null;
        }
        T dadoRemovido = topo.getDado();
        topo = topo.getProximo();
        return dadoRemovido;
    }

    public void printStack() {
        if (estaVazia()) {
            System.out.println("Nenhum pedido cancelado.");
            return;
        }
        No<T> atual = topo;
        System.out.println("\n--- Pilha de Pedidos Cancelados ---");
        while (atual != null) {
            System.out.println(atual.getDado());
            atual = atual.getProximo();
        }
    }
}
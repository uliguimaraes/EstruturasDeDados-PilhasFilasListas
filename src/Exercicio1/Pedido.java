package Exercicio1;

public class Pedido {
    private String id;
    private String descricao;

    public Pedido(String id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Descrição: " + descricao;
    }
}
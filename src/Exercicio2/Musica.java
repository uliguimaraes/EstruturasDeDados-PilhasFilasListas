package Exercicio2;

public class Musica {
    private String titulo;
    private String album;
    private String artista;
    private int duracao;

    public Musica(String titulo, String album, String artista, int duracao) {
        this.titulo = titulo;
        this.album = album;
        this.artista = artista;
        this.duracao = duracao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAlbum() {
        return album;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Artista: " + artista + " | Álbum: " + album
                + " | Duração: " + duracao + " segundos";
    }
}

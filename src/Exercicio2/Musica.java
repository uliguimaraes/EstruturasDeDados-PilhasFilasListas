package Exercicio2;

public class Musica {
    private String titulo;
    private String album;
    private String artista;
    private String duracao;

    public Musica(String titulo, String album, String artista, String duracao) {
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

    public String getDuracao() {
        return duracao;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + " | Artista: " + artista + " | Álbum: " + album + " | Duração: " + duracao;
    }
}
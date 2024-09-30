public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int nPaginas;

    public Livro() {}

    public Livro(String titulo, String autor, int anoPublicacao, int nPaginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.nPaginas = nPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", anoPublicacao=" + anoPublicacao +
                ", nPaginas=" + nPaginas +
                '}';
    }
}

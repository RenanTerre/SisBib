import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private final List<Livro> acervo = new ArrayList<>();

    public void adicionar(Livro livro) throws Exception {
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty()) {
            throw new Exception("Não é permitido cadastrar livro sem título");
        }
        if (livro.getAutor() == null || livro.getAutor().isEmpty()) {
            throw new Exception("Não é permitido cadastrar livro sem autor");
        }
        if (livro.getAnoPublicacao() < 1400 || livro.getAnoPublicacao() > LocalDate.now().getYear()) {
            throw new Exception("Ano de publicação inválido. Deve ser entre 1400 e o ano atual.");
        }
        if (livro.getnPaginas() <= 0) {
            throw new Exception("Número de páginas deve ser maior que zero.");
        }

        for (Livro livroAcervo : acervo) {
            if (livroAcervo.getTitulo().equalsIgnoreCase(livro.getTitulo())) {
                throw new Exception("Já existe livro cadastrado com esse título");
            }
        }
        acervo.add(livro);
    }

    public List<Livro> pesquisarPorTitulo(String titulo) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public void removerPorTitulo(String titulo) throws Exception {
        boolean removido = acervo.removeIf(livro -> livro.getTitulo().equalsIgnoreCase(titulo));
        if (!removido) {
            throw new Exception("Livro com título '" + titulo + "' não encontrado.");
        }
    }

    public List<Livro> pesquisarTodos() {
        return acervo;
    }
}

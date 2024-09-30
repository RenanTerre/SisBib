import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    private static int inputNumerico(String mensagem) {
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valorStr = input.nextLine();
            try {
                valor = Integer.parseInt(valorStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor, informe um número inteiro.");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void listar() {
        List<Livro> livros = biblio.pesquisarTodos();
        livros.sort(Comparator.comparing(Livro::getTitulo));

        System.out.println("Lista de livros:");
        for (Livro livro : livros) {
            System.out.println("Título: " + livro.getTitulo());
            System.out.println("Autor: " + livro.getAutor());
            System.out.println("Ano: " + livro.getAnoPublicacao());
            System.out.println("N. Páginas: " + livro.getnPaginas());
        }
        System.out.println("Pressione a tecla Enter para continuar");
        input.nextLine(); 
    }
    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("Adicionando um novo Livro");
        System.out.print("Informe o título do livro: ");
        novoLivro.setTitulo(input.nextLine());

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        novoLivro.setAnoPublicacao(inputNumerico("Informe o ano de publicação:"));
        novoLivro.setnPaginas(inputNumerico("Informe o número de páginas:"));

        try {
            biblio.adicionar(novoLivro);
            System.out.println("Livro adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine(); 
    }

    private static void pesquisar() {
        System.out.print("Informe o título do livro a ser pesquisado: ");
        String titulo = input.nextLine();
        List<Livro> livros = biblio.pesquisarPorTitulo(titulo);

        if (livros.isEmpty()) {
            System.out.println("Nenhum livro encontrado com o título: " + titulo);
        } else {
            System.out.println("Livros encontrados:");
            for (Livro livro : livros) {
                System.out.println(livro.getTitulo() + " - " + livro.getAutor() + " (" + livro.getAnoPublicacao() + ")");
            }
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine(); 
    }

    private static void remover() {
        System.out.print("Informe o título do livro a ser removido: ");
        String titulo = input.nextLine();

        try {
            biblio.removerPorTitulo(titulo);
            System.out.println("Livro removido com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
        System.out.println("Pressione Enter para continuar...");
        input.nextLine(); 
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("SISTEMA DE GERENCIAMENTO DE BIBLIOTECA");
            System.out.println("1 - Adicionar novo livro;");
            System.out.println("2 - Listar todos os livros;");
            System.out.println("3 - Pesquisar livro por título;");
            System.out.println("4 - Remover livro por título;");
            System.out.println("0 - Sair;");
            opcao = inputNumerico("Escolha uma das opções:");

            switch (opcao) {
                case 0:
                    System.out.println("VOLTE SEMPRE!!!");
                    break;
                case 1:
                    adicionar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    remover();
                    break;
                default:
                    System.out.println("Opção inválida!!!");
                    break;
            }
        } while (opcao != 0);
    }
}
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;

public class Main {
    static Biblioteca biblio = new Biblioteca();
    static Scanner input = new Scanner(System.in);

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private static int inputNumerico(String mensagem){
        int valor = 0;
        boolean entradaValida = false;
        System.out.println(mensagem);
        do {
            String valoStr = input.nextLine();
            try {
                valor = Integer.parseInt(valoStr);
                entradaValida = true;
            } catch (Exception e) {
                System.out.println("Erro. Por favor informe um número inteiro");
            }
        } while (!entradaValida);
        return valor;
    }

    private static void listar(){
        List<Livro> livros = biblio.pesquisarTodos();
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado.");
        } else {
            livros.sort(Comparator.comparing(Livro::getTitulo));
            System.out.println("======== LISTA DE LIVROS =========");
            for (Livro livro : livros) {
                System.out.println("Título: " + livro.getTitulo());
                System.out.println("Autor: " + livro.getAutor());
                System.out.println("Ano: " + livro.getAnoPublicacao());
                System.out.println("N. Páginas: " + livro.getnPaginas());
            }
        }
        input.nextLine(); 
    }

    private static void adicionar() {
        Livro novoLivro = new Livro();
        System.out.println("======== ADICIONANDO NOVO LIVRO ========");
        System.out.print("Informe o título do livro: ");
        novoLivro.setTitulo(input.nextLine());

        System.out.print("Informe o nome do autor: ");
        novoLivro.setAutor(input.nextLine());

        System.out.print("Informe o ano de publicação: ");
        novoLivro.setAnoPublicacao(input.nextInt());
        input.nextLine(); 

        System.out.print("Informe o número de páginas: ");
        novoLivro.setnPaginas(input.nextInt());
        input.nextLine(); 

        try {
            biblio.adicionar(novoLivro);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Livro adicionado com sucesso!");
        
        input.nextLine(); 
    }

    public static void main(String[] args) {
        String menu = """
                SISTEMA DE GERENCIAMENTO DE BIBLIOTECA
                Escolha uma das opções:
                1 - Adicionar novo livro;
                2 - Listar todos os livros;
                3 - Pesquisar livro;
                4 - Remover livro;
                0 - Sair;
                """;
        int opcao;
        do {
            limparTela(); 
            opcao = inputNumerico(menu);
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
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    input.nextLine();
                    break;
            }
        } while (opcao != 0);
    }
}

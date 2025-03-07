import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BlocoDeNotas bloco = new BlocoDeNotas();
        System.out.println("====================================");
        System.out.println("Bem-vindo ao bloco de notas!");
        System.out.println("====================================");
        System.out.println("ESCOLHA UMA OPÇÃO::");

        try {
            int opcao = menuPrincipal(sc); // Pega a opção do menu
            if (opcao < 1 || opcao >6) {
                System.err.println("opção inválida, tente novamente!");
                opcao = menuPrincipal(sc);
            }
            while (opcao != 6) {
                sistema(opcao, sc, bloco);
                opcao = menuPrincipal(sc);
            }

            System.err.println("Programa finalizado --");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        sc.close(); // Fechar o scanner quando terminar
    }

    private static void sistema(int opcao, Scanner sc, BlocoDeNotas bloco) throws Exception {
        switch (opcao) {
            case 1:
                System.out.print("Escreva a anotação: ");
                String texto = sc.nextLine();
                bloco.adicionarAnotacao(texto);
                System.out.println("Nota adicionada com sucesso!");
                break;
            case 2:
                System.out.println("Lista de notas:");
                bloco.listarAnotacoes();
                break;
            case 3:
                System.out.print("Digite o texto para buscar: ");
                String busca = sc.nextLine();
                System.out.println("Resultado da busca:");
                System.out.println(bloco.recuperarPorTexto(busca));
                break;
            case 4:
                System.out.print("Digite o ID da nota para editar: ");
                int idEditar = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha
                System.out.print("Digite o novo texto da nota: ");
                String novoTexto = sc.nextLine();
                bloco.editarAnotacao(idEditar, novoTexto);
                System.out.println("Nota editada com sucesso!");
                break;
            case 5:
                System.out.print("Digite o ID da nota para excluir: ");
                int idExcluir = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha
                if (bloco.excluirAnotacao(idExcluir)) {
                    System.out.println("Nota excluída com sucesso!");
                } else {
                    System.out.println("Nota não encontrada ou já deletada.");
                }
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            default:
                System.err.println("Opção inválida, tente novamente!");
                break;
        }
    }

    private static int menuPrincipal(Scanner sc) {
        System.out.println("___________________");
        System.out.println("1 - Cadastrar nota");
        System.out.println("2 - Listar notas");
        System.out.println("3 - Buscar nota");
        System.out.println("4 - Editar nota");
        System.out.println("5 - Excluir nota");
        System.out.println("6 - Sair");
        System.out.println("-------------------");

        int opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }
}
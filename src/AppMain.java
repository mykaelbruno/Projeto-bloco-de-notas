import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BlocoDeNotas bloco = new BlocoDeNotas();
        System.out.println("Bem vindo ao bloco de notas!");
        System.out.println("===============================");
        int opcao = menuPrincipal(sc);

        do {
            switch (opcao) {
                case 1:
                    System.out.print("Escreva a anotação: ");
                    String texto = sc.nextLine();
                    bloco.adicionarAnotacao(texto);
                    break;
                case 2:
                    System.out.println("Opção 2");
                    break;
                case 3:
                    System.out.println("Opção 3");
                    break;
                case 4:
                    System.out.println("Opção 4");
                    break;
                case 5:
                    System.out.println("Opção 5");
                    break;
                case 6:
                    System.out.println("Opção 6");
                    break;
                default:
                    System.err.println("Opção inválida, tente novamente!");
                    opcao = menuPrincipal(sc);
                    break;
            }
        } while (opcao != 6);

        /*System.out.println(bloco.adicionarAnotacao("Prova de ADM amanhã (dia 06/02)"));
        System.out.println(bloco.adicionarAnotacao("Show de guilherme dia 21/02"));
        System.out.println(bloco.adicionarAnotacao("Meu aniversário dia 09/02"));
        System.out.println(bloco.adicionarAnotacao(""));
        bloco.excluirAnotacao(1);
        System.out.println(bloco.buscarAnotacao(1));
        System.out.println(bloco.toString());*/
    }

    private static int menuPrincipal(Scanner sc) {
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar nota");
        System.out.println("2 - Listar notas");
        System.out.println("3 - Buscar nota");
        System.out.println("4 - Editar nota");
        System.out.println("5 - Excluir nota");
        System.out.println("6 - Sair");
        int opcao = sc.nextInt();
        return opcao;
    }
}
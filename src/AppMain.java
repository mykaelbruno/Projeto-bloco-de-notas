import java.util.ArrayList;

public class AppMain {
    public static void main(String[] args) {
        BlocoDeNotas bloco1 = new BlocoDeNotas();

        bloco1.adicionarAnotacao("Prova de ADM amanhã (dia 06/02)");
        bloco1.adicionarAnotacao("Show de guilherme dia 21/02");
        bloco1.adicionarAnotacao("Meu aniversário dia 09/02");
        bloco1.adicionarAnotacao(6);

        System.out.println(bloco1.toString());
        bloco1.deletarAnotacao(2);
        System.out.println(bloco1.toString());
        bloco1.buscarAnotacao(1);
        System.out.println(bloco1.recuperarPorTexto("Meu"));

    }
}

import java.sql.SQLOutput;
import java.util.ArrayList;

public class AppMain {
    public static void main(String[] args) {
        ArrayList<Anotacao> notas = new ArrayList<Anotacao>();

        BlocoDeNotas Blc1 = new BlocoDeNotas();

        Blc1.adicionarAnotacao("Consunta ao médico amanhã ás 21:00");
        Blc1.adicionarAnotacao("Ida ao trabalho hj ah 17:00");
        Blc1.adicionarAnotacao("ODEIO NESCAU");
        Blc1.adicionarAnotacao("Prova quinta feira");

        System.out.println(Blc1);

        System.out.println("Segunda rodada de testes:  ");

        System.out.println(Blc1.buscarAnotacao(3));
        System.out.println(Blc1.recuperarPorTexto("ODEIO"));



    }
}

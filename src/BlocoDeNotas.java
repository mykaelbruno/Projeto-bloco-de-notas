import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeNotas {
    ArrayList<Anotacao> Bloco = new ArrayList<Anotacao>();

    public Anotacao adicionarAnotacao (String texto) {
        Anotacao nota = new Anotacao(texto, Bloco.size()+1);
        Bloco.add(nota);
        return nota;
    }

    public Anotacao buscarAnotacao(int id) {
        for (Anotacao nota : Bloco){
            if (nota.getId() == id){
                return nota;
            }
        }
        return null;
    }

    public ArrayList<Anotacao> recuperarPorTexto(String buscaTexto) {
        ArrayList<Anotacao> encontradas = new ArrayList<Anotacao>();
        for(Anotacao nota : Bloco) {
            if (nota.getTexto().contains(buscaTexto)){
                encontradas.add(nota);
            }
        }
        return encontradas;
    }

    @Override
    public String toString() {
        return "BlocoDeNotas{" +
                "Bloco=" + Bloco +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlocoDeNotas that = (BlocoDeNotas) o;
        return Objects.equals(Bloco, that.Bloco);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Bloco);
    }
}
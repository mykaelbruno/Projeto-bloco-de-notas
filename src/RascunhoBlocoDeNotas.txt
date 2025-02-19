import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeNotas {
    private ArrayList<Anotacao> Notas;

    public BlocoDeNotas() {
        this.Notas = new ArrayList<Anotacao>();

    }

    public Anotacao adicionarAnotacao (String texto){
        Anotacao novanota = new Anotacao(texto, Notas.size());
        Notas.add(novanota);
        return novanota;
    }

    public Anotacao adicionarAnotacao (int id){
        Anotacao novanota = new Anotacao("-Sem texto-", id);
        Notas.add(novanota);
        return novanota;
    }


    public Anotacao buscarAnotacao(int id) {
        for (Anotacao nota : Notas) {
            if (nota.getId() == id) {
                return nota;
            }
        }
        return null;
    }

    public ArrayList<Anotacao> recuperarPorTexto (String texto) {
        ArrayList<Anotacao> retorno = new ArrayList<>();for (Anotacao nota : Notas) {
            if (!nota.isDeletado() && nota.getTexto().contains(texto)) {
                retorno.add(nota);
            }
        }
        return retorno;
    }

    public void editarAnotacao(int id, String novoTexto) {
        Anotacao nota = buscarAnotacao(id);
        if (nota != null) {
            nota.setTexto(novoTexto);
        }
    }

    public String exibeBloco () {
        ArrayList<Anotacao> ativas = new ArrayList<>();
        for (Anotacao nota : Notas) {
            if (!nota.isDeletado()) {
                ativas.add(nota);
            }
        }
        return "" + ativas;
    }

    public boolean deletarAnotacao(int id) {
        Anotacao nota = buscarAnotacao(id);
        if (nota != null) {
            nota.deleta();
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "" + Notas;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BlocoDeNotas that = (BlocoDeNotas) o;
        return Objects.equals(Notas, that.Notas);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Notas);
    }
}

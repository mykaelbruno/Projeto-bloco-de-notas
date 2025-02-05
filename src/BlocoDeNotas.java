import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeNotas {
    private ArrayList<Anotacao> Notas;

    public BlocoDeNotas(ArrayList<Anotacao> notas) {
        this.Notas = notas;

    }

    public Anotacao adicionarAnotacao (String texto){
        Anotacao novanota = new Anotacao(texto, Notas.size());
        Notas.add(novanota);
        return novanota;
    }

    public Anotacao buscarAnotacao (int id) {
        for (int i = 0;i < Notas.size();i++){
            Anotacao nota = Notas.get(i);
            if (nota.getId() == id){
                return nota;
            }
        }
        return null;
    }

    public Anotacao adicionarAnotacao (int id){
        Anotacao novanota = new Anotacao("-Sem texto-", id);
        Notas.add(novanota);
        return novanota;
    }

    public ArrayList<Anotacao> recuperarPorTexto (String texto) {
        ArrayList<Anotacao> retorno = new ArrayList<>();
        for (int i = 0; i < Notas.size(); i++){
            Anotacao nota = Notas.get(i);
            if (nota.getTexto().contains(texto)) {
                retorno.add(nota);
            }
        }
        return retorno;
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

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
                if (!nota.isDeletado()){
                    return nota;
                }
            }
        }
        return null;
    }

    public ArrayList<Anotacao> recuperarPorTexto(String buscaTexto) {
        ArrayList<Anotacao> encontradas = new ArrayList<Anotacao>();
        for(Anotacao nota : Bloco) {
            if (nota.getTexto().contains(buscaTexto)){
                if (!nota.isDeletado()){
                    encontradas.add(nota);
                }
            }
        }
        return encontradas;
    }

    public boolean excluirAnotacao(int id) {
        for (Anotacao nota : Bloco) {
            if (nota.getId() == id){
                Anotacao remover = nota;
                nota.deleta();
                return true;
            }
        }
        return false;
    }

    public Anotacao editarAnotacao(int id, String texto) {
        Anotacao editada = null;
        for (Anotacao nota : Bloco) {
            if (nota.getId() == id){
                if (!nota.isDeletado()) {
                    nota.setTexto(texto);
                    editada = nota;
                }
            }
        }
        return editada;
    }

    @Override
    public String toString() {
        return  "Bloco=" + Bloco + '}';
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
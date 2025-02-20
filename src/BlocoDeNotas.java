import java.util.ArrayList;
import java.util.Objects;

public class BlocoDeNotas {
    ArrayList<Anotacao> Bloco = new ArrayList<Anotacao>();

    public Anotacao adicionarAnotacao (String texto) throws Exception {
        Anotacao nota = new Anotacao(texto, Bloco.size()+1);
        Bloco.add(nota);
        return nota;
    }

    public Anotacao buscarAnotacao(int id) throws Exception {
        verificaID(id);
        for (Anotacao nota : Bloco){
            if (nota.getId() == id){
                verificaDeletado(nota);
                return nota;
            }
        }
        return null;
    }

    private static void verificaDeletado(Anotacao nota) throws Exception {
        if (nota.isDeletado()){
            throw new Exception("Anotação deletada.");
        }
    }

    private void verificaID(int id) throws Exception {
        if (id <= 0 || id >= Bloco.size()+1) {
            throw new Exception("ID inválido..");
        }
    }

    private static void verificaTexto(String buscaTexto) throws Exception {
        if (buscaTexto == null || buscaTexto == "" || buscaTexto == " ") {
            throw new Exception("O texto não pode ser vazio.");
        }
    }

    public ArrayList<Anotacao> recuperarPorTexto(String buscaTexto) throws Exception {
        verificaTexto(buscaTexto);
        ArrayList<Anotacao> encontradas = new ArrayList<Anotacao>();
        for(Anotacao nota : Bloco) {
            if (nota.ContemTexto(buscaTexto)){
                if (!nota.isDeletado()){
                    encontradas.add(nota);
                }
            }
        }
        return encontradas;
    }

    public boolean excluirAnotacao(int id) throws Exception {
        verificaID(id);
        for (Anotacao nota : Bloco) {
            if (nota.getId() == id){
                verificaDeletado(nota);
                Anotacao notaRemovida = nota;
                nota.deleta();
                return true;
            }
        }
        return false;
    }

    public Anotacao editarAnotacao(int id, String texto) throws Exception {
        verificaID(id);
        verificaTexto(texto);
        Anotacao editada = null;
        for (Anotacao nota : Bloco) {
            if (nota.getId() == id){
                verificaDeletado(nota);
                editada = nota;
                nota.setTexto(texto);
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
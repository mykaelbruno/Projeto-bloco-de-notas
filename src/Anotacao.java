import java.time.LocalDate;
import java.util.Objects;

public class Anotacao {
    private String texto;
    private int id;
    private LocalDate dataDeCriacao;
    private boolean deletado;

    public Anotacao (String texto, int id) {
        this.texto = texto;
        this.id = id;
        dataDeCriacao = LocalDate.now();
        deletado = false;
    }

    public boolean contemTexto (String texto) {
        if (!this.deletado){
            return this.texto.contains(texto);
        }
        return false;
    }

    public int getId() {
        return id;
    }

    public String getTexto() {
        if (!this.deletado){
            return texto;
        }
        return "(Anotação deletada!)";
    }

    public void setTexto(String texto) {
        if (!this.deletado){
            this.texto = texto;
        }
    }

    public LocalDate getData() {
        return dataDeCriacao;
    }

    //Métodos p/ deletar
    public boolean isDeletado() {
        return deletado;
    }

    public void deleta() {
        this.deletado = true;
    }

    //métodos obrigatórios
    @Override
    public String toString() {
        return "\n" + dataDeCriacao + " | ID: " + id + " >> " +texto;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return id == anotacao.id && Objects.equals(texto, anotacao.texto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, id);
    }
}

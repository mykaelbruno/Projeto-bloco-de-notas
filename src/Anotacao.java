import java.time.LocalDate;
import java.util.Objects;

public class Anotacao {
    private String texto;
    private int id;
    private LocalDate data;
    private boolean deletado;

    public Anotacao (String texto,int id) {
        this.texto = texto;
        this.id = id;
        data = LocalDate.now();
        deletado = false;
    }

    public String getTexto() {
        return texto;
    }

    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isDeletado() {
        return deletado;
    }

    public void deleta () {
        deletado = true;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean ContemTexto(String texto) {
        return this.texto.contains(texto);
    }

    @Override
    public String toString() {
        return "Anotação: " + data + " | " + id + " >> " + texto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anotacao anotacao = (Anotacao) o;
        return id == anotacao.id && Objects.equals(texto, anotacao.texto) && Objects.equals(data, anotacao.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(texto, id, data);
    }
}

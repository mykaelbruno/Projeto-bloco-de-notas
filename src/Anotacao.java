import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class Anotacao {
    private String texto;
    private int id;
    private LocalDate data;
    private boolean deletado;

    public Anotacao (String texto,int id) throws Exception {
        verificaTexto(texto);
        this.texto = texto;
        this.id = id;
        data = LocalDate.now();
        deletado = false;
    }

    private static void verificaTexto(String texto) throws Exception {
        if (texto == null || texto == "" || texto == " ") {
            throw new Exception("o texto não pode ser vazio");
        }
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

    public void setTexto(String texto) throws Exception {
        verificaTexto(texto);
        this.texto = texto;
    }

    public boolean ContemTexto(String texto) throws Exception {
        verificaTexto(texto);
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

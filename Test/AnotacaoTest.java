import com.sun.jdi.event.ExceptionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnotacaoTest {

    Anotacao nota;
    String texto = "Prova de ciências 09/02";
    int id = 56;

    @BeforeEach
    void setUp() throws Exception {
        nota = new Anotacao(texto, id);
    }

    @Test
    void getTexto() {
        String getTexto = nota.getTexto();
        assertEquals(texto, getTexto);
        assertEquals(getTexto, nota.getTexto());
        assertNotNull(nota.getTexto());
    }

    @Test
    void getId() {
        int testId = nota.getId();
        assertEquals(id, testId);
        if (testId <= 0) fail("O id precisa ser maior do que zero");
    }

    @Test
    void getData() {
    }

    @Test
    void isDeletado() {
        assertFalse(nota.isDeletado());
        nota.deleta();
        assertTrue(nota.isDeletado());
    }

    @Test
    void deleta() {
        nota.deleta();
        nota.deleta();
        assertTrue(nota.isDeletado());
    }

    @Test
    void setTexto() throws Exception {
        try {
            nota.setTexto(null);
            nota.setTexto("");
            fail("Um texto inválido foi aceito no set");
        } catch (Exception e){
            //se entrou aqui, ta ok.
        }
    }

    @Test
    void contemTexto() throws Exception {
        assertTrue(nota.ContemTexto(texto));
        nota.setTexto("Almoço na casa da sogra domingo :)");
        assertTrue(nota.ContemTexto("Almoço"));
        try {
            nota.ContemTexto(texto);
            fail("A nota foi modificada e continua retornando true para o texto antigo.");
        } catch (Exception e){}
        try {
            nota.ContemTexto(null);
            fail("A anotação contém um texto nulo");
        } catch (Exception e){}
        try {
            nota.ContemTexto("");
            fail("A anotação contém um texto vazio");
        } catch (Exception e) {}
    }

    @Test
    void testToString() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}
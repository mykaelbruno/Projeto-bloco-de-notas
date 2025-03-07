import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BlocoDeNotasTest {

    BlocoDeNotas bloco;
    String texto = "Volei toda sexta";

    @BeforeEach
    void setUp() {
        bloco = new BlocoDeNotas();
    }

    @Test
    void adicionarAnotacao() throws Exception {
        try {
            bloco.adicionarAnotacao(null);
            fail("O texto não pode ser nulo");
        } catch (Exception e) {}
        Anotacao nota = bloco.adicionarAnotacao(texto);
        assertEquals(nota.getTexto(), texto);
    }

    @Test
    void buscarAnotacao() throws Exception {

        for (int i =0; i<10; i++) {
            bloco.adicionarAnotacao("nota"+(i+1));
        }

        assertEquals(bloco.buscarAnotacao(1).getTexto(), "nota1");
        assertEquals(bloco.buscarAnotacao(3).getTexto(), "nota3");
        assertEquals(bloco.buscarAnotacao(9).getTexto(), "nota9");
        try {
            bloco.buscarAnotacao(56);
            fail("O método buscou um id maior que sua capacidade.");
        } catch (Exception e) {}

        Anotacao x = bloco.buscarAnotacao(3);
        x.deleta();
        try {
            bloco.buscarAnotacao(3);
            fail("O método buscou uma nota que havia sido excluída.");
        } catch (Exception e) {}
    }

    @Test
    void listarAnotacoes() {
    }

    @Test
    void recuperarPorTexto() throws Exception {
        // nn consegui formular uma lógica
    }

    @Test
    void excluirAnotacao() throws Exception {
        bloco.adicionarAnotacao(texto);
        assertFalse(bloco.buscarAnotacao(1).isDeletado());
        boolean b = bloco.excluirAnotacao(1);
        assertTrue(b);
        try {
            assertEquals(b,bloco.buscarAnotacao(1).isDeletado());
            fail("O sistema acessou uma nota deletada.");
        } catch (Exception e) {}
    }

    @Test
    void editarAnotacao() {
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
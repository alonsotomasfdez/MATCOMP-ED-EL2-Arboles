package ParteB_Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoGrafoTest {

    @Test
    void getValor() {
        NodoGrafo nodo = new NodoGrafo("A");

        assertEquals("A", nodo.getValor());
    }

    @Test
    void compareTo() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        assertTrue(a.compareTo(b) < 0);
        assertTrue(b.compareTo(a) > 0);
        assertEquals(0, a.compareTo(new NodoGrafo("A")));
    }

    @Test
    void testEquals() {
        NodoGrafo a1 = new NodoGrafo("A");
        NodoGrafo a2 = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        assertEquals(a1, a2);
        assertNotEquals(a1, b);
    }

    @Test
    void testToString() {
        NodoGrafo nodo = new NodoGrafo("Einstein");

        assertEquals("Einstein", nodo.toString());
    }
}
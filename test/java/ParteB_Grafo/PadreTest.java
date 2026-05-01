package ParteB_Grafo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PadreTest {

    @Test
    void getHijo() {
        NodoGrafo hijo = new NodoGrafo("H");
        NodoGrafo padre = new NodoGrafo("P");

        Padre rel = new Padre(hijo, padre);

        assertEquals(hijo, rel.getHijo());
    }

    @Test
    void getPadre() {
        NodoGrafo hijo = new NodoGrafo("H");
        NodoGrafo padre = new NodoGrafo("P");

        Padre rel = new Padre(hijo, padre);

        assertEquals(padre, rel.getPadre());
    }

    @Test
    void compareTo() {
        NodoGrafo hijo1 = new NodoGrafo("A");
        NodoGrafo hijo2 = new NodoGrafo("B");

        Padre p1 = new Padre(hijo1, new NodoGrafo("X"));
        Padre p2 = new Padre(hijo2, new NodoGrafo("Y"));

        // A < B ⇒ p1 < p2
        assertTrue(p1.compareTo(p2) < 0);
        assertTrue(p2.compareTo(p1) > 0);
        assertEquals(0, p1.compareTo(new Padre(new NodoGrafo("A"), new NodoGrafo("Z"))));
    }
}
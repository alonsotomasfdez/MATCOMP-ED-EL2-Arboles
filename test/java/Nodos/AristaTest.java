package Nodos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AristaTest {

    @Test
    void getOrigen() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        Arista arista = new Arista(a, b, "conecta");

        assertEquals(a, arista.getOrigen());
    }

    @Test
    void getDestino() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        Arista arista = new Arista(a, b, "conecta");

        assertEquals(b, arista.getDestino());
    }

    @Test
    void compareTo() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");
        NodoGrafo c = new NodoGrafo("C");

        Arista arista1 = new Arista(a, b, "x");
        Arista arista2 = new Arista(a, c, "x");

        // b < c, por tanto arista1 < arista2
        assertTrue(arista1.compareTo(arista2) < 0);
    }

    @Test
    void testEquals() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        Arista arista1 = new Arista(a, b, "x");
        Arista arista2 = new Arista(a, b, "x");
        Arista arista3 = new Arista(a, b, "y");

        assertEquals(arista1, arista2);
        assertNotEquals(arista1, arista3);
    }

    @Test
    void getEtiqueta() {
        NodoGrafo a = new NodoGrafo("A");
        NodoGrafo b = new NodoGrafo("B");

        Arista arista = new Arista(a, b, "conecta");

        assertEquals("conecta", arista.getEtiqueta());
    }
}
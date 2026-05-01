import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArbolBinarioDeBusquedaTest {

    private ArbolBinarioDeBusquedaEnteros crearArbolOrdenado() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        for (int i = 0; i <= 5; i++) {
            arbol.add(new Enteros(i));
        }
        return arbol;
    }

    @Test
    void getRaiz() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(0, arbol.getRaiz().getDato().getValor());
    }

    @Test
    void add() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.add(new Enteros(10));
        assertNotNull(arbol.getRaiz());
    }

    @Test
    void getListaPreOrden() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertNotNull(arbol.getListaPreOrden());
        assertEquals(6, arbol.getListaPreOrden().getSize());
    }

    @Test
    void getListaPostOrden() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertNotNull(arbol.getListaPostOrden());
        assertEquals(6, arbol.getListaPostOrden().getSize());
    }

    @Test
    void getListaOrdenCentral() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertNotNull(arbol.getListaOrdenCentral());
        assertEquals(6, arbol.getListaOrdenCentral().getSize());
    }

    @Test
    void getAltura() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(5, arbol.getAltura()); // árbol degenerado
    }

    @Test
    void getCamino() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(6, arbol.getCamino(new Enteros(5)).getSize());
    }

    @Test
    void getGrado() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(1, arbol.getGrado());
    }

    @Test
    void getSubarbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(0, arbol.getSubarbolIzquierda().getSuma());
    }

    @Test
    void getSubarbolDerecha() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertTrue(arbol.getSubarbolDerecha().getSuma() > 0);
    }

    @Test
    void getListaDatosNivel() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertEquals(1, arbol.getListaDatosNivel(0).getSize());
    }

    @Test
    void isArbolHomogeneo() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertFalse(arbol.isArbolHomogeneo());
    }

    @Test
    void isArbolCompleto() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertFalse(arbol.isArbolCompleto());
    }

    @Test
    void isArbolCasiCompleto() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbolOrdenado();
        assertFalse(arbol.isArbolCasiCompleto());
    }
}
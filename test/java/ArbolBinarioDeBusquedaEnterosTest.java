import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ArbolBinarioDeBusquedaEnterosTest {

    private ArbolBinarioDeBusquedaEnteros crearArbol() {
        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();
        arbol.add(new Enteros(2));
        arbol.add(new Enteros(1));
        arbol.add(new Enteros(3));
        return arbol;
    }

    @Test
    void getSuma() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(6, arbol.getSuma());
    }

    @Test
    void getMaximo() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(3, arbol.getMaximo());
    }

    @Test
    void getMinimo() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(1, arbol.getMinimo());
    }

    @Test
    void getMedia() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(2.0, arbol.getMedia());
    }

    @Test
    void getSubarbolIzquierda() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(1, arbol.getSubarbolIzquierda().getSuma());
    }

    @Test
    void getSubarbolDerecha() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(3, arbol.getSubarbolDerecha().getSuma());
    }

    @Test
    void getSumaInorden() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(6, arbol.getSumaInorden());
    }

    @Test
    void getSumaPreorden() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(6, arbol.getSumaPreorden());
    }

    @Test
    void getSumaPostorden() {
        ArbolBinarioDeBusquedaEnteros arbol = crearArbol();
        assertEquals(6, arbol.getSumaPostorden());
    }
}
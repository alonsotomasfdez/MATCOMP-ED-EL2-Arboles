import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import Listas_reutilizadas.Lista;
import Listas_reutilizadas.ListaSimplementeEnlazada;

class NodoTest {

    private Nodo<Enteros> crearNodoBasico() {
        Nodo<Enteros> raiz = new Nodo<>(new Enteros(2));
        raiz.addRecursivo(new Enteros(1));
        raiz.addRecursivo(new Enteros(3));
        return raiz;
    }

    @Test
    void getDato() {
        Nodo<Enteros> nodo = new Nodo<>(new Enteros(5));
        assertEquals(5, nodo.getDato().getValor());
    }

    @Test
    void getIzquierda() {
        Nodo<Enteros> nodo = crearNodoBasico();
        assertNotNull(nodo.getIzquierda());
    }

    @Test
    void getDerecha() {
        Nodo<Enteros> nodo = crearNodoBasico();
        assertNotNull(nodo.getDerecha());
    }

    @Test
    void addRecursivo() {
        Nodo<Enteros> nodo = new Nodo<>(new Enteros(2));
        nodo.addRecursivo(new Enteros(1));
        nodo.addRecursivo(new Enteros(3));

        assertEquals(1, nodo.getIzquierda().getDato().getValor());
        assertEquals(3, nodo.getDerecha().getDato().getValor());
    }

    @Test
    void rellenarPreOrden() {
        Nodo<Enteros> nodo = crearNodoBasico();
        Lista<Enteros> lista = new ListaSimplementeEnlazada<>();

        nodo.rellenarPreOrden(lista);

        assertEquals(3, lista.getSize());
    }

    @Test
    void rellenarPostOrden() {
        Nodo<Enteros> nodo = crearNodoBasico();
        Lista<Enteros> lista = new ListaSimplementeEnlazada<>();

        nodo.rellenarPostOrden(lista);

        assertEquals(3, lista.getSize());
    }

    @Test
    void rellenarOrdenCentral() {
        Nodo<Enteros> nodo = crearNodoBasico();
        Lista<Enteros> lista = new ListaSimplementeEnlazada<>();

        nodo.rellenarOrdenCentral(lista);

        assertEquals(3, lista.getSize());
        // Comprobamos que está ordenado
        ListaSimplementeEnlazada<Enteros> l = (ListaSimplementeEnlazada<Enteros>) lista;
        assertEquals(1, l.get_posicion(0).getValor());
        assertEquals(2, l.get_posicion(1).getValor());
        assertEquals(3, l.get_posicion(2).getValor());
    }

    @Test
    void calcularAltura() {
        Nodo<Enteros> nodo = crearNodoBasico();
        assertEquals(1, nodo.calcularAltura());
    }

    @Test
    void calcularCamino() {
        Nodo<Enteros> nodo = crearNodoBasico();
        Lista<Enteros> lista = new ListaSimplementeEnlazada<>();

        boolean encontrado = nodo.calcularCamino(lista, new Enteros(3));

        assertTrue(encontrado);
        assertEquals(2, lista.getSize());
    }

    @Test
    void calcularGrado() {
        Nodo<Enteros> nodo = crearNodoBasico();
        assertEquals(2, nodo.calcularGrado());
    }

    @Test
    void comprobarNivel() {
        Nodo<Enteros> nodo = crearNodoBasico();
        Lista<Enteros> lista = new ListaSimplementeEnlazada<>();

        nodo.comprobarNivel(1, 0, lista);

        assertEquals(2, lista.getSize());
    }

    @Test
    void comprobarHomogeneo() {
        Nodo<Enteros> nodo = crearNodoBasico();
        assertTrue(nodo.comprobarHomogeneo());
    }

    @Test
    void comprobarCompleto() {
        Nodo<Enteros> nodo = crearNodoBasico();
        int altura = nodo.calcularAltura();

        assertTrue(nodo.comprobarCompleto(altura, 0));
    }
}
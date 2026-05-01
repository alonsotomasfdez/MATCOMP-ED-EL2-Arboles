package ParteB_Grafo;

import Listas_reutilizadas.ListaSimplementeEnlazada;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrafoConocimientoTest {

    @Test
    void agregarNodo() {
        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.agregarNodo("persona:Einstein");
        grafo.agregarNodo("persona:Einstein"); // duplicado

        // no debería duplicar nodos
        assertEquals(1, grafo.caminoMinimo("persona:Einstein", "persona:Einstein").getSize());
    }

    @Test
    void agregarArista() {
        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.agregarArista("A", "conecta", "B");
        grafo.agregarArista("A", "conecta", "B"); // duplicada

        ListaSimplementeEnlazada<NodoGrafo> camino =
                grafo.caminoMinimo("A", "B");

        assertNotNull(camino);
        assertEquals(2, camino.getSize());
    }

    @Test
    void caminoMinimo() {
        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.agregarArista("A", "to", "B");
        grafo.agregarArista("B", "to", "C");
        grafo.agregarArista("A", "to", "C");

        ListaSimplementeEnlazada<NodoGrafo> camino =
                grafo.caminoMinimo("A", "C");

        assertNotNull(camino);

        // camino mínimo A → C directo
        assertEquals(2, camino.getSize());
        assertEquals("A", camino.get_posicion(0).getValor());
        assertEquals("C", camino.get_posicion(1).getValor());
    }

    @Test
    void esDisjunto() {

        GrafoConocimiento grafo = new GrafoConocimiento();

        // grafo conectado
        grafo.agregarArista("A", "x", "B");
        grafo.agregarArista("B", "x", "C");

        assertFalse(grafo.esDisjunto());

        // grafo disjunto (dos componentes)
        GrafoConocimiento grafo2 = new GrafoConocimiento();

        grafo2.agregarArista("A", "x", "B");
        grafo2.agregarArista("C", "x", "D");

        assertTrue(grafo2.esDisjunto());
    }

    @Test
    void cargarDesdeJson() {
        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.cargarDesdeJson("src/Nodos/grafo_no_disjunto.json");

        // debería cargar al menos las relaciones
        ListaSimplementeEnlazada<NodoGrafo> camino =
                grafo.caminoMinimo("persona:Albert Einstein", "lugar:Ulm");

        assertNotNull(camino);
        assertTrue(camino.getSize() >= 2);
    }

    @Test
    void fisicosNobelNacidosComoEinstein() {

        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.cargarDesdeJson("src/Nodos/nobel_fisicos.json");

        ListaSimplementeEnlazada<NodoGrafo> resultado =
                grafo.fisicosNobelNacidosComoEinstein();

        assertNotNull(resultado);

        // Einstein debe excluirse
        for (int i = 0; i < resultado.getSize(); i++) {
            assertNotEquals("persona:Albert Einstein",
                    resultado.get_posicion(i).getValor());
        }
    }

    @Test
    void lugaresNacimientoPremiosNobel() {

        GrafoConocimiento grafo = new GrafoConocimiento();

        grafo.cargarDesdeJson("src/Nodos/nobel_fisicos.json");

        ListaSimplementeEnlazada<NodoGrafo> lugares =
                grafo.lugaresNacimientoPremiosNobel();

        assertNotNull(lugares);

        // debe contener al menos un lugar
        assertTrue(lugares.getSize() > 0);
    }
}
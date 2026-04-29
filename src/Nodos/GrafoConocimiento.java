package Nodos;
import Listas_reutilizadas.ListaSimplementeEnlazada;
import Listas_reutilizadas.MiIterador;
import Listas_reutilizadas.PilaLista;
import Listas_reutilizadas.ColaLista;


public class GrafoConocimiento {

    private ListaSimplementeEnlazada<NodoGrafo> nodos;
    private ListaSimplementeEnlazada<Arista> aristas;

    public GrafoConocimiento() {
        nodos = new ListaSimplementeEnlazada<>();
        aristas = new ListaSimplementeEnlazada<>();
    }

    public void agregarNodo(String valor) {
        NodoGrafo nuevo = new NodoGrafo(valor);

        if (!nodos.contains(nuevo)) {
            nodos.add(nuevo);
        }
    }

    public void agregarArista(String origen, String etiqueta, String destino) {
        agregarNodo(origen);
        agregarNodo(destino);

        NodoGrafo nodoOrigen = buscarNodo(origen);
        NodoGrafo nodoDestino = buscarNodo(destino);

        Arista nueva = new Arista(nodoOrigen, nodoDestino, etiqueta);

        if (!aristas.contains(nueva)) {
            aristas.add(nueva);
        }
    }

    private NodoGrafo buscarNodo(String valor) {
        MiIterador<NodoGrafo> iterador = nodos.getIterador();

        while (iterador.hasNext()) {
            NodoGrafo actual = iterador.next();

            if (actual.getValor().equals(valor)) {
                return actual;
            }
        }

        return null;
    }

    private ListaSimplementeEnlazada<NodoGrafo> obtenerVecinos(NodoGrafo nodo) {
        ListaSimplementeEnlazada<NodoGrafo> vecinos = new ListaSimplementeEnlazada<>();

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getOrigen().equals(nodo)) {
                vecinos.add(arista.getDestino());
            }
        }

        return vecinos;
    }

    public ListaSimplementeEnlazada<NodoGrafo> caminoMinimo(String origen, String destino) {
        NodoGrafo nodoOrigen = buscarNodo(origen);
        NodoGrafo nodoDestino = buscarNodo(destino);

        if (nodoOrigen == null || nodoDestino == null) {
            return null;
        }

        ColaLista<NodoGrafo> cola = new ColaLista<>();
        ListaSimplementeEnlazada<NodoGrafo> visitados = new ListaSimplementeEnlazada<>();
        ListaSimplementeEnlazada<Padre> padres = new ListaSimplementeEnlazada<>();

        cola.enqueue(nodoOrigen);
        visitados.add(nodoOrigen);
        padres.add(new Padre(nodoOrigen, null));

        while (!cola.isEmpty()) {
            NodoGrafo actual = cola.dequeue();

            if (actual.equals(nodoDestino)) {
                return reconstruirCamino(padres, nodoDestino);
            }

            ListaSimplementeEnlazada<NodoGrafo> vecinos = obtenerVecinos(actual);
            MiIterador<NodoGrafo> iteradorVecinos = vecinos.getIterador();

            while (iteradorVecinos.hasNext()) {
                NodoGrafo vecino = iteradorVecinos.next();

                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    padres.add(new Padre(vecino, actual));
                    cola.enqueue(vecino);
                }
            }
        }

        return null;
    }

    private ListaSimplementeEnlazada<NodoGrafo> reconstruirCamino(
            ListaSimplementeEnlazada<Padre> padres,
            NodoGrafo destino) {

        PilaLista<NodoGrafo> pila = new PilaLista<>();
        NodoGrafo actual = destino;

        while (actual != null) {
            pila.push(actual);
            actual = buscarPadre(padres, actual);
        }

        ListaSimplementeEnlazada<NodoGrafo> camino = new ListaSimplementeEnlazada<>();

        while (!pila.isEmpty()) {
            camino.add(pila.pop());
        }

        return camino;
    }

    private NodoGrafo buscarPadre(ListaSimplementeEnlazada<Padre> padres, NodoGrafo hijo) {
        MiIterador<Padre> iterador = padres.getIterador();

        while (iterador.hasNext()) {
            Padre actual = iterador.next();

            if (actual.getHijo().equals(hijo)) {
                return actual.getPadre();
            }
        }

        return null;
    }
}
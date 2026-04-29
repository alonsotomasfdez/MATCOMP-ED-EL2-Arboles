package Nodos;
import Listas_reutilizadas.ListaSimplementeEnlazada;
import Listas_reutilizadas.MiIterador;
import Listas_reutilizadas.PilaLista;
import Listas_reutilizadas.ColaLista;
import java.io.BufferedReader;
import java.io.FileReader;


public class GrafoConocimiento {

    private ListaSimplementeEnlazada<NodoGrafo> nodos;
    private ListaSimplementeEnlazada<Arista> aristas;

    public GrafoConocimiento() {
        nodos = new ListaSimplementeEnlazada<>();
        aristas = new ListaSimplementeEnlazada<>();
    }

    public void agregarNodo(String valor) {//Añade un nodo al grafo solo si no existe ya.
        NodoGrafo nuevo = new NodoGrafo(valor);

        if (!nodos.contains(nuevo)) {
            nodos.add(nuevo);
        }
    }

    public void agregarArista(String origen, String etiqueta, String destino) {//Añade una relación entre dos nodos
        agregarNodo(origen);
        agregarNodo(destino);

        NodoGrafo nodoOrigen = buscarNodo(origen);
        NodoGrafo nodoDestino = buscarNodo(destino);

        Arista nueva = new Arista(nodoOrigen, nodoDestino, etiqueta);

        if (!aristas.contains(nueva)) {
            aristas.add(nueva);
        }
    }

    private NodoGrafo buscarNodo(String valor) {//Busca dentro de la lista de nodos uno con ese valor
        MiIterador<NodoGrafo> iterador = nodos.getIterador();

        while (iterador.hasNext()) {
            NodoGrafo actual = iterador.next();

            if (actual.getValor().equals(valor)) {
                return actual;
            }
        }

        return null;
    }

    private ListaSimplementeEnlazada<NodoGrafo> obtenerVecinos(NodoGrafo nodo) {//Busca todos los nodos a los que puedo llegar desde un nodo concreto
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

    public ListaSimplementeEnlazada<NodoGrafo> caminoMinimo(String origen, String destino) {//La respuesta de la pregunta 1
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

    private ListaSimplementeEnlazada<NodoGrafo> reconstruirCamino(//Cuando BFS llega al destino, el camino está guardado al revés mediante padres, uso entonces una pila para darle la vuelta y devolver
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


    //Pregunta 2:

    //metodo auxiliar:
    private ListaSimplementeEnlazada<NodoGrafo> obtenerVecinosNoDirigido(NodoGrafo nodo) {

        ListaSimplementeEnlazada<NodoGrafo> vecinos = new ListaSimplementeEnlazada<>();

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getOrigen().equals(nodo)) {
                vecinos.add(arista.getDestino());
            }

            if (arista.getDestino().equals(nodo)) {
                vecinos.add(arista.getOrigen());
            }
        }

        return vecinos;
    }

    //Pregunta en si, para saber si es disjunto o no.
    public boolean esDisjunto() {

        if (nodos.isEmpty()) {
            return false;
        }

        ListaSimplementeEnlazada<NodoGrafo> visitados = new ListaSimplementeEnlazada<>();
        ColaLista<NodoGrafo> cola = new ColaLista<>();

        NodoGrafo primerNodo = nodos.get_posicion(0);

        cola.enqueue(primerNodo);
        visitados.add(primerNodo);

        while (!cola.isEmpty()) {

            NodoGrafo actual = cola.dequeue();

            ListaSimplementeEnlazada<NodoGrafo> vecinos = obtenerVecinosNoDirigido(actual);
            MiIterador<NodoGrafo> iterador = vecinos.getIterador();

            while (iterador.hasNext()) {
                NodoGrafo vecino = iterador.next();

                if (!visitados.contains(vecino)) {
                    visitados.add(vecino);
                    cola.enqueue(vecino);
                }
            }
        }

        return visitados.getSize() != nodos.getSize();
    }

    public void cargarDesdeJson(String ruta) {

        String sujeto = null;
        String predicado = null;
        String objeto = null;

        try {
            BufferedReader lector = new BufferedReader(new FileReader(ruta));
            String linea;

            while ((linea = lector.readLine()) != null) {
                linea = linea.trim();

                if (linea.startsWith("\"s\"")) {
                    sujeto = extraerValorJson(linea);
                }

                else if (linea.startsWith("\"p\"")) {
                    predicado = extraerValorJson(linea);
                }

                else if (linea.startsWith("\"o\"")) {
                    objeto = extraerValorJson(linea);
                }

                if (sujeto != null && predicado != null && objeto != null) {
                    agregarArista(sujeto, predicado, objeto);

                    sujeto = null;
                    predicado = null;
                    objeto = null;
                }
            }

            lector.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + ruta);
            e.printStackTrace();
        }
    }

    private String extraerValorJson(String linea) {
        String[] partes = linea.split(": ", 2);//Divide la línea en dos partes, usando como separador ": "
        String valor = partes[1];//Nos quedamos con la segunda parte del texto.

        valor = valor.replace(",", "");//quitas la coma del final
        valor = valor.replace("\"", "");//quitas comillas dobles

        return valor;
    }
}

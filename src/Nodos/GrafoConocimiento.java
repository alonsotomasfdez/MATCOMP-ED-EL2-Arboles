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

    private String extraerValorJson(String linea) {// Metodo más robusto para extraer el valor del JSON sin depender del formato exacto de espacios
        int posicionDosPuntos = linea.indexOf(":");
        String valor = linea.substring(posicionDosPuntos + 1);

        valor = valor.replace(",", "");
        valor = valor.replace("\"", "");
        valor = valor.trim();

        return valor;
    }

    //Pregunta 3

    private boolean tieneRelacion(String sujeto, String predicado, String objeto) {

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getOrigen().getValor().equals(sujeto)
                    && arista.getEtiqueta().equals(predicado)
                    && arista.getDestino().getValor().equals(objeto)) {
                return true;
            }
        }

        return false;
    }

    private NodoGrafo buscarObjeto(String sujeto, String predicado) {

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getOrigen().getValor().equals(sujeto) && arista.getEtiqueta().equals(predicado)) {
                return arista.getDestino();
            }
        }

        return null;
    }
    //Metodo en si que responde a la pregunta 3
    public ListaSimplementeEnlazada<NodoGrafo> fisicosNobelNacidosComoEinstein() {//devuelve una lista de nodos del grafo

        ListaSimplementeEnlazada<NodoGrafo> resultado = new ListaSimplementeEnlazada<>();

        NodoGrafo ciudadEinstein = buscarObjeto("persona:Albert Einstein", "nace_en");

        if (ciudadEinstein == null) {
            return resultado;
        }

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getEtiqueta().equals("nace_en") && arista.getDestino().equals(ciudadEinstein)) {//Comprobamos que hayan nacido en el mismo sitio

                NodoGrafo persona = arista.getOrigen();// convierte el origen en una persona nacida en la misma ciudad que Einstein

                if (!persona.getValor().equals("persona:Albert Einstein") && tieneRelacion(persona.getValor()
                        , "profesion", "profesion:Fisico") && tieneRelacion(persona.getValor()
                        , "premio", "premio:Nobel")) {
                    //Excluimos al propio Einstein y comprobamos la relacion

                    if (!resultado.contains(persona)) {//Antes de añadirlo comprobamos que no este ya en la lista de resultados
                        resultado.add(persona);
                    }
                }
            }
        }

        return resultado;
    }

    //Pregunta 4
    public ListaSimplementeEnlazada<NodoGrafo> lugaresNacimientoPremiosNobel() {

        ListaSimplementeEnlazada<NodoGrafo> lugares = new ListaSimplementeEnlazada<>();

        MiIterador<Arista> iterador = aristas.getIterador();

        while (iterador.hasNext()) {
            Arista arista = iterador.next();

            if (arista.getEtiqueta().equals("premio") && arista.getDestino().getValor().equals("premio:Nobel")) {

                NodoGrafo persona = arista.getOrigen();

                NodoGrafo lugarNacimiento = buscarObjeto(persona.getValor(), "nace_en");

                if (lugarNacimiento != null && !lugares.contains(lugarNacimiento)) {
                    lugares.add(lugarNacimiento);
                }
            }
        }

        return lugares;
    }
}

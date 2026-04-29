package Nodos;

import Listas_reutilizadas.ListaSimplementeEnlazada;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== PREGUNTA 1: CAMINO MINIMO =====");

        GrafoConocimiento grafoCamino = new GrafoConocimiento();

        grafoCamino.agregarArista("persona:Albert Einstein", "nace_en", "lugar:Ulm");
        grafoCamino.agregarArista("lugar:Ulm", "esta_en", "lugar:Alemania");
        grafoCamino.agregarArista("lugar:Alemania", "esta_en", "lugar:Europa");
        grafoCamino.agregarArista("persona:Max Born", "nace_en", "lugar:Ulm");

        ListaSimplementeEnlazada<NodoGrafo> camino =
                grafoCamino.caminoMinimo("persona:Albert Einstein", "lugar:Europa");

        System.out.println("Camino mínimo entre Einstein y Europa:");
        System.out.println(camino);


        System.out.println("===== PREGUNTA 2: GRAFO NO DISJUNTO DESDE JSON =====");

        GrafoConocimiento grafoNoDisjunto = new GrafoConocimiento();
        grafoNoDisjunto.cargarDesdeJson("src/Nodos/grafo_no_disjunto.json");//Le añado src/Nodos/... para que el programa sea capaz de encontrar el archivo, sino fallaba.

        System.out.println("¿El grafo no disjunto es disjunto?");
        System.out.println(grafoNoDisjunto.esDisjunto()); // false


        System.out.println();
        System.out.println("===== PREGUNTA 2: GRAFO DISJUNTO DESDE JSON =====");

        GrafoConocimiento grafoDisjunto = new GrafoConocimiento();
        grafoDisjunto.cargarDesdeJson("src/Nodos/grafo_disjunto.json");

        System.out.println("¿El grafo disjunto es disjunto?");
        System.out.println(grafoDisjunto.esDisjunto()); // true
    }
}
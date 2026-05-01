package ParteA_ArbolBinario;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        // ==================================================
        // INSERTAR 0..128 ORDENADO
        // ==================================================
        for (int i = 0; i <= 128; i++) {
            arbol.add(new Enteros(i));
        }

        System.out.println("===== ARBOL ORDENADO 0..128 =====");

        System.out.println("Inorden: " + arbol.getListaOrdenCentral());
        System.out.println("Preorden: " + arbol.getListaPreOrden());
        System.out.println("Postorden: " + arbol.getListaPostOrden());

        System.out.println("\n===== SUMAS =====");

        System.out.println("Suma total: " + arbol.getSuma());
        System.out.println("Inorden: " + arbol.getSumaInorden());
        System.out.println("Preorden: " + arbol.getSumaPreorden());
        System.out.println("Postorden: " + arbol.getSumaPostorden());

        System.out.println("\n===== EXTRAS =====");


        System.out.println("Media: " + arbol.getMedia());
        System.out.println("Max: " + arbol.getMaximo());
        System.out.println("Min: " + arbol.getMinimo());

        System.out.println("Altura: " + arbol.getAltura());
        System.out.println("Grado: " + arbol.getGrado());

        System.out.println("Completo: " + arbol.isArbolCompleto());
        System.out.println("Casi completo: " + arbol.isArbolCasiCompleto());

        System.out.println("\n===== CAMINO =====");

        System.out.println("Camino a 110: " + arbol.getCamino(new Enteros(110)));
        System.out.println("Longitud camino 110: " + arbol.getCamino(new Enteros(110)).getSize());


        System.out.println("\n===== SUBARBOLES =====");

        int sumaIzqOrdenado = arbol.getSubarbolIzquierda().getSuma();
        int sumaDerOrdenado = arbol.getSubarbolDerecha().getSuma();
        int raizOrdenado = arbol.getRaiz().getDato().getValor();

        System.out.println("Suma total: " + arbol.getSuma());
        System.out.println("Suma izq: " + arbol.getSubarbolIzquierda().getSuma());
        System.out.println("Suma der: " + arbol.getSubarbolDerecha().getSuma());
        System.out.println("Raíz + izq + der: " + (raizOrdenado + sumaIzqOrdenado + sumaDerOrdenado));

        System.out.println("¿Coincide? " +
                (arbol.getSuma() == raizOrdenado + sumaIzqOrdenado + sumaDerOrdenado));


        // ==================================================
        // INSERTAR ALEATORIO
        // ==================================================
        System.out.println("\n===== ARBOL ALEATORIO =====");

        arbol = new ArbolBinarioDeBusquedaEnteros();

        Random r = new Random();
        boolean[] usados = new boolean[129];

        int count = 0;
        while (count < 129) {
            int v = r.nextInt(129);

            if (!usados[v]) {
                usados[v] = true;
                arbol.add(new Enteros(v));
                count++;
            }
        }

        System.out.println("Inorden: " + arbol.getListaOrdenCentral());
        System.out.println("Preorden: " + arbol.getListaPreOrden());
        System.out.println("Postorden: " + arbol.getListaPostOrden());

        System.out.println("\n===== SUMAS =====");

        System.out.println("Suma total: " + arbol.getSuma());
        System.out.println("Inorden: " + arbol.getSumaInorden());
        System.out.println("Preorden: " + arbol.getSumaPreorden());
        System.out.println("Postorden: " + arbol.getSumaPostorden());

        System.out.println("\n===== EXTRAS =====");

        System.out.println("Media: " + arbol.getMedia());
        System.out.println("Max: " + arbol.getMaximo());
        System.out.println("Min: " + arbol.getMinimo());

        System.out.println("Altura: " + arbol.getAltura());
        System.out.println("Grado: " + arbol.getGrado());

        System.out.println("Completo: " + arbol.isArbolCompleto());
        System.out.println("Casi completo: " + arbol.isArbolCasiCompleto());

        System.out.println("\n===== CAMINO =====");

        System.out.println("Camino a 110: " + arbol.getCamino(new Enteros(110)));
        System.out.println("Longitud camino 110: " + arbol.getCamino(new Enteros(110)).getSize());

        System.out.println("\n===== SUBARBOLES =====");

        int sumaIzqAleatorio = arbol.getSubarbolIzquierda().getSuma();
        int sumaDerAleatorio = arbol.getSubarbolDerecha().getSuma();
        int raizAleatorio = arbol.getRaiz().getDato().getValor();

        System.out.println("Suma total: " + arbol.getSuma());
        System.out.println("Suma izq: " + sumaIzqAleatorio);
        System.out.println("Suma der: " + sumaDerAleatorio);
        System.out.println("Raíz + izq + der: " + (raizAleatorio + sumaIzqAleatorio + sumaDerAleatorio));

        System.out.println("¿Coincide? " +
                (arbol.getSuma() == raizAleatorio + sumaIzqAleatorio + sumaDerAleatorio));
    }
}
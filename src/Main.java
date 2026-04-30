import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        System.out.println("==================================");
        System.out.println("TEST 1: INSERCION ORDENADA 0..9");
        System.out.println("==================================");

        for (int i = 0; i <= 9; i++) {
            arbol.add(new Enteros(i));
        }

        ejecutarTests(arbol);

        System.out.println("\n==================================");
        System.out.println("TEST 2: INSERCION ALEATORIA (seed 1)");
        System.out.println("==================================");

        arbol = new ArbolBinarioDeBusquedaEnteros();

        Random r = new Random(1);
        boolean[] usados = new boolean[10];

        int insertados = 0;
        while (insertados < 10) {
            int v = r.nextInt(10);
            if (!usados[v]) {
                usados[v] = true;
                arbol.add(new Enteros(v));
                insertados++;
            }
        }

        ejecutarTests(arbol);
    }

    private static void ejecutarTests(ArbolBinarioDeBusquedaEnteros arbol) {

        System.out.println("Inorden: " + arbol.getListaOrdenCentral());
        System.out.println("Preorden: " + arbol.getListaPreOrden());
        System.out.println("Postorden: " + arbol.getListaPostOrden());

        System.out.println("Altura: " + arbol.getAltura());
        System.out.println("Grado: " + arbol.getGrado());

        System.out.println("Suma: " + arbol.getSuma());
        System.out.println("Media: " + arbol.getMedia());
        System.out.println("Max: " + arbol.getMaximo());
        System.out.println("Min: " + arbol.getMinimo());

        System.out.println("Completo: " + arbol.isArbolCompleto());
        System.out.println("Casi completo: " + arbol.isArbolCasiCompleto());

        System.out.println("Camino a 7: " + arbol.getCamino(new Enteros(7)));

        System.out.println("Raíz subárbol izq: " +
                (arbol.getSubarbolIzquierda().getRaiz() != null
                        ? arbol.getSubarbolIzquierda().getRaiz().getDato()
                        : "null"));

        System.out.println("Raíz subárbol der: " +
                (arbol.getSubarbolDerecha().getRaiz() != null
                        ? arbol.getSubarbolDerecha().getRaiz().getDato()
                        : "null"));
    }
}
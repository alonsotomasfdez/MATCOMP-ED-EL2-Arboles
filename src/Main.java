import java.util.Random;

public class Main {

    public static void main(String[] args) {

        ArbolBinarioDeBusquedaEnteros arbol = new ArbolBinarioDeBusquedaEnteros();

        // --------------------------------------------------
        // 1. INSERTAR DATOS ORDENADOS (0..9)
        // --------------------------------------------------
        System.out.println("=== INSERCION ORDENADA ===");

        for (int i = 0; i <= 9; i++) {
            arbol.add(new Enteros(i));
        }

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

        System.out.println("Subárbol izq raíz: " +
                (arbol.getSubarbolIzquierda().getRaiz() != null
                        ? arbol.getSubarbolIzquierda().getRaiz().getDato()
                        : "null"));

        System.out.println("Subárbol der raíz: " +
                (arbol.getSubarbolDerecha().getRaiz() != null
                        ? arbol.getSubarbolDerecha().getRaiz().getDato()
                        : "null"));

        // --------------------------------------------------
        // 2. INSERTAR ALEATORIO (REINICIAMOS ARBOL)
        // --------------------------------------------------
        System.out.println("\n=== INSERCION ALEATORIA ===");

        arbol = new ArbolBinarioDeBusquedaEnteros();

        Random r = new Random(1); // semilla fija para reproducible
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

        System.out.println("Inorden: " + arbol.getListaOrdenCentral());
        System.out.println("Altura: " + arbol.getAltura());

        System.out.println("Suma: " + arbol.getSuma());
        System.out.println("Media: " + arbol.getMedia());
        System.out.println("Max: " + arbol.getMaximo());
        System.out.println("Min: " + arbol.getMinimo());

        System.out.println("Completo: " + arbol.isArbolCompleto());
        System.out.println("Casi completo: " + arbol.isArbolCasiCompleto());

        System.out.println("Camino a 7: " + arbol.getCamino(new Enteros(7)));
    }
}
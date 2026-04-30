public class ArbolBinarioDeBusquedaEnteros
        extends ArbolBinarioDeBusqueda<Enteros> {

    public int getSuma() {
        return sumar(getRaiz());
    }

    private int sumar(Nodo<Enteros> nodo) {

        if (nodo == null) return 0;

        return nodo.getDato().getValor()
                + sumar(nodo.getIzquierda())
                + sumar(nodo.getDerecha());
    }

    public int getMaximo() {
        if (getRaiz() == null) return Integer.MIN_VALUE;
        return max(getRaiz());
    }

    private int max(Nodo<Enteros> nodo) {

        if (nodo == null) return Integer.MIN_VALUE;

        int actual = nodo.getDato().getValor();

        return Math.max(actual,
                Math.max(max(nodo.getIzquierda()),
                        max(nodo.getDerecha())));
    }

    public int getMinimo() {
        if (getRaiz() == null) return Integer.MAX_VALUE;
        return min(getRaiz());
    }

    private int min(Nodo<Enteros> nodo) {

        if (nodo == null) return Integer.MAX_VALUE;

        int actual = nodo.getDato().getValor();

        return Math.min(actual,
                Math.min(min(nodo.getIzquierda()),
                        min(nodo.getDerecha())));
    }

    public double getMedia() {
        if (getRaiz() == null) return 0;

        int suma = getSuma();
        int total = contar(getRaiz());

        return (double) suma / total;
    }

    private int contar(Nodo<Enteros> nodo) {

        if (nodo == null) return 0;

        return 1 + contar(nodo.getIzquierda())
                + contar(nodo.getDerecha());
    }
}
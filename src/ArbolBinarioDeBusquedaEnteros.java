import Listas_reutilizadas.Lista;
import Listas_reutilizadas.ListaSimplementeEnlazada;

public class ArbolBinarioDeBusquedaEnteros
        extends ArbolBinarioDeBusqueda<Enteros> {

    public ArbolBinarioDeBusquedaEnteros() {
        super();
    }

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

    @Override
    public ArbolBinarioDeBusquedaEnteros getSubarbolIzquierda() {
        if (getRaiz() == null || getRaiz().getIzquierda() == null) {
            return new ArbolBinarioDeBusquedaEnteros();
        }
        return new ArbolBinarioDeBusquedaEnteros(getRaiz().getIzquierda());
    }

    @Override
    public ArbolBinarioDeBusquedaEnteros getSubarbolDerecha() {
        if (getRaiz() == null || getRaiz().getDerecha() == null) {
            return new ArbolBinarioDeBusquedaEnteros();
        }
        return new ArbolBinarioDeBusquedaEnteros(getRaiz().getDerecha());
    }

    public ArbolBinarioDeBusquedaEnteros(Nodo<Enteros> raiz) {
        super(raiz);
    }

    public int getSumaInorden() {
        return sumarLista(getListaOrdenCentral());
    }

    public int getSumaPreorden() {
        return sumarLista(getListaPreOrden());
    }

    public int getSumaPostorden() {
        return sumarLista(getListaPostOrden());
    }

    private int sumarLista(Lista<Enteros> lista) {
        int suma = 0;

        ListaSimplementeEnlazada<Enteros> l =
                (ListaSimplementeEnlazada<Enteros>) lista;

        for (int i = 0; i < l.getSize(); i++) {
            suma += l.get_posicion(i).getValor();
        }

        return suma;
    }
}
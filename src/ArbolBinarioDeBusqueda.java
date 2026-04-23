import java.util.ArrayList;
import java.util.List;


public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

    private Nodo<T> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public ArbolBinarioDeBusqueda(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    //------------------------------------------------------------------

    public void add(T dato) {
        // Si el árbol está vacío, el nuevo dato es la raíz
        if (this.raiz == null) {
            this.raiz = new Nodo<>(dato);
        } else {
            // Si no, iniciamos el add recursivo desde la raíz
            this.raiz.addRecursivo(dato);
        }
    }

    //Para estos 3 metodos creamos una lista vacia y la enviamos cada una con su metodo
    public List<T> getListaPreOrden() {
        List<T> lista = new ArrayList<>();
        if (this.raiz != null) {
            this.raiz.rellenarPreOrden(lista);
        }
        return lista;
    }

    public List<T> getListaPostOrden() {
        List<T> lista = new ArrayList<>();
        if (this.raiz != null) {
            this.raiz.rellenarPostOrden(lista);
        }
        return lista;
    }

    public List<T> getListaOrdenCentral() {
        List<T> lista = new ArrayList<>();
        if (this.raiz != null) {
            this.raiz.rellenarOrdenCentral(lista);
        }
        return lista;
    }

    public int getAltura() {
        if (this.raiz == null) {
            return 0; //Árbol vacío
        }
        return this.raiz.calcularAltura();
    }

    public List<T> getCamino(T datoPedido) {
        List<T> lista = new ArrayList<>();//Nueva lista
        if (this.raiz != null) {
            this.raiz.calcularCamino(lista, datoPedido); //Si hay nodo, calculamos el camino
        }
        return lista;
    }

    public int getGrado() {
        if (this.raiz == null) {
            return 0; //Árbol vacío
        }
        return this.raiz.calcularGrado();
    }

    public ArbolBinarioDeBusqueda<T> getSubarbolIzquierda(){
        // Si el árbol está vacío o no tiene hijo izquierdo, devolvemos un árbol vacío
        if (this.raiz==null || this.raiz.getIzquierda() ==null){
            return new ArbolBinarioDeBusqueda<>();
        }
        return new ArbolBinarioDeBusqueda<>(this.raiz.getIzquierda());
    }

    public ArbolBinarioDeBusqueda<T> getSubarbolDerecha(){
        // Si el árbol está vacío o no tiene hijo derecho, devolvemos un árbol vacío
        if (this.raiz==null || this.raiz.getDerecha() ==null){
            return new ArbolBinarioDeBusqueda<>();
        }
        return new ArbolBinarioDeBusqueda<>(this.raiz.getDerecha());
    }
}

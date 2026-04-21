import java.util.ArrayList;
import java.util.List;


public class ArbolBinarioDeBusqueda<T extends Comparable<T>> {

    private Nodo<T> raiz;

    public ArbolBinarioDeBusqueda() {
        this.raiz = null;
    }

    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

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
        return this.raiz.calcularAltura(); // Delegamos en la raíz
    }

    public List<T> getCamino(T datoPedido) {
        List<T> lista = new ArrayList<>();
        if (this.raiz != null) {
            this.raiz.calcularCamino(lista, datoPedido);
        }
        return lista;
    }
}

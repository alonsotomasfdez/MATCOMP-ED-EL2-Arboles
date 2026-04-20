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
    
    public List<T> getListaOrdenCentral() {
        List<T> lista = new ArrayList<>(); // Creamos la lista vacía
        if (this.raiz != null) {
            // Le pasamos la lista a la raíz para que la rellene por referencia
            this.raiz.rellenarOrdenCentral(lista);
        }
        return lista;
    }

}

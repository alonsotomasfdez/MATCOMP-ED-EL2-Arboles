import Listas_reutilizadas.Lista;
import Listas_reutilizadas.ListaSimplementeEnlazada;
import Listas_reutilizadas.Cola;
import Listas_reutilizadas.ColaLista;


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
    public Lista<T> getListaPreOrden() {
        Lista<T> lista = new ListaSimplementeEnlazada<>();
        if (this.raiz != null) {
            this.raiz.rellenarPreOrden(lista);
        }
        return lista;
    }

    public Lista<T> getListaPostOrden() {
        Lista<T> lista = new ListaSimplementeEnlazada<>();
        if (this.raiz != null) {
            this.raiz.rellenarPostOrden(lista);
        }
        return lista;
    }

    public Lista<T> getListaOrdenCentral() {
        Lista<T> lista = new ListaSimplementeEnlazada<>();
        if (this.raiz != null) {
            this.raiz.rellenarOrdenCentral(lista);
        }
        return lista;
    }

    public int getAltura() {
        if (this.raiz == null) {
            return -1;
        }
        return this.raiz.calcularAltura();
    }

    public Lista<T> getCamino(T datoPedido) {
        Lista<T> lista = new ListaSimplementeEnlazada<>();

        if (this.raiz != null) {
            boolean encontrado = this.raiz.calcularCamino(lista, datoPedido);

            if (!encontrado) {
                return new ListaSimplementeEnlazada<>();
            }
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

    public Lista<T> getListaDatosNivel(int nivelPedido) {

        Lista<T> lista = new ListaSimplementeEnlazada<>();

        if (this.raiz != null && nivelPedido >= 0) {
            this.raiz.comprobarNivel(nivelPedido, 0, lista);
        }

        return lista;
    }

    public boolean isArbolHomogeneo(){
        if (this.raiz==null){
            return true;
        }
        return this.raiz.comprobarHomogeneo();
    }

    public boolean isArbolCompleto() {

        if (raiz == null) return true;

        int altura = getAltura();

        return raiz.comprobarCompleto(altura, 0);
    }

    public boolean isArbolCasiCompleto() {

        if (raiz == null) return true;

        Cola<Nodo<T>> cola = new ColaLista<>();
        cola.enqueue(raiz);

        boolean finNivel = false;

        while (!cola.isEmpty()) {

            Nodo<T> actual = cola.dequeue();

            Nodo<T> izq = actual.getIzquierda();
            Nodo<T> der = actual.getDerecha();

            if (izq != null) {

                if (finNivel) return false;
                cola.enqueue(izq);

            } else {
                finNivel = true;
            }

            if (der != null) {

                if (finNivel) return false;
                cola.enqueue(der);

            } else {
                finNivel = true;
            }
        }

        return true;
    }
}

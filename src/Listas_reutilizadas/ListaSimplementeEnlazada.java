package Listas_reutilizadas;

public class ListaSimplementeEnlazada<T extends Comparable<T>> implements Lista<T> {

    private ElementoSE<T> primero;
    private int size;

    public ListaSimplementeEnlazada() {
        primero = null;
        size = 0;
    }

    public boolean isEmpty() {
        return primero == null;
    }

    public int getSize() {
        return size;
    }
//ESTRUCTURA BASICA DE LA LISTA.

    public void add(T dato) {

        ElementoSE<T> nuevo = new ElementoSE<>(dato); // Crea el nodo que vamos a insertar.

        //Caso lista vacía
        if (isEmpty()) {
            primero = nuevo;

            //Caso lista no vacia.
        } else {

            //Primero recorremos la lista
            ElementoSE<T> actual = primero;


            //Recorrer hasta el último
            while (actual.siguiente != null) { //sigue avanzando mientras haya siguiente
                actual = actual.siguiente;
            }
            //Conectar el nuevo nodo
            actual.siguiente = nuevo;
        }
        //Actualizar tamaño
        size++;
    }
    //CODIGO METODO ADD.

    public T get(T dato) {

        ElementoSE<T> actual = primero; //Esto significa : actual -> primer nodo

        while (actual != null) { //mientras no lleguemos al final

            if (actual.dato.equals(dato)) { //Muy importante usar: equals() y no ==, porque estamos comparando objetos.

                return actual.dato;
            }

            actual = actual.siguiente;
        }

        return null;
    }
    //CODIGO METODO GET.


    public T del(T dato) {

        ElementoSE<T> actual = primero;
        ElementoSE<T> anterior = null;

        while (actual != null) {

            if (actual.dato.equals(dato)) {

                if (anterior == null) {
                    primero = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }

                size--;
                return actual.dato;
            }

            anterior = actual;
            actual = actual.siguiente;
        }

        return null;
    }
    //CODIGO DEL METODO DEL().



    //Cómo se conectan lista e iterador
    public MiIterador<T> getIterador() { //crear un iterador que empiece en el primer nodo
        return new IteradorLSE<>(primero);
    }

    public void insert(int index, T dato) {

        ElementoSE<T> nuevo = new ElementoSE<>(dato); // Crea el nodo que vamos a insertar.

        if (index < 0 || index > size) {
            return;
        }

        if (isEmpty()) {
            primero = nuevo;
            size++;
            return;
        }

        if (index == 0) {
            nuevo.siguiente = primero;
            primero = nuevo;
            size++;
            return;
        }
        ElementoSE<T> actual = primero;
        int i = 0;

        while (i < index - 1) {
            actual = actual.siguiente;
            i++;
        }

        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
        size++;
    }

    public T del_posicion(int index){

        if (index < 0 || index >= size){
            return null;
        }

        if (index == 0){
            T dato = primero.dato;
            primero = primero.siguiente;
            size--;
            return dato;
        }

        ElementoSE<T> actual = primero;
        int i = 0;

        while (i != index-1) {
            actual = actual.siguiente;
            i++;
        }
        T dato = actual.siguiente.dato;
        actual.siguiente = actual.siguiente.siguiente;
        size--;
        return dato;
    }
    public T get_posicion(int index) {

        if (index < 0 || index >= size) {
            return null;
        }

        ElementoSE<T> actual = primero;
        int i = 0;

        while (i != index) {
            actual = actual.siguiente;
            i++;
        }

        return actual.dato;
    }

    public boolean contains(T dato){

        ElementoSE<T> actual = primero;

        while (actual != null){
            if (actual.dato.compareTo(dato) == 0){
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }
    public int indexOf(T dato) {

        ElementoSE<T> actual = primero;
        int i = 0;

        while (actual != null) {

            if (actual.dato.compareTo(dato) == 0) {
                return i;
            }

            actual = actual.siguiente;
            i++;
        }

        return -1;
    }
    public void reverse() {

        ElementoSE<T> anterior = null;
        ElementoSE<T> actual = primero;
        ElementoSE<T> siguiente;

        while (actual != null) {

            siguiente = actual.siguiente;
            actual.siguiente = anterior;
            anterior = actual;
            actual = siguiente;
        }

        primero = anterior;
    }
    @Override
    public String toString() {

        String resultado = "[";
        ElementoSE<T> actual = primero;

        while (actual != null) {

            resultado += actual.dato;

            if (actual.siguiente != null) {
                resultado += ", ";
            }

            actual = actual.siguiente;
        }

        resultado += "]";
        return resultado;
    }

    public void removeDuplicates() {

        ElementoSE<T> actual = primero;//Empieza desde el primer nodo.

        while (actual != null) {//Recorre toda la lista

            ElementoSE<T> anterior = actual;//Se usa para borrar
            ElementoSE<T> buscador = actual.siguiente;// buscador busca duplicados

            while (buscador != null) {

                if (buscador.dato.compareTo(actual.dato) == 0) {//Comprueba si es duplicado

                    anterior.siguiente = buscador.siguiente;//Elimina el nodo duplicado
                    size--;//Actualiza el tamaño

                } else {
                    anterior = buscador;//Solo avanzas anterior si no borras
                }

                buscador = buscador.siguiente; //avanza siempre el recorrido
            }

            actual = actual.siguiente;
        }
    }

    public void removeLast() {

        // Caso 1: lista vacía
        if (isEmpty()) {
            return;
        }

        // Caso 2: un solo elemento
        if (primero.siguiente == null) {
            primero = null;
            size--;
            return;
        }

        // Caso 3: varios elementos → llegar al penúltimo
        ElementoSE<T> actual = primero;

        while (actual.siguiente.siguiente != null) {
            actual = actual.siguiente;
        }

        // eliminar el último
        actual.siguiente = null;
        size--;
    }
}

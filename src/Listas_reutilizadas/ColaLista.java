package Listas_reutilizadas;

public class ColaLista<T extends Comparable<T>> implements Cola<T> {

    private ElementoSE<T> primero;
    private ElementoSE<T> ultimo;
    private int size;

    public ColaLista() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return primero == null;
    }
    @Override
    public void enqueue(T dato) {
        ElementoSE<T> nuevo = new ElementoSE<>(dato);

        if (isEmpty()) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }

        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T dato = primero.dato;
        primero = primero.siguiente;

        if (primero == null) {
            ultimo = null;
        }

        size--;
        return dato;
    }

    @Override
    public T front() {

        if (isEmpty()) {
            return null;
        }

        return primero.dato;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public T back() {
        if (isEmpty()) {
            return null;
        }

        return ultimo.dato;
    }

    @Override
    public void clear() {
        primero = null;
        ultimo = null;
        size = 0;
    }

    @Override
    public boolean contains(T dato) {
        ElementoSE<T> actual = primero;

        while (actual != null) {
            if (actual.dato.compareTo(dato) == 0) {
                return true;
            }
            actual = actual.siguiente;
        }

        return false;
    }

    @Override
    public MiIterador<T> getIterador() {
        return new IteradorLSE<>(primero);
    }

    @Override
    public Cola<T> copy() {
        ColaLista<T> copia = new ColaLista<>();

        ElementoSE<T> actual = primero;

        while (actual != null) {
            copia.enqueue(actual.dato);
            actual = actual.siguiente;
        }

        return copia;
    }
    @Override
    public T max() {
        if (isEmpty()) {
            return null;
        }

        T maximo = primero.dato;
        ElementoSE<T> actual = primero.siguiente;

        while (actual != null) {
            if (actual.dato.compareTo(maximo) > 0) {
                maximo = actual.dato;
            }
            actual = actual.siguiente;
        }

        return maximo;
    }
    public T min(){
        if (isEmpty()){
            return null;
        }

        T minimo = primero.dato;
        ElementoSE<T> actual = primero.siguiente;

        while (actual != null){
            if (actual.dato.compareTo(minimo)<0){
                minimo = actual.dato;
            }
            actual = actual.siguiente;
        }
        return minimo;
    }

    @Override
    public int count(T dato) {
        int contador = 0;
        ElementoSE<T> actual = primero;

        while (actual != null) {
            if (actual.dato.compareTo(dato) == 0) {
                contador++;
            }
            actual = actual.siguiente;
        }
        return contador;
    }

    @Override
    public void enqueueAll(Cola<T> otra) {
        MiIterador<T> it = otra.getIterador();

        while (it.hasNext()) {
            enqueue(it.next());
        }
    }
}

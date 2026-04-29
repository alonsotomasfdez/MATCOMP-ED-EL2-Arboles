package Listas_reutilizadas;

public class IteradorLSE<T> implements MiIterador<T> {

    private ElementoSE<T> actual;

    public IteradorLSE(ElementoSE<T> primero) {
        actual = primero;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public T next() {

        T dato = actual.dato;
        actual = actual.siguiente;

        return dato;
    }

}

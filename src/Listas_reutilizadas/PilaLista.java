package Listas_reutilizadas;

public class PilaLista<T> implements Pila<T> {

    private ElementoSE<T> cima;

    public PilaLista() {
        cima = null;
    }
    @Override
    public boolean isEmpty() {
        return cima == null;
    }

    @Override
    public void push(T dato) {

        ElementoSE<T> nuevo = new ElementoSE<>(dato);

        nuevo.siguiente = cima;

        cima = nuevo;
    }

    @Override
    public T pop() {

        if (isEmpty()) {
            return null;
        }

        T dato = cima.dato;

        cima = cima.siguiente;

        return dato;
    }

    @Override
    public T top() {

        if (isEmpty()) {
            return null;
        }

        return cima.dato;
    }
    public int tamano() {

        int contador = 0;
        ElementoSE<T> actual = cima;

        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }

        return contador;
    }
    public void clear() {
        cima = null;
    }
    public boolean contains(T dato) {

        ElementoSE<T> actual = cima;

        while (actual != null) {

            if (actual.dato.equals(dato)) {
                return true;
            }

            actual = actual.siguiente;
        }

        return false;
    }

}
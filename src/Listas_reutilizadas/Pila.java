package Listas_reutilizadas;

public interface Pila<T> {

    void push(T dato);

    T pop();

    T top();

    boolean isEmpty();

    int tamano();

    void clear();

    boolean contains(T dato);


}
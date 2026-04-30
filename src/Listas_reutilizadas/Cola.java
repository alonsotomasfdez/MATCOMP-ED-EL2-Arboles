package Listas_reutilizadas;

public interface Cola<T> {
    void enqueue(T dato);

    T dequeue();

    T front();

    boolean isEmpty();

    int size();

    T back();

    void clear();

    boolean contains(T dato);

    MiIterador<T> getIterador();

    Cola<T> copy();

    int count(T dato);

    void enqueueAll(Cola<T> otra);

}
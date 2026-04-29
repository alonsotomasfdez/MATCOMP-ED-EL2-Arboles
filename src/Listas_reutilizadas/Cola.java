package Listas_reutilizadas;

public interface Cola<T extends Comparable<T>> {
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

    T max();

    T min();

    int count(T dato);

    void enqueueAll(Cola<T> otra);

}
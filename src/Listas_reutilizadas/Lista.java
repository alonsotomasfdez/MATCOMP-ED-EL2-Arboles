package Listas_reutilizadas;

public interface Lista<T extends Comparable<T>> {

    void add(T dato);

    T get(T dato);

    T del(T dato);

    boolean isEmpty();

    int getSize();

    MiIterador<T> getIterador();

    void insert(int index, T dato);
}

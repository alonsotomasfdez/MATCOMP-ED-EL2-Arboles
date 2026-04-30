package Listas_reutilizadas;

public interface Lista<T> {

    void add(T dato);

    T get(T dato);

    T del(T dato);

    T del_posicion(int index);

    boolean isEmpty();

    int getSize();

    MiIterador<T> getIterador();

    void insert(int index, T dato);
}

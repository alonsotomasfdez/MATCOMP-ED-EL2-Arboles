public class Enteros implements Comparable<Enteros> {

    private int valor;

    public Enteros(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    // Permite ordenar en el árbol (BST)
    @Override
    public int compareTo(Enteros otro) {
        return Integer.compare(this.valor, otro.valor);
    }

    // Permite sumar dos objetos Enteros
    public Enteros sumar(Enteros otro) {
        return new Enteros(this.valor + otro.valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}

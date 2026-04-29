package Nodos;

public class Padre implements Comparable<Padre> {

    private NodoGrafo hijo;
    private NodoGrafo padre;

    public Padre(NodoGrafo hijo, NodoGrafo padre) {
        this.hijo = hijo;
        this.padre = padre;
    }

    public NodoGrafo getHijo() {
        return hijo;
    }

    public NodoGrafo getPadre() {
        return padre;
    }

    @Override
    public int compareTo(Padre otro) {
        return this.hijo.compareTo(otro.hijo);
    }
}
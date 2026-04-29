package Nodos;

public class Arista implements Comparable<Arista> {

    private NodoGrafo origen;
    private NodoGrafo destino;
    private String etiqueta;

    public Arista(NodoGrafo origen, NodoGrafo destino, String etiqueta) {
        this.origen = origen;
        this.destino = destino;
        this.etiqueta = etiqueta;
    }

    public NodoGrafo getOrigen() {
        return origen;
    }

    public NodoGrafo getDestino() {
        return destino;
    }

    @Override
    public int compareTo(Arista otra) {
        int comparable = this.origen.compareTo(otra.origen);
        if (comparable != 0) return comparable;

        comparable = this.destino.compareTo(otra.destino);
        if (comparable != 0) return comparable;

        return this.etiqueta.compareTo(otra.etiqueta);
    }
    public String getEtiqueta() {
        return etiqueta;
    }
}
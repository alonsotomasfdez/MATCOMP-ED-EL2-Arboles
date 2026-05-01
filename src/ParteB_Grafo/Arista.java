package ParteB_Grafo;

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
    @Override
    public boolean equals(Object objeto) { // Sobrescribimos equals para poder detectar aristas duplicadas correctamente al usar contains
        if (objeto instanceof Arista) {
            Arista otra = (Arista) objeto;

            return this.origen.equals(otra.origen)
                    && this.destino.equals(otra.destino)
                    && this.etiqueta.equals(otra.etiqueta);
        }

        return false;
    }
    public String getEtiqueta() {
        return etiqueta;
    }
}
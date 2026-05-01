package ParteB_Grafo;

public class NodoGrafo implements Comparable<NodoGrafo> {

    private String valor;

    public NodoGrafo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public int compareTo(NodoGrafo otro) {
        return this.valor.compareTo(otro.valor);
    }

    @Override
    public boolean equals(Object objeto) //recibe un objeto, necesitas comprobar si puedes tratar este objeto como un NodoGrafo
    {
        if (objeto instanceof NodoGrafo) //Comprueba el tipo
        {
            NodoGrafo otroObjeto = (NodoGrafo) objeto;// Haces el casting, esto convierte el Object en NodoGrafo
            return this.valor.equals(otroObjeto.valor);
        }
        return false;
    }

    @Override
    public String toString() {
        return valor;
    }
}
public class Nodo<T extends Comparable<T>> {

    private T dato;
    private Nodo<T> izquierda;
    private Nodo<T> derecha;

    public Nodo(T dato){
        this.dato=dato;
        izquierda =null;
        derecha =null;}

    public T getDato() {return dato;}
    public void setDato(T dato) {this.dato = dato;}

    public Nodo<T> getIzquierda() {return izquierda;}
    public void setIzquierda(Nodo<T> izquierda) {this.izquierda = izquierda;}

    public Nodo<T> getDerecha() {return derecha;}
    public void setDerecha(Nodo<T> derecha) {this.derecha = derecha;}

    //--------------------------------------------------------------------------------------------------------------------

    protected void addRecursivo(Nodo<T> actual, T dato) {

        //Si el actual es mayor que el dato, el dato se va a la izquierda
        if (actual.getDato().compareTo(dato) > 0) {
            //Comprobamos si existe hijo izquierdo
            if (actual.izquierda == null) {
                actual.izquierda.setDato(dato);
            } else {addRecursivo(izquierda,dato);}}

        //Si el actual es menor que el dato, el dato se va a la derecha
        else if (actual.getDato().compareTo(dato) < 0){
            //Comprobamos si existe hijo derecho
            if (actual.derecha == null) {
                actual.derecha.setDato(dato);
            } else {addRecursivo(derecha,dato);}}

        }
    }


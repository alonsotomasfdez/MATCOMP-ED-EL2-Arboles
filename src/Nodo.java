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

    protected void addRecursivo(T nuevoDato) {

        //Si el dato es mayor que el nuevoDato, el dato se va a la izquierda
        if (this.dato.compareTo(nuevoDato) > 0) {
            //Si no existe hijo izquierdo, establecemos el nuevo nodo
            if (this.izquierda == null) {
                this.izquierda = new Nodo<>(nuevoDato);
            } else {this.izquierda.addRecursivo(nuevoDato);}}



        //Si el actual es menor que el dato, el dato se va a la derecha
        else if (this.dato.compareTo(nuevoDato) < 0){
            //Si no existe hijo derecho, establecemos el nuevo nodo
            if (this.derecha==null){
                this.derecha = new Nodo<>(nuevoDato);
            }
            else {this.derecha.addRecursivo(nuevoDato);}}

        }
    }


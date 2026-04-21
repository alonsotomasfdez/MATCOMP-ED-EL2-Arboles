import java.util.List;


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

    //Para estos 3 métodos de manera recursiva vamos accediendo a los hijos
    //Como cada metodo de relleno es distinto se modifica el orden de las instrucciones

    //El pre orden es raíz-izquierda-derecha
    protected void rellenarPreOrden(List<T> lista) {
        //Añadimos el dato de la raíz
        lista.add(this.dato);
        //Si hay hijo izquierdo, lo tomamos como nueva raíz y volvemos a llamar al metodo
        if (this.izquierda!=null){this.izquierda.rellenarPreOrden(lista);}
        //Si hay hijo derecho, lo tomamos como nueva raíz y volvemos a llamar al metodo
        if (this.derecha!=null){this.derecha.rellenarPreOrden(lista);}
    }

    //El post orden es izquierda-derecha-raíz
    protected void rellenarPostOrden(List<T> lista) {
        if (this.izquierda!=null){this.izquierda.rellenarPostOrden(lista);}
        if (this.derecha!=null){this.derecha.rellenarPostOrden(lista);}
        lista.add(this.dato);
    }

    //El orden central es izquierda-raíz-derecha (devuelve la lista ordenada de menor a mayor)
    protected void rellenarOrdenCentral(List<T> lista) {
        if (this.izquierda!=null){this.izquierda.rellenarOrdenCentral(lista);}
        lista.add(this.dato);
        if (this.derecha!=null){this.derecha.rellenarOrdenCentral(lista);}
    }

    protected int calcularAltura() {
        int alturaIzquierda = 0;
        int alturaDerecha = 0;

        //Si hay hijo izquierdo, calculamos la altura de esa rama
        if (this.izquierda != null) {alturaIzquierda = this.izquierda.calcularAltura();}
        //Si hay hijo derecho, calculamos la altura de esa rama
        if (this.derecha != null) {alturaDerecha = this.derecha.calcularAltura();}

        //Cogemos la rama con más altura y sumamos 1 por el nodo actual
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    protected void calcularCamino(List<T> lista, T datoPedido) {
        lista.add(this.dato);
        if (this.dato.compareTo(datoPedido)>0) {
            if (this.izquierda != null) {this.izquierda.calcularCamino(lista, datoPedido);}
        }
        if (this.dato.compareTo(datoPedido)<0) {
            if (this.derecha != null) {this.derecha.calcularCamino(lista, datoPedido);}
        }
    }
}




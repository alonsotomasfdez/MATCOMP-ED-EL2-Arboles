import Listas_reutilizadas.Lista;
import Listas_reutilizadas.ListaSimplementeEnlazada;

public class Nodo<T extends Comparable<T>> {

    private T dato;
    private Nodo<T> izquierda;
    private Nodo<T> derecha;

    public Nodo(T dato){
        this.dato=dato;
        izquierda =null;
        derecha =null;}

    public T getDato() {return dato;}
    public Nodo<T> getIzquierda() {return izquierda;}
    public Nodo<T> getDerecha() {return derecha;}

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
        //Hemos tomado que cuando el dato es igual no se añade y ya
        }

    //Para estos 3 métodos de manera recursiva vamos accediendo a los hijos
    //Como cada metodo de relleno es distinto se modifica el orden de las instrucciones

    //El pre orden es raíz-izquierda-derecha
    protected void rellenarPreOrden(Lista<T> lista) {
        //Añadimos el dato de la raíz
        lista.add(this.dato);
        //Si hay hijo izquierdo, lo tomamos como nueva raíz y volvemos a llamar al metodo
        if (this.izquierda!=null){this.izquierda.rellenarPreOrden(lista);}
        //Si hay hijo derecho, lo tomamos como nueva raíz y volvemos a llamar al metodo
        if (this.derecha!=null){this.derecha.rellenarPreOrden(lista);}
    }

    //El post orden es izquierda-derecha-raíz
    protected void rellenarPostOrden(Lista<T> lista) {
        if (this.izquierda!=null){this.izquierda.rellenarPostOrden(lista);}
        if (this.derecha!=null){this.derecha.rellenarPostOrden(lista);}
        lista.add(this.dato);
    }

    //El orden central es izquierda-raíz-derecha (devuelve la lista ordenada de menor a mayor)
    protected void rellenarOrdenCentral(Lista<T> lista) {
        if (this.izquierda!=null){this.izquierda.rellenarOrdenCentral(lista);}
        lista.add(this.dato);
        if (this.derecha!=null){this.derecha.rellenarOrdenCentral(lista);}
    }

    protected int calcularAltura() {

        int alturaIzquierda = -1;
        int alturaDerecha = -1;

        if (this.izquierda != null) {
            alturaIzquierda = this.izquierda.calcularAltura();
        }

        if (this.derecha != null) {
            alturaDerecha = this.derecha.calcularAltura();
        }

        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }

    protected boolean calcularCamino(Lista<T> lista, T datoPedido) {

        // Añadimos el nodo actual al camino
        lista.add(this.dato);

        int comparacion = this.dato.compareTo(datoPedido);

        // Caso 1: hemos encontrado el dato
        if (comparacion == 0) {
            return true;
        }

        // Caso 2: buscamos por la izquierda
        if (comparacion > 0 && this.izquierda != null) {
            if (this.izquierda.calcularCamino(lista, datoPedido)) {
                return true;
            }
        }

        // Caso 3: buscamos por la derecha
        if (comparacion < 0 && this.derecha != null) {
            if (this.derecha.calcularCamino(lista, datoPedido)) {
                return true;
            }
        }

        // Caso 4: no está en este camino → eliminamos el nodo añadido
        ((ListaSimplementeEnlazada<T>) lista).removeLast();

        return false;
    }

    protected int calcularGrado(){
        int grado=0;

        //Compruebo si tiene 2 hijos, 2 es el grado máximo, si llego ahí se para
        if (this.izquierda!=null){grado++;}
        if (this.derecha!=null){grado++;}
        if (grado==2){return 2;}

        //Ahora bien si el grado no es 2:
        //Si el hijo que existe es el izquierdo, compruebo el grado de este
        int gradoIzquierda=0;
        if (this.izquierda!=null){gradoIzquierda=this.izquierda.calcularGrado();}
        //Si el hijo que existe es el derecho, compruebo el grado de este
        int gradoDerecha=0;
        if (this.derecha!=null){gradoDerecha=this.derecha.calcularGrado();}

        //Tomo el valor mayor de los 3 valores
        return Math.max(Math.max(gradoIzquierda,gradoDerecha),grado);
    }

    protected void comprobarNivel(int nivelPedido, int nivelActual, Lista<T> lista){
        //Caso base, caundo llegamos al nivel pedido
        if (nivelPedido==nivelActual){
            lista.add(this.dato);
            return;
        }

        if (this.izquierda!=null){
            this.izquierda.comprobarNivel(nivelPedido,nivelActual+1,lista);
        }

        if (this.derecha!=null){
            this.derecha.comprobarNivel(nivelPedido,nivelActual+1,lista);
        }

    }

    protected boolean comprobarHomogeneo(){
        int hijos=0;
        if (this.izquierda!=null){hijos++;}
        if (this.derecha!=null){hijos++;}

        //Si solo tiene un hijo ya devolvemos el false
        if (hijos==1){return false;}
        //Las hojas no tienen hijos (son las unicas que no son grado 2)
        if (hijos==0){return true;}
        //Ahora bien, con dos hijos, comprobamos cada una de las ramas
        return this.derecha.comprobarHomogeneo() && this.izquierda.comprobarHomogeneo();

    }

    protected boolean comprobarCompleto(int alturaArbol, int nivelActual) {

        // Si es hoja → comprobamos nivel
        if (this.izquierda == null && this.derecha == null) {
            return nivelActual == alturaArbol;
        }

        boolean izquierdaOk = true;
        boolean derechaOk = true;

        if (this.izquierda != null) {
            izquierdaOk = this.izquierda.comprobarCompleto(alturaArbol, nivelActual + 1);
        }

        if (this.derecha != null) {
            derechaOk = this.derecha.comprobarCompleto(alturaArbol, nivelActual + 1);
        }

        return izquierdaOk && derechaOk;
    }
}
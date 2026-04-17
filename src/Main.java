import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Nodo<Integer> nodoraiz= new Nodo<>(5);
        ArbolBinarioDeBusqueda<Integer> arbol1 = new ArbolBinarioDeBusqueda<>(nodoraiz);

        arbol1.add(10);
        arbol1.add(2);
        arbol1.add(3);

        //System.out.println(nodoraiz.getRaiz().getDato());
        System.out.println(arbol1.getRaiz().getIzquierda().getDerecha().getDato()); //3

    }
}
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        Nodo<Integer> nodoraiz= new Nodo<>(5);
        ArbolBinarioDeBusqueda<Integer> arbol1 = new ArbolBinarioDeBusqueda<>(nodoraiz);

        Nodo<Integer> nodo1= new Nodo<>(10);
        arbol1.add(10);

        //System.out.println(nodoraiz.getRaiz().getDato());
        System.out.println(arbol1.getRaiz().getDato());

    }
}
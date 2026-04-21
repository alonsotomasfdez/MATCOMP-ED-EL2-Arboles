import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        //Prueba add()
        ArbolBinarioDeBusqueda<Integer> arbol1 = new ArbolBinarioDeBusqueda<>();
        arbol1.add(10);
        arbol1.add(2);
        arbol1.add(3);

        //System.out.println(nodoraiz.getRaiz().getDato());
        System.out.println(arbol1.getRaiz().getIzquierda().getDerecha().getDato()); //3


        //Prueba listas
        ArbolBinarioDeBusqueda<Integer> arbol2 = new ArbolBinarioDeBusqueda<>();
        arbol2.add(8);
        arbol2.add(3);
        arbol2.add(10);
        arbol2.add(1);
        arbol2.add(6);
        arbol2.add(14);
        arbol2.add(4);
        arbol2.add(7);

        System.out.println(arbol2.getListaPreOrden());
        System.out.println(arbol2.getListaPostOrden());
        System.out.println(arbol2.getListaOrdenCentral());

        //Prueba altura usando arbol 2 (que es de altura 4)
        System.out.println("La altura de arbol2 es "+arbol2.getAltura());

        //Prueba camino al 4 en arbol 2 (que es [8,3,6,4]
        System.out.println("El camino para llegar al 4 en arbol2 es "+arbol2.getCamino(4));
    }
}

public class Main {
    public static void main(String[] args) {

        //Prueba add()
        /*
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

        //Prueba altura usando arbol2 (que es de altura 4)
        System.out.println("La altura de arbol2 es "+arbol2.getAltura());

        //Prueba camino al 4 en arbol2 (que es [8,3,6,4]
        System.out.println("El camino para llegar al 4 en arbol2 es "+arbol2.getCamino(4));

        //Prueba calculo de grado
        ArbolBinarioDeBusqueda<Integer> arbol3 = new ArbolBinarioDeBusqueda<>();
        arbol3.add(9);
        arbol3.add(8);
        arbol3.add(6);
        arbol3.add(5);
        System.out.println("El grado de arbol3 es "+arbol3.getGrado());//Grado 1
        arbol3.add(7);
        System.out.println("El grado de arbol3 ahora es "+arbol3.getGrado());//Grado 2

        //Prueba subarboles
        arbol3.add(10);
        arbol3.add(11);
        System.out.println(arbol3.getSubarbolDerecha().getRaiz().getDato());
        System.out.println(arbol3.getSubarbolIzquierda().getRaiz().getDato());

        //Prueba getListaNivelDato
        ArbolBinarioDeBusqueda<Integer> arbol4 = new ArbolBinarioDeBusqueda<>();
        arbol4.add(19);//Nivel 1
        arbol4.add(13);//Nivel 2
        arbol4.add(15);//Nivel 3
        arbol4.add(5);//Nivel 3
        arbol4.add(25);//Nivel 2
        arbol4.add(21);//Nivel 3
        arbol4.add(30);//Nivel 3
        System.out.println(arbol4.getListaDatosNivel(2));
        System.out.println(arbol4.getListaDatosNivel(3));

        //Prueba homogeneo
        System.out.println("arbol4 es homogéneo: "+arbol4.isArbolHomogeneo());//True
        arbol4.add(1);
        arbol4.add(7);
        System.out.println("arbol4 es homogéneo: "+arbol4.isArbolHomogeneo());//True
        arbol4.add(50);
        System.out.println("arbol4 es homogéneo: "+arbol4.isArbolHomogeneo());//False

        */

        //prueba getCamino
        //test1
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.add(8);
        arbol.add(3);
        arbol.add(10);
        arbol.add(1);
        arbol.add(6);
        arbol.add(4);
        arbol.add(7);

        System.out.println("Camino a 4: " + arbol.getCamino(4));

        System.out.println("Camino a 8: " + arbol.getCamino(8));

        System.out.println("Camino a 7: " + arbol.getCamino(7));

        System.out.println("Camino a 99: " + arbol.getCamino(99));

        ArbolBinarioDeBusqueda<Integer> arbolVacio = new ArbolBinarioDeBusqueda<>();
        System.out.println("Camino en árbol vacío: " + arbolVacio.getCamino(5));
    }
}
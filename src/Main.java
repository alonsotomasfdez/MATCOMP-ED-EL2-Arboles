
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

        //prueba getCamino
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


         */
        // isArbolCompleto
        System.out.println("===== TEST ARBOLES =====");

        // =============================
        // 1. ÁRBOL COMPLETO PERFECTO
        // =============================
        ArbolBinarioDeBusqueda<Integer> completo = new ArbolBinarioDeBusqueda<>();

        completo.add(8);
        completo.add(4);
        completo.add(12);
        completo.add(2);
        completo.add(6);
        completo.add(10);
        completo.add(14);

        System.out.println("\n--- ARBOL COMPLETO PERFECTO ---");
        System.out.println("InOrden: " + completo.getListaOrdenCentral());
        System.out.println("Altura: " + completo.getAltura());
        System.out.println("isCompleto: " + completo.isArbolCompleto()); // true
        System.out.println("isCasiCompleto: " + completo.isArbolCasiCompleto()); // true


        // =============================
        // 2. ÁRBOL CASI COMPLETO
        // =============================
        ArbolBinarioDeBusqueda<Integer> casi = new ArbolBinarioDeBusqueda<>();

        casi.add(8);
        casi.add(4);
        casi.add(12);
        casi.add(2);
        casi.add(6);
        casi.add(10); // falta el 14 → sigue siendo casi completo

        System.out.println("\n--- ARBOL CASI COMPLETO ---");
        System.out.println("InOrden: " + casi.getListaOrdenCentral());
        System.out.println("isCompleto: " + casi.isArbolCompleto()); // false
        System.out.println("isCasiCompleto: " + casi.isArbolCasiCompleto()); // true


        // =============================
        // 3. ÁRBOL NO CASI COMPLETO
        // =============================
        ArbolBinarioDeBusqueda<Integer> noCasi = new ArbolBinarioDeBusqueda<>();

        noCasi.add(8);
        noCasi.add(4);
        noCasi.add(12);
        noCasi.add(2);
        noCasi.add(1); // rompe estructura

        System.out.println("\n--- ARBOL NO CASI COMPLETO ---");
        System.out.println("InOrden: " + noCasi.getListaOrdenCentral());
        System.out.println("isCasiCompleto: " + noCasi.isArbolCasiCompleto()); // false


        // =============================
        // 4. ÁRBOL VACÍO
        // =============================
        ArbolBinarioDeBusqueda<Integer> vacio = new ArbolBinarioDeBusqueda<>();

        System.out.println("\n--- ARBOL VACIO ---");
        System.out.println("isCompleto: " + vacio.isArbolCompleto()); // true
        System.out.println("isCasiCompleto: " + vacio.isArbolCasiCompleto()); // true

    }


}
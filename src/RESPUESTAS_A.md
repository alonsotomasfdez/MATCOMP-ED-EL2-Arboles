3
    iii. El resultado de la suma es el mismo para los tres casos.
    iv. Es de nuevo el mismo resultado, porque da lo mismo sumar todo el arbol a la vez que primero una rama y despues otra, ademas esta degenerado, todo el valor lo tiene la rama derecha.
    v. La altura del arbol es 128, porque el arbol esta completamente desbalanceado hacia la derecha, cada nodo tiene solo hijo derecho.
    vi. El camino para llegar a 110, es desde 0-110, por la rama derecha, su longitud es 111 nodos, es igual al valor+1 porque es una cadena lineal.

4
    iii. De nuevo la suma sigue siendo la misma de las 3 maneras, 8256.
    iv. Coincide porque cualquier nodo divide el árbol en: subárbol izquierdo, subárbol derecho y la raíz. Como no hay elementos repetidos ni pérdidas, todos los nodos están incluidos exactamente una vez es 8256.
    v. La altura es 13, porque el árbol está relativamente equilibrado en promedio y no se degenera como en el caso ordenado, pero cada vez cambia y es distinta o no.
    vi. El camino para llegar a 110 es diferente cada vez que lo ejecutes y normalmente mas corto que el arbol ordenado, en este caso de longitud 9.


La principal diferencia está en la forma del árbol. En la inserción ordenada el árbol se vuelve totalmente desbalanceado, con forma de lista, lo que provoca una altura muy grande (128) y caminos muy largos. En cambio, en la inserción aleatoria el árbol se distribuye de forma más equilibrada, reduciendo mucho la altura (13) y acortando los caminos, aunque los valores globales como suma, media, mínimo y máximo se mantienen iguales en ambos casos.

En el caso ordenado no hay cambios entre ejecuciones porque el orden de inserción siempre es el mismo. En el caso aleatorio, el orden de inserción cambia en cada ejecución, por lo que cambia la estructura del árbol (altura, caminos, forma). Sin embargo, los valores globales como suma, media, mínimo y máximo siempre se mantienen iguales porque los elementos son los mismos.
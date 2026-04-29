PREGUNTA 2:Dado un archivo de datos que se carga en el grafo, ¿genera un grafo disjunto?  
Cree dos archivos que generen cada opción posible y compruebe en el código.

Para comprobar si un archivo genera un grafo disjunto, 
se carga el contenido del archivo en el grafo y se realiza un recorrido BFS desde uno de sus nodos.

Durante el recorrido se almacenan los nodos visitados. 
Si al finalizar el BFS el número de nodos visitados es menor que el número total de nodos del grafo, 
significa que existen nodos que no son alcanzables desde la componente inicial. 
Por tanto, el grafo es disjunto.

Para esta comprobación se considera el grafo como no dirigido, 
ya que el objetivo es estudiar si las entidades están conectadas entre sí, 
independientemente del sentido de la relación RDF.
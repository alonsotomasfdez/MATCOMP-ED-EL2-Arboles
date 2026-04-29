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


PREGUNTA 4: ¿Qué caminos necesita recorrer para que su respuesta fuese correcta?

Para que la respuesta sea correcta, 
es necesario seguir primero las relaciones que identifican a las personas que han recibido un premio Nobel, 
y a partir de esas personas recorrer la relación que indica su lugar de nacimiento.

Es decir, no se debe partir directamente de los lugares, 
sino primero seleccionar a las personas que cumplen la condición de ser premios Nobel y, 
después, obtener sus lugares de nacimiento.

PREGUNTA 5: ¿Qué tipos de nodos tiene el grafo?

El grafo está formado por distintos tipos de nodos que representan entidades del dominio del problema.
Los tipos de nodos son:
- Persona: representa individuos, como científicos o premios Nobel.
- Lugar: representa ciudades .
- Premio: representa distinciones, como el premio Nobel.
- Profesión: representa la actividad profesional que realiza una persona, como físico.

Estos tipos permiten estructurar la información y establecer relaciones entre las distintas entidades del grafo.

PREGUNTA 6: ¿Qué es una ontología? ¿Qué relación tiene con los grafos? 
¿Podríamos crear una ontología para nuestro problema? ¿Qué haríamos con ella?

Una ontología es una forma de organizar y definir el conocimiento de un dominio, 
estableciendo los tipos de entidades que existen y las relaciones que pueden darse entre ellas.

En el contexto de los grafos, una ontología sirve como base para estructurar la información, 
ya que define qué tipos de nodos hay (por ejemplo, persona, lugar o premio) y qué relaciones pueden existir entre ellos 
(como nace_en o premio). El grafo sería la representación concreta de esa ontología aplicada a datos reales.

En este problema sí es posible crear una ontología. 
En ella se definirían las entidades principales, como personas, lugares, premios y profesiones, 
así como las relaciones entre ellas.

Esta ontología permitiría dar coherencia al grafo, 
evitar inconsistencias y facilitar la realización de consultas, 
ya que se sabría de antemano cómo están organizados los datos y qué tipo de relaciones pueden existir entre ellos.
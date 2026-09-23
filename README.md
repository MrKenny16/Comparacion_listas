# Práctica: ArrayList vs. LinkedList en Java Collections Framework

## 1. Tiempos Obtenidos (Benchmarks)

**Benchmark de acceso:**

| Ejecución | ArrayList | LinkedList |

| 1 (get)   | de 2 a 3 ms  | 3,500 ms   |

| 2 (for-each)| de 2 a 3 ms| de 3 a 4 ms   |

**Inserciones y Eliminaciones:**
| Operación | ArrayList | LinkedList |

| Insertar al inicio (50k) | de 180 a 190 ms | de 2 a 3 ms |

| Insertar al final (100k) |    2 ms   |   3 ms |

| Eliminar al inicio (50k) | 175 ms | de 1 a 2 ms |

## 2. Comparación entre acceso mediante get(i) y for-each
Al utilizar `get(i)`, el acceso en LinkedList es extremadamente lento porque su complejidad es O(n); debe recorrer los nodos desde el principio en cada iteración. Al cambiar a `for-each`, el rendimiento mejora drásticamente ya que utiliza un iterador interno que avanza nodo por nodo sin reiniciar la búsqueda, manteniendo un tiempo constante entre pasos.

## 3. Tabla Comparativa Final

| Característica | ArrayList | LinkedList |
|----------------|-----------|------------|
| Implementa `List` | Sí | Sí |
| Estructura | Arreglo dinámico | Lista doblemente enlazada |
| Acceso `get(i)` | O(1) | O(n) |
| Modificación `set(i)` | O(1) | O(n) |
| Inserción al final | O(1) amortizado | O(1) |
| Inserción al inicio | O(n) | O(1) |
| Eliminación al inicio | O(n) | O(1) |
| Búsqueda por valor | O(n) | O(n) |
| Recorrido completo | O(n) | O(n) |
| Implementa `Deque` | No | Sí |
| Memoria adicional por elemento| Menor en general | Mayor por los enlaces |
| Acceso aleatorio frecuente | Adecuado | Poco adecuado |
| Operaciones frecuentes en extremos| No es su principal fortaleza | Adecuado |

## 4. Respuestas a las Preguntas de Análisis

1. **¿Qué interfaz implementan tanto ArrayList como LinkedList?** 

R: Ambas implementan la interfaz `List`.
2. **¿Cuál es la principal diferencia en su estructura interna?** 

R: `ArrayList` utiliza un arreglo dinámico, mientras que `LinkedList` utiliza una lista doblemente enlazada de nodos independientes.
3. **¿Por qué ArrayList.get(i) tiene complejidad O(1)?** 

R: Porque al basarse en arreglos, calcula la dirección de memoria exacta matemáticamente usando el índice, accediendo de forma instantánea.
4. **¿Por qué LinkedList.get(i) tiene complejidad O(n)?** 

R: Porque no tiene índices reales en memoria; debe saltar secuencialmente de nodo en nodo hasta alcanzar la posición deseada.
5. **¿Qué ocurre internamente cuando se ejecuta ArrayList.add(0, elemento)?** 

R: Java debe desplazar todos los elementos existentes una posición hacia la derecha para hacer espacio en el índice 0.
6. **¿Por qué LinkedList.add(0, elemento) no necesita desplazar los demás elementos?**

R: Solo crea un nuevo nodo y ajusta un par de referencias (punteros) para conectarlo como la nueva cabeza de la lista.
7. **¿Por qué afirmar que "LinkedList es mejor para inserciones" puede ser incorrecto?** Porque si la inserción es en una posición intermedia, primero se debe buscar esa posición recorriendo la lista, lo cual cuesta O(n).
8. **¿Qué diferencia observó entre recorrer LinkedList mediante get(i) y mediante for-each?** 

R: El `for-each` es enormemente más rápido gracias al uso de iteradores, mientras que el `get(i)` dispara el tiempo de ejecución de forma exponencial.
9. **¿Qué resultados obtuvo para inserciones al inicio?** 

R: `LinkedList` fue significativamente más rápido debido a su complejidad O(1).
10. **¿Qué resultados obtuvo para inserciones al final?** 

R: Ambos fueron muy rápidos (O(1)), pero `ArrayList` suele ser ligeramente más veloz por la contigüidad en la memoria caché.
11. **¿Los tiempos medidos coinciden exactamente con lo esperado a partir de Big-O?** 

R: Sí, las tendencias se cumplen, aunque factores de hardware como la caché del procesador benefician ligeramente a las estructuras contiguas como `ArrayList`.
12. **¿Qué costo de memoria adicional tiene conceptualmente una lista enlazada?** 

R: Mayor costo, ya que cada nodo debe almacenar el dato más dos referencias (al nodo anterior y al siguiente).
13. **¿Qué ventajas proporciona programar contra List?** 

R: Permite aprovechar el polimorfismo, facilitando intercambiar la implementación (`ArrayList` a `LinkedList`) sin romper el resto del código.
14. **¿Por qué Deque representa mejor el problema de la cola de trabajos?**

R: Porque expone semánticamente operaciones específicas para manipular los extremos (como `addFirst`, `pollFirst`), que es la esencia de una cola.
15. **¿En qué escenario seleccionaría ArrayList?**

R: Cuando haya una gran cantidad de lecturas aleatorias (`get`), iteraciones frecuentes y las inserciones sean principalmente al final.
16. **¿En qué escenario tendría sentido utilizar LinkedList?**

R: Al implementar pilas, colas o estructuras donde se inserta y elimina constantemente en los extremos y el tamaño fluctúa drásticamente.

## 5. Conclusión Técnica
La elección entre `ArrayList` y `LinkedList` no se basa en cuál es inherentemente "mejor", sino en el perfil de operaciones del problema a resolver. Si el sistema demanda alta concurrencia de lecturas y accesos aleatorios, `ArrayList` es la estructura ideal. Por otro lado, si la naturaleza del problema requiere constantes inserciones y eliminaciones en los extremos como en una cola de trabajos, la flexibilidad de los enlaces de `LinkedList` o su uso bajo la interfaz `Deque` ofrece un rendimiento superior, mitigando el costo de desplazamiento de memoria.
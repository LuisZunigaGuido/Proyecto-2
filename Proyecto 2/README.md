## Proyecto-2 Estructuras de datos Arbol binario y Lista de prioridad 

Este proyecto implementa una interfaz gráfica en Java que combina dos estructuras de datos: un árbol binario y una lista de prioridad. Incluye funcionalidades para insertar, buscar, eliminar y organizar datos, tanto en el árbol como en la lista. Además, la interfaz gráfica permite una interacción mas intuitivas para realizar estas operaciones.

## Contenido y archivos del proyecto 

## Nodo.java
Implementa la clase Nodo, que es la unidad básica de la Lista de Prioridad. Cada nodo tiene:

Un dato (entero).
Una prioridad (entero).
Una referencia al siguiente nodo en la lista.

# Principales Métodos:

getDato() y getPrioridad(): Devuelven el dato y la prioridad del nodo.
setDato(int) y setPrioridad(int): Permiten modificar el dato y la prioridad.
getNodoSiguiente() y setNodoSiguiente(Nodo): Acceden y modifican el nodo siguiente.

## NodoArbol.java
Define la clase NodoArbol,unidad básica del Árbol Binario. Cada nodo tiene:

Un valor (entero).
Una referencia al nodo hijo izquierdo (nodoIzquierda).
Una referencia al nodo hijo derecho (nodoDerecha).

# Principales Métodos:

Métodos get y set para acceder y modificar los valores y referencias de los hijos izquierdo y derecho.
Constructor para inicializar un nodo con un valor.

## Clase Arbol
Esta clase implementa un Árbol Binario de Búsqueda. Se utiliza para almacenar y gestionar datos jerárquicamente con reglas de orden. Los valores menores van a la izquierda y los mayores a la derecha.

# Métodos principales:

ingresarNodo(int valorParam)

-Inserta un nuevo nodo en el árbol respetando las reglas del BST.
-Si el árbol está vacío, el nuevo nodo se convierte en la raíz.
-Si ya existe una raíz, el método recursivo determina si el valor debe colocarse en el subárbol izquierdo o derecho.
-Maneja casos donde el árbol tiene uno o más nodos.

eliminarNodo(NodoArbol nodo, int valor)

-Elimina un nodo específico del árbol.
-Busca el nodo con el valor dado.
-Considera tres escenarios:
  1-Nodo sin hijos: simplemente lo elimina.
  2-Nodo con un hijo: reemplaza el nodo con su único hijo.
  3-Nodo con dos hijos: encuentra el sucesor en el subárbol derecho (el nodo más pequeño en el lado derecho) para reemplazar el nodo eliminado.
-Usa recursión para reordenar las conexiones entre nodos.

existenciaNodo(NodoArbol nodo, int valor)

-Verifica si un valor específico está presente en el árbol.
-Recursivamente busca el valor, moviéndose hacia el lado izquierdo o derecho según corresponda.
-Retorna true si el valor se encuentra; de lo contrario, false.

## Clase ListaDePrioridad
Esta clase implementa una lista enlazada que mantiene los nodos en orden según su prioridad.

# Métodos principales:

insertarDatos(int dato, int prioridad)

-Agrega un nuevo nodo a la lista manteniendo el orden por prioridad.
-Si la lista está vacía, el nodo se convierte en la raíz.
-Si hay nodos, determina la posición correcta comparando prioridades.
-Inserta el nodo al principio, en el medio o al final de la lista según corresponda.

imprimirLista()

-Imprime los valores y prioridades de todos los nodos en la lista.
-Si la lista está vacía, muestra un mensaje de "lista vacía".
-Recorre la lista y presenta la información de cada nodo.

buscarDato(int valor)

-Busca un nodo en la lista por su dato.
-Recorre secuencialmente desde la raíz.
-Retorna el nodo encontrado o null si no existe.

eliminarDato(int valor)

-Elimina un nodo de la lista basado en su dato.
-Si el nodo a eliminar es la raíz, actualiza la referencia de la raíz al siguiente nodo.
-Si el nodo está en el medio o al final, ajusta las referencias de los nodos anteriores y siguientes para excluirlo.

encontrarMenorPrioridad()

-Encuentra el nodo con la menor prioridad en la lista.
-Recorre toda la lista comparando prioridades.
-Retorna el nodo con la prioridad más baja.

ordenarListaPrioridad()

-Reorganiza la lista de prioridad.
-Usa una lista temporal para insertar los nodos en el orden correcto.
-Rellena la lista original con los nodos ordenados.

## Clase Interfaz
Se implemeto una interfaz gráfica que permite al usuario interactuar con el árbol y la lista de prioridad.

# Métodos principales:

actualizarPanelLista()
-Actualiza la representación visual de la lista en el panel gráfico.
-Elimina cualquier contenido anterior del panel.
-Recorre la lista y añade etiquetas con los datos y prioridades de cada nodo.

ordenarListaPrioridad()

-Llama al método ordenarListaPrioridad de la clase ListaDePrioridad para mantener la lista ordenada y reflejar los cambios en la interfaz gráfica.

# Configuraciones de botones y menús

-Botón "Agregar Nodo": Permite al usuario agregar un nodo a la lista priorizada. Los datos deben ingresarse en el formato dato, prioridad.
-Botón "Eliminar Nodo": Elimina un nodo de la lista basado en su valor ingresado.
-Botón "Buscar Nodo": Busca un nodo en la lista y notifica al usuario si fue encontrado.

-Ingresar Nodo: Agrega un nodo al árbol binario.
-Eliminar Nodo: Elimina un nodo del árbol.
-Buscar Nodo: Busca un nodo en el árbol y notifica si existe.

Método main
Inicia la ejecución de la interfaz gráfica y permite al usuario interactuar con las dos estructuras.



/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol
{
    //atributos
    public NodoArbol nodoRaiz;
    //constructor
    public Arbol(){
        this.nodoRaiz = null;
    }
    //setters
    public void setNodoRaiz(NodoArbol nodoRaiz){
        this.nodoRaiz = nodoRaiz;
    }
    //getters
    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }
    
    /* metodo buscarNodo
    *   busca nodos en el arbol y retorna el nodo buscado
    * parametros de entrada
    *   toma como parametros un Nodo y un valor buscado, el nodo es para comparar el valor buscado
    * parametros de salida
    *   retorna un nodoArbol
    * respuesta esperada
    *       se espera que el metodo sea capaz de buscar nodos en el arbol y retornarlo correctamente
   */
    public NodoArbol buscarNodo(NodoArbol nodoParam,int valorBuscado){
        //cubrimos el caso donde no esta en el arbol binario
        if (nodoParam == null) {
            System.out.println("El nodo que desea buscar no se encuentra en el árbol");
            return null;
        }
        //buscamos por recursividad
        //caso base
        if (nodoParam.getValor() == valorBuscado) {
            System.out.println("el nodo fue encontrado "+ nodoParam.getValor());
            return nodoParam;
        } else if (valorBuscado < nodoParam.getValor()) {
            //caso resursivo, recorre a la izquierda
            return buscarNodo(nodoParam.getNodoIzquierda(), valorBuscado); 
        } else {
            //caso recursivo, recorre a la derecha
            return buscarNodo(nodoParam.getNodoDerecha(), valorBuscado);
        }
    }

    /* metodo insertarNodoRecursivo
    *   busca el lugar donde el nodo debe ser ingresado y lo ingresa en dicho lugar
    * parametros de entrada
    *   toma como parametros un nodoArbol para comparar y un entero valor para ingresar
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de recorrer el arbol para saber donde debe ingresar el nodo
   */
    public void ingresarNodoRecursivo(NodoArbol nodoParam, int valorParam){
        NodoArbol nodoIngresado = new NodoArbol(valorParam);
        if(nodoParam.getValor()>valorParam){
           if(nodoParam.getNodoIzquierda()==null){
               nodoParam.setNodoIzquierda(nodoIngresado);
           } else {
               ingresarNodoRecursivo(nodoParam.getNodoIzquierda(), valorParam);
           }
        } else if(nodoParam.getValor()<valorParam){
            if(nodoParam.getNodoDerecha()==null){
                nodoParam.setNodoDerecha(nodoIngresado);
            } else {
                ingresarNodoRecursivo(nodoParam.getNodoDerecha(),valorParam);
            }
        }
    }
   /* metodo insertar
        *   recibe el metodo recursivo y lo transforma para que reciba un parametro
        * parametros de entrada
        *   toma como parametros un numero entero para ingresar un nodo
        * parametros de salida
        *   ninguno
        * respuesta esperada
        *       se espera que el metodo sea capaz de ingresar un nodo con el valor insertado
       */
    public void ingresarNodo(int valorParam){
        NodoArbol nodoIngresado = new NodoArbol (valorParam);
        if(this.nodoRaiz==null){
            this.nodoRaiz = nodoIngresado;
        } else {
            ingresarNodoRecursivo(this.nodoRaiz , valorParam);
        }
    }
    
    /* metodo eliminarNodo
    *   el metodo recorre el arbol y elimina el nodo del valor ingresado
    * parametros de entrada
    *   toma como parametros un numero entero y un nodoArbol para comparar
    * parametros de salida
    *   retorna un nodoArbol
    * respuesta esperada
    *       se espera que el metodo sea capaz de eliminar el nodo del valor solicitado
   */
    public NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            System.out.println("Nodo no encontrado: " + valor);
            return null;
        }
        
        // Si el valor que buscamos es menor, buscamos en el lado izquierdo
        if (valor < nodo.getValor()) {
            nodo.setNodoIzquierda(eliminarNodo(nodo.getNodoIzquierda(), valor));
        }
        // Si el valor es mayor, buscamos en el lado derecho
        else if (valor > nodo.getValor()) {
            nodo.setNodoDerecha(eliminarNodo(nodo.getNodoDerecha(), valor));
        }

        else {
            System.out.println("Eliminando nodo  " + valor);
            
            // Caso Nodo sin hijos
            if (nodo.getNodoIzquierda() == null && nodo.getNodoDerecha() == null) {
                return null;
            }
            
            // Caso Nodo con un solo hijo
            if (nodo.getNodoIzquierda() == null) {
                return nodo.getNodoDerecha(); 
            }
            if (nodo.getNodoDerecha() == null) {
                return nodo.getNodoIzquierda();
            }
    
            // Caso Nodo con dos hijos
            NodoArbol sucesor = nodo.getNodoDerecha();
            while (sucesor.getNodoIzquierda() != null) {
                sucesor = sucesor.getNodoIzquierda();
            }

            nodo.setNodoRaiz(sucesor.getValor());
    
            nodo.setNodoDerecha(eliminarNodo(nodo.getNodoDerecha(), sucesor.getValor()));
        }
        return nodo; 
    }
    
    /* metodo mostrarOrden
    *   recorre el arbol y lo imprime
    * parametros de entrada
    *   toma como parametros un nodo
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de recorrer el arbol
   */
    public void mostrarOrden(NodoArbol nodo) {
        if (nodo != null) {
            // Procesar el nodo actual (en este caso, mostrar su valor)
            System.out.print(nodo.valor + " ");
            
            // Recorrer el subárbol izquierdo
            mostrarOrden(nodo.nodoIzquierda);
            
            // Recorrer el subárbol derecho
            mostrarOrden(nodo.nodoDerecha);
        }
    }
    
    /* metodo existenciaNodo
    *   recorre el arbol y nos devuelve true si el nodo deseado existe
    * parametros de entrada
    *   toma como parametros un numero entero para buscar y un nodo para comparar
    * parametros de salida
    *   retorna un booleano
    * respuesta esperada
    *       se espera que el metodo sea capaz de recorrer el arbol y retornar la existencua del nodo.
   */
    public boolean existenciaNodo(NodoArbol nodo, int valor){
        if(nodo==null){
            return false;
        } else {
            if(nodo.getValor()==valor){
                return true;
            } else {
                if(nodo.getValor()>valor){
                    return existenciaNodo(nodo.getNodoIzquierda(),valor);
                } else {
                    return existenciaNodo(nodo.getNodoDerecha(),valor);
                }
            }
        }
    }
}


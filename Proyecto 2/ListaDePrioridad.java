public class ListaDePrioridad {
   //atributos de la clas
   private Nodo nodoRaiz;
   //constructor 
   public ListaDePrioridad(){
       this.nodoRaiz = null;
    }
   //setters
   public void setNodoRaiz(Nodo nodoRaiz) {
       this.nodoRaiz = nodoRaiz;
   }
    //getters
   public Nodo getNodoRaiz(){
       return this.nodoRaiz;
   } 
   
   /* metodo insertarDatos
    *   inserta datos de tipo entero en la lista de prioridad
    * parametros de entrada
    *   toma como parametros dos enteros para el valor y la prioridad
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de ingresar enteros, ademas de identificar la prioridad para ingresarlos en la pocision adecuada
   */
    public void insertarDatos(int DatoIn, int prioridadIn) {
        Nodo nuevoNodo = new Nodo(DatoIn, prioridadIn); // Creamos un nuevo nodo con el dato y la prioridad deseada
        // Caso 1: Si la lista está vacía, el nuevo nodo es la raíz
        if (this.nodoRaiz == null) {
            this.nodoRaiz = nuevoNodo;
        } else {
            Nodo nodoActual = this.nodoRaiz;
            Nodo nodoSiguiente = nodoActual.getNodoSiguiente();
            // Caso 2: Si solo hay un nodo, el nuevo nodo va antes o después dependiendo de su prioridad
            if (nodoSiguiente == null) {
                if (nodoActual.getPrioridad() > nuevoNodo.getPrioridad()) {
                    // Si el nodo raíz tiene como prioridad un numero mayor al neuvo nodo, el nuevo nodo debe ser la raíz
                    nuevoNodo.setNodoSiguiente(nodoActual);
                    this.nodoRaiz = nuevoNodo;
                } else {
                    // Si el nuevo nodo tiene como prioridad un numero igual o mayor al de la raiz, lo ponemos después de la raíz
                    nodoActual.setNodoSiguiente(nuevoNodo);
                }
            } else {
                // Caso 3 y 4: Si hay más de un nodo, recorremos la lista buscando el lugar correcto donde debe ingresarse
                while (nodoSiguiente != null && nodoActual.getPrioridad() < nuevoNodo.getPrioridad()) {
                    nodoActual = nodoSiguiente;
                    nodoSiguiente = nodoSiguiente.getNodoSiguiente();
                }
                // Si el nuevo nodo tiene como prioridad un numero menor que el de la raiz debe ir al inicio como nodo Raíz
                if (nuevoNodo.getPrioridad() < this.nodoRaiz.getPrioridad()) {
                    nuevoNodo.setNodoSiguiente(this.nodoRaiz);
                    this.nodoRaiz = nuevoNodo;
                } else {
                    //si el nuevo nodo tiene como prioridad un numero mayor al nodo Actual entonces debe ir al final
                    nuevoNodo.setNodoSiguiente(nodoSiguiente);
                    nodoActual.setNodoSiguiente(nuevoNodo);
                }
            }
        }
    }
    
    /* metodo buscarDato
    *   busca datos enteros ubicados en la lista
    * parametros de entrada
    *   toma como parametros un enteros para el valor que desea buscar
    * parametros de salida
    *   retorna el nodo buscado 
    * respuesta esperada
    *       se espera que el metodo sea capaz de buscar datos enteros y devolverlos correctamente
   */
    public Nodo buscarDato(int valor) {
        Nodo nodoActual = nodoRaiz;
        while (nodoActual != null) {
            if (nodoActual.getDato() == valor){
                return nodoActual;
            } else{
                nodoActual = nodoActual.getNodoSiguiente();
            }
        }
        return null;
    }
    
    /* metodo eliminarDato
    *   elimina los datos enteros de la lista de prioridad
    * parametros de entrada
    *   toma como parametros un entero para eliminar
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de eliminar nodo unicamente con el dato solicitado
   */
    public void eliminarDato(int valor) {
        if (nodoRaiz == null){
            System.out.println("Lista vacia");
        } else if(nodoRaiz.getDato() == valor  ) {
    
            Nodo nodoEliminar = nodoRaiz;
            nodoRaiz = nodoRaiz.getNodoSiguiente();
            nodoEliminar.setNodoSiguiente(null);
            System.out.println("Valor"+ " " + valor +" "+ "eliminado");
        } else {
    
            Nodo nodoActual = nodoRaiz;
    
            while (nodoActual.getNodoSiguiente() != null) {
    
                Nodo nodoSiguiente = nodoActual.getNodoSiguiente();
    
                if (nodoActual.getNodoSiguiente().getDato() == valor ) {
                    
                    Nodo nodoEliminar = nodoSiguiente;
                    nodoEliminar = nodoActual.getNodoSiguiente();
                    nodoActual.setNodoSiguiente(nodoEliminar.getNodoSiguiente());
                    nodoEliminar.setNodoSiguiente(null);
                    System.out.println("Valor"+ " "+ valor + " "+ "eliminado");
                    return;
                }
                nodoActual = nodoActual.getNodoSiguiente();
            } 
    
            System.out.println("El dato"+ " "+ valor +" " + "no esta en la lista");
    
        }
    
    }
   
    /* metodo encontrarMenorPrioridad
    *   este metodo recorre la lista de prioridad y devuelve el nodo con menor prioridad para actualizar la lista correctamente
    * parametros de entrada
    *   ninguno
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de encontrar el nodo con menor prioridad
   */
   public Nodo encontrarMenorPrioridad() {
        Nodo nodoMin = nodoRaiz; 
        Nodo nodoActual = nodoRaiz;
        while (nodoActual != null) {
            if (nodoActual.getPrioridad() < nodoMin.getPrioridad()) {
                nodoMin = nodoActual;
            }
            nodoActual = nodoActual.getNodoSiguiente(); 
        }
        return nodoMin; 
    }
    
     /* metodo imprimirLista
    *   recorre la lista e imprime la lista de prioridad
    * parametros de entrada
    *   ninguno
    * parametros de salida
    *   ninguno
    * respuesta esperada
    *       se espera que el metodo sea capaz de imprimir la lista correctamente
   */
    public void imprimirLista(){
        Nodo nodoActual;
        nodoActual = this.nodoRaiz;
        if(nodoActual==null){
            System.out.println("lista vacía");
        } else {
            while(nodoActual!=null){
                System.out.println("el Dato es "+ nodoActual.getDato() + " y la prioridad es "+ nodoActual.getPrioridad());
                nodoActual = nodoActual.getNodoSiguiente();
            }
        }
    }
}


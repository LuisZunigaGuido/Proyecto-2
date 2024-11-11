public class ListaDePrioridad {
    Nodo nodoRaiz;
    public ListaDePrioridad(){
        this.nodoRaiz = null;
    }
    //setters
    public void setNodoRaiz(Nodo nodoRaiz) {
        this.nodoRaiz = nodoRaiz;
    }
    //getters
    public Nodo getNodoRaiz(){
        return nodoRaiz;
    }
    public void insertarDatos (int DatoIn, int prioridadIn) {
       Nodo nuevoNodo = new Nodo(DatoIn,prioridadIn); // creamos un nuevo nodo con el dato y la prioridad deseada
       // si el nodo es nulo entonces el primer nodo insertado es e nodo raiz
       if(this.nodoRaiz == null) {
           nodoRaiz = nuevoNodo;
       } else {
           //si no es nullo entonces queremos crear el puntero nodo actual en el nodo raiz y el nodo siguiente sera el ingresado
           Nodo nodoActual = nodoRaiz;
           while(nodoActual.nodoSiguiente!=null && nodoActual.nodoSiguiente.prioridad<=prioridadIn){
               nodoActual = nodoActual.nodoSiguiente;
           }
           nuevoNodo = nodoActual;
           nuevoNodo.nodoSiguiente = nodoActual.nodoSiguiente;
       }
    }
}
//casos si tengo nodo raiz y solo hay raiz, ahora el segundo caso es cuando lo tengo en el medio

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
        return this.nodoRaiz;
    }
    public void insertarDatos (int DatoIn, int prioridadIn) {
       Nodo nuevoNodo = new Nodo(DatoIn,prioridadIn); // creamos un nuevo nodo con el dato y la prioridad deseada
       // si el nodo raiz es nulo entonces el primer nodo insertado es el nodo raiz
       if(this.nodoRaiz == null) {
           this.nodoRaiz = nuevoNodo;
       } else{
           //la prioridad del nodo ingresado es mayor a la del nodo raíz
           if(prioridadIn>nodoRaiz.prioridad){
               nuevoNodo.nodoSiguiente = this.nodoRaiz;
               this.nodoRaiz = nuevoNodo;
           } 
           else{
           //si no es nulo entonces queremos cubrir los casos donde el nuevo nodo va al final o el nuevo nodo va en el medio de dos nodos
           //cuando va al medio de eso se encarga el while y cuando no, se sale del while y entran las ultimas lineas.
           Nodo nodoActual = this.nodoRaiz;
           while(nodoActual.nodoSiguiente!=null && nodoActual.nodoSiguiente.prioridad<=prioridadIn){
               nodoActual = nodoActual.nodoSiguiente;
           }
           nuevoNodo.nodoSiguiente = nodoActual.nodoSiguiente;
           nodoActual.nodoSiguiente = nuevoNodo;
           }
       }
    }
    //metodo para imprimir lista
    public void imprimirLista(){
        Nodo nodoActual;
        nodoActual = this.nodoRaiz;
        if(nodoActual==null){
            System.out.println("lista vacía");
            return;
        } else {
            while(nodoActual!=null){
                System.out.println("el Dato es "+ nodoActual.dato + " y la prioridad es "+ nodoActual.prioridad);
                nodoActual = nodoActual.nodoSiguiente;
            }
        }
    }
}
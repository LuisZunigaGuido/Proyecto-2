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
       // si el nodo raiz es nulo entonces el primer nodo insertado es el nodo raiz
       if(this.nodoRaiz == null) {
           nodoRaiz = nuevoNodo;
       } else{
           //la prioridad del nodo ingresado es mayor a la del nodo raíz
           if(prioridadIn>nodoRaiz.prioridad){
           nuevoNodo.nodoSiguiente = nodoRaiz;
           nodoRaiz = nuevoNodo;
           }
           //si no es nulo entonces queremos cubrir los casos donde el nuevo nodo va al final o el nuevo nodo va en el medio de dos nodos
           //cuando va al medio de eso se encarga el while y cuando no, se sale del while y entran las ultimas lineas.
           Nodo nodoActual = nodoRaiz;
           while(nodoActual.nodoSiguiente!=null && nodoActual.nodoSiguiente.prioridad>=prioridadIn){
               nodoActual = nodoActual.nodoSiguiente;
           }
           nuevoNodo.nodoSiguiente = nodoActual.nodoSiguiente;
           nodoActual.nodoSiguiente = nuevoNodo;
       }
    }
    //metodo para imprimir lista
    public void imprimirLista(){
        Nodo nodoActual = nodoRaiz;
        if(nodoActual==null){
            System.out.println("lista vacía");
        }
        while(nodoActual!=null){
            System.out.println("el Dato es "+nodoActual.dato+ "y la prioridad es "+nodoActual.prioridad);
            nodoActual = nodoActual.nodoSiguiente;
        }
    }

    //metodo para buscar dato
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
}
//casos si tengo nodo raiz y solo hay raiz, ahora el segundo caso es cuando lo tengo en el medio

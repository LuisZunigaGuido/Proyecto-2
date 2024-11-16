public class ListaDePrioridad {
    private Nodo nodoRaiz;
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
    //metodo para imprimir lista
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
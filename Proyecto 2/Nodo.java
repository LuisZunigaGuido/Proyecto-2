public class Nodo {
    static int dato;
    static int prioridad;
    Nodo nodoSiguiente;
    public Nodo(int dato, int prioridad){
        this.dato = dato;
        this.prioridad = prioridad;
        this.nodoSiguiente = null;
    }
    //seters
    public void setDato(int dato){
        this.dato = dato;
    }
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    public void setNodoSiguiente(Nodo nodoSiguiente){
        this.nodoSiguiente = nodoSiguiente;
    }
    //geters
    public int getDato(){
        return this.dato;
    }
    public int getPrioridad(){
        return this.prioridad;
    }
    public Nodo getNodoSiguiente(){
        return this.nodoSiguiente;
    }
}

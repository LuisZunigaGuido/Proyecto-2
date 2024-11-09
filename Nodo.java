

public class Nodo {
    private Dato dato;
    private Nodo nodoSiguiente;
    
    
    public Nodo (Dato dato) {
        this.dato = dato;
        this.nodoSiguiente = null;
    }

    public Dato getDato(){
        return dato;

    }
    public void setDato(Dato dato){
        this.dato = dato;

    }
    public Nodo getNodoSiguiente(){
    return nodoSiguiente;

    }
    
    public void setNodoSiguiente(Nodo nodoSiguiente){
    this.nodoSiguiente = nodoSiguiente;

    }
}
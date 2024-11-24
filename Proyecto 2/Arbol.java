
/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol
{
    private NodoArbol nodoRaiz;;
    public Arbol(){
        this.nodoRaiz = null;
    }
    public void setNodoRaiz(NodoArbol nodoRaiz){
        this.nodoRaiz = nodoRaiz;
    }

    public NodoArbol getNodoRaiz(){
        return this.nodoRaiz;
    }

    public void ingresarNodo(){
        
    }
    public void buscarNodo(int valor){
    }
    public void eliminarNodo(int Valor){
        
    }
    //este metodo solo evalúa la existencia del nodo 
    public boolean existenciaNodo(NodoArbol nodo,int valor){
        //caso base
        if(nodo==null){
            return false;
        } else {
            if(nodo.getValor()==valor){
                return true;
            }
            if(nodo.getValor()<valor){
                return existenciaNodo(nodo.getNodoDerecha(),valor);
            } else {
                return existenciaNodo(nodo.getNodoIzquierda(),valor);
            }
        }
    }
    
    
}


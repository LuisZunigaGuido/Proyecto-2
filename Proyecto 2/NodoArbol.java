
/**
 * Write a description of class NodoArbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoArbol
{
    int valor;
    public static NodoArbol nodoDerecha;
    public static NodoArbol nodoIzquierda;
    public NodoArbol(int valor){
        this.valor = valor;
        nodoDerecha = null;
        nodoIzquierda = null;
    }
    public void setNodoDerecha(NodoArbol nodoDerecha){
        this.nodoDerecha = nodoDerecha;
    }
    public void setNodoIzquierda(NodoArbol nodoIzquierda){
        this.nodoIzquierda = nodoIzquierda;
    }
    public void setNodoRaiz(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return this.valor;
    }
    public NodoArbol getNodoDerecha(){
        return this.nodoDerecha;
    }
    public NodoArbol getNodoIzquierda(){
        return this.nodoIzquierda;
    }
}

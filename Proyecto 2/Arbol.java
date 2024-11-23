
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
    
    public void eliminarNodo(){
        
    }
    public NodoArbol buscarNodo(NodoArbol nodoParam, int valor){
       //caso base
       if(nodoParam.getValor()==valor){
           return nodoParam;
       } else {
           if(valor<nodoParam.getValor()){
               return buscarNodo(NodoArbol.nodoIzquierda,valor);
           } else {
               return buscarNodo(NodoArbol.nodoDerecha,valor);
           }
       }
    }
}

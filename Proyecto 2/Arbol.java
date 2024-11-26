
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

    public void ingresarNodo(int valorParam){
        //Primero creamos un nodo Arbol 
        NodoArbol nodoIngresado = new NodoArbol(valorParam);
        //primer caso si la lista esta vacia
        if(this.nodoRaiz == null){
            this.nodoRaiz = nodoIngresado;
        } else {
            //caso en que solo este el nodo Raiz
            if(this.nodoRaiz.getNodoIzquierda() == null && this.nodoRaiz.getNodoDerecha()==null){
                if(this.nodoRaiz.getValor()<valorParam){
                    this.nodoRaiz.setNodoDerecha(nodoIngresado);
                } else {
                    this.nodoRaiz.setNodoIzquierda(nodoIngresado);
                }
            } else {
                //caso de que haya mas de un nodo en el arbol creamos el metodo recursivo
                //caso base dividido en dos
                NodoArbol nodoActual = this.nodoRaiz;
                NodoArbol nodoSiguienteDerecha = nodoActual.getNodoDerecha();
                NodoArbol nodoSiguienteIzquierda = nodoActual.getNodoIzquierda();
                if(nodoActual.getNodoDerecha()!=null || nodoActual.getNodoIzquierda()!=null){
                    if(valorParam == nodoActual.getNodoDerecha().getValor()){
                        nodoActual.setNodoDerecha(nodoIngresado);
                    } else if (valorParam == nodoActual.getNodoIzquierda().getValor()){
                        nodoActual.setNodoIzquierda(nodoIngresado);
                    }
                } if(nodoActual.getNodoDerecha()!=null && nodoActual.getValor()<valorParam){
                    nodoActual.setNodoDerecha(nodoActual);
                    ingresarNodo(valorParam);
                } else if(nodoActual.getNodoIzquierda()!=null && nodoActual.getValor()>valorParam){
                    nodoActual.setNodoIzquierda(nodoActual);
                    ingresarNodo(valorParam);
                }
            }
        }
    }
    public void buscarNodo(int valor){
    }
    
    public NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            System.out.println("Nodo no encontrado: " + valor);
            return null;
        }
        
        // Si el valor que buscamos es menor, buscamos en el lado izquierdo
        if (valor < nodo.getValor()) {
            nodo.setNodoIzquierda(eliminarNodo(nodo.getNodoIzquierda(), valor));
        }
        // Si el valor es mayor, buscamos en el lado derecho
        else if (valor > nodo.getValor()) {
            nodo.setNodoDerecha(eliminarNodo(nodo.getNodoDerecha(), valor));
        }

        else {
            System.out.println("Eliminando nodo  " + valor);
            
            // Caso Nodo sin hijos
            if (nodo.getNodoIzquierda() == null && nodo.getNodoDerecha() == null) {
                return null;
            }
            
            // Caso Nodo con un solo hijo
            if (nodo.getNodoIzquierda() == null) {
                return nodo.getNodoDerecha(); 
            }
            if (nodo.getNodoDerecha() == null) {
                return nodo.getNodoIzquierda();
            }
    
            // Caso Nodo con dos hijos
            NodoArbol sucesor = nodo.getNodoDerecha();
            while (sucesor.getNodoIzquierda() != null) {
                sucesor = sucesor.getNodoIzquierda();
            }

            nodo.setNodoRaiz(sucesor.getValor());
    
            nodo.setNodoDerecha(eliminarNodo(nodo.getNodoDerecha(), sucesor.getValor()));
        }
        
        return nodo; 
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


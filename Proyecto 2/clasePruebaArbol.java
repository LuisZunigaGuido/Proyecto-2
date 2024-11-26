
/**
 * Write a description of class clasePruebaArbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class clasePruebaArbol{
    public static void main(String[] args) {
        
        Arbol arbol = new Arbol();

        NodoArbol nodo1 = new NodoArbol(50);
        NodoArbol nodo2 = new NodoArbol(30);
        NodoArbol nodo3 = new NodoArbol(70);
        NodoArbol nodo4 = new NodoArbol(20);
        NodoArbol nodo5 = new NodoArbol(40);
        NodoArbol nodo6 = new NodoArbol(60);
        NodoArbol nodo7 = new NodoArbol(80);

        arbol.setNodoRaiz(nodo1);

        nodo1.setNodoIzquierda(nodo2);
        nodo1.setNodoDerecha(nodo3);
        nodo2.setNodoIzquierda(nodo4);
        nodo2.setNodoDerecha(nodo5);
        nodo3.setNodoIzquierda(nodo6);
        nodo3.setNodoDerecha(nodo7);

        // Mostrar árbol antes de eliminar
        System.out.println("Árbol antes de eliminar:");
        imprimirArbol(arbol.getNodoRaiz());

        arbol.eliminarNodo(nodo1,20);
        imprimirArbol(arbol.getNodoRaiz());  
    }

    public static void imprimirArbol(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValor() + " ");
            imprimirArbol(nodo.getNodoIzquierda());
            imprimirArbol(nodo.getNodoDerecha());
        }
    }
}
    




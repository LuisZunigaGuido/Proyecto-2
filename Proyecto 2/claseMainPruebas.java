public class claseMainPruebas
{
    public static void main(String[] args){
        //listaPrueba.imprimirLista()
        ListaDePrioridad listaPrueba = new ListaDePrioridad();
        //primer dato como dato raiz
        //ahora ingresamos los datos
        listaPrueba.insertarDatos(9,8);
        listaPrueba.insertarDatos(7,7);
        listaPrueba.insertarDatos(1,3);
        listaPrueba.insertarDatos(2,3);
        listaPrueba.insertarDatos(2,9);
        listaPrueba.insertarDatos(10,12);
        listaPrueba.insertarDatos(56,19);
        listaPrueba.insertarDatos(90,1);
        listaPrueba.insertarDatos(59,9);
        System.out.println("\n Lista de Prioridad");
        listaPrueba.imprimirLista();

        int valor = 59;
        Nodo resultado = listaPrueba.buscarDato(valor);

        if(resultado != null){
            System.out.println("El dato solicitado fué encontrado, es el dato: " + resultado.getDato() + " y tiene prioridad " + resultado.getPrioridad()); 
        } else {
        System.out.println("El valor " + valor + " no existe en la lista.");
        }
    }
}
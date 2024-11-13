public class claseMainPruebas
{
    public static void main(String[] args){
        ListaDePrioridad listaPrueba = new ListaDePrioridad();
        //insertamos datos para probar
        /*
        listaPrueba.insertarDatos(5,2);
        listaPrueba.insertarDatos(6,1);
        listaPrueba.insertarDatos(8,4);
        listaPrueba.insertarDatos(10,3);
        listaPrueba.insertarDatos(69,5);*/
        listaPrueba.insertarDatos(5,2);
        listaPrueba.insertarDatos(6,3);
        System.out.println("Lista de prioridad ");
        listaPrueba.imprimirLista();
    }
}
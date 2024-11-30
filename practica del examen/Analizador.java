
/**
 * Write a description of class Analizador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Analizador
{
    private int filaSecuencia;
    private int columnaSecuencia;
    private int largoSecuencia;
    public void buscarSecuencia(int[][] matriz, int fila, int columna, int numeroAnterior, int longitud){
        //caso base
        if(fila<0 || columna<0 || fila >= matriz.length || columna >= matriz[0].length || matriz[fila][columna] != numeroAnterior + 1){
            filaSecuencia = fila;
            columnaSecuencia = columna;
            largoSecuencia = longitud;
        } else {
            int valorActual = matriz[fila][columna];
            buscarSecuencia(matriz, fila+1,columna,numeroAnterior, longitud+1);
            buscarSecuencia(matriz, fila-1,columna,numeroAnterior, longitud+1);
            buscarSecuencia(matriz, fila,columna+1,numeroAnterior, longitud+1);
            buscarSecuencia(matriz, fila+1,columna+1,numeroAnterior, longitud+1);
            buscarSecuencia(matriz, fila+1,columna+1,numeroAnterior, longitud+1);
            buscarSecuencia(matriz, fila-1,columna-1,numeroAnterior, longitud+1);
            matriz[fila][columna] = valorActual;
        }
    }
    
    public void IdentificarHileraLarga(int[][] matrizParam){
        filaSecuencia = -1;
        columnaSecuencia = -1;
        largoSecuencia = 0;
        
        for(int i=0; i<matrizParam.length; i++){
            for(int j=0; j<matrizParam.length;j++){
                buscarSecuencia(matrizParam, i, j, matrizParam[i][j]-1, 0);
            }
        }
        System.out.println("Secuencia más larga inicia en fila: " + filaSecuencia + ", columna: " + columnaSecuencia + ", longitud: " + largoSecuencia);
    }
     public static void main(String[] args) {
        Analizador analizador = new Analizador();

        // Ejemplo de matriz (puedes modificarla según sea necesario)
        int[][] matriz = {
            {1, 1, 3, 0},
            {1, 1, 1, 3},
            {3, 2, 1, 2},
            {2, 3, 1, 2}
        };

        // Llamamos al método para identificar la hilera más larga
        analizador.IdentificarHileraLarga(matriz);
    }
}

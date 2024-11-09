public class Dato{
    int prioridad;
    int numeroValor;
    public Dato(int prioridad, int numeroValor){
        this.prioridad = prioridad;
        this.numeroValor = numeroValor;
    }
    //seters
    public void setPrioridad(int prioridad){
        this.prioridad = prioridad;
    }
    public void setNumeroValor(int numeroValor){
            this.numeroValor = numeroValor;
    }
    //geters
    public int getPrioridad(){
        return prioridad;
    }
    public int getNumeroValor(){
        return numeroValor;
    }
}
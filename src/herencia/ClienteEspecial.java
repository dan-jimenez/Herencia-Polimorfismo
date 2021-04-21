
package herencia;


public class ClienteEspecial extends Cliente {
    private int paciencia;

    public ClienteEspecial(int paciencia, int contador, int numeroCliente) {
        super(contador, numeroCliente);
        this.paciencia = paciencia;
    }
    
    @Override
    public int getPaciencia(){
        return paciencia;
    }
    
    
    public void decrementarPaciencia(){
        while (paciencia > 0){
            paciencia--;
        }
    }
    
    
}

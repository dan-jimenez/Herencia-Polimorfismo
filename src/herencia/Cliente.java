package claseclientes;


import java.util.Random;





public class Cliente {
    private int contador;

    public Cliente(int contador) {
        this.contador = contador;
    }
    
    public int codigoProducto(){
        
        Random MiAleatorio = new Random();
        int cod = 1 + MiAleatorio.nextInt(12);
        return cod;
    }
            
}

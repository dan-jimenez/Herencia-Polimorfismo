package herencia;


public class Cliente {
    private int contador;
    private int numeroCliente;
    private int paciencia;

    

    public Cliente(int contador, int numeroCliente) {
        this.contador = contador;
        this.numeroCliente = numeroCliente;
        this.paciencia = 60;
    }
    
    public int[] ordenar(){
        int numeroProductos = (int) Math.floor(Math.random() * 10);
        
        while(numeroProductos == 0){
            numeroProductos = (int) Math.floor(Math.random() * 10);
        }
        
        int[] productos = new int[numeroProductos];
        
        for (int i = 0; i < productos.length; i++){
            int producto = (int) Math.floor(Math.random() * 12);
            productos[i] = producto;
        }
        
        return productos;
    }
    
    public int getContador(){
        return contador;
    }
    public int getNumeroCliente(){
        return numeroCliente;
    }
    public int getPaciencia() {
        return paciencia;
    }
            
}

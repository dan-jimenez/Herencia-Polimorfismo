
package claseclientes;


public class ClaseClientes {

   
    public static void main(String[] args) {
        Cliente cliente = new Cliente(10);
        int codigoProducto = cliente.codigoProducto();
        System.out.print(codigoProducto);
    }
    
}

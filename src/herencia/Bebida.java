/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herencia;

/**
 *
 * @author larry
 */
public class Bebida extends Producto {
    
    
    private String tipoBebida;
    private String tamannoBebida;

    public Bebida(String tipoBebida, String tamannoBebida, String nombre, int precio, int tiempoProduccion) {
        super(nombre, precio, tiempoProduccion);
        this.tipoBebida = tipoBebida;
        this.tamannoBebida = tamannoBebida;
    }
    
    
    
}

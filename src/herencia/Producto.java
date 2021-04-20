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
public class Producto {
    
    private String nombre;
    private int precio;
    private int tiempoProduccion;

    public Producto(String nombre, int precio, int tiempoProduccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProduccion = tiempoProduccion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public int getTiempoProduccion() {
        return tiempoProduccion;
    }
    
    
    
    
    
    
}

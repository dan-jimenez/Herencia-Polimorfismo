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
public class PlatoFuerte extends Producto{
    
    private String tamanno;

    public PlatoFuerte(String tamanno, String nombre, int precio, int tiempoProduccion) {
        super(nombre, precio, tiempoProduccion);
        this.tamanno = tamanno;
    }
    
}

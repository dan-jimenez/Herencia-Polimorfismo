
package herencia;

import static herencia.PrincipalClass.principalWindow;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


/**
 *
 * @author Danny Jimenez
 */
public class Produccion {
    private final int maximoProductos = 10;
    private int espacioDisponible;
    private Producto[] pedidos;

    
    
    
    @SuppressWarnings("empty-statement")
    public String[] hacerPedido(int[] productos, String cliente){
        JSONParser parser = new JSONParser();
        
                
        String[] orden = new String[productos.length + 1];
        pedidos = new Producto[productos.length];
        
        
        try{
            Object menu = parser.parse(new FileReader("menu.json"));
            JSONObject jsonMenu = (JSONObject) menu;
            
            JSONArray bebidas = (JSONArray) jsonMenu.get("Bebidas");
            JSONArray platoFuerte = (JSONArray) jsonMenu.get("Platos Fuertes");
            JSONArray acompañamientos = (JSONArray) jsonMenu.get("Acompañamientos");
            
            JSONObject jsonPlatoFuerte;
            JSONObject jsonAcompañamiento;
            JSONObject jsonBebida;
            
            String sNombre;
            String sTamaño;
            String sTipo;
            String iPrecio;
            String iTiempo;
            
            for(int i = 0; i < productos.length; i++){
                if (productos[i] < 4){
                    jsonBebida = (JSONObject) bebidas.get(productos[i]);
                    
                    sNombre = (String) jsonBebida.get("Nombre");
                    sTamaño = (String) jsonBebida.get("Tamaño");
                    sTipo = (String) jsonBebida.get("Tipo");
                    iPrecio = (String) jsonBebida.get("Precio");
                    iTiempo = (String) jsonBebida.get("Tiempo");
                    
                    pedidos[i] = new Bebida(sTipo, sTamaño, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                    orden[i] = sNombre + " - - " + sTamaño + " - - " + iPrecio;
                   
                }
                else if ( 3 < productos[i] && productos[i] < 8){
                    jsonAcompañamiento = (JSONObject) acompañamientos.get(productos[i] - 4);
                    
                    sNombre = (String) jsonAcompañamiento.get("Nombre");
                    sTipo = (String) jsonAcompañamiento.get("Tipo");
                    iPrecio = (String) jsonAcompañamiento.get("Precio");
                    iTiempo = (String) jsonAcompañamiento.get("Tiempo");
                    
                    pedidos[i] = new Acompanamiento(sTipo, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                    orden[i] = sNombre + " - - " + iPrecio;
                    
                }
                else if (productos[i] < 12){
                    jsonPlatoFuerte = (JSONObject) platoFuerte.get(productos[i] - 8);
                    
                    sNombre = (String) jsonPlatoFuerte.get("Nombre");
                    sTamaño = (String) jsonPlatoFuerte.get("Tamaño");
                    iPrecio = (String) jsonPlatoFuerte.get("Precio");
                    iTiempo = (String) jsonPlatoFuerte.get("Tiempo");
                    
                    pedidos[i] = new PlatoFuerte(sTamaño, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                    orden[i] = sNombre + " - - " + sTamaño + " - - " + iPrecio;
                }
                
            }
        }catch (FileNotFoundException e){} catch (IOException | ParseException e) {}
        
        principalWindow.tPedidosPendientes.append("Orden del cliente: " + cliente + " \n\n" );
        for(int i = 0; i < orden.length - 1; i++){
            principalWindow.tPedidosPendientes.append(orden[i] + " \n");
            
        }
        principalWindow.tPedidosPendientes.append("\n" +
                "- - - - - - - - - - - - - - - - - - - - - - - - - - -"
                + " - - - - - - - - - - - - - - - " );

        return orden;
    }
   
    
    public int getEspacioDisponible() {
        return espacioDisponible;
    }
    
    
    public int getMaximoProductos() {
        return maximoProductos;
    }
    
}

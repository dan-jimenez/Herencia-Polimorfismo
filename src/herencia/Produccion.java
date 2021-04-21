
package herencia;

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

    
    
    
    public String[] hacerPedido(int[] productos, String cliente){
        JSONParser parser = new JSONParser();
        
                
        String[] orden = new String[productos.length + 1];
        pedidos = new Producto[productos.length];
        
        orden[0] = "Pedido del cliente " + cliente;
        
        try{
            Object menu = parser.parse(new FileReader("menu.json"));
            JSONObject jsonMenu = (JSONObject) menu;
            JSONArray bebidas = (JSONArray) jsonMenu.get("Bebidas");
            JSONArray platoFuerte = (JSONArray) jsonMenu.get("Platos Fuertes");
            JSONArray acompañamientos = (JSONArray) jsonMenu.get("Acompañamientos");
            
            System.out.println(jsonMenu);
            for(int i = 0; i < productos.length; i++){
                if (productos[i] < 4){
                    for (int j = 0; i < 4; i++){
                        JSONObject jsonBebida = (JSONObject) bebidas.get(i);
                        
                        String iCodigo = (String) jsonBebida.get("Codigo");
                        String sNombre = (String) jsonBebida.get("Nombre");
                        String sTamaño = (String) jsonBebida.get("Tamaño");
                        String sTipo = (String) jsonBebida.get("Tipo");
                        String iPrecio = (String) jsonBebida.get("Precio");
                        String iTiempo = (String) jsonBebida.get("Tiempo P");
                        
                        
                        if(Integer.parseInt(iCodigo) == j){
                            pedidos[i] = new Bebida(sTipo, sTamaño, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                            orden[i +1] = sNombre + " - - " + sTamaño + " - - " + iPrecio;
                            System.out.println(sNombre + "\n");
                            
                        }
                    }
                }
                else if ( 3 < productos[i] && productos[i] < 8){
                    for (int j = 0; i < 4; i++){
                        JSONObject jsonAcompañamiento = (JSONObject) acompañamientos.get(i);
                        String iCodigo = (String) jsonAcompañamiento.get("Codigo");
                        String sNombre = (String) jsonAcompañamiento.get("Nombre");
                        String sTipo = (String) jsonAcompañamiento.get("Tipo");
                        String iPrecio = (String) jsonAcompañamiento.get("Precio");
                        String iTiempo = (String) jsonAcompañamiento.get("Tiempo P");
                        
                        System.out.println(Integer.parseInt(iCodigo));
                        
                        if(Integer.parseInt(iCodigo) == j){
                            pedidos[i] = new Acompanamiento(sTipo, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                            orden[i +1] = sNombre + " - - " + iPrecio;
                            System.out.println(sNombre + "\n");
                        }
                    }
                    
                }
                else if (productos[i] < 12){
                    for (int j = 0; i < 4; i++){
                        JSONObject jsonPlatoFuerte = (JSONObject) platoFuerte.get(i);
                        String iCodigo = (String) jsonPlatoFuerte.get("Codigo");
                        String sNombre = (String) jsonPlatoFuerte.get("Nombre");
                        String sTamaño = (String) jsonPlatoFuerte.get("Tamaño");
                        String iPrecio = (String) jsonPlatoFuerte.get("Precio");
                        String iTiempo = (String) jsonPlatoFuerte.get("Tiempo P");
                        
                        
                        if(Integer.parseInt(iCodigo) == j){
                            pedidos[i] = new PlatoFuerte(sTamaño, sNombre, Integer.parseInt(iPrecio), Integer.parseInt(iTiempo));
                            orden[i+1] = sNombre + " - - " + sTamaño + " - - " + iPrecio;
                            System.out.println(sNombre + "\n");
                        }
                    }
                }
                    
                }
            }catch (FileNotFoundException e){} catch (IOException | ParseException e) {}
        
        for (int i = 1; i < orden.length; i++) {
            System.out.println( orden[i] + "\n");
        }
        return orden;
    }
   
    
    public int getEspacioDisponible() {
        return espacioDisponible;
    }
    
    
    public int getMaximoProductos() {
        return maximoProductos;
    }
    
}

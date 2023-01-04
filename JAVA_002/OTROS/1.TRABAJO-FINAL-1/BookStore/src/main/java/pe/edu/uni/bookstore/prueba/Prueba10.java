package pe.edu.uni.bookstore.prueba;

import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.service.ConsultasService;

public class Prueba10 {

	public static void main(String[] args) {
        try {
            ConsultasService service = new ConsultasService();
            List<Map<String,?>> lista = service.ultimasVentas();
            for(Map<String,?> r : lista) {
            	String fila =  r.get("CLIENTE").toString(); 
               	fila += " - " + r.get("FECHA").toString(); 
            	fila += " - " + r.get("IDPUBLICACION").toString(); 
            	
            	fila += " - " + r.get("CANTIDAD").toString();  
            	fila += " - " + r.get("PRECIO").toString();  
            	fila += " - " + r.get("DCTO").toString();  
            	
            	
            	fila += " - " + r.get("SUBTOTAL").toString();  
            	fila += " - " + r.get("IMPUESTO").toString();  
            	fila += " - " + r.get("TOTAL").toString();  
            	
            
            	System.out.println(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

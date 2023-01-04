package pe.edu.uni.bookstore.prueba;

import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.service.ConsultasService;

public class Prueba02 {

	public static void main(String[] args) {
        try {
            ConsultasService service = new ConsultasService();
            List<Map<String,?>> lista = service.consultarPublicaciones("REVISTA");
            for(Map<String,?> r : lista) {
            	String fila = r.get("IDPUBLICACION").toString();
            	fila += " - " + r.get("TITULO").toString();  
            	fila += " - " + r.get("AUTOR").toString();  
            	fila += " - " + r.get("NROEDICION").toString();  
            	fila += " - " + r.get("PRECIO").toString();  
            	fila += " - " + r.get("STOCK").toString();  
            	
            
            	System.out.println(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

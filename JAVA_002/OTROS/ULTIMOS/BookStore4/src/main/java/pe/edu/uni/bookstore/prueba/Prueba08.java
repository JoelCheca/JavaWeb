package pe.edu.uni.bookstore.prueba;

import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.service.ServicesBook;

public class Prueba08 {

	public static void main(String[] args) {
        try {
            ServicesBook service = new ServicesBook();
            List<Map<String,?>> lista = service.traerPrecio("LIB00001");
            System.out.println(lista);
            for(Map<String,?> r : lista) {
            	String fila = r.get("PRECIO").toString();
             
            	          	 
            	System.out.println(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
	
	
	
	
	
	
	
	
}

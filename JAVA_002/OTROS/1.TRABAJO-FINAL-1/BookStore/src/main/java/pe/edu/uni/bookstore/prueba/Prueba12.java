package pe.edu.uni.bookstore.prueba;

import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.service.ServicesBook;

public class Prueba12 {

	public static void main(String[] args) {
        try {
          ServicesBook service = new  ServicesBook();
            List<Map<String,?>> lista = service.calcular("LIB00001",5);
            for(Map<String,?> r : lista) {
            	String fila = r.get("DCTO").toString();     
            	fila += " - " + r.get("TOTAL").toString();  
            	fila += " - " + r.get("SUBTOTAL").toString(); 
            	fila += " - " + r.get("IMPUESTO").toString(); 
            	System.out.println(fila);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

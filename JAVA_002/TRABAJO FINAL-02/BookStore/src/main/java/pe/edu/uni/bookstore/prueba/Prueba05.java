package pe.edu.uni.bookstore.prueba;

import pe.edu.uni.bookstore.service.ServicesBook;

public class Prueba05 {
	public static void main(String[] args) {
        try {
            ServicesBook service = new ServicesBook ();
            service.modificarPrecio(1, "LIB00004");
            System.out.println("Proceso ok.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}

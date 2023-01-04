package pe.edu.uni.bookstore.prueba;

import pe.edu.uni.bookstore.service.ServicesBook;

public class Prueba04 {
	public static void main(String[] args) {
        try {
            ServicesBook service = new ServicesBook ();
            service.registraVenta("juan", "eaguero", "LIB00001", 1, 1, 1, 1, 1, 1);
            System.out.println("Proceso ok.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}

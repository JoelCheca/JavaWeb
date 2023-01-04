package pe.edu.uni.bookstore.prueba;

import pe.edu.uni.bookstore.service.RegistraVenta;

public class Prueba04 {
	public static void main(String[] args) {
        try {
            RegistraVenta service = new RegistraVenta ();
            service.registraVenta("MARIAJOSE portilla verastegui",2, "LIB00005", 6);
            System.out.println("Proceso ok.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
}

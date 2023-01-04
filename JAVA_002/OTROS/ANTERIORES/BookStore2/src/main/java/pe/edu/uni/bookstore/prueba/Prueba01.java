package pe.edu.uni.bookstore.prueba;

import java.sql.Connection;

import pe.edu.uni.bookstore.db.AccesoDB;


public class Prueba01 {
    
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion ok.");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

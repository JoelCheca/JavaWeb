package pe.edu.uni.bookstore.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import pe.edu.uni.bookstore.db.AccesoDB;

public class ServicesBook {
	
	public void registraVenta(String cliente,int idempleado, String  idpublicacion, int cantidad) {
		Connection cn = null;
		CallableStatement cStmt = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_venta1(?,?,?,?,?,?)}");
			cStmt.setString(1, cliente);
			cStmt.setInt(2, idempleado);
			cStmt.setString(3, idpublicacion);
			cStmt.setInt(4, cantidad);
			cStmt.registerOutParameter(5, java.sql.Types.INTEGER);
			cStmt.registerOutParameter(6, java.sql.Types.VARCHAR,2000);
			cStmt.execute();
			int estado = cStmt.getInt(5);
			String mensaje = cStmt.getString(6);
			if(estado!=00) {
				throw new SQLException(mensaje);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}
	
	
	
	public void modificarPrecio(double precio, String  idpublicacion) {
		Connection cn = null;
		CallableStatement cStmt = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_modificarprecio1(?,?,?,?)}");
			cStmt.setDouble(1, precio);
			cStmt.setString(2, idpublicacion);
			cStmt.registerOutParameter(3, java.sql.Types.INTEGER);
			cStmt.registerOutParameter(4, java.sql.Types.VARCHAR,2000);
			cStmt.execute();
			int estado = cStmt.getInt(3);
			String mensaje = cStmt.getString(4);
			if(estado!=00) {
				throw new SQLException(mensaje);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error en el proceso.");
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

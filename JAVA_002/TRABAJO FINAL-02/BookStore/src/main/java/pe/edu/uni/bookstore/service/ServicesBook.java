package pe.edu.uni.bookstore.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.db.AccesoDB;

public class ServicesBook {
	
	public void registraVenta(String cliente,String idempleado, String  idpublicacion, int cantidad, double precio, double total, double impuesto,
			double subtotal,double dcto) {
		Connection cn = null;
		CallableStatement cStmt = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_venta2(?,?,?,?,?,?,?,?,?,?,?)}");
			cStmt.setString(1, cliente);
			cStmt.setString(2, idempleado);
			cStmt.setString(3, idpublicacion);
			cStmt.setInt(4, cantidad);			
			cStmt.setDouble(5, precio);
			cStmt.setDouble(6, total);
			cStmt.setDouble(7, impuesto);
			cStmt.setDouble(8, subtotal);
			cStmt.setDouble(9, dcto);		
			cStmt.registerOutParameter(10, java.sql.Types.INTEGER);
			cStmt.registerOutParameter(11, java.sql.Types.VARCHAR,2000);
			cStmt.execute();
			int estado = cStmt.getInt(10);
			String mensaje = cStmt.getString(11);
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
	
	
	
	
	
	
	public List<Map<String, ?>> listarPublicaciones() {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_listarPublicaciones()}");
			cStmt.execute();
			rs = cStmt.getResultSet();
			lista = JdbcUtil.rsToList(rs);
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
		return lista;
	}


	
	
	
	
	public List<Map<String, ?>> traerPrecio(String idpublicacion) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_traerPrecio(?)}");
			cStmt.setString(1, idpublicacion);
			cStmt.execute();
			rs = cStmt.getResultSet();
			lista = JdbcUtil.rsToList(rs);
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
		return lista;
	}
	
	
	public List<Map<String, ?>> calcular( String  idpublicacion, int cantidad) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_calcular(?,?)}");
			cStmt.setString(1, idpublicacion);
			cStmt.setInt(2, cantidad);
			cStmt.execute();
			rs = cStmt.getResultSet();
			lista = JdbcUtil.rsToList(rs);
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
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

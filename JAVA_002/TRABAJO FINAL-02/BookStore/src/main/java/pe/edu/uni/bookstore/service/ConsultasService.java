package pe.edu.uni.bookstore.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import pe.edu.uni.bookstore.db.AccesoDB;

public class ConsultasService {

	public List<Map<String, ?>> consultarPublicaciones(String descripcion) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_publicacion(?)}");
			cStmt.setString(1,  descripcion);
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

	
	
	public List<Map<String, ?>> buscafechas(String fecha1, String fecha2) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
	
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_buscafechas(?,?)}");
			cStmt.setString(1,  fecha1);
			cStmt.setString(2,  fecha2);
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
	
	
	
	
	public List<Map<String, ?>> comboPublicaciones() {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_comboPublicaciones()}");
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

	
	
	public List<Map<String, ?>> comboTipoPublicaciones() {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_comboTipoPublicaciones()}");
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
	
	
	
	public List<Map<String, ?>> ultimasVentas() {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_ultimasventas()}");
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
	
	public List<Map<String, ?>> comboPublicacionesTipo(String descripcion) {
		List<Map<String, ?>> lista = null;
		Connection cn = null;
		CallableStatement cStmt = null;
		ResultSet rs = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call  usp_tipoPublicacion (?)}");
			cStmt.setString(1,  descripcion);
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

package pe.edu.uni.bookstore.service;

import java.sql.CallableStatement;
import java.sql.Connection;

import pe.edu.uni.bookstore.db.AccesoDB;

public class ValidaService {

	
	public int validaUsuario(String usuario, String clave) {
		int estado = 1;
		Connection cn = null;
		CallableStatement cStmt = null;
		try {
			cn = AccesoDB.getConnection();
			cStmt = cn.prepareCall("{call usp_logon(?,?,?)}");
			cStmt.setString(1, usuario);
			cStmt.setString(2, clave);
			cStmt.registerOutParameter(3, java.sql.Types.INTEGER);
			cStmt.execute();
			estado = cStmt.getInt(3);
		} catch  (Exception e) {
			estado = -1;
		} finally {
			try {
				cn.close();
			} catch (Exception e2) {
			}
		}
		
		return estado;
	}
}

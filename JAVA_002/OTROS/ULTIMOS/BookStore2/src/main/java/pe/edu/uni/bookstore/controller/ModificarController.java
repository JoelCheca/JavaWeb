package pe.edu.uni.bookstore.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.google.gson.Gson;

import pe.edu.uni.bookstore.model.Mensaje;
import pe.edu.uni.bookstore.service.ServicesBook;

/**
 * Servlet implementation class CuentaController
 */
@WebServlet({"/ModificarController","/postModificarPrecio"})
public class ModificarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/postModificarPrecio":
			postModificarPrecio(request, response);
			break;

		default:
			break;
		}
	}

	private void postModificarPrecio(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Mensaje msg = new Mensaje();
		try {
			// Datos
			double precio = Double.parseDouble(request.getParameter("precio"));
			String idpublicacion = request.getParameter("idpublicacion");
			
			
			// Proceso
			ServicesBook service = new ServicesBook();
			service.modificarPrecio(precio,idpublicacion);
			msg.setEstado(1);
			msg.setMensaje("Proceso ejecutado correctamente");
		} catch (Exception e) {
			msg.setEstado(-1);
			msg.setMensaje(e.getMessage());
		}
		// Reporte
		Gson gson = new Gson();
		String strJson = gson.toJson(msg);
		HttpUtil.reporteJson(response, strJson);
	}

}

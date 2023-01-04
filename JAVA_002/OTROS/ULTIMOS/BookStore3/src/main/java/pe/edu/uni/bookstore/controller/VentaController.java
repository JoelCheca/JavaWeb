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
@WebServlet({"/VentaController","/postProcesarVenta"})
public class VentaController extends HttpServlet {
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
		case "/postProcesarVenta":
			postProcesarVenta(request, response);
			break;

		default:
			break;
		}
	}

	private void postProcesarVenta(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		Mensaje msg = new Mensaje();
		try {
			// Datos
			String cliente = request.getParameter("cliente");
			HttpSession session = request.getSession(true);
			String idempleado = session.getAttribute("idempleado").toString();
			String idpublicacion = request.getParameter("idpublicacion");
			int cantidad =Integer.parseInt( request.getParameter("cantidad"));
			
			// Proceso
			ServicesBook service = new ServicesBook();
			service.registraVenta(cliente, idempleado,idpublicacion , cantidad);
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

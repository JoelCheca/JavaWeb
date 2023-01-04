package pe.edu.uni.bookstore.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.uni.bookstore.service.ConsultasService;
import pe.edu.uni.bookstore.service.ServicesBook;


@WebServlet({"/ConResumen1","/ConResumen2", "/listarPublicaciones" })
public class ConsultaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/ConResumen1":
			getConResumen1(request, response);
			break;
		case "/ConResumen2":
			getConResumen2(request, response);
			break;	
			
		case "/listarPublicaciones":
			getlistarPublicaciones(request, response);
			break;				
		default:
			break;
		}
	}

	
	private void getlistarPublicaciones(HttpServletRequest request, HttpServletResponse response) throws IOException {
				// Proceso
				ServicesBook service = new ServicesBook ();
				List<Map<String,?>> lista = service.listarPublicaciones();
				// Reporte
				Gson gson = new Gson();
				String strJson = gson.toJson(lista);
				HttpUtil.reporteJson(response, strJson);
		
	}


	private void getConResumen1(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Parametro
		String descripcion = (request.getParameter("descripcion"));
		// Proceso
		ConsultasService service = new ConsultasService();
		List<Map<String,?>> lista = service.consultarPublicaciones(descripcion);
		// Reporte
		Gson gson = new Gson();
		String strJson = gson.toJson(lista);
		HttpUtil.reporteJson(response, strJson);
	}
	
	
	
	private void getConResumen2(HttpServletRequest request, HttpServletResponse response) 
			throws IOException {
		// Parametro
		String fecha1 = (request.getParameter("fecha1"));
		String fecha2 = (request.getParameter("fecha2"));
		// Proceso
		ConsultasService service = new ConsultasService();
		List<Map<String,?>> lista = service.buscafechas(fecha1, fecha2);
		// Reporte
		Gson gson = new Gson();
		String strJson = gson.toJson(lista);
		HttpUtil.reporteJson(response, strJson);
	}
	
	

}

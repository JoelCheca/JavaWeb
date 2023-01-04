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



	@WebServlet({"/traerCombos","/traerPrecio","/traerCombos2"})
	public class ComboController  extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
		
		
		
		

		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String path = request.getServletPath();
			switch (path) {
		 case "/traerCombos":
				traerCombos(request,response);
				break;
			
		 case "/traerPrecio":
				traerPrecio(request,response);
				break;		
				
		 case "/traerCombos2":
			 	traerCombos2(request,response);
				break;		
		

			default:
				break;
			}
			
			
		}



		private void traerCombos2(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// Proceso
			ConsultasService service = new ConsultasService();
			List<Map<String, ?>> lista = service.comboTipoPublicaciones();
			// Reporte
			Gson gson = new Gson();
			String strJson = gson.toJson(lista);
			HttpUtil.reporteJson(response, strJson);
			
		}



		private void traerPrecio(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			String idpublicacion = request.getParameter("idpublicacion");
			
			// Proceso
			ServicesBook service = new  ServicesBook();
			List<Map<String,?>> lista = service.traerPrecio(idpublicacion);
			// Reporte
			Gson gson = new Gson();
			String strJson = gson.toJson(lista);
			HttpUtil.reporteJson(response, strJson);
			
			
			
		}



		private void traerCombos(HttpServletRequest request, HttpServletResponse response) throws IOException {
				
			// Proceso
			ConsultasService service = new  ConsultasService();
            List<Map<String,?>> lista = service.comboPublicaciones();
			// Reporte
			Gson gson = new Gson();
			String strJson = gson.toJson(lista);
			HttpUtil.reporteJson(response, strJson);
		}
		

	}
	

package pe.edu.uni.app.prueba;

import pe.edu.uni.app.Model.ComisionModel;
import pe.edu.uni.app.service.ComisionService;

public class Prueba {
	
	public static void main(String[]args){
		
		// Datos
				ComisionModel model = new ComisionModel();
				model.setCat(1);
				model.setPart(20);
			
				// Procesar
				ComisionService service = new ComisionService();
				model = service.procesar(model);
				// Reporte		
				System.out.println("Categoría del curso:: " +  model.getCurso());
				System.out.println("Descripción del curso: " +  model.getDescripcion());
				System.out.println("Participantes: " +  model.getPart());
				System.out.println("Precio del curso: " +  model.getPrecio());
				System.out.println("Importe: " +  model.getImporte());
				System.out.println("Impuesto: " +  model.getImpuesto());
				System.out.println("Total a pagar: " +  model.getTotal());
				System.out.println("Comision: " +  model.getComision());
	}


}

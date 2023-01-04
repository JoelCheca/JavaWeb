package pe.edu.uni.prueba;

import pe.edu.uni.model.ClinicaModel;
import pe.edu.uni.service.ClinicaService;

public class Prueba {

public static void main(String[]args){
		
				// Datos
				ClinicaModel model = new ClinicaModel();	
				
				 model.setServicio(1);
				 model.setPrecio(2);
				 model.setCantidad(10);
				 model.setTipocliente(1);
				 model.setFrecuente(true);
				 model.setDescripcion("paracetamol");
				
				
			
				// Procesar
				ClinicaService service = new  ClinicaService();
				model = service.procesar(model);
				// Reporte		
				System.out.println("Descripción: " +  model.getDescripcion());
				System.out.println("Importe: " +  model.getImporte());
				System.out.println("Descuento: " +  model.getDescuento());
				System.out.println("Subtotal: " +  model.getSubtotal());
				System.out.println("Impuesto: " +  model.getImpuesto());
				System.out.println("Total: " +  model.getTotal());
				
	}

	
	
}

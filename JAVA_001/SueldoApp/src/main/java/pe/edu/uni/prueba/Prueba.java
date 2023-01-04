package pe.edu.uni.prueba;

import pe.edu.uni.model.SueldoModel;
import pe.edu.uni.service.SueldoService;

public class Prueba {
	
	public static void main(String[]args){
		
		// Datos
				SueldoModel model = new SueldoModel();
				model.setHorasDt(6);
				model.setDiasT(28);
				model.setPagoHoras(120);
				model.setCanHijos(3);
					
				// Procesar
				SueldoService service = new SueldoService ();
				model = service.procesar(model);
				// Reporte		
				System.out.println("Horas trabajadas: " +  model.getHorasTT());
				System.out.println("Pago por hora: " +  model.getPagoHoras());
				System.out.println("Sueldo: " +  model.getSueldo());
				System.out.println("Asignación: " +  model.getAsignacion());
				System.out.println("Bono: " +  model.getBono());
				System.out.println("Ingresos: " +  model.getIngreso());
				System.out.println("Renta: " +  model.getRenta());
				System.out.println("Neto: " +  model.getNeto());
	}


}

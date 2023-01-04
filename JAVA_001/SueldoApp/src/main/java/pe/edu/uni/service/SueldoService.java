package pe.edu.uni.service;

import pe.edu.uni.model.SueldoModel;

public class SueldoService {

	public SueldoModel procesar(SueldoModel model) {
		// Datos
		int horasDt = model.getHorasDt();
		int diasT = model.getDiasT();
		double pagoHoras= model.getPagoHoras();
		double canHijos= model.getCanHijos();
		// Proceso	
		
		int horasTT=(horasDt* diasT);
		double sueldo=(horasTT * pagoHoras);
		double  asignacion=(canHijos*80);	
		
		double bono=0;	
		
		if(horasTT > 150)
		{
			bono = sueldo*0.15;
			
		}
		
		double ingreso = (sueldo+asignacion+bono);
		
		double renta =0;
		
		if(ingreso > 1500)		{
			renta=ingreso*0.08;			
		}
		
		double neto = ingreso-renta;
		
		// Reporte	
		model.setHorasTT(horasTT);
		model.setPagoHoras(pagoHoras);
		model.setSueldo(sueldo);
		model.setAsignacion(asignacion);
		model.setBono(bono);
		model.setIngreso(ingreso);
		model.setRenta(renta);
		model.setNeto(neto);	
		return model;

	}

}
	
	
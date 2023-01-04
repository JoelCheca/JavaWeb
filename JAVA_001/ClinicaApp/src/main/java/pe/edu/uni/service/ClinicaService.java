package pe.edu.uni.service;

import pe.edu.uni.model.ClinicaModel;

public class ClinicaService {
	
	public ClinicaModel procesar(ClinicaModel model) {
		
		int servicio= model.getServicio();
		double precio = model.getPrecio();
		int cantidad = model.getCantidad();
		int tipocliente = model.getTipocliente();
		boolean frecuente = model.isFrecuente();
		String descripcion = model.getDescripcion();
		
		double porcendesc=0;
		
		
		switch (tipocliente) {
		case 1:
			if (servicio==1) {
				porcendesc=(0.9);				
			}
			if (servicio==2) {
				porcendesc=(0.9);				
			}
			if (servicio==3) {
				porcendesc=(0.95);				
			}
			if (servicio==4) {
				porcendesc=(0.80);				
			}
			if (servicio==5) {
				porcendesc=(0.60);				
			}
			if (servicio==6) {
				porcendesc=(1);				
			}
			if (servicio==7) {
				porcendesc=(0.60);				
			}			
			
			break;
		case 2:
			if (servicio==1) {
				porcendesc=(0.8);				
			}
			if (servicio==2) {
				porcendesc=(0.8);				
			}
			if (servicio==3) {
				porcendesc=(0.85);				
			}
			if (servicio==4) {
				porcendesc=(0.75);				
			}
			if (servicio==5) {
				porcendesc=(0.50);				
			}
			if (servicio==6) {
				porcendesc=(0.90);				
			}
			if (servicio==7) {
				porcendesc=(0.50);				
			}
			break;
	
		case 3:					
			if (frecuente==false) {
				if (servicio<=7) {
					porcendesc=(0);				
				}
			}
			if (frecuente== true) {
				if (servicio==1) {
					porcendesc=(0.15);				
				}			
				if (servicio==2) {
					porcendesc=(0.15);				
				}
				if (servicio==3) {
					porcendesc=(0.20);				
				}
				if (servicio==4) {
					porcendesc=(0.15);				
				}
				if (servicio==5) {
					porcendesc=(0.10);				
				}
				if (servicio==6) {
					porcendesc=(0.10);				
				}
				if (servicio==7) {
					porcendesc=(0.05);				
				}			
			}
			
			break;
			}
		
			double importe = (precio * cantidad);
			double descuento = (porcendesc * importe);
			double total = (importe - descuento);
			double impuesto = (total - (total / 1.18));
			double subtotal = (total - impuesto);

			// Reporte
			model.setDescripcion(descripcion);
			model.setImporte(Math.round((importe) * 100.0) / 100.0);
			model.setDescuento(Math.round((descuento) * 100.0) / 100.0);
			model.setSubtotal(Math.round((subtotal) * 100.0) / 100.0);
			model.setImpuesto(Math.round((impuesto) * 100.0) / 100.0);
			model.setTotal(Math.round((total) * 100.0) / 100.0);

			return model;
		
	}

	
}

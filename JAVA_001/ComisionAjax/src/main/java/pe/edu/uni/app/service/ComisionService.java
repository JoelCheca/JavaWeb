package pe.edu.uni.app.service;

import pe.edu.uni.app.Model.ComisionModel;

public class ComisionService {

	public ComisionModel procesar(ComisionModel model) {
		
		
		// Datos
		int cat = model.getCat();			
		int part = model.getPart();
		
		
		
		// Proceso		
		double total = part*precio(cat);
		double importe = ( (part*precio(cat))/1.18);
		double impuesto =(importe*0.18);	
		double precio = precio(cat);
		double gana1=ganancia1(cat);
		double gana2=ganancia2(cat);	
		double comision=0;	
		if (part>15){
	        comision =  (Math.round((importe * gana2)  *100.0)/100.0);      
	      
	             }
	    else {
	    	comision =  (Math.round((importe * gana1)  *100.0)/100.0);     
	            }
		
		
		
		
		
		// Reporte	
		model.setCurso(nombrCurso(cat));
		model.setDescripcion(descrip(cat));
		model.setTotal(Math.round((total)*100.0)/100.0);	
		model.setImporte(Math.round((importe) *100.0)/100.0);		
		model.setImpuesto(Math.round((impuesto)*100.0) /100.0  );		
		model.setPrecio(precio);
		model.setComision(comision);		
		return model;
	}

	public String descrip(int cat) {
		return switch (cat) {
		case 1 -> "Desarrollo de Aplicaciones con Spring Framework";
		case 2 -> "Nivel básico-Empresarial";
		case 3 -> "Gestión y dirección de empresas";
		case 4 -> "Informática Básica";
		default -> "CURSO NO DISPONIBLE";
		};	
	}

	public String nombrCurso(int cat) {
		return switch (cat) {
		case 1 -> "Programación";
		case 2 -> "Ofimática";
		case 3 -> "Administración";
		case 4 -> "Otros";
		default -> "";
		};			
	}
	

	public double precio(int cat) {
		return switch (cat) {
		case 1 -> 800.00;
		case 2 -> 500.00;
		case 3 -> 1800.00;
		default -> 1000.00;
		};
	
	}
	
	
	private double ganancia1 (int cat) {
		return switch (cat) {
		case 1 -> 0.05;		
		case 2 -> 0.03;
		case 3 -> 0.08;
		default -> 0.04;
		};
		
		
	}
	
	private double ganancia2 (int cat) {
		return switch (cat) {
		case 1 -> 0.07;
		case 2 -> 0.05;
		case 3 -> 0.10;
		default -> 0.06;
		};
		
		
	}

	
	
}

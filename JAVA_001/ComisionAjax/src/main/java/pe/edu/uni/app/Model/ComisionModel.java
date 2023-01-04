package pe.edu.uni.app.Model;

public class ComisionModel {

	// Datos de entrada
	private int part, cat;
	private double precio; 

	// Salida
	private double importe;
	private double impuesto;
	private double comision;
	private double gana1, gana2, total;
	private String curso;
	private String descripcion;
	
	
	public ComisionModel() {
		
		
	}


	public ComisionModel(int part, int cat, double precio) {
		super();
		this.part = part;
		this.cat = cat;
		this.precio = precio;

	}


	public int getPart() {
		return part;
	}


	public void setPart(int part) {
		this.part = part;
	}


	public int getCat() {
		return cat;
	}


	public void setCat(int cat) {
		this.cat = cat;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public double getGana1() {
		return gana1;
	}


	public void setGana1(double gana1) {
		this.gana1 = gana1;
	}


	public double getGana2() {
		return gana2;
	}


	public void setGana2(double gana2) {
		this.gana2 = gana2;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}


	public double getComision() {
		return comision;
	}


	public void setComision(double comision) {
		this.comision = comision;
	}


	


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getCurso() {
		return curso;
	}


	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	

}

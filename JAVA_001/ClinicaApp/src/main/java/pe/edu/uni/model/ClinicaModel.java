package pe.edu.uni.model;

public class ClinicaModel {
	
	//datos entrada
	private int tipocliente;
	private boolean frecuente;
	private int servicio;
	private String descripcion;
	private double precio;
	private int cantidad;
	//datos salida
	private double importe;
	private double descuento;
	private double subtotal;
	private double impuesto;
	private double total;
	private double porcendesc;
	
	
	 public ClinicaModel()  {
		this.tipocliente=0;
		this.frecuente=true;
		this.servicio=0;
		this.descripcion =null;
		this.precio =0;
		this.cantidad=0;
		//datos salida
		this.importe=0;
		this.descuento=0;
		this.subtotal=0;
		this.impuesto=0;
		this.total=0;
		this.porcendesc=0;
	}


	public ClinicaModel(int tipocliente, boolean frecuente, int servicio, String descripcion, double precio,
			int cantidad, double importe, double descuento, double subtotal, double impuesto, double total,
			double porcendesc) {
		super();
		this.tipocliente = tipocliente;
		this.frecuente = frecuente;
		this.servicio = servicio;
		this.descripcion = descripcion;
		this.precio = precio;
		this.cantidad = cantidad;
		this.importe = importe;
		this.descuento = descuento;
		this.subtotal = subtotal;
		this.impuesto = impuesto;
		this.total = total;
		this.porcendesc = porcendesc;
	}


	public int getTipocliente() {
		return tipocliente;
	}


	public void setTipocliente(int tipocliente) {
		this.tipocliente = tipocliente;
	}


	public boolean isFrecuente() {
		return frecuente;
	}


	public void setFrecuente(boolean frecuente) {
		this.frecuente = frecuente;
	}


	public int getServicio() {
		return servicio;
	}


	public void setServicio(int servicio) {
		this.servicio = servicio;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getImporte() {
		return importe;
	}


	public void setImporte(double importe) {
		this.importe = importe;
	}


	public double getDescuento() {
		return descuento;
	}


	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}


	public double getSubtotal() {
		return subtotal;
	}


	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	public double getImpuesto() {
		return impuesto;
	}


	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getPorcendesc() {
		return porcendesc;
	}


	public void setPorcendesc(double porcendesc) {
		this.porcendesc = porcendesc;
	}
	

	
	
	
}

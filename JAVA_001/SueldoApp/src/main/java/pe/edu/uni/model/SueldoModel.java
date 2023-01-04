package pe.edu.uni.model;

public class SueldoModel {

	// Datos ingreso
		private int horasDt; // Horas diarias trabajadas
		private int diasT;	// Dias trabajados
		private double pagoHoras;	//Pago por horas
		private int canHijos;	// Cantidad hijos
		// Datos proceso
		private int horasTT;	// horas totales trabajadas = horasDt * diasT
		private double sueldo;// horasTT * pagoHoras
		private double asignacion;// canHijos * 80
		private double bono;// if(horasTT >=150)sueldo * 0.15
		private double ingreso;// sueldo + asignacion + bono
		private double renta;// (ingresos > 1500) ingresos - 8%(0.08)
		private double neto;// (ingresos - renta)
	
	
	
		public SueldoModel() {
			
			this.horasDt = 0;
			this.diasT = 0;
			this.pagoHoras = 0;
			this.canHijos = 0;

			this.horasTT = 0;
			this.sueldo = 0;
			this.asignacion = 0;
			this.bono = 0;
			this.ingreso = 0;
			this.renta = 0;
			this.neto = 0;
		}



		public SueldoModel(int horasDt, int diasT, double pagoHoras, int canHijos, int horasTT, double sueldo,
				double asignacion, double bono, double ingreso, double renta, double neto) {
			super();
			this.horasDt = horasDt;
			this.diasT = diasT;
			this.pagoHoras = pagoHoras;
			this.canHijos = canHijos;
			this.horasTT = horasTT;
			this.sueldo = sueldo;
			this.asignacion = asignacion;
			this.bono = bono;
			this.ingreso = ingreso;
			this.renta = renta;
			this.neto = neto;
		}



		public int getHorasDt() {
			return horasDt;
		}



		public void setHorasDt(int horasDt) {
			this.horasDt = horasDt;
		}



		public int getDiasT() {
			return diasT;
		}



		public void setDiasT(int diasT) {
			this.diasT = diasT;
		}



		public double getPagoHoras() {
			return pagoHoras;
		}



		public void setPagoHoras(double pagoHoras) {
			this.pagoHoras = pagoHoras;
		}



		public int getCanHijos() {
			return canHijos;
		}



		public void setCanHijos(int canHijos) {
			this.canHijos = canHijos;
		}



		public int getHorasTT() {
			return horasTT;
		}



		public void setHorasTT(int horasTT) {
			this.horasTT = horasTT;
		}



		public double getSueldo() {
			return sueldo;
		}



		public void setSueldo(double sueldo) {
			this.sueldo = sueldo;
		}



		public double getAsignacion() {
			return asignacion;
		}



		public void setAsignacion(double asignacion) {
			this.asignacion = asignacion;
		}



		public double getBono() {
			return bono;
		}



		public void setBono(double bono) {
			this.bono = bono;
		}



		public double getIngreso() {
			return ingreso;
		}



		public void setIngreso(double ingreso) {
			this.ingreso = ingreso;
		}



		public double getRenta() {
			return renta;
		}



		public void setRenta(double renta) {
			this.renta = renta;
		}



		public double getNeto() {
			return neto;
		}



		public void setNeto(double neto) {
			this.neto = neto;
		}



		
	
	
}

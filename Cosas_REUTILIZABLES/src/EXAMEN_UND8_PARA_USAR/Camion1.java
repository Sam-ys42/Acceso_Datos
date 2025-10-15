package EXAMEN_UND8_PARA_USAR;

public class Camion1 extends Vehiculo1{

	private double capacidadCarga;
	public Camion1(String marca, String modelo, int año, double kilometraje, double capacidadCarga) {
		super(marca, modelo, año, kilometraje);
		this.capacidadCarga = capacidadCarga;
	}
	
	public String mostrarInfo() {
		return "--- Camión ---\n"+super.mostrarInfo()+" | Capacidad de Carga: "+ capacidadCarga+"t"+ "\nConsumo: "+ calcularConsumo(capacidadCarga)+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento();
	}
	
	public String calcularMantenimiento() {
		return super.calcularMantenimiento()+ "la insección de freno puede tardar un poco, suspención al 50%...";
	}
	
	public double calcularConsumo(double carga) {
		return (800 * 10) / (100 * carga);
	}
	

	
}

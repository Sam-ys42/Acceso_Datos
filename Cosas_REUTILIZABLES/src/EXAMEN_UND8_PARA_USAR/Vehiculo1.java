package EXAMEN_UND8_PARA_USAR;

public class Vehiculo1 {
	
	private String marca;
	private String modelo;
	private int año;
	protected double kilometraje;
	
	public Vehiculo1(String marca, String modelo, int año, double kilometraje) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.año = año;
		this.kilometraje = kilometraje;
	}
	
	public String mostrarInfo() {
		return "Marca: " + marca + "| Modelo: " + modelo + "| Año: " + año + "| Kilometraje: " + kilometraje + " km ";
	}

	public double calcularConsumo(double litros, double distancia) {
		return (distancia * litros) / 100;
	}
	
	public String calcularMantenimiento() {
		return "Calculando mantenimiento...";
	}
	
	
}

package EXAMEN_UND8_PARA_USAR;


public class Automovil1 extends Vehiculo1 {

	private int numeroPuertas;
	
	public Automovil1(String marca, String modelo, int año, double kilometraje, int numeroPuertas) {
		super(marca, modelo, año, kilometraje);
		this.numeroPuertas = numeroPuertas;
	}

	public String mostrarInfo() {
		return "--- Automovil ---\n"+super.mostrarInfo()+" | Puertas: "+ numeroPuertas+ "\nConsumo: "+ calcularConsumo()+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento();
		}
	
	public String calcularMantenimiento() {
		return super.calcularMantenimiento()+ "la revisión de freno se aceite se esta llevando a cabo.";
	}
	
	public double calcularConsumo() {
		return (300 * 5) / 100;
	}
	

	
	
	
}

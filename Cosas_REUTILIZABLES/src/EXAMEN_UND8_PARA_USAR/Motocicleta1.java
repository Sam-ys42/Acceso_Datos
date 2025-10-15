package EXAMEN_UND8_PARA_USAR;

public class Motocicleta1 extends Vehiculo1 {

	private String tipoMotor;
	
	public Motocicleta1(String marca, String modelo, int año, double kilometraje, String tipoMotor) {
		super(marca, modelo, año, kilometraje);
		this.tipoMotor = tipoMotor;
	}
	
	public String calcularMantenimiento() {
		return super.calcularMantenimiento()+"estamos evaluando el motor...";
	}
	
	public double calcularConsumo(double distancia) {
		return (distancia*3)/50;
	}
	
	public String mostrarInfo() {
		return "--- Motocicleta ---\n"+super.mostrarInfo()+" | Tipo Motor: "+ tipoMotor+ "\nConsumo: "+ calcularConsumo(kilometraje)+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento();
	}
	
}

package PruebaUNIT8;

public class Motocicleta extends Vehiculo{
	protected String tipoMotor;
public Motocicleta(String marca, String modelo, int anyo, double kilometraje, String tipoMotor) {
		super(marca, modelo, anyo, kilometraje);
		this.tipoMotor= tipoMotor;
	}


public String mostrarInfo() {
	return "--- Motocicleta ---\n"+super.mostrarInfo()+" | Tipo Motor: "+ tipoMotor+ "\nConsumo: "+ calcularConsumo(kilometraje)+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento();
}


public String calcularMantenimiento() {
	return super.calcularMantenimiento()+"estamos evaluando el motor...";
}
public double calcularConsumo(double distancia) {
	return distancia*20;
}
}

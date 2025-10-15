package PruebaUNIT8;

public class Automovil extends Vehiculo{

protected int numeroPuertas;

public Automovil(String marca, String modelo, int anyo, double kilometraje, int numeroPuertas) {
	super(marca, modelo, anyo, kilometraje);
	this.numeroPuertas=numeroPuertas;
	// TODO Auto-generated constructor stub
}
public String mostrarInfo() {
	return "--- Automovil ---\n"+super.mostrarInfo()+" | Puertas: "+ numeroPuertas+ "\nConsumo: "+ calcularConsumo(30, kilometraje)+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento()+ "\n";
}
public String calcularMantenimiento() {
	return super.calcularMantenimiento()+ "la revisión de freno se aceite se esta llevando a cabo.";
}
public double calcularConsumo(int litros, double kilometraje) { // calcular consumo sin parametros
	return (litros*kilometraje)/100;
}
public void rellenarLimpiaParabrisas() {
	
}
}

package PruebaUNIT8;

public class Camion extends Vehiculo {

protected double capacidadCarga;
public Camion(String marca, String modelo, int anyo, double kilometraje, double capacidadCarga) {
	super(marca, modelo, anyo, kilometraje);
	this.capacidadCarga= capacidadCarga;
}

public String mostrarInfo() {
	return "--- Camión ---\n"+super.mostrarInfo()+" | Capacidad de Carga: "+ capacidadCarga+"t"+ "\nConsumo: "+ calcularConsumo(capacidadCarga)+ "km/l"+ "\nMantenimiento: "+ calcularMantenimiento();
}


public String calcularMantenimiento() {
	return super.calcularMantenimiento()+ "la insección de freno puede tardar un poco, suspención al 50%...";
}
public double calcularConsumo(double cargasoportada) {
	return cargasoportada*100;
}

}

package PruebaUNIT8;



public class Vehiculo {
protected String marca;
protected String modelo;
protected int anyo;
protected double kilometraje;
	
public Vehiculo(String marca, String modelo, int anyo, double kilometraje) {
	
	
	System.out.print("Marca: ");
	this.marca = marca;
	System.out.print("Modelo: ");
	this.modelo = modelo;
	System.out.print("Año: ");
	this.anyo = anyo;
	System.out.print("Kilometraje: ");
	this.kilometraje = kilometraje;
}
public String mostrarInfo() {
	return "Marca: "+ marca+ " | Modelo: "+modelo+ " | Año: "+ anyo+ " | Kilometraje: "+ kilometraje+"km" ;
}
public double calcularConsumo(double litros, double distancia) { // litros* distancia /100
	return litros* distancia/100;
}
public String calcularMantenimiento(){
	return "Calculando...";
}

	
}

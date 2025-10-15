package PruebaUNIT9;

public class Laptop extends Dispositivo {
	protected double tamanioPantalla;
	public Laptop(String marca, String modelo, double precio, double pantalla) {
		super(marca, modelo, precio);
		this.tamanioPantalla= pantalla;
		
	}

	public String mostrarInfo() {
		return "Laptop - "+super.mostrarInfo()+"| Tamaño de la pantalla: "+ tamanioPantalla+ " pulgadas";
		}
	
	@Override
	public double calcularDescuento(double porcentaje) {
		
		return  precio - precio*(porcentaje/100);
	}

}

package PruebaUNIT9;

public abstract class Dispositivo {
	protected String marca;
  protected String modelo;
  protected double precio;
  protected static double descuento;
  
  public Dispositivo(String marca, String modelo, double precio) {
	  this.marca=marca;
	  this.modelo= modelo;
	  this.precio = precio;
  }
  public String mostrarInfo() {
	return marca+ " "+ modelo+ "| Precio: "+ calcularDescuento(descuento)+ " USD ";
}
  public abstract double calcularDescuento(double porcentaje);
  
}

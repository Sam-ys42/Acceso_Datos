package UNIT8.ejercicioCamisetas;

public class Camiseta {
	protected int numeroPedido;
	protected String tamaño;
	protected String color;
	protected double precio;
	
	
	public Camiseta() {	}
	
	public void setNumeroPedido(int numeroPedido) {
		this.numeroPedido= numeroPedido;
	}
	public void setTamaño(String tamaño) {
		this.tamaño= tamaño;
		if(tamaño.equalsIgnoreCase("XXL") || tamaño.equalsIgnoreCase("XXXL")) {
			this.precio = 22.99;
		}else {
			this.precio = 9.99;
		}
	}
	public void setColor(String color) {
		this.color = color; 
	}
	
	
	public int getNumeroPedido() {
		return numeroPedido;
	}
	
	public String getTamaño() {
		return tamaño;
	}
	public String getColor() {
		return color;
	}
	public double getPrecio() {	
		return precio;
}
@Override
public String toString() {
	return "Camiseta [numPedido=" + numeroPedido + ", tamano=" + tamaño + ", color=" + color + ", precio=" + precio
			+ "]";
}
	
	
}

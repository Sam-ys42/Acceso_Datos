package PruebaUNIT9;

public class Telefono extends Dispositivo {
protected int cantidadCamaras;
public Telefono(String marca, String modelo, double precio, int camaras) {
	super(marca, modelo, precio);
	this.cantidadCamaras= camaras; 
}
public String mostrarInfo() {
	return "Teléfono - "+super.mostrarInfo()+"| Cámaras: "+ cantidadCamaras;
	}
	
	@Override
	public double calcularDescuento(double porcentaje) {
		return precio = precio -precio*(porcentaje/100);
		
	}

}

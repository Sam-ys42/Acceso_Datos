package PruebaUNIT9;

public class Tablet extends Dispositivo{
	protected boolean tieneLapizOptico;
	public Tablet(String marca, String modelo, double precio, boolean tieneLapizOptico) {
		super(marca, modelo, precio);
		this.tieneLapizOptico= tieneLapizOptico;
	}

	
	public String mostrarInfo() {
		String lapiz="";
		if(tieneLapizOptico== true) {
			lapiz = "sí";
		}
		else lapiz = "no";
		return "Tablet - "+super.mostrarInfo()+"| Lápiz Óptico: "+ lapiz;
		}

	@Override
	public double calcularDescuento(double porcentaje) {
		
		return precio = precio -precio*(porcentaje/100);
	}

}

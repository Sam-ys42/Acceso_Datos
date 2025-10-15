package UNIT8.velasEjercicio;
public class Vela {
	
	private String color;
	protected double altura;
	protected double precio;
	

	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public double getAltura() {
		return altura;
	}


	public void setAltura(double altura) {
		this.altura = altura;
		this.precio = 2*altura;
	}
	
	@Override
	public String toString() {
		return "Vela [color=" + color + ", altura=" + altura + ", precio=" + precio + "]";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	



}
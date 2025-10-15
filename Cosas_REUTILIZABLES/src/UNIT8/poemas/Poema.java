package UNIT8.poemas;

public class Poema {
	

	private String nombre;
	private int numLineas;
	
	public Poema(String nombre, int numLineas) {
		this.nombre = nombre;
		this.numLineas = numLineas;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getNumLineas() {
		return numLineas;
	}


}
package UNIT8.poemas;

public class Quintilla extends Poema{
	
	public Quintilla(String titulo) {
		super(titulo, 5);
	}

	@Override
	public String toString() {
		return "Quintilla [Nombre()=" + getNombre() + ", NumLineas()=" + getNumLineas() + "]";
	}
	
	
}
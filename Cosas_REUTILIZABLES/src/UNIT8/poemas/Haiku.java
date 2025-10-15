package UNIT8.poemas;

public class Haiku extends Poema{
	
	public Haiku(String titulo) {
		super(titulo, 3);
	}

	@Override
	public String toString() {
		return "Haiku [Nombre()=" + getNombre() + ", NumLineas()=" + getNumLineas() + " ]";
	}
	
}
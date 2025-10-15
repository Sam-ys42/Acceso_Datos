package UNIT8.poemas;

public class Pareado extends Poema{
	
	public Pareado(String titulo) {
		super(titulo, 2);
	}

	@Override
	public String toString() {
		return "Pareado [Nombre()=" + getNombre() + ", NumLineas()=" + getNumLineas() +  "]";
	}

}
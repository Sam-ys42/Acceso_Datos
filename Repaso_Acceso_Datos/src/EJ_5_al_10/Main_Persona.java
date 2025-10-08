package EJ_5_al_10;

public class Main_Persona {

	public static void main(String[] args) {
		Persona persona1 = new Persona("Pepe", "Fernandez", "27272727Q", 23, false);

		Persona persona2 = new Persona("Ana", "Perez", "46464646E", 18, true);
		if(persona1.getEdad() == persona2.getEdad()) {
			System.out.println(persona1.getNombre()+ " y " +persona2.getNombre()+ " tienen la misma edad");
		}
		else if (persona1.getEdad()> persona2.getEdad()) {
			System.out.println(persona1.getNombre()+ " es mayor que " +persona2.getNombre() );
		}
		else {
			System.out.println(persona2.getNombre()+ " es mayor que " +persona1.getNombre() );

		}

	}

}

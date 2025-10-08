package EJ_5_al_10;

public class Ejercicio_23 {

	public static void main(String[] args) {
		Persona array[] = new Persona[5];
		array[0] = new Persona("Pepe"," Sánchez", "23232323R", 23, false);
		array[1] = new Persona("Ana"," Pintado", "34343434E", 90, true);
		array[2] = new Persona("Nacho"," Hurtado", "56565656U", 19, false);
		array[3] = new Persona("Ignacio"," Bravo", "45454545Y", 56, true);
		array[4] = new Persona("Samanta"," Lugo", "78787878O", 33, false);
		// TODO Auto-generated method stub
		
		for (Persona persona : array) {
			System.out.println(persona);
		}

	}

}

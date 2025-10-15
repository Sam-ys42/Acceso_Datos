package UNIT5;

public class ejercicio4_eliminar_elemento {

	public static void main(String[] args) {
		
		int valores[] = new int[5];
		
		valores[0]=20;
		valores[1]=23;
		valores[2]=43;
		valores[3]=45;
		valores[4]=52;
		
		boolean encontrado=false;
		int i=0;
		
		while(!encontrado && i<5) {
			if (valores[i]==43) {
				encontrado=true;
				valores[1]=-1;
			} else {
				i++;
			}
		}
		
		if (encontrado) {
			System.out.println("El array SÍ contiene el valor buscado.");
		} else {
		
				System.out.println("El array no contiene el valor buscado.");
		}
	}
}

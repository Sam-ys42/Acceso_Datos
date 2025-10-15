package UNIT3;
import java.util.Scanner;
public class ejercicio16Jubilacion {
	public static final int interes= 4;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int edad;
		double ahorro, ahorrototal=0;
		
		do {
			System.out.println("Dime cuántos años le queda hasta la jubilación: " );
			edad = input.nextInt();
		}while(edad <=0);
		
		do {
			System.out.println("Dime cuánto dinero puedes ahorrar anualmente: " );
			ahorro = input.nextInt();
		}while(ahorro <=0);
		for (int i=0; i<edad; i++) {
			ahorrototal = ahorrototal +(ahorro*interes) +ahorro;
		}
		System.out.println("Vamos a suponer que no se ganan intereses sobre el dinero. \n "
				+ "Cuando se jubile, tendrá la valiosa cantidad de: "  + ahorrototal + "€");
	}

}

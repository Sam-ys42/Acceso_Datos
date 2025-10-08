package EJ_5_al_10;
import java.util.Scanner;
public class Ejercicio7 {

	public static void main(String[] args) {
		// ejercio 7
		Scanner input = new Scanner(System.in);
		System.out.print("Dame 1 número: ");
		int numero1 = input.nextInt();
		System.out.print("Dame otro número: ");
		int numero2 = input.nextInt();
		if(numero1== numero2) {
			System.out.println("Son iguales");
		}else {
			System.out.println("No son iguales");
		}

		System.out.print("Dame 1 número: ");
		String palabra = input.nextLine();
		System.out.print("Dame otro número: ");
		String palabra2 = input.nextLine();
		if(palabra.equalsIgnoreCase(palabra2)) {
			System.out.println("Son iguales");
		}else {
			System.out.println("No son iguales");
		}
		
	}

}

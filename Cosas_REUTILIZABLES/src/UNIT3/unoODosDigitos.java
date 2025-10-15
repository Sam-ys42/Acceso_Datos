package UNIT3;

import java.util.Scanner;
public class unoODosDigitos {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce 1 número: ");
		int numero = input.nextInt();
		if (numero > 9) {
			System.out.println("El número" +numero+" tiene 2 dígitos");
		}
		else {
			System.out.println("El número" +numero+" tiene 1 dígito");
		}
	}

}

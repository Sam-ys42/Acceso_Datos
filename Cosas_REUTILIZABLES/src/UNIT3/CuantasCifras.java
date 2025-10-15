package UNIT3;

import java.util.Scanner;
public class CuantasCifras { // esta está mejor

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("introduce 1 número: ");
		int numero = input.nextInt(), cifras=0;
		while (numero !=0) {
			numero = numero/10;
			cifras++;
		}
		System.out.println( "El número tiene "+cifras +"cifras.");

	}

}

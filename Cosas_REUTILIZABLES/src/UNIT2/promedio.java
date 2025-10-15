package UNIT2;

import java.util.Scanner;
public class promedio {
	public static void main (String[]args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Dime 3 notas: ");
		//double promedio = (input.nextDouble() + input.nextDouble() + input.nextDouble())/3;
		System.out.printf("Tu promedio es: " +  "%.2f",(input.nextDouble() + input.nextDouble() + input.nextDouble())/3);
	}
}
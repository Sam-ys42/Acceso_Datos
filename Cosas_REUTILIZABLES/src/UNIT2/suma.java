package UNIT2;

import java.util.Scanner;

public class suma {
	static int numero1 = 8; 
	
	public static void main(String[] args) {
		Scanner numeros = new Scanner(System.in);
		
		int suma= 0;
		int numero1= numeros.nextInt();
		int numero2= numeros.nextInt();

		suma = numero1 + numero2;
		System.out.println("la suma es: " + suma);
		int numero3= numeros.nextInt();

		suma += numero3;
		System.out.println("la suma es: " + suma);

	}

}

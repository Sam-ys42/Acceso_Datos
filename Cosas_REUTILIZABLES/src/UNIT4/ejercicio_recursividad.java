package UNIT4;
import java.util.Scanner;
public class ejercicio_recursividad {
	public static int factorial(int numero) {
		if(numero==1) {
			return 1;
		}
		return numero*factorial(numero-1);
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Introduce un numero para calcular su factorial: ");
		int n = input.nextInt();
		Pedir.E("El factorial es: "+ factorial(n));

	}

}

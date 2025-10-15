package UNIT4;
import java.util.Scanner;
public class Ejercicio9Unit4 {
	 // Escribe un método llamado cuadrado que acepte un argumento entero y devuelva el cuadrado de ese argumento. 
	public static int Cuadrado(int a) {
		a= a*a;
		return a;
	}
	public static void main(String[] args) {
		Pedir.E("Introduce in número entero: ");
		Scanner input = new Scanner(System.in);
		int a = input.nextInt();
		Pedir.E("El cuadrado de " + a + " es: "+ Cuadrado(a));

	}

}

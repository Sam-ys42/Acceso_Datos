package UNIT4;
import java.util.Scanner;
public class Ejercicio4Unit4 { // Escribe un programa que pida la edad por teclado y muestre por pantalla si eres mayor de edad o no. Implementa y utiliza la función: 

								//boolean esMayorEdad(int a) // Devuelve verdadero si a>=18, falso en caso contrario
	public static boolean esMayorEdad(int a) {
		if(a>=18) {
			return true;
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("introduce tu edad: ");
		int a = input.nextInt();
		if(esMayorEdad(a)) {
			Pedir.E("Eres mayor de edad");
		}else {
			Pedir.E("NO eres mayor de edad...");
		}

	}

}

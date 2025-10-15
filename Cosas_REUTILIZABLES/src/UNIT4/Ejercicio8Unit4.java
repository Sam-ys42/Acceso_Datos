package UNIT4;
import java.util.Scanner;
public class Ejercicio8Unit4 { // Escribe un método llamado diezVeces. El método debe 
								//aceptar un valor de tipo doble y devuelve un valor doble que es diez veces el valor del argumento.

	public static double diezVeces(double a) {
		a= a*10;
		return a;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Introduce un valor: ");
		double a = input.nextDouble();
		Pedir.E("Valor final: "+diezVeces(a));

	}

}

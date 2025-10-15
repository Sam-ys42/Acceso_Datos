package UNIT4;
import java.util.Scanner;
public class Ejercicio15Unit4 {

	public static String funcionNIF(int a) {
		String NIF[]={"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
		return NIF[a];
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Dime su DNI");
		int DNI = input.nextInt();
		int numero = DNI%23;
		Pedir.E("Su número NIF es: "+ funcionNIF(numero) /*+ " "+ numero*/);

	}

}

package UNIT4;
import java.util.Scanner;
public class Ejercicio11Unit4 {
	
	public static double millas_a_kilometros(int millas) {
		return millas*1.60934;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Dime las millas: ");
		int a = input.nextInt();
		Pedir.E("El equivalente de "+ a+ " millas, son " + millas_a_kilometros(a)+ " kilómetros" );
	}
}

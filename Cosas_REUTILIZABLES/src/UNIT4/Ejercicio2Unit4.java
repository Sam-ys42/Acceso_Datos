package UNIT4;
import java.util.Scanner;
public class Ejercicio2Unit4 {

	public static double Media(double a, double b, double c) {
		double media = ((a+b+c)/3);
		return media;
	}
	public static void main(String[] args) {  // Escribe un método Java para calcular la media de tres números.
		Scanner input = new Scanner(System.in);
		System.out.println("Vamos a calcular la media de 3 números: ");
		Pedir.tresNumeros(0);
		double a = input.nextInt();
		Pedir.tresNumeros(1);
		double b= input.nextInt();
		Pedir.tresNumeros(2);
		double c = input.nextInt();
		System.out.printf("La media de los 3 números es: %.2f" ,Media(a,b,c));
		
		
		

	}

}

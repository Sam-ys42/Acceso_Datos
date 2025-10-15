package UNIT4;
import java.util.Scanner;
public class Ejercicio12Unit4 {
	
public static double AreaTriangulo(int a, int b, int c) {
	double s= (a+b+c)/2;
	
	return Math.sqrt(s*(s-a)*(s-b)*(s-c));
}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int lado1, lado2, lado3;
		Pedir.E("Voy a pedirte 3 lados de un triángulo: ");
		Pedir.tresNumeros(0);
		lado1= input.nextInt();
		Pedir.tresNumeros(1);
		lado2= input.nextInt();
		Pedir.tresNumeros(2);
		lado3= input.nextInt();
		
		Pedir.E("Lado-1: "+ lado1);
		Pedir.E("Lado-2: "+ lado2);
		Pedir.E("Lado-3: "+ lado3);
		Pedir.E("El lado del triángulo es "+ AreaTriangulo(lado1,lado2,lado3) + " unidades cuadradas");
	}

}

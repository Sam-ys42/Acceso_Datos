package UNIT4;
import java.util.Scanner; // 
public class Ejercicio3Unit4 {

	
	public static double multiplica(double a, double b) {
		double multiplicacion = a*b;
		return multiplicacion;
	}
	public static void main(String[] args) { // Escribe un programa que pida dos números reales por teclado y muestre por pantalla el resultado de multiplicarlos. Implementa y utiliza la función: 

												//double multiplica(double a, double b) // Devuelve la multiplicación de dos números 
		Scanner input = new Scanner(System.in);
		Pedir.tresNumeros(0);
		double a = input.nextInt();
		Pedir.tresNumeros(1);
		double b = input.nextInt();
		System.out.printf("El resultado de multiplicar " + a + " por "+ b +" es: %.2f", multiplica(a,b));

	}

}

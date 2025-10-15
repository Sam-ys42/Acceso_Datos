package Tareas_Evaluables;
import java.util.Scanner;
public class Tarea4_1 {
	public static double IVA = 0.21; // constante del IVA
	public static double precioConIVA(double precio) {
		
		return precio+precio*IVA;    // devuelvo el precio con el IVA incrementado
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Introduce 5 precios:");
		for(int i=1; i<6; i++) {					// Con esta estructura de programa, es posible preguntar más que solo 5 precios, cambiando el valor "6" por un valor "n"
			System.out.print(i+ "- ");			// Aquí uso la variable "i" para orientarme en qué precio voy
			double a= input.nextDouble();
			System.out.printf("Precio final tras sumarle el IVA: %.2f€ \n", precioConIVA(a));
		}
		
		

	}

}

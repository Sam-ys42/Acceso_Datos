package Tareas_Evaluables;  // pide al usuario el radio de un circulo en int y output en consola el D, 
							//la circunferencia, y área, con double pi= 3,14159 que se define como constante 
import java.util.Scanner;  // importamos la librería "Scanner", la cual nos permite almacenar información que introduzca el usuario
public class Tarea2_1 {

	public static void main(String[] args) { 					// D= 2r ; Circunferencia= 2*pi*r ; Área= pi*r*r
		Scanner input = new Scanner(System.in);					// declaramos un objeto llamado "input" que nos ayudará a preguntar información al usuario
		int r;													// declaramos la variable radio "r" como valor entero
		double pi= 3.14159;										// declaramos el double pi, como valor constante (3.14159)
		System.out.print("Introduzca el radio del círculo: "); 
		r= input.nextInt();										// pedimos al usuario el radio
		System.out.println("");
		System.out.printf("Diámetro: %d unidades n", 2*r);	// A continuación mostramos valores para: Diámetro, Circunferencia y área:
		System.out.printf("Circunferencia: %.2f unidades \n", pi*2*r);
		System.out.printf("Área: %.2f unidades \n", pi*r*r);
		input.close(); 											// cerramos el flujo de datos de "input"
	}

}

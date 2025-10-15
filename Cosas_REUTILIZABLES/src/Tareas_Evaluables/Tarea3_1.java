package Tareas_Evaluables; //Se desea escribir un programa para el cálculo del área de superficies: cuadrado, rectángulo, círculo, triángulo y trapecio.
import java.util.Scanner;  // importamos la librería "Scanner", la cual nos permite almacenar información que introduzca el usuario

public class Tarea3_1 {
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);	// declaramos un objeto llamado "input" que nos ayudará a preguntar información al usuario
	int respuesta;							// con este valor int, sabremos lo que quiere hacer el usuario con el programa
	double valor1, valor2, valor3, pi=3.1415; // aquí declaramos las variables necesarias para el programa en genereal, declaramos 3, ya que la opción con más datos es el trapecio, aunque el usuario nunca llegue a usar ese modo, por lo menos lo tenemos definido

	do{
		System.out.print("__________________________ \n CÁLCULO DE SUPERFICIES \n \n 1.Cuadrado lado*lado \n 2.Círculo pi*radio*radio \n"
				+ " 3.Rectángulo base*altura \n 4.Trapecio (base1+base2)*altura/2 \n 5.Triángulo (base*altura)/2 \n ________________________________\n"
				+ "\n");
		respuesta= input.nextInt(); 			
		} while (respuesta <1 || respuesta>5);		// Aquí le preguntamos al usuario qué tipo de cálculo hay disponibles, mientras el valor de la respuesta no cumpla con los márgenes establecidos en el menú, seguirá preguntando hasta recibir un valor adecuado
	switch(respuesta) {								// creamos un switch para los diferentes modos, dentro de las cuales se pedirá las medidas necesarias y calculará el área de la figura seleccionada :)
	case 1:
		System.out.print("Introduzca la medida de 1 de los lado: ");
		valor1 = input.nextDouble();
		System.out.printf("El área del cuadrado es: %.2f und", (valor1*valor1));
		break;
	case 2:
		System.out.print("Introduzca la medida del radio: ");
		valor1 = input.nextDouble();
		System.out.printf("El área del círculo es: %.2f und", (valor1*valor1*pi));
		break;
	case 3:
		System.out.print("Introduzca la medida de la base: ");
		valor1 = input.nextDouble();
		System.out.print("Introduzca la medida de la altura: ");
		valor2 = input.nextDouble();
		System.out.printf("El área del círculo es: %.2f und", (valor1*valor2));
		break;
	case 4:
		System.out.print("Introduzca la medida de la primera base: ");
		valor1 = input.nextDouble();
		System.out.print("Introduzca la medida de la segunda base: ");
		valor2 = input.nextDouble();
		System.out.print("Introduzca la medida de la altura: ");
		valor3 = input.nextDouble();
		System.out.printf("El área del trapecio es: %.2f und", ((valor1+valor2)*valor3/2));
		break;
	case 5:
		System.out.print("Introduzca la medida de la base: ");
		valor1 = input.nextDouble();
		System.out.print("Introduzca la medida de la altura: ");
		valor2 = input.nextDouble();
		System.out.printf("El área del círculo es: %.2f und", ((valor1*valor2)/2));
		break;
	} 						//Luego de mostrar el resultado (en unidades) procederá a acabar el programa <3
}
}

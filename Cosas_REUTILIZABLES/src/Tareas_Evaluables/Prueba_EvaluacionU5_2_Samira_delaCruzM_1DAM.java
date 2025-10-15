package Tareas_Evaluables;
import java.util.Scanner;
//que lea 15 números por teclado y que los almacene en 1 array, los elementos hay que rotarlos, mover 1 posición 
public class Prueba_EvaluacionU5_2_Samira_delaCruzM_1DAM {
	public static final int NUM=15; // este es el tamaño del array (15)
	
	public static void main(String[] args) { // EN ESTA ACTIVIDAD VAMOS GESTIONAR DIFERENTES ACCIONES DENTRO DE MÉTODOS, YA QUE EL USO DE ESTOS FACILITA EL MANEJO DEL PROGRAMA A FUTUROS CAMBIOS
		Scanner input = new Scanner(System.in);
		int array[]= new int [NUM];
		pedirValoresArray(input, array);
		System.out.println("Los valores  que has introducido dentro del array son: ");
		mostrarArray(array);
		rotarElementos(array);
		System.out.println("Este es el contenido final del array: ");
		mostrarArray(array);
	}
	public static void pedirValoresArray(Scanner input, int[] array) {
		System.out.println("Introduzca 15 números para almacenarlos en un array: ");
		for (int i=0; i<NUM; i++) {
			array[i]= input.nextInt(); // pedimos al usuario que introduzca valores numéricos para meterlos dentro del array
		}
	}
	public static void rotarElementos(int[] array) {
		int aux= array[NUM-1]; // guardamos el valor de la última posición, en una variable auxiliar, para luego añadirla al final de array,
		for (int i=NUM-1; i>0 ;i--) {
			array[i]= array[i-1];
		}
		array[0]= aux; // aqui lo añadimos, sabemos que el array es de tamaño NUM, pero al no existir esa posición del array, le restamos 1
	}
	public static void mostrarArray(int[] array) { // // vamos a meter los valores del array, sigo pensando que el uso de un String facilitaría la salida del resultado, ya que nos ahorramos poner 3 syso, pero bueno...
		System.out.print("["); 
		for (int i=0; i<NUM; i++) {
			if(i<NUM-1) {
				System.out.print(array[i]+", ");
			}else{
				System.out.print(array[i]);
			}
		}
		System.out.println("] \n"); // aquí lo mostramos todo por pantalla
	}
}

package UNIT4;
import java.util.Scanner;
public class Ejercicio7Unit4 {
	 public static int OPMIN= 0;
	 public static int OPMAX = 100;
	 
	 public static void Funcion(int a) {
		 if(a<OPMIN || a>OPMAX) {
			 Pedir.E("El número "+ a+" se encuentra fuera de los parámetros :(");
		 }else {
			 Pedir.E("El número " + a+ " Sí se encuentra dentro de los parámetros");
		 }
	 }
	 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Pedir.E("Introduzca un número, para ver si se encuentra dentro de los parámetros: ");
		int a = input.nextInt();
		Funcion(a);
	}

}

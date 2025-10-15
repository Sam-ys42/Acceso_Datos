package UNIT5;

import java.util.Scanner;

public class ejercicio3_indice {
	public static int a =0, b=0;
	public static int array[];
	public static void comprobar(int i) {
		int lugar = 0;
		boolean f= false;
		do {
			if(i == array[lugar]) {
				escribir.E("está aquí, en la posición "+ (lugar));
				f= true;
				break;
			}
			lugar++;
		}while(lugar<array.length);
		if(!f) {
		escribir.E("que va.. nada");}
	}
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		escribir.E("cuántos valores quiere añadir al array?");
		int a = input.nextInt();
		array = new int[a];
		escribir.E("rellene los " + a +" espacios:");
		for (int i=0; i< array.length; i++) {
			array[i]= input.nextInt();
		}
		
		escribir.E("qué valor quiere comprobar si está dentro del array?");
		int b = input.nextInt();
		comprobar(b);
	}
}
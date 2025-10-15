package UNIT5;

import java.util.Scanner;

// syso y control+espacio para escribir System.out.println(); de una, y que te deje dentro de los parentesis
public class escribir {
	public static int array2[];
	public static void agregarValores(){
		Scanner input = new Scanner(System.in);
		escribir.E("cuántos valores quiere añadir al array?");
		int a = input.nextInt();
		 array2 = new int[a];
		escribir.E("rellene los " + a +" espacios:");
		for (int i=0; i< array2.length; i++) {
			array2[i]= input.nextInt();
		}
	}
	
	public static void tresNumeros(int jota){
		String a[]= { "primer", "segundo", "tercer"};
		
			System.out.println("Dime el "+ a[jota]+ " número");

	}
	public static void E (String texto) {
		System.out.println(texto);	}
}

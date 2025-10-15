package UNIDAD9_USAR;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej03_encontrarIndice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Integer> valores = new ArrayList<Integer>(); 
		
		boolean seguir=true;
		
		while (seguir) {
			System.out.println("Introduce un valor entero: ");
			valores.add(teclado.nextInt());
			teclado.nextLine(); // Para recoger el salto de línea.
			
			System.out.println("¿Quieres seguir introduciendo valores? (s/n)");
			if (teclado.nextLine().equalsIgnoreCase("N")) {
				seguir=false;
			}
		}
		
		System.out.println("Dime un elemento y te daré su indice: ");
		System.out.println(valores.indexOf(teclado.nextInt()));

	}

}

package UNIDAD9_USAR;

import java.util.ArrayList;
import java.util.Scanner;

public class EjercicioMaxMinArrayList {


		public static void main(String[] args) {
			// Escriba un programa Java para encontrar el valor máximo y mínimo de un ArrayList.

			Scanner teclado = new Scanner(System.in);
			
			ArrayList<Integer> valores = new ArrayList<Integer>(); 
			
			int min, max;
			boolean seguir = true;
			
			// Pedimos valores de números enteros al usuario hasta que no quiera seguir.
			while (seguir) {
				System.out.println("Introduce un valor entero: ");
				valores.add(teclado.nextInt());
				teclado.nextLine(); // Para recoger el salto de línea.
				System.out.println("¿Quieres seguir introduciendo valores? (s/n)");
				if (teclado.nextLine().equalsIgnoreCase("N")) {
					seguir=false;
				}
			}
			valores.sort(null);
			System.out.println("Mínimo: "+ valores.getFirst());
			System.out.println("Máximo: "+ valores.getLast());

//			System.out.println("El valor mínimo introducido es: "+valores.getLast());
//			System.out.println("El valor máximo introducido es: "+valores.getLast());			
		}
	}
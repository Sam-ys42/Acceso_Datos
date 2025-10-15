package UNIDAD9_USAR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ej05_insertarElemento {

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
		
		System.out.println("Introduce en que posicion quieres insertar: ");
		
		int pos=teclado.nextInt();
		
		System.out.println("Introduce el valor que quieres insertar en la posición "+pos);
		
		valores.add(pos, teclado.nextInt());
		
		//Recorrer Array
		
		Iterator<Integer> i = valores.iterator();
		Integer elemento;
				
		while (i.hasNext()) {
			elemento = i.next();
			System.out.println(elemento);
					
		}

	}

}
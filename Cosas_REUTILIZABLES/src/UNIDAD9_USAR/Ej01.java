package UNIDAD9_USAR;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ej01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner teclado = new Scanner(System.in);
		
		ArrayList<Integer> valores = new ArrayList<Integer>(); 
		
		double promedio=0;
		int valor;
		boolean seguir=true;
		
		while (seguir) {
			System.out.println("Introduce un valor entero: ");
			valor=teclado.nextInt();
			valores.add(valor);
			teclado.nextLine(); // Para recoger el salto de línea.
			promedio=promedio+valor;
			
			System.out.println("¿Quieres seguir introduciendo valores? (s/n)");
			if (teclado.nextLine().equalsIgnoreCase("N")) {
				seguir=false;
			}
		}
		
		System.out.println("El promedio es: "+promedio/valores.size());
		Iterator<Integer> i = valores.iterator();
		while (i.hasNext()) {
			System.out.println("Funciona");
			i.next();
		}
		
		for (int j = 0; j < valores.size(); j++) {
			System.out.println(valores.get(j));
		}
	}

}
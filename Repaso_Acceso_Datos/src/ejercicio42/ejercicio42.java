package ejercicio42;

import java.util.Scanner;

public class ejercicio42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libreria miLibreria = new Libreria();
		
		Scanner input = new Scanner(System.in);
		System.out.println("Introduce el nombre de la librería");
		miLibreria.setNombre(input.nextLine());
		System.out.println("Introduce la población");
		miLibreria.setLugar(input.nextLine());
		System.out.println("Introduce el cp");
		miLibreria.setCP(Integer.parseInt(input.nextLine()));
		
		// pido datos de los libros de esa libreria
		
		
		
	}

}

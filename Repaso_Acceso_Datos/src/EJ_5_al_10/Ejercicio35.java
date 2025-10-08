package EJ_5_al_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio35 {

	public static void menu() {
		System.out.println("1- Añadir nombre. \n 2- Borrar elemento. \n 3- Listar. \n 4- Salir. \n =========================");
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> lista = new ArrayList<String>();
		Scanner input = new Scanner(System.in);
		int respuesta=0;
		do {
			menu();
			 respuesta = input.nextInt();
			 
			 switch (respuesta) {
			case 1:
				System.out.println("Añade un nombre");
				lista.add(input.next());
				break;
			case 2:
				System.out.println("Elimina nombre");
				lista.remove(input.next());
				break;
			case 3:
				System.out.println("Listado: ");
				for (String string : lista) {
					System.out.println(string);
				}
				break;
			case 4:
				System.out.println("Adiosss");
				break;
			default:
				System.out.println("Opción no válida");
				break;
			}
			
		} while ( respuesta != 4);
	}
	
	
	

}

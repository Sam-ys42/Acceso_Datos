package ACCESO_FICHEROS_unidad1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio16Ramon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		System.out.println("Introduce el nombre del fichero");
		String nombre = input.nextLine();
		try (BufferedReader fichero = new BufferedReader(new FileReader(nombre));) {

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}

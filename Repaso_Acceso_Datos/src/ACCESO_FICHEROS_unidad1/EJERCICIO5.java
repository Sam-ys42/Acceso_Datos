package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.Scanner;

public class EJERCICIO5 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Introduce la ruta del fichero: ");
		String texto = input.nextLine();
		try {
			File file = new File(texto);
			
			if (!file.exists()) {
				file.createNewFile();
				
				System.out.println("El fichero no existía, carpeta creada con éxito");
			}
			else {
				System.out.println("Ya está creada");
			}
		
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

}

package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.Scanner;

public class EJERCICIO2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Dime la ruta de un fichero o carpeta: ");
		String texto = input.nextLine();
		
		try {
			File file = new File(texto);
			
			if(file.isDirectory()) {
				System.out.println("Es una carpeta");
			}
			else if(file.isFile()) {
				System.out.println("Es un archivo. \n Tamaño: "+ file.length()+ "bytes");
				
			}else {
				System.out.println("Que cojones es esto");
			}
			
			
		} catch ( Exception e) {

			System.out.println(e.getMessage());
			
		}
		
	}

}

package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class EJERCICIO3 {

	public static void main(String[] args) {
		//  /home/diurno/eclipse-workspace/Repaso_Acceso_Datos/FicheroTexto.txt

		Scanner input = new Scanner(System.in);
		System.out.println("Dime la ruta de un fichero o carpeta: ");
		String texto = input.nextLine();
		
		try {
			File file = new File(texto);
			
			if (file.isDirectory()) {
				System.out.println("Contenido de "+ texto);
			for (File hola : file.listFiles()) {
				System.out.print(hola.getName()+ "        ");
				
				if (hola.isFile()) {
					if(hola.canRead()) {
						System.out.print("Puede leer"+ "---");
					}
					if(hola.canWrite()) {
						System.out.print("Puedes escribir");
					}
				}
				System.out.println();
				
				
			
			}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}

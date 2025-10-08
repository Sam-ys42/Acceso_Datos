package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.Scanner;

public class EJERCICIO4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//  /home/diurno/eclipse-workspace/Repaso_Acceso_Datos/FicheroTexto.txt

			Scanner input = new Scanner(System.in);
			System.out.println("Introduce la ruta de la carpeta: ");
			String texto = input.nextLine();
			try {
				File file = new File(texto);
				
				if (!file.exists()) {
					file.mkdir();
					
					System.out.println("La carpeta no existía, carpeta creada con éxito");
				}
				else {
					System.out.println("Ya está creada");
				}
				
				
				
			} catch (Exception e) {
				// TODO: handle exception
			}
	}

}

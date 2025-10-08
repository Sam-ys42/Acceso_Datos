package ACCESO_FICHEROS_unidad1;

import java.io.File;

public class EJERCICIO1 {

	public static void main(String[] args) {

		try {
			File file = new File("Fichero2.txt");
			if (file.exists()) {
				System.out.println("El fichero ya exsite");
				System.out.println(file.getAbsoluteFile());
			}else {
				if (file.createNewFile()) {
					System.out.println("Fichero creado");
				}
				else {
					System.out.println("No se pudo crear");
				}
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

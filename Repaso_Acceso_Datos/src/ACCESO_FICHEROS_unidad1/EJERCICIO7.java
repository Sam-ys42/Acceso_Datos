package ACCESO_FICHEROS_unidad1;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class EJERCICIO7 {
	final static String RUTA = "/home/diurno/eclipse-workspace/Repaso_Acceso_Datos/FicherosPrueba/";
	public static void mostrarInformacion(String fichero) {
		System.out.println("----------------------------");
		System.out.println(fichero);
		System.out.println("----------------------------");
		
		try {
			File file = new File(RUTA+fichero);
			String respuesta = (file.exists())? "Existe ": "No existe";
			System.out.println(respuesta);
			System.out.println("Fichero: "+file.isFile()+ " | Carpeta: "+ file.isDirectory());
			System.out.println(file.getAbsolutePath());
			String datos="";
			datos += (file.canRead())? "r": "";
			datos += (file.canWrite())? "w": "";
			datos += (file.canExecute())? "x": "";
			System.out.println(datos);
			System.out.println("Tamaño: "+ file.length());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public static void main(String[] args) {
		HashSet<String> nombreFichero = new HashSet<String>();
		Scanner input = new Scanner(System.in);
		String texto ="";
		
		do {
			System.out.println("Introduce nombres de fichero (escribe 'salir' para terminar) : ");
			System.out.print("Nombre de fichero: ");
			texto = input.nextLine();
			nombreFichero.add(texto);
			
			System.out.println("Fichero añadido.");
			
		} while (!texto.equals("salir"));
		
		for (String string : nombreFichero) {
				if(!string.equals("salir")) {
					mostrarInformacion(string);
			}
		}

	}

}

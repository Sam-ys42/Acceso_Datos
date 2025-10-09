package ACCESO_FICHEROS_unidad1;

    import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EJERCICIO17 {

	public static int mostrarFichero(File nombreFichero) {

		BufferedReader fichero = null;

		int numFilas = 0;

		
		try {
			fichero = new BufferedReader(new FileReader(nombreFichero));
			String linea;
			while ((linea = fichero.readLine()) != null) {
				System.out.println(linea);
				numFilas++;
			}

		} catch (Exception e) {

			System.out.println("Error al abrir el fichero");
			e.getMessage();
			e.printStackTrace();

		} finally {

			try {

				fichero.close();

			} catch (IOException e) { 

				e.printStackTrace();
			}
		}

		return numFilas;

	}

	public static void modificarFichero(File nombreFichero, int numLinea) {

		try {
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("¿Que nuevos datos desea añadir?");
			String newLinea = teclado.nextLine();
			
			BufferedReader FOriginal = new BufferedReader(new FileReader(nombreFichero));

			File Ftemporal = new File("tmp.txt");
			
			BufferedWriter Ftmp = new BufferedWriter(new FileWriter(Ftemporal));

			String linea;
			int lineaActual = 1;
			
			while ((linea = FOriginal.readLine()) != null) {
				if (lineaActual != numLinea) {
					Ftmp.append(linea);
					Ftmp.newLine();
				}else {
					
					Ftmp.append(newLinea);
					Ftmp.newLine();
				}

				lineaActual++;
			}
			FOriginal.close();
			Ftmp.close();
			
			if (nombreFichero.delete()) {
				Ftemporal.renameTo(nombreFichero.getAbsoluteFile());
			} else {
				System.out.println("No se puede borrar el fichero original.");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			    e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		System.out.println("Introduzca la ruta del fichero del fichero: ");

		String ruta = input.nextLine();
		File fichero = new File(ruta);
		int numFilas = mostrarFichero(fichero);
		System.out.println("\n¿Que linea desea modificar?: ");
		int lineaModificada = input.nextInt();
		if (lineaModificada > 0 || lineaModificada <= numFilas) {
			modificarFichero(fichero, lineaModificada);
		} else {
			System.out.println("Error, no pudo modificarse el fichero.");

		}
		System.out.println("Fichero modificado: ");
		mostrarFichero(fichero);

	}


}

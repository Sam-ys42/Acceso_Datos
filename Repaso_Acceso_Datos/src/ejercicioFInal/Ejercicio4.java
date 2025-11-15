package ejercicioFInal;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ejercicio4 {
	private static Personas personas = new Personas();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println((leerArchivoBin(personas, "personas.obj")) ? "Se han leido los archivos binarios correctamente": "nada, error");
		System.out.println( (meterDatosArchivoCSV(personas, "contactos.csv ")) ? "Se han guardado los datos al fichero": "nada, error"); // APRENDIDO CON ROSA LA DE AWS

	}

	private static boolean meterDatosArchivoCSV(Personas personas, String archivo) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		File ficheroTxt = new File(archivo);
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(ficheroTxt));
		
		for (Persona persona : personas.getPersonas()) {
			try  {
				bw.write(persona.getNombre() + ";" + persona.getEmail());
				System.out.println("persona escrita en el fichero");
				bw.newLine();
				
				resultado = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		}
		bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;
	}

	private static boolean leerArchivoBin(Personas listaPersonas, String archivo) {
		// TODO Auto-generated method stub
		boolean resultado = false;

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo));
			try {
				System.out.println("objetos del fichero bin: ");
				while (true) {
					Persona p = (Persona) ois.readObject();
					listaPersonas.anadirPersona(p);
					resultado = true;
					System.out.println(p.toString());

				}
			} catch (EOFException e) {
				// fin del fichero
				// System.out.println("fin del fichero");
			}
			ois.close();

			System.out.println("fin bin");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultado;
	}

}

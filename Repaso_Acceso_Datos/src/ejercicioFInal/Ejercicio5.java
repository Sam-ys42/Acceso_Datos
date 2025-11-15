package ejercicioFInal;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.RandomAccessFile;

public class Ejercicio5 {
	private static Personas personas = new Personas();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( (leerArchivoBin(personas, "personas.obj")) ? "Se han leido los archivos binarios correctamente": "nada, error");
		System.out.println((meterDatosArchivoBinAleatorio(personas, "teléfonos.bin")) ?"Se han guardado los datos binarios de acceso aleatorio": "nada, error"); // APRENDIDO CON ROSA LA DE AWS
 // SON 13 bytesS EN TOTAL

	}
	private static boolean meterDatosArchivoBinAleatorio(Personas p, String nombreArchivo) {
	    boolean resultado = false;

	    try (RandomAccessFile archivoBin = new RandomAccessFile(nombreArchivo, "rw")) {
	        for (Persona persona : p.getPersonas()) {

	            // Escribir los datos en el archivo binario
	            archivoBin.writeBytes(persona.getDni());                // 9 bytes
	            archivoBin.writeInt(persona.getTelefono()); // 4 bytes
	        }

	        resultado = true; // si todo se ejecuta bien
	    } catch (IOException e) {
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

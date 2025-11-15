package ejercicioFInal;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Ejercicio3 {
	private static Personas personas1 = new Personas();
	private static Personas personas2 = new Personas();
	private static Personas personasFusionadas = new Personas();


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ejercicio 3
		System.out.println( (leerArchivoBin(personas1,"personas1.obj")) ? "Se han leido los archivos binarios correctamente" : "nada, error");
		/*System.out.println("personas1");
		personas1.mostrarPersonas();
		System.out.println();
*/
		System.out.println((leerArchivoBin(personas2,"personas2.obj")) ? "Se han leido los archivos binarios correctamente" : "nada, error");
		/*System.out.println("personas2");
		personas2.mostrarPersonas();
		System.out.println();
*/
		personasFusionadas.setPersonas(fusion(personas1,personas2));
		System.out.println( (meterDatosArchivoBin(personasFusionadas, "personas.obj")) ?"Se han guardado los datos binarios": "nada, error"); // APRENDIDO CON ROSA LA DE AWS
		/*System.out.println("personasfusionadas");
		personasFusionadas.mostrarPersonas();
		System.out.println();
*/
		// -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-
	}
	private static ArrayList<Persona> fusion(Personas a, Personas b) {
		// TODO Auto-generated method stub
		ArrayList<Persona> resultado = new ArrayList<Persona>(); // vamos a rellenar este array con los nuevo s valores a ver si funciona

	    for (Persona personaA : a.getPersonas()) {
			for (Persona personaB : b.getPersonas()) {
				if (personaA.getDni().equalsIgnoreCase(personaB.getDni())) { // se rellenan los campos faltantes
					personaA.setTelefono(personaB.getTelefono());
					personaA.setEmail(personaB.getEmail());
				}
			}
			resultado.add(personaA);
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
				//System.out.println("fin del fichero");
			}
			ois.close();
			
			System.out.println("fin bin");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	private static boolean meterDatosArchivoBin(Personas p, String archivo) {
		boolean resultado = false;
		File ficheroBin = new File(archivo);
		ObjectOutputStream oos = null;
		for (Persona persona : p.getPersonas()) { 
			if (ficheroBin.exists()) {
				try {
					MyObjectOutputStream myoos = new MyObjectOutputStream(new FileOutputStream(ficheroBin, true));
					myoos.writeObject(persona);
					myoos.close();
					System.out.println(" Se ha guardado la persona");
					resultado = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					oos = new ObjectOutputStream(new FileOutputStream(ficheroBin, true));
					oos.writeObject(persona);
					oos.close();
					System.out.println(" Fichero creado y persona guardada");
					resultado = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return resultado;
	}

}

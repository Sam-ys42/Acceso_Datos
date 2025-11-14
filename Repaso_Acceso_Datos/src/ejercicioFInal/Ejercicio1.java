package ejercicioFInal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;


import ejercicioFInal.MyObjectOutputStream;

public class Ejercicio1 {
	private static Personas personas1 = new Personas();
	private static Personas personas2 = new Personas();

	private static Scanner input = new Scanner(System.in);

	/*
	 * Crea una lista de objetos de tipo personas y guárdalas en una lista a partir
	 * del fichero personas.json
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// leer jso
	String resultado;
	// ejercicio 1 
	System.out.println(resultado = (leerJson()) ?"Se ha leido el archivo json correctamente": "nada, error"); // como me diga ah
	System.out .println(resultado = (meterDatosArchivoBin(personas1, "personas1.obj")) ?"Se han guardados los datos binarios": "nada, error"); // APRENDIDO CON ROSA LA DE AWS
		// -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

	// ejercicio 2
	System.out.println(resultado = (leerXml()) ? "Se ha leido el archivo xml correctamente" : "nada, error");
	//System.out.println(resultado = (meterDatosArchivoBin(personas2, "personas2,obj")) ?"Se han guardado los datos binarios": "nada, error"); // APRENDIDO CON ROSA LA DE AWS

	//ejercicio 3
	System.out.println(resultado = (leerArchivosBin("personas1.obj","personas2.obj")) ? "Se han leido los archivos binarios correctamente" : "nada, error");
	System.out.println(resultado = (meterDatosArchivoBin(personas2, "personas2,obj")) ?"Se han guardado los datos binarios": "nada, error"); // APRENDIDO CON ROSA LA DE AWS

	
	}

	private static boolean leerArchivosBin(String archivo1, String archivo2) {
		// TODO Auto-generated method stub
		boolean resultado = false;
		
		
		return resultado;
	}

	private static boolean leerXml() {
		// TODO Auto-generated method stub
		boolean resultado = false;
		try {
			JAXBContext contexto = JAXBContext.newInstance(Personas.class);
			//2 Crear un unmarshaller  que convierte el XML en JavaBeans. 
			Unmarshaller um = contexto.createUnmarshaller(); 
			//Realizar la deserialización  llamando al método unmarshal del marshaller. 
			personas2= (Personas) um.unmarshal(new File("personas.xml"));
			resultado = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
	}

	private static boolean meterDatosArchivoBin(Personas p, String archivo) {
		boolean resultado = false;
		File ficheroBin = new File(archivo);
		ObjectOutputStream oos = null;
		for (Persona persona : p.getPersonas()) { // preguntar si esto es una lista """ACEPTABLE"""
			String DNI = persona.getDni();
			String nombre = persona.getNombre();
			int edad = persona.getEdad();
			int telefono = persona.getTelefono();
			String email = persona.getEmail();

			Persona p1 = new Persona(DNI, nombre, edad, telefono, email);
			if (ficheroBin.exists()) {
				try {
					MyObjectOutputStream myoos = new MyObjectOutputStream(new FileOutputStream(ficheroBin, true));
					myoos.writeObject(p1);
					myoos.close();
					System.out.println(" Se ha guardado la persona");
					resultado = true;
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				try {
					oos = new ObjectOutputStream(new FileOutputStream(ficheroBin, true));
					oos.writeObject(p1);
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

	private static boolean leerJson() {
		boolean resultado = false;
		ObjectMapper mimapper = new ObjectMapper();
		mimapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {

			personas1 = mimapper.readValue(new File("personas.json"), Personas.class);
			resultado = true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return resultado;
	}

}

package ejercicioFInal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Ejercicio2 {

	private static Personas personas2 = new Personas();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ejercicio 2
		System.out.println( (leerXml()) ? "Se ha leido el archivo xml correctamente" : "nada, error");
		System.out.println( (meterDatosArchivoBin(personas2, "personas2.obj")) ?"Se han guardado los datos binarios": "nada, error"); // APRENDIDO CON ROSA LA DE AWS
		// -+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-

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

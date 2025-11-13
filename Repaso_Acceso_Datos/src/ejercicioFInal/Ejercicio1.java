package ejercicioFInal;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio1 {
/*Crea una lista de objetos de tipo personas y guárdalas en una lista a partir del fichero personas.json */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mimapper = new ObjectMapper();
		mimapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		try {
			
		Personas	personas = mimapper.readValue(new File("personas.json"), Personas.class);
			
			
			System.out.println("Esto es otra prueba");
			personas.mostrarPersonas();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

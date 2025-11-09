package ACCESO_JSON;

import java.io.IOException;
import java.lang.runtime.ObjectMethods;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio45 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper mimapper = new ObjectMapper();
		String jsonString = "{ \"DNI\": \"12345678A\", \"nombre\": \"Juan\", \"edad\": 30 }";
		
		Persona p = new Persona();
		try {
			p = mimapper.readValue(jsonString, Persona.class);
			mimapper.writeValue(System.out, p);
			
		} catch (JsonProcessingException e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

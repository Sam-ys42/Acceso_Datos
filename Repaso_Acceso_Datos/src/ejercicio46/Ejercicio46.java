package ejercicio46;

import java.io.File;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ejercicio46 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectMapper om = new ObjectMapper();
		 om.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); 
		try {
			
			Recetas r = om.readValue(new File("ej46recetas.json"), Recetas.class);
			System.out.println("MIS RECETAS: ");
			r.mostrarRecetas();
			

			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}

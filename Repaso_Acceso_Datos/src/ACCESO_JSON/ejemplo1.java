package ACCESO_JSON;

import java.io.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ejercicio42y43.Libreria;
import ejercicio42y43.Libro;

public class ejemplo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ObjectMapper mapper = new ObjectMapper();
//leer una cadena json
/*String jsonInput = "{\"id\":1,\"nombre\":\"Robin\",\"apellido\":\"Wilson\"}";
Libreria a = new Libreria();
try {
	a = mapper.readValue(jsonInput, Libreria.class);
	
} catch (JsonProcessingException e) {
	// TODO: handle exception
	e.printStackTrace();
	
}*/

System.out.println("Leer y parsed a animados desde JSON: ");
Libro b = new Libro("hola", "ADIOS", "SI", 1234);
try {
	mapper.writeValue(System.out, b);
} catch (Exception e) {
	// TODO: handle exception
}
	}

}

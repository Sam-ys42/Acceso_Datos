package ejercicioFinal_NavaVinted;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ejercicio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(escribirJson("ropa.dat")? "json escrito correctamente" : "nada");

	}

	private static boolean escribirJson(String archivo) {
		boolean resultado = false;
		try {
			// escribir json
			ObjectInputStream ois1 = new ObjectInputStream(
					new FileInputStream(archivo));
			Productos lista = (Productos) ois1.readObject();
			ois1.close();

			// Mostrar lista (comprobación)
			lista.mostrarProductos();

			ObjectMapper mapeador = new ObjectMapper();
			mapeador.enable(SerializationFeature.INDENT_OUTPUT);

			mapeador.writeValue(new File("ropa.json"), lista);
			resultado = true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return resultado;
	}

}

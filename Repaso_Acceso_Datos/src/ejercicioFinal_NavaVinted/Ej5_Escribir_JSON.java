package ejercicioFinal_NavaVinted;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Ej5_Escribir_JSON {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ObjectInputStream ois1 = new ObjectInputStream(
					new FileInputStream("C:\\Users\\itsca\\git\\AccesoDatos\\AccesoDatos\\ropa.dat"));
			Productos lista = (Productos) ois1.readObject();
			ois1.close();

			// Mostrar lista (comprobación)
			lista.mostrarProductos();

			ObjectMapper mapeador = new ObjectMapper();
			mapeador.enable(SerializationFeature.INDENT_OUTPUT);

			mapeador.writeValue(new File("C:\\Users\\itsca\\git\\AccesoDatos\\AccesoDatos\\ropa.json"), lista);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
